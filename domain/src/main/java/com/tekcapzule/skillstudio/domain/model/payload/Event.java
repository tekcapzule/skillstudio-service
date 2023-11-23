package com.tekcapzule.skillstudio.domain.model.payload;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Event extends LearningData {

    @DynamoDBAttribute(attributeName = "eventSchedule")
    private EventSchedule eventSchedule;
    @DynamoDBAttribute(attributeName = "pastPopularEvent")
    private Boolean pastPopularEvent;
    @DynamoDBAttribute(attributeName = "region")
    @DynamoDBTypeConvertedEnum
    private Region region;
    @DynamoDBAttribute(attributeName = "eventDate")
    private String eventDate;
    @DynamoDBAttribute(attributeName = "venue")
    private String venue;
    @DynamoDBAttribute(attributeName = "registrationUrl")
    private String registrationUrl;
}