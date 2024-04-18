package com.example.library.model.responsebody;

import com.example.library.entity.BooksEntity;
import lombok.Data;

import java.util.List;

@Data
public class FindBookResponseBody {
   private List<BooksEntity> booksEntityList;
}
