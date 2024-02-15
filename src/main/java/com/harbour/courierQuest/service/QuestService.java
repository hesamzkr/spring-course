package com.harbour.courierQuest.service;

import com.harbour.courierQuest.database.CourierRepository;
import com.harbour.courierQuest.database.QuestRepository;
import com.harbour.courierQuest.entity.Courier;
import com.harbour.courierQuest.entity.QuestDetails;
import com.harbour.courierQuest.entity.QuestStatus;
import com.harbour.courierQuest.database.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestService {

    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private CourierRepository courierRepository;

    public void joinQuest(String questId) {
        Quest quest = questRepository.findById(questId).orElseThrow();
        quest.getCouriers().add("1");
        questRepository.save(quest);
    }

    public List<com.harbour.courierQuest.entity.Quest> getActiveQuests() {
        return questRepository.findAll().stream()
                .filter((x) -> x.getStatus() == QuestStatus.ACTIVE)
                .map((quest) -> new com.harbour.courierQuest.entity.Quest(
                       quest.getId(),
                       quest.getName(),
                        quest.getDescription(),
                        quest.getStartTime(),
                        quest.getEndTime(),
                        quest.getStatus()
                ))
                .collect(Collectors.toList());
    }

    public List<com.harbour.courierQuest.entity.Quest> getQuestHistory() {
        return questRepository.findByCourierId("1").stream()
                .filter((x) -> x.getStatus() == QuestStatus.COMPLETED)
                .map((quest) -> new com.harbour.courierQuest.entity.Quest(
                       quest.getId(),
                       quest.getName(),
                        quest.getDescription(),
                        quest.getStartTime(),
                        quest.getEndTime(),
                        quest.getStatus()
                ))
                .collect(Collectors.toList());
    }

    public QuestDetails getQuestDetails(String questId) {
        Quest quest = questRepository.findById(questId).orElseThrow();
        Set<String> courierIds = quest.getCouriers();
        Set<Courier> couriers = courierIds
                .stream()
                .map((id) -> courierRepository.findById(id).orElseThrow())
                .map((courier) -> new Courier(courier.getId(), courier.getName(), courier.getEmail()))
                .collect(Collectors.toSet());

        return new QuestDetails(
                quest.getId(),
                quest.getName(),
                quest.getStatus(),
                quest.getDescription(),
                couriers,
                quest.getTier()
        );
    }
}
