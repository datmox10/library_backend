package com.example.library.service.impl;

import com.example.library.entity.BooksEntity;
import com.example.library.model.responsebody.BookDetailResponse;
import com.example.library.model.responsebody.GetBookResponseBody;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public GetBookResponseBody listBook(Pageable pageable) {
        GetBookResponseBody responseBody = new GetBookResponseBody();
        Page<BooksEntity> booksEntities = bookRepository.findAll(pageable);
        responseBody.setBooksEntityList(booksEntities.getContent());
        return responseBody;
    }

    @Override
    public BookDetailResponse bookDetail(String id) {
        Optional<BooksEntity> booksEntity = bookRepository.findById(id);
        return booksEntity.map(BookDetailResponse::new).orElseGet(BookDetailResponse::new);
    }
}
