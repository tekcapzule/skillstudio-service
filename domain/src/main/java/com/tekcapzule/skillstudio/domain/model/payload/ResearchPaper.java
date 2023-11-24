package com.tekcapzule.skillstudio.domain.model.payload;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@DynamoDBDocument
public class ResearchPaper extends LearningData {

}

