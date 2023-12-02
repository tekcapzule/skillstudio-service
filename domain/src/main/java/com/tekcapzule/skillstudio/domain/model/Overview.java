package com.tekcapzule.skillstudio.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@DynamoDBDocument
public  class Overview {
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
