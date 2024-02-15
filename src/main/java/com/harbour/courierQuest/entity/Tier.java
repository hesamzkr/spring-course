package com.harbour.courierQuest.entity;


public record Tier(
        int tierLevel,
        int deliveriesRequired,
        String reward
) {}
