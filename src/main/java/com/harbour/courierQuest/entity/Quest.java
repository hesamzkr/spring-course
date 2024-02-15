package com.harbour.courierQuest.entity;

import java.time.LocalDateTime;

public record Quest(String id, String name, String description, LocalDateTime startTime, LocalDateTime endTime, QuestStatus status) {
}

