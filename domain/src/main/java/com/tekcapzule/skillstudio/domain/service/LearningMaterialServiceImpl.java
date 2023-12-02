package com.tekcapzule.skillstudio.domain.service;

import com.tekcapzule.skillstudio.domain.command.ApproveLearningMaterialCommand;
import com.tekcapzule.skillstudio.domain.command.CreateLearningMaterialCommand;
import com.tekcapzule.skillstudio.domain.command.RecommendLearningMaterialCommand;
import com.tekcapzule.skillstudio.domain.command.UpdateLearningMaterialCommand;
import com.tekcapzule.skillstudio.domain.model.LearningMaterial;
import com.tekcapzule.skillstudio.domain.model.Status;
import com.tekcapzule.skillstudio.domain.repository.LearningMaterialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class LearningMaterialServiceImpl implements LearningMaterialService {
    private LearningMaterialRepository learningMaterialRepository;

    @Autowired
    public LearningMaterialServiceImpl(LearningMaterialRepository learningMaterialRepository) {
        this.learningMaterialRepository = learningMaterialRepository;
    }

    @Override
    public void create(CreateLearningMaterialCommand createLearningMaterialCommand) {

        log.info(String.format("Entering create LearningMaterial service - title :%s", createLearningMaterialCommand.getTitle()));

        LearningMaterial learningMaterial = LearningMaterial.builder()
                .title(createLearningMaterialCommand.getTitle())
                .topicCode(createLearningMaterialCommand.getTopicCode())
                .subTopicCode(createLearningMaterialCommand.getSubTopicCode())
                .authors(createLearningMaterialCommand.getAuthors())
                .publisher(createLearningMaterialCommand.getPublisher())
                .duration(createLearningMaterialCommand.getDuration())
                .resourceUrl(createLearningMaterialCommand.getResourceUrl())
                .summary(createLearningMaterialCommand.getSummary())
                .description(createLearningMaterialCommand.getDescription())
                .prizingModel(createLearningMaterialCommand.getPrizingModel())
                .imageUrl(createLearningMaterialCommand.getImageUrl())
                .tags(createLearningMaterialCommand.getTags())
                .promotion(createLearningMaterialCommand.getPromotion())
                .modules(createLearningMaterialCommand.getModules())
                .deliveryMode(createLearningMaterialCommand.getDeliveryMode())
                .overview(createLearningMaterialCommand.getOverview())
                .level(createLearningMaterialCommand.getLevel())
                .targetAudience(createLearningMaterialCommand.getTargetAudience())
                .schedule(createLearningMaterialCommand.getSchedule())
                .region(createLearningMaterialCommand.getRegion())
                .venue(createLearningMaterialCommand.getVenue())
                .registrationUrl(createLearningMaterialCommand.getRegistrationUrl())
                .prizingModel(createLearningMaterialCommand.getPrizingModel())
                .promotion(createLearningMaterialCommand.getPromotion())
                .status(Status.SUBMITTED)
                .publishedOn(createLearningMaterialCommand.getPublishedOn())
                .build();

        learningMaterial.setAddedOn(createLearningMaterialCommand.getExecOn());
        learningMaterial.setAddedBy(createLearningMaterialCommand.getExecBy().getUserId());

        learningMaterialRepository.save(learningMaterial);
    }

    @Override
    public void update(UpdateLearningMaterialCommand updateLearningMaterialCommand) {

        log.info(String.format("Entering update LearningMaterial service - LearningMaterial ID:%s", updateLearningMaterialCommand.getLearningMaterialId()));

        LearningMaterial learningMaterial = learningMaterialRepository.findBy(updateLearningMaterialCommand.getLearningMaterialId());
        if (learningMaterial != null) {
            learningMaterial.setTitle(updateLearningMaterialCommand.getTitle());
            learningMaterial.setTopicCode(updateLearningMaterialCommand.getTopicCode());
            learningMaterial.setSubTopicCode(updateLearningMaterialCommand.getSubTopicCode());
            learningMaterial.setAuthors(updateLearningMaterialCommand.getAuthors());
            learningMaterial.setPublisher(updateLearningMaterialCommand.getPublisher());
            learningMaterial.setDuration(updateLearningMaterialCommand.getDuration());
            learningMaterial.setResourceUrl(updateLearningMaterialCommand.getResourceUrl());
            learningMaterial.setSummary(updateLearningMaterialCommand.getSummary());
            learningMaterial.setDescription(updateLearningMaterialCommand.getDescription());
            learningMaterial.setPrizingModel(updateLearningMaterialCommand.getPrizingModel());
            learningMaterial.setImageUrl(updateLearningMaterialCommand.getImageUrl());
            learningMaterial.setTags(updateLearningMaterialCommand.getTags());
            learningMaterial.setPromotion(updateLearningMaterialCommand.getPromotion());
            learningMaterial.setModules(updateLearningMaterialCommand.getModules());
            learningMaterial.setDeliveryMode(updateLearningMaterialCommand.getDeliveryMode());
            learningMaterial.setOverview(updateLearningMaterialCommand.getOverview());
            learningMaterial.setLevel(updateLearningMaterialCommand.getLevel());
            learningMaterial.setTargetAudience(updateLearningMaterialCommand.getTargetAudience());
            learningMaterial.setSchedule(updateLearningMaterialCommand.getSchedule());
            learningMaterial.setRegion(updateLearningMaterialCommand.getRegion());
            learningMaterial.setVenue(updateLearningMaterialCommand.getVenue());
            learningMaterial.setRegistrationUrl(updateLearningMaterialCommand.getRegistrationUrl());
            learningMaterial.setPrizingModel(updateLearningMaterialCommand.getPrizingModel());
            learningMaterial.setPromotion(updateLearningMaterialCommand.getPromotion());
            learningMaterial.setStatus(Status.SUBMITTED);
            learningMaterial.setPublishedOn(updateLearningMaterialCommand.getPublishedOn());
            learningMaterialRepository.save(learningMaterial);
        }
    }

    @Override
    public void recommend(RecommendLearningMaterialCommand recommendLearningMaterialCommand) {
        log.info(String.format("Entering recommend LearningMaterial service -  LearningMaterial Id:%s", recommendLearningMaterialCommand.getLearningMaterialId()));

        LearningMaterial learningMaterial = learningMaterialRepository.findBy(recommendLearningMaterialCommand.getLearningMaterialId());
        if (learningMaterial != null) {
            Integer recommendationsCount = learningMaterial.getRecommendations();
            recommendationsCount += 1;
            learningMaterial.setRecommendations(recommendationsCount);

            learningMaterial.setUpdatedOn(recommendLearningMaterialCommand.getExecOn());
            learningMaterial.setUpdatedBy(recommendLearningMaterialCommand.getExecBy().getUserId());

            learningMaterialRepository.save(learningMaterial);
        }
    }

    @Override
    public void approve(ApproveLearningMaterialCommand approveLearningMaterialCommand) {
        log.info(String.format("Entering approve LearningMaterial service -  learningMaterial Id:%s", approveLearningMaterialCommand.getLearningMaterialId()));

        LearningMaterial learningMaterial = learningMaterialRepository.findBy(approveLearningMaterialCommand.getLearningMaterialId());
        if (learningMaterial != null) {
            learningMaterial.setStatus(Status.ACTIVE);

            learningMaterial.setUpdatedOn(approveLearningMaterialCommand.getExecOn());
            learningMaterial.setUpdatedBy(approveLearningMaterialCommand.getExecBy().getUserId());

            learningMaterialRepository.save(learningMaterial);
        }
    }

    @Override
    public List<LearningMaterial> findAll() {

        log.info("Entering findAll LearningMaterial service");

        return learningMaterialRepository.findAll();
    }

    @Override
    public List<LearningMaterial> findAllByTopicCode(String topicCode) {

        log.info(String.format("Entering findAllByTopicCode LearningMaterial service - topic code:%s", topicCode));

        return learningMaterialRepository.findAllByTopicCode(topicCode);
    }


}
