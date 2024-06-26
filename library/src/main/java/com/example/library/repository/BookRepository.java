package com.example.library.repository;

import com.example.library.entity.BooksEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BooksEntity, String> {
    Page<BooksEntity> findAll(Pageable pageable);
}
