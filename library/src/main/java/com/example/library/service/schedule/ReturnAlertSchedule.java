package com.example.library.service.schedule;

import com.example.library.entity.BorrowReturnEntity;
import com.example.library.entity.UserEntity;
import com.example.library.repository.BorrowReturnRepository;
import com.example.library.repository.UserRepository;
import com.example.library.service.AsyncMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReturnAlertSchedule {
    private final AsyncMailSender asyncMailSender;
    private final BorrowReturnRepository borrowReturnRepository;
    private final UserRepository userRepository;

    @Autowired
    public ReturnAlertSchedule(AsyncMailSender asyncMailSender, BorrowReturnRepository borrowReturnRepository, UserRepository userRepository) {
        this.asyncMailSender = asyncMailSender;
        this.borrowReturnRepository = borrowReturnRepository;
        this.userRepository = userRepository;
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void sendDailyEmails() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        List<String> dueDateUserList = borrowReturnRepository.findByOrderByDueDateDesc().stream()
                .filter(book -> book.getDueDate().toLocalDate().isEqual(tomorrow))
                .map(BorrowReturnEntity::getUserId)
                .collect(Collectors.toList());
        List<String> emailList = userRepository.findAllByIdIn(dueDateUserList).stream()
                .map(UserEntity::getEmail).collect(Collectors.toList());
        String subject = "Thông báo đến hạn trả sách";
        String message = "Sách của bạn hiện sắp đến hạn trả, vui lòng trả lại cho thư viện sớm tránh thu thêm phụ phí";
        for (String email : emailList) {
            asyncMailSender.sendEmail(email, subject, message);
        }
    }
}
