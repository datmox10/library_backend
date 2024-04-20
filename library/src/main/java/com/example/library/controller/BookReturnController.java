package com.example.library.controller;

import com.example.library.model.requestbody.BorrowRequest;
import com.example.library.model.responsebody.BookDetailResponse;
import com.example.library.model.responsebody.BorrowResponse;
import com.example.library.model.responsebody.HistoryBorrowResponse;
import com.example.library.service.BorrowService;
import com.example.library.util.KMAException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/lib/v1/book-return")
@RequiredArgsConstructor
public class BookReturnController {
    private final BorrowService borrowService;

    @PostMapping("/borrow")
    public BorrowResponse borrowBook(@RequestBody BorrowRequest request) throws KMAException {
        return borrowService.borrowBook(request);
    }

    @GetMapping("/borrow-history")
    public HistoryBorrowResponse historyBorrow() throws KMAException {
        return borrowService.borrowHistory();
    }
}
