package com.tekcapzule.skillstudio.domain.utils;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tekcapzule.skillstudio.domain.model.payload.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Base64;

@Slf4j
public class PayloadConverter implements DynamoDBTypeConverter<String, LearningData> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convert(LearningData object) {
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            log.info("json value"+jsonString);
            return jsonString;
        } catch (JsonProcessingException e) {
            // Handle the exception appropriately
            throw new RuntimeException("Error converting object to JSON", e);
        }
    }

    @Override
    public LearningData unconvert(String json) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(json);
            String jsonString = new String(decodedBytes);
            LearningData learningData = objectMapper.readValue(jsonString, LearningData.class);

            if ("Course".equals(learningData.getType())) {
                return objectMapper.readValue(jsonString, Course.class);
            } else if ("Digest".equals(learningData.getType())) {
                return objectMapper.readValue(jsonString, Digest.class);
            }else if ("Event".equals(learningData.getType())) {
                return objectMapper.readValue(jsonString, Event.class);
            }else if ("Tekbyte".equals(learningData.getType())) {
                log.info("Entering tekbyte");
                return objectMapper.readValue(jsonString, Tekbyte.class);
            }else if ("Video".equals(learningData.getType())) {
                return objectMapper.readValue(jsonString, Video.class);
            }else if ("ResearchPaper".equals(learningData.getType())) {
                return objectMapper.readValue(jsonString, ResearchPaper.class);
            }


            // Handle other types or throw an exception for unknown types
            throw new RuntimeException("Unknown type: " + learningData.getType());
        } catch (JsonProcessingException e) {
            // Handle the exception appropriately
            throw new RuntimeException("Error converting JSON to object", e);
        }
    }
}
