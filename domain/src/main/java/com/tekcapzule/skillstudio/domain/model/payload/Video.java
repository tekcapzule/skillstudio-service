package com.tekcapzule.skillstudio.domain.model.payload;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @DynamoDBAttribute(attributeName = "recommendations")
    private int recommendations;
    @DynamoDBAttribute(attributeName = "publishedOn")
    private String publishedOn;
}

