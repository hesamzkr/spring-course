package com.harbour.demo.courierQuest.controller;

import com.harbour.demo.courierQuest.entity.Quest;
import com.harbour.demo.courierQuest.entity.QuestDetails;
import com.harbour.demo.courierQuest.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/quests")
public class QuestController {

    @Autowired
    private QuestService questService;

    @PostMapping("/{questId}/join")
    public ResponseEntity<String> joinQuest(@PathVariable Long questId) {
        // Implementation to subscribe a courier to a quest
        questService.joinQuest(questId);
        return ResponseEntity.ok("Subscribed successfully to quest " + questId);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Quest>> getActiveQuests() {
        // Implementation to retrieve active quests
        List<Quest> activeQuests = questService.getActiveQuests();
        return ResponseEntity.ok(activeQuests);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Quest>> getQuestHistory() {
        // Implementation to retrieve quest history for a courier
        List<Quest> questHistory = questService.getQuestHistory();
        return ResponseEntity.ok(questHistory);
    }

    @GetMapping("/{questId}/details")
    public ResponseEntity<QuestDetails> getQuestDetails(@PathVariable Long questId) {
        // Implementation to retrieve details of a specific quest
        QuestDetails questDetails = questService.getQuestDetails(questId);
        return ResponseEntity.ok(questDetails);
    }
}
