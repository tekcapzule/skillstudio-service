package com.tekcapzule.skillstudio.application.function;

import com.tekcapzule.core.domain.Origin;
import com.tekcapzule.core.utils.HeaderUtil;
import com.tekcapzule.core.utils.Outcome;
import com.tekcapzule.core.utils.PayloadUtil;
import com.tekcapzule.core.utils.Stage;
import com.tekcapzule.skillstudio.application.config.AppConfig;
import com.tekcapzule.skillstudio.application.function.input.UpdateLearningMaterialInput;
import com.tekcapzule.skillstudio.application.mapper.InputOutputMapper;
import com.tekcapzule.skillstudio.domain.command.UpdateLearningMaterialCommand;
import com.tekcapzule.skillstudio.domain.service.LearningMaterialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@Slf4j
public class UpdateLearningMaterialFunction implements Function<Message<UpdateLearningMaterialInput>, Message<Void>> {

    private final LearningMaterialService skillstudioService;

    private final AppConfig appConfig;

    public UpdateLearningMaterialFunction(final LearningMaterialService skillstudioService, final AppConfig appConfig) {
        this.skillstudioService = skillstudioService;
        this.appConfig = appConfig;
    }

    @Override
    public Message<Void> apply(Message<UpdateLearningMaterialInput> updateInputMessage) {

        Map<String, Object> responseHeaders = new HashMap<>();
        Map<String, Object> payload = new HashMap<>();
        String stage = appConfig.getStage().toUpperCase();

        try {
            UpdateLearningMaterialInput updateLearningMaterialInput = updateInputMessage.getPayload();
            log.info(String.format("Entering update LearningMaterial Function -  learning material Id:%s", updateLearningMaterialInput.getTopicCode()));
            Origin origin = HeaderUtil.buildOriginFromHeaders(updateInputMessage.getHeaders());
            UpdateLearningMaterialCommand updateLearningMaterialCommand = InputOutputMapper.buildUpdateCommandFromUpdateInput.apply(updateLearningMaterialInput, origin);
            skillstudioService.update(updateLearningMaterialCommand);
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