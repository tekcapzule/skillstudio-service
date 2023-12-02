package com.tekcapzule.skillstudio.application.mapper;

import com.tekcapzule.core.domain.Command;
import com.tekcapzule.core.domain.ExecBy;
import com.tekcapzule.core.domain.Origin;
import com.tekcapzule.skillstudio.application.function.input.ApproveLearningMaterialInput;
import com.tekcapzule.skillstudio.application.function.input.CreateLearningMaterialInput;
import com.tekcapzule.skillstudio.application.function.input.RecommendLearningMaterialInput;
import com.tekcapzule.skillstudio.application.function.input.UpdateLearningMaterialInput;
import com.tekcapzule.skillstudio.domain.command.ApproveLearningMaterialCommand;
import com.tekcapzule.skillstudio.domain.command.CreateLearningMaterialCommand;
import com.tekcapzule.skillstudio.domain.command.RecommendLearningMaterialCommand;
import com.tekcapzule.skillstudio.domain.command.UpdateLearningMaterialCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.function.BiFunction;

@Slf4j
public final class InputOutputMapper {
    private InputOutputMapper() {

    }

    public static final BiFunction<Command, Origin, Command> addOrigin = (command, origin) -> {
        OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
        command.setChannel(origin.getChannel());
        command.setExecBy(ExecBy.builder().tenantId(origin.getTenantId()).userId(origin.getUserId()).build());
        command.setExecOn(utc.toString());
        return command;
    };

    public static final BiFunction<CreateLearningMaterialInput, Origin, CreateLearningMaterialCommand> buildCreateCommandFromCreateInput = (createLearningMaterialInput, origin) -> {
        CreateLearningMaterialCommand createLearningMaterialCommand =  CreateLearningMaterialCommand.builder().build();
        BeanUtils.copyProperties(createLearningMaterialInput, createLearningMaterialCommand);
        addOrigin.apply(createLearningMaterialCommand, origin);
        return createLearningMaterialCommand;
    };

    public static final BiFunction<UpdateLearningMaterialInput, Origin, UpdateLearningMaterialCommand> buildUpdateCommandFromUpdateInput = (updateLearningMaterialInput, origin) -> {
        UpdateLearningMaterialCommand updateLearningMaterialCommand = UpdateLearningMaterialCommand.builder().build();
        BeanUtils.copyProperties(updateLearningMaterialInput, updateLearningMaterialCommand);
        addOrigin.apply(updateLearningMaterialCommand, origin);
        return updateLearningMaterialCommand;
    };

    public static final BiFunction<RecommendLearningMaterialInput, Origin, RecommendLearningMaterialCommand> buildRecommendCommandFromRecommendInput = (recommendLearningMaterialInput, origin) -> {
        RecommendLearningMaterialCommand recommendLearningMaterialCommand =  RecommendLearningMaterialCommand.builder().build();
        BeanUtils.copyProperties(recommendLearningMaterialInput, recommendLearningMaterialCommand);
        addOrigin.apply(recommendLearningMaterialCommand, origin);
        return recommendLearningMaterialCommand;
    };

    public static final BiFunction<ApproveLearningMaterialInput, Origin, ApproveLearningMaterialCommand> buildApproveCommandFromApproveSkillStudioInput = (approveLearningMaterialInput, origin) -> {
        ApproveLearningMaterialCommand approveLearningMaterialCommand =  ApproveLearningMaterialCommand.builder().build();
        BeanUtils.copyProperties(approveLearningMaterialInput, approveLearningMaterialCommand);
        addOrigin.apply(approveLearningMaterialCommand, origin);
        return approveLearningMaterialCommand;
    };

}
