package com.tekcapzule.skillstudio.application.function;

import com.tekcapzule.core.utils.HeaderUtil;
import com.tekcapzule.core.utils.Outcome;
import com.tekcapzule.core.utils.Stage;
import com.tekcapzule.skillstudio.application.config.AppConfig;
import com.tekcapzule.skillstudio.application.function.input.GetLearningMaterialInput;
import com.tekcapzule.skillstudio.domain.model.LearningMaterial;
import com.tekcapzule.skillstudio.domain.service.LearningMaterialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
@Slf4j
public class GetLearningMaterialFunction implements Function<Message<GetLearningMaterialInput>, Message<List<LearningMaterial>>> {

    private final LearningMaterialService skillstudioService;

    private final AppConfig appConfig;

    public GetLearningMaterialFunction(final LearningMaterialService skillstudioService, final AppConfig appConfig) {
        this.skillstudioService = skillstudioService;
        this.appConfig = appConfig;
    }


    @Override
    public Message<List<LearningMaterial>> apply(Message<GetLearningMaterialInput> getInputMessage) {

        Map<String, Object> responseHeaders = new HashMap<>();
        List<LearningMaterial> learningMaterials = new ArrayList<>();

        String stage = appConfig.getStage().toUpperCase();

        try {
            GetLearningMaterialInput getLearningMaterialInput = getInputMessage.getPayload();
            log.info(String.format("Entering get LearningMaterial Function -  learning material Id:%s", getLearningMaterialInput.getLearningMaterialId()));
            learningMaterials = skillstudioService.findAllByTopicCode(getLearningMaterialInput.getLearningMaterialId());
            if (learningMaterials.isEmpty()) {
                responseHeaders = HeaderUtil.populateResponseHeaders(responseHeaders, Stage.valueOf(stage), Outcome.NOT_FOUND);
            } else {
                responseHeaders = HeaderUtil.populateResponseHeaders(responseHeaders, Stage.valueOf(stage), Outcome.SUCCESS);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
            responseHeaders = HeaderUtil.populateResponseHeaders(responseHeaders, Stage.valueOf(stage), Outcome.ERROR);
        }
        return new GenericMessage<>(learningMaterials, responseHeaders);
    }
}