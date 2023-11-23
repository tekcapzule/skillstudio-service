package com.tekcapzule.skillstudio.domain.model.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@SuperBuilder
public class Video extends LearningData{
}

