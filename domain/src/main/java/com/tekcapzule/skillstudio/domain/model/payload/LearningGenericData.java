package com.tekcapzule.skillstudio.domain.model.payload;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBFlattened;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBFlattened
@JsonInclude(JsonInclude.Include.NON_NULL)
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
public class LearningGenericData<T extends LearningData> {
    private T item;
}
