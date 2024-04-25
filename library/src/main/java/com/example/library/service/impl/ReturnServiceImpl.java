package com.example.library.service.impl;

import com.example.library.entity.BorrowReturnEntity;
import com.example.library.entity.UserEntity;
import com.example.library.model.requestbody.ReturnRequest;
import com.example.library.model.responsebody.ReturnResponse;
import com.example.library.repository.BorrowReturnRepository;
import com.example.library.repository.UserRepository;
import com.example.library.service.ReturnService;
import com.example.library.util.Common;
import com.example.library.util.ErrorCode;
import com.example.library.util.KMAException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReturnServiceImpl implements ReturnService {
    private final BorrowReturnRepository borrowReturnRepository;
    private final UserRepository userRepository;

    @Override
    public ReturnResponse returnBook(ReturnRequest request) throws KMAException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserEntity user = userRepository.findAllByUserName(userName);
        BorrowReturnEntity returnEntity = borrowReturnRepository.findAllByBookId(request.getBookId());
        if (!user.getId().equals(returnEntity.getUserId())) {
            throw new KMAException(ErrorCode.USER_NOT_EXITS, "USER_NOT_MATCH");
        }
        returnEntity.setStatus(Common.RETURN);
        returnEntity.setReturnDate(LocalDateTime.now());
        borrowReturnRepository.save(returnEntity);
        return new ReturnResponse(Common.SUCCESS);
    }
}
