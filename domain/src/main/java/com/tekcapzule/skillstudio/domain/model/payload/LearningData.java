package com.tekcapzule.skillstudio.domain.model.payload;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type") @JsonSubTypes({
        @JsonSubTypes.Type(value = Course.class, name = "Course"),
        @JsonSubTypes.Type(value = Digest.class, name = "Digest"),
        @JsonSubTypes.Type(value = Event.class, name = "Event"),
        @JsonSubTypes.Type(value = LearningData.Tekbyte.class, name = "Tekbyte"),
        @JsonSubTypes.Type(value = LearningData.Video.class, name = "Video"),
        @JsonSubTypes.Type(value = ResearchPaper.class, name = "ResearchPaper"),

})
public class LearningData {
    @DynamoDBAttribute(attributeName = "type")
    private String type;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    @DynamoDBDocument
    @JsonTypeName("Tekbyte")
    public static class Tekbyte extends LearningData {
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

    @JsonIgnoreProperties(ignoreUnknown = true)
    @DynamoDBDocument
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    @JsonTypeName("Video")
    public static class Video extends LearningData{
    }

}
