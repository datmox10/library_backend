package com.example.library.model.responsebody;

import com.example.library.entity.BorrowReturnEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryBorrowResponse {
    private List<BorrowReturnEntity> list;
}
