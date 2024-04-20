package com.example.library.service;

import com.example.library.model.requestbody.BorrowRequest;
import com.example.library.model.responsebody.BorrowResponse;
import com.example.library.model.responsebody.HistoryBorrowResponse;
import com.example.library.util.KMAException;

public interface BorrowService {
    BorrowResponse borrowBook(BorrowRequest request) throws KMAException;
    HistoryBorrowResponse borrowHistory() throws KMAException;
}
