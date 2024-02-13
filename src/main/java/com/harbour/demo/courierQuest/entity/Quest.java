package com.harbour.demo.courierQuest.entity;

import java.time.LocalDateTime;

public record Quest(Long id, String name, String description, LocalDateTime startTime, LocalDateTime endTime, QuestStatus status) {}

