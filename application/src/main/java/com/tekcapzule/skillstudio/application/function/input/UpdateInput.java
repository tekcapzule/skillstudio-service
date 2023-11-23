package com.tekcapzule.skillstudio.application.function.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tekcapzule.skillstudio.domain.model.*;
import com.tekcapzule.skillstudio.domain.model.payload.Module;
import com.tekcapzule.skillstudio.domain.model.payload.DeliveryMode;
import com.tekcapzule.skillstudio.domain.model.payload.LearningMode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class UpdateInput {
    private String skillstudioId;
    private String title;
    private String topicCode;
    private String author;
    private String publisher;
    private String duration;
    private String resourceUrl;
    private String publishedOn;
    private String summary;
    private String description;
    private List<Module> modules;
    private PrizingModel prizingModel;
    private DeliveryMode deliveryMode;
    private LearningMode learningMode;
    private String imageUrl;

    private int recommendations;

    private Promotion promotion;

}
