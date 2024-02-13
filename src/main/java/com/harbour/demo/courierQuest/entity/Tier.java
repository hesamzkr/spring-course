package com.harbour.demo.courierQuest.entity;


public record Tier(
        int tierLevel,
        int deliveriesRequired,
        String reward
) {}
