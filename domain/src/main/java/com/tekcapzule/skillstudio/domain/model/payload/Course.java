package com.tekcapzule.skillstudio.domain.model.payload;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class Course extends LearningData {

    @DynamoDBAttribute(attributeName = "modules")
    private List<Module> modules;
    @DynamoDBAttribute(attributeName = "deliveryMode")
    @DynamoDBTypeConvertedEnum
    private DeliveryMode deliveryMode;
    @DynamoDBAttribute(attributeName = "learningMode")
    @DynamoDBTypeConvertedEnum
    private LearningMode learningMode;

}

