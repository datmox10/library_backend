package com.example.library.repository;

import com.example.library.entity.BorrowReturnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowReturnRepository extends JpaRepository<BorrowReturnEntity, String> {
    List<BorrowReturnEntity> findByOrderByDueDateDesc();
    List<BorrowReturnEntity> findAllByUserIdOrderByBorrowDateDesc(String userId);
    BorrowReturnEntity findAllByBookId(String bookId);
}
