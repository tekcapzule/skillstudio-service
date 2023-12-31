package com.tekcapzule.skillstudio.domain.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tekcapzule.core.domain.Command;
import lombok.Builder;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class ApproveLearningMaterialCommand extends Command {
    private String learningMaterialId;
}