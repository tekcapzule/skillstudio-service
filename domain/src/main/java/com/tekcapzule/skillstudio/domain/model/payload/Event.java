package com.tekcapzule.skillstudio.domain.model.payload;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @DynamoDBAttribute(attributeName = "schedule")
    private Schedule schedule;
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