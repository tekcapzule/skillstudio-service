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
public class Digest {
    @DynamoDBAttribute(attributeName = "category")
    @DynamoDBTypeConvertedEnum
    private Category category;
    @DynamoDBAttribute(attributeName = "schedule")
    private String schedule;

}