package com.tekcapzule.skillstudio.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tekcapzule.core.domain.AggregateRoot;
import com.tekcapzule.core.domain.BaseDomainEntity;
import com.tekcapzule.skillstudio.domain.model.payload.Tekbyte;
import lombok.*;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
@DynamoDBTable(tableName = "SkillStudio")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LearningMaterial extends BaseDomainEntity implements AggregateRoot {
    @DynamoDBHashKey(attributeName = "learningMaterialId")
    @DynamoDBAutoGeneratedKey
    private String learningMaterialId;
    @DynamoDBAttribute(attributeName = "topicCode")
    private String topicCode;
    @DynamoDBAttribute(attributeName = "subTopicCode")
    private String subTopicCode;
    @DynamoDBAttribute(attributeName = "title")
    private String title;
    @DynamoDBAttribute(attributeName = "summary")
    private String summary;
    @DynamoDBAttribute(attributeName = "description")
    private String description;
    @DynamoDBAttribute(attributeName = "publisher")
    private String publisher;
    @DynamoDBAttribute(attributeName = "publishedOn")
    private String publishedOn;
    @DynamoDBAttribute(attributeName = "authors")
    private List<String> authors;
    @DynamoDBAttribute(attributeName = "tags")
    private List<String> tags;
    @DynamoDBAttribute(attributeName = "duration")
    private String duration;
    @DynamoDBAttribute(attributeName = "resourceUrl")
    private String resourceUrl;
    @DynamoDBAttribute(attributeName = "imageUrl")
    private String imageUrl;
    @DynamoDBAttribute(attributeName = "modules")
    private List<Module> modules;
    @DynamoDBAttribute(attributeName = "deliveryMode")
    @DynamoDBTypeConvertedEnum
    private DeliveryMode deliveryMode;
    @DynamoDBAttribute(attributeName = "learningMode")
    @DynamoDBTypeConvertedEnum
    private LearningMode learningMode;
    @DynamoDBAttribute(attributeName = "schedule")
    private Schedule schedule;
    @DynamoDBAttribute(attributeName = "region")
    @DynamoDBTypeConvertedEnum
    private Region region;
    @DynamoDBAttribute(attributeName = "venue")
    private String venue;
    @DynamoDBAttribute(attributeName = "registrationUrl")
    private String registrationUrl;
    @DynamoDBAttribute(attributeName = "prizingModel")
    @DynamoDBTypeConvertedEnum
    private PrizingModel prizingmodel;
    @DynamoDBAttribute(attributeName = "promotion")
    private Promotion promotion;
    @DynamoDBAttribute(attributeName = "recommendations")
    private int recommendations;
    @DynamoDBAttribute(attributeName = "status")
    @DynamoDBTypeConvertedEnum
    private Status status;
    @DynamoDBAttribute(attributeName = "tekbyte")
    private Tekbyte tekbyte;
}

