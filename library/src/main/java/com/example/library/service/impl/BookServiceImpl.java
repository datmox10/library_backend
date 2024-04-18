package com.example.library.service.impl;

import com.example.library.entity.BooksEntity;
import com.example.library.model.responsebody.FindBookResponseBody;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public FindBookResponseBody listBook(Pageable pageable) {
        FindBookResponseBody responseBody = new FindBookResponseBody();
        Page<BooksEntity> booksEntities = bookRepository.findAll(pageable);
        responseBody.setBooksEntityList(booksEntities.getContent());
        return responseBody;
    }
}
