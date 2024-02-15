package com.harbour.courierQuest.database;

import com.harbour.courierQuest.entity.QuestStatus;
import com.harbour.courierQuest.entity.Tier;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Document
@Getter
@Setter
public class Quest {
    @Id
    private String id;
    private String name;
    private String description;
    private java.time.LocalDateTime startTime;
    private LocalDateTime endTime;
    private QuestStatus status;
    private Set<String> couriers = new HashSet<>();
    private Tier tier;
}