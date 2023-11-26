package com.tekcapzule.skillstudio.domain.model.payload;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
//@DynamoDBDocument
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Course.class, name = "Course"),
        @JsonSubTypes.Type(value = Digest.class, name = "Digest"),
        @JsonSubTypes.Type(value = Event.class, name = "Event"),
        @JsonSubTypes.Type(value = Tekbyte.class, name = "Tekbyte"),
        @JsonSubTypes.Type(value = Video.class, name = "Video"),
        @JsonSubTypes.Type(value = ResearchPaper.class, name = "ResearchPaper")
})
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = Course.class, name = "Course"),
//        @JsonSubTypes.Type(value = Digest.class, name = "Digest"),
//        @JsonSubTypes.Type(value = Event.class, name = "Event"),
//        @JsonSubTypes.Type(value = LearningData.Tekbyte.class, name = "Tekbyte"),
//        @JsonSubTypes.Type(value = LearningData.Video.class, name = "Video"),
//        @JsonSubTypes.Type(value = ResearchPaper.class, name = "ResearchPaper"),
//
//})
public class LearningData {
    private String type;

}
