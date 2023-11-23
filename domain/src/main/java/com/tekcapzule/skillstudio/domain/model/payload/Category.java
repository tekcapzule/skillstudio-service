package com.tekcapzule.skillstudio.domain.model.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Category {
    NEWS_LETTER("News Letter"),
    PODCAST("Podcast");

    @Getter
    private String value;
}