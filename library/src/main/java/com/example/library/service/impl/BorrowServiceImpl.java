package com.example.library.service.impl;

import com.example.library.entity.BorrowReturnEntity;
import com.example.library.entity.UserEntity;
import com.example.library.model.requestbody.BorrowRequest;
import com.example.library.model.responsebody.BorrowResponse;
import com.example.library.model.responsebody.HistoryBorrowResponse;
import com.example.library.repository.BorrowReturnRepository;
import com.example.library.repository.UserRepository;
import com.example.library.service.BorrowService;
import com.example.library.util.Common;
import com.example.library.util.ErrorCode;
import com.example.library.util.KMAException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    private final BorrowReturnRepository borrowReturnRepository;
    private final UserRepository userRepository;

    @Override
    public BorrowResponse borrowBook(BorrowRequest request) throws KMAException {
        LocalDateTime now = LocalDateTime.now();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserEntity user = userRepository.findAllByUserName(userName);
        if (user == null) {
            throw new KMAException(ErrorCode.USER_NOT_EXITS, "USER_NOT_EXITS");
        }
        BorrowReturnEntity borrowReturnEntity = BorrowReturnEntity.builder()
                .id(UUID.randomUUID().toString())
                .bookId(request.getBookId())
                .borrowDate(now)
                .dueDate(now.plusDays(14))
                .status(Common.BORROW)
                .quantity(request.getQuantity())
                .userId(user.getId())
                .build();
        borrowReturnRepository.save(borrowReturnEntity);
        return new BorrowResponse(Common.SUCCESS);
    }

    @Override
    public HistoryBorrowResponse borrowHistory() throws KMAException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserEntity user = userRepository.findAllByUserName(userName);
        if (user == null) {
            throw new KMAException(ErrorCode.USER_NOT_EXITS, "USER_NOT_EXITS");
        }
        List<BorrowReturnEntity> list = borrowReturnRepository.findAllByUserIdOrderByBorrowDateDesc(user.getId());
        return new HistoryBorrowResponse(list);
    }
}
