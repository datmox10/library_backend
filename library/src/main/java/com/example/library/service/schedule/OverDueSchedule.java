package com.example.library.service.schedule;

import com.example.library.entity.BorrowReturnEntity;
import com.example.library.repository.BorrowReturnRepository;
import com.example.library.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OverDueSchedule {
    private final BorrowReturnRepository borrowReturnRepository;

    @Autowired
    public OverDueSchedule(BorrowReturnRepository borrowReturnRepository) {
        this.borrowReturnRepository = borrowReturnRepository;
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void overDueCheck() {
        LocalDateTime now = LocalDateTime.now();
        List<BorrowReturnEntity> borrowReturnEntities = borrowReturnRepository.findAll().stream()
                .filter(item->item.getDueDate().isBefore(now)).collect(Collectors.toList());
        for (BorrowReturnEntity borrowReturn : borrowReturnEntities){
            borrowReturn.setOverdue((int) now.until(borrowReturn.getDueDate(), ChronoUnit.DAYS));
            borrowReturn.setStatus(Common.OVER_DUE);
        }
        borrowReturnRepository.saveAll(borrowReturnEntities);
    }
}
