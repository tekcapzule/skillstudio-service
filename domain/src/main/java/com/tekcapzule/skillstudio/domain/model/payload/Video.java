package com.tekcapzule.skillstudio.domain.model.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Video extends LearningData{
}

