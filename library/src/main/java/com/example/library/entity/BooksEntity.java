package com.example.library.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "books")
public class BooksEntity {
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "AUTHOR")
    private String author;
    @Basic
    @Column(name = "AVAILABLE_QUANTITY")
    private int availableQuantity;
    @Basic
    @Column(name = "STATUS")
    private String status;
    @Basic
    @Column(name = "PRICE")
    private BigDecimal price;
    @Basic
    @Column(name = "GENRE")
    private String genre;
    @Basic
    @Column(name = "PUBLISHER")
    private String publisher;
    @Basic
    @Column(name = "IMAGE")
    private String image;
    @Basic
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
    @Basic
    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooksEntity that = (BooksEntity) o;
        return availableQuantity == that.availableQuantity && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(author, that.author) && Objects.equals(status, that.status) && Objects.equals(price, that.price) && Objects.equals(genre, that.genre) && Objects.equals(publisher, that.publisher) && Objects.equals(createdDate, that.createdDate) && Objects.equals(updatedDate, that.updatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, availableQuantity, status, price, genre, publisher, createdDate, updatedDate);
    }
}
