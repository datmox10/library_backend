package com.example.library.model.responsebody;

import com.example.library.entity.BooksEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailResponse {
    private String id;
    private String title;
    private String author;
    private int availableQuantity;
    private String status;
    private BigDecimal price;
    private String genre;
    private String publisher;
    private String image;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public BookDetailResponse(BooksEntity entity){
        BeanUtils.copyProperties(entity, this);
    }
}
