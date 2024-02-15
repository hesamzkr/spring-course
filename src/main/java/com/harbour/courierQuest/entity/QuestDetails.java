package com.harbour.courierQuest.entity;

import java.util.List;
import java.util.Set;

public record QuestDetails(
        String questId,
        String title,
        QuestStatus status,
        String description,
        Set<Courier> courier,
        Tier tier
) {
}
