package com.tekcapzule.skillstudio.domain.model.payload;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = Course.class, name = "Course"),
//        @JsonSubTypes.Type(value = Digest.class, name = "Digest"),
//        @JsonSubTypes.Type(value = Event.class, name = "Event"),
//        @JsonSubTypes.Type(value = Tekbyte_old.class, name = "Tekbyte"),
//        @JsonSubTypes.Type(value = Video.class, name = "Video"),
//        @JsonSubTypes.Type(value = ResearchPaper.class, name = "ResearchPaper"),
//
//})
public class LearningData {
    private String type;
}
