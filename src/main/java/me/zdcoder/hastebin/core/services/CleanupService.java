package me.zdcoder.hastebin.core.services;


import jakarta.transaction.Transactional;
import me.zdcoder.hastebin.core.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CleanupService {

    @Autowired
    private RecordRepository recordRepository;


    @Scheduled(fixedRate = 604800000) //1 week
    @Transactional
    public void deleteExpiredRecords() {
        LocalDateTime now = LocalDateTime.now();
        recordRepository.deleteAllByExpiryDateBefore(now);
    }
}
