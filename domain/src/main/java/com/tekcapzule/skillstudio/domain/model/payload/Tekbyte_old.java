package com.tekcapzule.skillstudio.domain.model.payload;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tekbyte_old extends LearningData {
    @DynamoDBAttribute(attributeName = "illustrationUrl")
    private String illustrationUrl;
    @DynamoDBAttribute(attributeName = "goldenCircle")
    private GoldenCircle goldenCircle;
    @DynamoDBAttribute(attributeName = "keyConcepts")
    private List<Concept> keyConcepts;
    @DynamoDBAttribute(attributeName = "timeline")
    private List<Event> timeline;
    @DynamoDBAttribute(attributeName = "applications")
    private List<Application> applications;
    @DynamoDBAttribute(attributeName = "didYouKnow")
    private String didYouKnow;
    @DynamoDBAttribute(attributeName = "wayForward")
    private String wayForward;
}