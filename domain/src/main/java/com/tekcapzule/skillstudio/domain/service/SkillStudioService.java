package com.tekcapzule.skillstudio.domain.service;

import com.tekcapzule.skillstudio.domain.command.ApproveCommand;
import com.tekcapzule.skillstudio.domain.command.CreateCommand;
import com.tekcapzule.skillstudio.domain.command.RecommendCommand;
import com.tekcapzule.skillstudio.domain.command.UpdateCommand;
import com.tekcapzule.skillstudio.domain.model.LearningMaterial;

import java.util.List;


public interface SkillStudioService {

    void create(CreateCommand createCommand);

    void update(UpdateCommand updateCommand);
    List<LearningMaterial> findAll();
    List<LearningMaterial> findAllByTopicCode(String code);
    void recommend(RecommendCommand recommendCommand);
    void approve(ApproveCommand approveCommand);
}
