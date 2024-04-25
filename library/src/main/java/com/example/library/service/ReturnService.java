package com.example.library.service;

import com.example.library.model.requestbody.ReturnRequest;
import com.example.library.model.responsebody.ReturnResponse;
import com.example.library.util.KMAException;

public interface ReturnService {
    ReturnResponse returnBook(ReturnRequest request) throws KMAException;
}
