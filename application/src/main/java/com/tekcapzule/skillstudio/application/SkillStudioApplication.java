package com.tekcapzule.skillstudio.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.tekcapzule.skillstudio","com.tekcapzule.core"})
public class SkillStudioApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkillStudioApplication.class, args);
    }
}
