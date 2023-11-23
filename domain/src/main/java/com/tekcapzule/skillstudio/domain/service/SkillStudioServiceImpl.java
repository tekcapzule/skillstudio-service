package com.tekcapzule.skillstudio.domain.service;

import com.tekcapzule.skillstudio.domain.command.ApproveCommand;
import com.tekcapzule.skillstudio.domain.command.CreateCommand;
import com.tekcapzule.skillstudio.domain.command.RecommendCommand;
import com.tekcapzule.skillstudio.domain.command.UpdateCommand;
import com.tekcapzule.skillstudio.domain.model.LearningMaterial;
import com.tekcapzule.skillstudio.domain.model.Status;
import com.tekcapzule.skillstudio.domain.repository.SkillStudioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class SkillStudioServiceImpl implements SkillStudioService {
    private SkillStudioRepository skillStudioRepository;

    @Autowired
    public SkillStudioServiceImpl(SkillStudioRepository skillStudioRepository) {
        this.skillStudioRepository = skillStudioRepository;
    }

    @Override
    public void create(CreateCommand createCommand) {

        log.info(String.format("Entering create learningMaterial service - Module Code :%s", createCommand.getTopicCode()));

        LearningMaterial learningMaterial = LearningMaterial.builder()
                .title(createCommand.getTitle())
                .topicCode(createCommand.getTopicCode())
                .publisher(createCommand.getPublisher())
                .duration(createCommand.getDuration())
                .resourceUrl(createCommand.getResourceUrl())
                .summary(createCommand.getSummary())
                .description(createCommand.getDescription())
                .imageUrl(createCommand.getImageUrl())
                .promotion(createCommand.getPromotion())
                .status(Status.SUBMITTED)
                .recommendations(createCommand.getRecommendations())
                .publishedOn(createCommand.getPublishedOn())
                .build();

        learningMaterial.setAddedOn(createCommand.getExecOn());
        learningMaterial.setAddedBy(createCommand.getExecBy().getUserId());

        skillStudioRepository.save(learningMaterial);
    }

    @Override
    public void update(UpdateCommand updateCommand) {

        log.info(String.format("Entering update learningMaterial service - LearningMaterial ID:%s", updateCommand.getSkillstudioId()));

        LearningMaterial learningMaterial = skillStudioRepository.findBy(updateCommand.getSkillstudioId());
        if (learningMaterial != null) {
            learningMaterial.setTitle(updateCommand.getTitle());
            learningMaterial.setTopicCode(updateCommand.getTopicCode());
            learningMaterial.setPublisher(updateCommand.getPublisher());
            learningMaterial.setDuration(updateCommand.getDuration());
            learningMaterial.setResourceUrl(updateCommand.getResourceUrl());
            learningMaterial.setSummary(updateCommand.getSummary());
            learningMaterial.setDescription(updateCommand.getDescription());
            learningMaterial.setPromotion(updateCommand.getPromotion());
            learningMaterial.setImageUrl(updateCommand.getImageUrl());
            learningMaterial.setUpdatedOn(updateCommand.getExecOn());
            learningMaterial.setUpdatedBy(updateCommand.getExecBy().getUserId());
            learningMaterial.setRecommendations(updateCommand.getRecommendations());
            learningMaterial.setPublishedOn(updateCommand.getPublishedOn());
            skillStudioRepository.save(learningMaterial);
        }
    }

    @Override
    public void recommend(RecommendCommand recommendCommand) {
        log.info(String.format("Entering recommend learningMaterial service -  LearningMaterial Id:%s", recommendCommand.getSkillstudioId()));

        LearningMaterial learningMaterial = skillStudioRepository.findBy(recommendCommand.getSkillstudioId());
        if (learningMaterial != null) {
            Integer recommendationsCount = learningMaterial.getRecommendations();
            recommendationsCount += 1;
            learningMaterial.setRecommendations(recommendationsCount);

            learningMaterial.setUpdatedOn(recommendCommand.getExecOn());
            learningMaterial.setUpdatedBy(recommendCommand.getExecBy().getUserId());

            skillStudioRepository.save(learningMaterial);
        }
    }

    @Override
    public void approve(ApproveCommand approveCommand) {
        log.info(String.format("Entering approve learningMaterial service -  learningMaterial Id:%s", approveCommand.getSkillstudioId()));

        LearningMaterial learningMaterial = skillStudioRepository.findBy(approveCommand.getSkillstudioId());
        if (learningMaterial != null) {
            learningMaterial.setStatus(Status.ACTIVE);

            learningMaterial.setUpdatedOn(approveCommand.getExecOn());
            learningMaterial.setUpdatedBy(approveCommand.getExecBy().getUserId());

            skillStudioRepository.save(learningMaterial);
        }
    }

    @Override
    public List<LearningMaterial> findAll() {

        log.info("Entering findAll LearningMaterial service");

        return skillStudioRepository.findAll();
    }

    @Override
    public List<LearningMaterial> findAllByTopicCode(String topicCode) {

        log.info(String.format("Entering findAllByTopicCode LearningMaterial service - Module code:%s", topicCode));

        return skillStudioRepository.findAllByTopicCode(topicCode);
    }


}
