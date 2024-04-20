package com.example.library.controller;

import com.example.library.model.responsebody.BookDetailResponse;
import com.example.library.model.responsebody.GetBookResponseBody;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/lib/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public GetBookResponseBody listBooks(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "1") int size,
                                         @RequestParam(defaultValue = "id,asc") String[] sort) {
        Sort.Direction dir = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sort[0]));
        return bookService.listBook(pageable);
    }

    @GetMapping("/{id}")
    public BookDetailResponse listBooks(@PathVariable("id") String id) {
        return bookService.bookDetail(id);
    }
}
