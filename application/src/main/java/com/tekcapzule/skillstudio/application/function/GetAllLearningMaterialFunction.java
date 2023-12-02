package com.tekcapzule.skillstudio.application.function;

import com.tekcapzule.core.domain.EmptyFunctionInput;
import com.tekcapzule.core.utils.HeaderUtil;
import com.tekcapzule.core.utils.Outcome;
import com.tekcapzule.core.utils.Stage;
import com.tekcapzule.skillstudio.application.config.AppConfig;
import com.tekcapzule.skillstudio.domain.model.LearningMaterial;
import com.tekcapzule.skillstudio.domain.service.LearningMaterialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;

@Component
@Slf4j
public class GetAllLearningMaterialFunction implements Function<Message<EmptyFunctionInput>, Message<List<LearningMaterial>>> {

    private final LearningMaterialService skillstudioService;

    private final AppConfig appConfig;

    public GetAllLearningMaterialFunction(final LearningMaterialService skillstudioService, final AppConfig appConfig) {
        this.skillstudioService = skillstudioService;
        this.appConfig = appConfig;
    }


    @Override
    public Message<List<LearningMaterial>> apply(Message<EmptyFunctionInput> getAllInputMessage) {

        Map<String, Object> responseHeaders = new HashMap<>();
        List<LearningMaterial> cours = new ArrayList<>();
        String stage = appConfig.getStage().toUpperCase();
        try {
            log.info("Entering get all LearningMaterial Function");
            cours = skillstudioService.findAll();
            responseHeaders = HeaderUtil.populateResponseHeaders(responseHeaders, Stage.valueOf(stage), Outcome.SUCCESS);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            responseHeaders = HeaderUtil.populateResponseHeaders(responseHeaders, Stage.valueOf(stage), Outcome.ERROR);
        }
        return new GenericMessage<>(cours, responseHeaders);
    }
}