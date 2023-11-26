package com.tekcapzule.skillstudio.domain.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tekcapzule.core.domain.Command;
import com.tekcapzule.skillstudio.domain.model.PrizingModel;
import com.tekcapzule.skillstudio.domain.model.Promotion;
import com.tekcapzule.skillstudio.domain.model.payload.LearningData;
import com.tekcapzule.skillstudio.domain.model.payload.LearningGenericData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class CreateCommand extends Command {
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
    private LearningData payload;

}