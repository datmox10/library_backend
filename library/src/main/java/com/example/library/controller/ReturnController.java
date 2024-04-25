package com.example.library.controller;

import com.example.library.model.requestbody.ReturnRequest;
import com.example.library.model.responsebody.ReturnResponse;
import com.example.library.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/lib/v1/return-book")
public class ReturnController {
    private final ReturnService returnService;

    @Autowired
    public ReturnController(ReturnService returnService) {
        this.returnService = returnService;
    }

    @PostMapping
    public ResponseEntity<ReturnResponse> register(@RequestBody ReturnRequest requestBody) throws Exception {
        return new ResponseEntity<>(returnService.returnBook(requestBody), HttpStatus.OK);
    }
}
