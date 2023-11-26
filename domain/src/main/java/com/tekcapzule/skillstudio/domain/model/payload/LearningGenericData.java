package com.tekcapzule.skillstudio.domain.model.payload;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBFlattened;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@Slf4j
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
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

    public T getItem() {
        log.info("entering get item"+item.getClass());

        if(item instanceof Tekbyte) {
            System.out.println("illustration url"+((Tekbyte) item).getIllustrationUrl());
        }
        return item;
    }

    public void setItem(T item) throws JsonProcessingException {
        if(item.getType().equals("Tekbyte")) {
            log.info("entering tekbyte setitem");

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(item);
            // Print the JSON string
            System.out.println(jsonString);
            this.item = mapper.readValue(jsonString, (Class<T>) Tekbyte.class);
        }

    }

    @DynamoDBAttribute(attributeName = "item")
    private T item;

}
