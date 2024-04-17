package com.example.library.controller;

import com.example.library.model.requestbody.RegisterRequestBody;
import com.example.library.model.responsebody.RegisterResponseBody;
import com.example.library.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/lib/v1/register")
public class RegisterController {
    private final RegisterService registerService;
    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @PostMapping
    public ResponseEntity<RegisterResponseBody> register(@RequestBody RegisterRequestBody requestBody) throws Exception {
        return registerService.register(requestBody);
    }
}
