package com.example.library.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "borrow_return")
public class BorrowReturnEntity {
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "USER_ID")
    private String userId;
    @Basic
    @Column(name = "BOOK_ID")
    private String bookId;
    @Basic
    @Column(name = "BORROW_DATE")
    private LocalDateTime borrowDate;
    @Basic
    @Column(name = "RETURN_DATE")
    private LocalDateTime returnDate;
    @Basic
    @Column(name = "DUE_DATE")
    private LocalDateTime dueDate;
    @Basic
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Basic
    @Column(name = "OVERDUE")
    private Integer overdue;
    @Basic
    @Column(name = "STATUS")
    private String status;
    @Basic
    @Column(name = "PUBLISHER_YEAR")
    private String publisherYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublisherYear() {
        return publisherYear;
    }

    public void setPublisherYear(String publisherYear) {
        this.publisherYear = publisherYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowReturnEntity that = (BorrowReturnEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(bookId, that.bookId) && Objects.equals(borrowDate, that.borrowDate) && Objects.equals(returnDate, that.returnDate) && Objects.equals(dueDate, that.dueDate) && Objects.equals(quantity, that.quantity) && Objects.equals(overdue, that.overdue) && Objects.equals(status, that.status) && Objects.equals(publisherYear, that.publisherYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, bookId, borrowDate, returnDate, dueDate, quantity, overdue, status, publisherYear);
    }
}
