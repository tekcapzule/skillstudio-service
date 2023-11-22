package com.tekcapzule.skillstudio.domain.repository;

import com.tekcapzule.core.domain.CrudRepository;
import com.tekcapzule.skillstudio.domain.model.LearningMaterial;

import java.util.List;

public interface SkillStudioRepository extends CrudRepository<LearningMaterial, String> {

    List<LearningMaterial> findAllByTopicCode(String topicCode);
}
