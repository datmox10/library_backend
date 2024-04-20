package com.example.library.service;

import com.example.library.model.responsebody.BookDetailResponse;
import com.example.library.model.responsebody.GetBookResponseBody;
import org.springframework.data.domain.Pageable;

public interface BookService {
    GetBookResponseBody listBook(Pageable pageable);
    BookDetailResponse bookDetail(String id);
}
