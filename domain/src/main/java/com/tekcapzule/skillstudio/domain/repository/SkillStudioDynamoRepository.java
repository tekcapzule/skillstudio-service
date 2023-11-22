package com.tekcapzule.skillstudio.domain.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.tekcapzule.skillstudio.domain.model.LearningMaterial;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Repository
public class SkillStudioDynamoRepository implements SkillStudioRepository {

    private DynamoDBMapper dynamo;
    public static final String ACTIVE_STATUS = "ACTIVE";

    @Autowired
    public SkillStudioDynamoRepository(DynamoDBMapper dynamo) {
        this.dynamo = dynamo;
    }

    @Override
    public List<LearningMaterial> findAll() {

        return dynamo.scan(LearningMaterial.class,new DynamoDBScanExpression());
    }

    @Override
    public List<LearningMaterial> findAllByTopicCode(String topicCode) {

        HashMap<String, AttributeValue> expAttributes = new HashMap<>();
        expAttributes.put(":status", new AttributeValue().withS(ACTIVE_STATUS));
        expAttributes.put(":topicCode", new AttributeValue().withS(topicCode));

        HashMap<String, String> expNames = new HashMap<>();
        expNames.put("#status", "status");
        expNames.put("#topicCode", "topicCode");


        DynamoDBQueryExpression<LearningMaterial> queryExpression = new DynamoDBQueryExpression<LearningMaterial>()
                .withIndexName("topicGSI").withConsistentRead(false)
                .withKeyConditionExpression("#status = :status and #topicCode = :topicCode")
                .withExpressionAttributeValues(expAttributes)
                .withExpressionAttributeNames(expNames);

        return dynamo.query(LearningMaterial.class, queryExpression);

    }

    @Override
    public LearningMaterial findBy(String code) {
        return dynamo.load(LearningMaterial.class, code);
    }

    @Override
    public LearningMaterial save(LearningMaterial learningMaterial) {
        dynamo.save(learningMaterial);
        return learningMaterial;
    }
}
