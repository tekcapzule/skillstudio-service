package com.tekcapzule.skillstudio.application.function.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tekcapzule.skillstudio.domain.model.*;
import com.tekcapzule.skillstudio.domain.model.Module;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class CreateInput {
    private String topicCode;
    private String subTopicCode;
    private String title;
    private String summary;
    private String description;
    private String publisher;
    private String publishedOn;
    private List<String> authors;
    private List<String> tags;
    private String duration;
    private String resourceUrl;
    private String imageUrl;
    private List<Module> modules;
    private DeliveryMode deliveryMode;
    private LearningMode learningMode;
    private Overview overview;
    private Level level;
    private TargetAudience targetAudience;
    private Schedule schedule;
    private Region region;
    private String venue;
    private String registrationUrl;
    private PrizingModel prizingModel;
    private Promotion promotion;
}
