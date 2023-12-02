package com.tekcapzule.skillstudio.domain.service;

import com.tekcapzule.skillstudio.domain.command.ApproveLearningMaterialCommand;
import com.tekcapzule.skillstudio.domain.command.CreateLearningMaterialCommand;
import com.tekcapzule.skillstudio.domain.command.RecommendLearningMaterialCommand;
import com.tekcapzule.skillstudio.domain.command.UpdateLearningMaterialCommand;
import com.tekcapzule.skillstudio.domain.model.LearningMaterial;

import java.util.List;


public interface LearningMaterialService {

    void create(CreateLearningMaterialCommand createLearningMaterialCommand);

    void update(UpdateLearningMaterialCommand updateLearningMaterialCommand);
    List<LearningMaterial> findAll();
    List<LearningMaterial> findAllByTopicCode(String code);
    void recommend(RecommendLearningMaterialCommand recommendLearningMaterialCommand);
    void approve(ApproveLearningMaterialCommand approveLearningMaterialCommand);
}
