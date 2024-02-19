package com.harbour.courierQuest;

import com.harbour.courierQuest.database.Quest;
import com.harbour.courierQuest.database.QuestRepository;
import com.harbour.courierQuest.service.QuestService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QuestServiceTest {

    @Mock
    private QuestRepository questRepository;

    @InjectMocks
    private QuestService questService;

    @Test
    public void testJoinQuest() {
        // Setup
        String questId = "questId";
        Quest quest = new Quest(/* parameters for quest */);
        when(questRepository.findById(questId)).thenReturn(Optional.of(quest));

        // Execute
        questService.joinQuest(questId);

        // Verify
        verify(questRepository, times(1)).save(any(Quest.class));
    }

    @Test
    public void testGetActiveQuests() {
        // Setup
        when(questRepository.findActiveQuests()).thenReturn(List.of(new Quest()));

        // Execute
        List<com.harbour.courierQuest.entity.Quest> activeQuests = questService.getActiveQuests();

        // Assert
        assertThat(activeQuests).isNotEmpty();
    }
}

