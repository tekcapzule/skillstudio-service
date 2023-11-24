package com.tekcapzule.skillstudio.domain.utils;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tekcapzule.skillstudio.domain.model.payload.*;

public class PayloadConverter implements DynamoDBTypeConverter<String, LearningData> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convert(LearningData object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            // Handle the exception appropriately
            throw new RuntimeException("Error converting object to JSON", e);
        }
    }

    @Override
    public LearningData unconvert(String json) {
        try {
            LearningData superClassObject = objectMapper.readValue(json, LearningData.class);

            if ("Course".equals(superClassObject.getType())) {
                return objectMapper.readValue(json, Course.class);
            } else if ("Digest".equals(superClassObject.getType())) {
                return objectMapper.readValue(json, Digest.class);
            }else if ("Event".equals(superClassObject.getType())) {
                return objectMapper.readValue(json, Event.class);
            }else if ("Tekbyte".equals(superClassObject.getType())) {
                return objectMapper.readValue(json, Tekbyte.class);
            }else if ("Video".equals(superClassObject.getType())) {
                return objectMapper.readValue(json, Video.class);
            }else if ("ResearchPaper".equals(superClassObject.getType())) {
                return objectMapper.readValue(json, ResearchPaper.class);
            }


            // Handle other types or throw an exception for unknown types
            throw new RuntimeException("Unknown type: " + superClassObject.getType());
        } catch (JsonProcessingException e) {
            // Handle the exception appropriately
            throw new RuntimeException("Error converting JSON to object", e);
        }
    }
}
