package com.example.library.model.responsebody;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoResponse {
    private String id;
    private String userName;
    private String email;
    private String phoneNumber;
    private String fullName;
}
