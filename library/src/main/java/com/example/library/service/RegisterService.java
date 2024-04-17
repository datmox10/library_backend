package com.example.library.service;


import com.example.library.model.requestbody.RegisterRequestBody;
import com.example.library.model.responsebody.RegisterResponseBody;
import org.springframework.http.ResponseEntity;

public interface RegisterService {
    ResponseEntity<RegisterResponseBody> register(RegisterRequestBody requestBody) throws Exception;
}
