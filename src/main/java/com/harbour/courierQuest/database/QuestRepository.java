package com.harbour.courierQuest.database;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestRepository extends MongoRepository<Quest, String> {

    public  java.util.Optional<Quest> findByCourierId(String courierId);
}
