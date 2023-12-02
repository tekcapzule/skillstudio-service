package com.tekcapzule.skillstudio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TargetAudience {
    STUDENT("Student"),
    DEVELOPER("Developer"),
    MANAGER("Manager"),
    EXECUTIVE("Executive");

    @Getter
    private String value;
}