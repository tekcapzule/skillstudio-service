/*
package com.tekcapzule.skillstudio.domain.utils;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.tekcapzule.skillstudio.domain.model.payload.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Slf4j

public class PayloadConverter implements DynamoDBTypeConverter<String, LearningData> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convert(LearningData object) {
        try {
//            Map<String, Object> attributeMap = new HashMap<>();
//            attributeMap.put("type", object.getType());
            //String jsonString = objectMapper.writeValueAsString(object);
            if (object.getType()!=null && object.getType().equals("Tekbyte")) {
                LearningData.Tekbyte tekbyte = (LearningData.Tekbyte) object;
                String jsonString = objectMapper.writeValueAsString(object);
                log.info("jsonString value"+jsonString);
                return jsonString;
              //  attributeMap.put()
              //  objectMapper.
               */
/* attributeMap.put("videoAttribute", tekbyte.());
                attributeMap.put("additionalAttributes", video.getAdditionalAttributes());*//*

            } else if (object.getType()!=null && object.getType().equals("Video")) {
                LearningData.Video video = (LearningData.Video) object;
                String jsonString = objectMapper.writeValueAsString(video);
                log.info("jsonString value"+jsonString);
                return jsonString;
                //  attributeMap.put()
                //  objectMapper.
               */
/* attributeMap.put("videoAttribute", tekbyte.());
                attributeMap.put("additionalAttributes", video.getAdditionalAttributes());*//*

            }
        } catch (JsonProcessingException e) {
            // Handle the exception appropriately
            throw new RuntimeException("Error converting object to JSON", e);
        }
        return null;
    }

    @Override
    public LearningData unconvert(String jsonString) {
        try {
//            byte[] decodedBytes = Base64.getDecoder().decode(json);
//            String jsonString = new String(decodedBytes);
            LearningData learningData = objectMapper.readValue(jsonString, LearningData.class);

//            if ("Course".equals(learningData.getType())) {
//                return objectMapper.readValue(jsonString, Course.class);
//            } else if ("Digest".equals(learningData.getType())) {
//                return objectMapper.readValue(jsonString, Digest.class);
//            }else if ("Event".equals(learningData.getType())) {
//                return objectMapper.readValue(jsonString, Event.class);
//            }else if ("Tekbyte".equals(learningData.getType())) {
//                log.info("Entering tekbyte");
//                return objectMapper.readValue(jsonString, Tekbyte.class);
//            }else if ("Video".equals(learningData.getType())) {
//                return objectMapper.readValue(jsonString, Video.class);
//            }else if ("ResearchPaper".equals(learningData.getType())) {
//                return objectMapper.readValue(jsonString, ResearchPaper.class);
//            }
            if ("Video".equals(learningData.getType())) {
                log.info("Entering tekbyte");
                return objectMapper.readValue(jsonString, LearningData.Video.class);
           }else if ("Tekbyte".equals(learningData.getType())) {
                log.info("Entering tekbyte");
                return objectMapper.readValue(jsonString, LearningData.Tekbyte.class);
            }


            // Handle other types or throw an exception for unknown types
           throw new RuntimeException("Unknown type: " + learningData.getType());
        } catch (JsonProcessingException e) {
            // Handle the exception appropriately
            throw new RuntimeException("Error converting JSON to object", e);
        }
    }
}
*/
/*
public class PayloadConverter {
public static class Serializer extends JsonSerializer<LearningData> {
    @Override
    public void serialize(LearningData value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", value.getType());
        gen.writeFieldName("data");
        provider.defaultSerializeValue(value, gen);
        gen.writeEndObject();
    }
}

public static class Deserializer extends JsonDeserializer<LearningData> {
    @Override
    public LearningData deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        String type = node.get("type").asText();
        JsonNode dataNode = node.get("data");

        switch (type) {
            case "Tekbyte":
                return p.getCodec().treeToValue(dataNode, Tekbyte.class);
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
}*//*



*/
