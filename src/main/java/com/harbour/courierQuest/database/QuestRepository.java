package com.harbour.courierQuest.database;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestRepository extends MongoRepository<Quest, String> {

    @Query("{ 'couriers' : ?0 }")
    List<Quest> findByCourierId(String courierId);

    List<Quest> findActiveQuests();
}
