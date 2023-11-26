package com.tekcapzule.skillstudio.application.function;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tekcapzule.core.domain.Origin;
import com.tekcapzule.core.domain.SourceSystem;
import com.tekcapzule.core.utils.HeaderUtil;
import com.tekcapzule.core.utils.Outcome;
import com.tekcapzule.core.utils.PayloadUtil;
import com.tekcapzule.core.utils.Stage;
import com.tekcapzule.skillstudio.application.config.AppConfig;
import com.tekcapzule.skillstudio.application.function.input.CreateInput;
import com.tekcapzule.skillstudio.application.mapper.InputOutputMapper;
import com.tekcapzule.skillstudio.domain.command.CreateCommand;
import com.tekcapzule.skillstudio.domain.model.payload.Tekbyte;
import com.tekcapzule.skillstudio.domain.model.payload.Video;
import com.tekcapzule.skillstudio.domain.service.SkillStudioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@Slf4j
public class CreateFunction implements Function<Message<CreateInput>, Message<Void>> {

    private final SkillStudioService skillstudioService;

    private final AppConfig appConfig;

    public CreateFunction(final SkillStudioService skillstudioService, final AppConfig appConfig) {
        this.skillstudioService = skillstudioService;
        this.appConfig = appConfig;
    }

    @Override
    public Message<Void> apply(Message<CreateInput> createInputMessage) {

        Map<String, Object> responseHeaders = new HashMap<>();
        Map<String, Object> payload = new HashMap<>();
        String stage = appConfig.getStage().toUpperCase();

        try {
            CreateInput createInput = createInputMessage.getPayload();
            log.info(String.format("Entering create skillstudio Function - Module Code:%s", createInput.getTopicCode()));
            Origin origin = HeaderUtil.buildOriginFromHeaders(createInputMessage.getHeaders());
          //  Origin origin =Origin.builder().channel(SourceSystem.WEB_CLIENT).userId("haritha.peryala@gmail.com").build();
            ObjectMapper mapper = new ObjectMapper();
            if(createInput.getPayload().getClass().getName().contains("Video") ) {
                log.info("entering video condition");
                createInput.setPayload(mapper.convertValue(createInput.getPayload(), Video.class));
            }
            CreateCommand createCommand = InputOutputMapper.buildCreateCommandFromCreateInput.apply(createInput, origin);
            skillstudioService.create(createCommand);
            responseHeaders = HeaderUtil.populateResponseHeaders(responseHeaders, Stage.valueOf(stage), Outcome.SUCCESS);
            payload = PayloadUtil.composePayload(Outcome.SUCCESS);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            responseHeaders = HeaderUtil.populateResponseHeaders(responseHeaders, Stage.valueOf(stage), Outcome.ERROR);
            payload = PayloadUtil.composePayload(Outcome.ERROR);
        }
        return new GenericMessage(payload, responseHeaders);
    }
}