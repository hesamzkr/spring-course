package com.harbour.demo.courierQuest.entity;

import java.util.List;

public record QuestDetails(
        String questId,
        String title,
        String status,
        int progress,
        int total,
        String reward,
        String description,
        List<Tier> tiers
) {
}
