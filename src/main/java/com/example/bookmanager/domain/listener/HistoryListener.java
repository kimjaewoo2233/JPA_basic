package com.example.bookmanager.domain.listener;

import com.example.bookmanager.domain.UserHistory;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class HistoryListener {

    @PrePersist
    public void persist(Object obj) {
        if (obj instanceof UserHistory) {
            ((UserHistory) obj).setCreatedAt(LocalDateTime.now());
            ((UserHistory) obj).setUpdatedAt(LocalDateTime.now());
        }
    }
}
