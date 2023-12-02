package com.tekcapzule.skillstudio.application.function.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tekcapzule.skillstudio.domain.model.PrizingModel;
import com.tekcapzule.skillstudio.domain.model.Promotion;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class CreateInput {
    private String title;
    private String topicCode;
    private String subTopicCode;
    private List<String> authors;
    private String publisher;
    private String duration;
    private String resourceUrl;
    private String summary;
    private String description;
    private PrizingModel prizingModel;
    private String imageUrl;
    private List<String> tags;

    private int recommendations;

    private Promotion promotion;
    private String publishedOn;
}