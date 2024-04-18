package com.example.library.service;

import com.example.library.model.responsebody.FindBookResponseBody;
import org.springframework.data.domain.Pageable;

public interface BookService {
    FindBookResponseBody listBook(Pageable pageable);
}
