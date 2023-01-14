package com.example.Task_Management.dto.response;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class UnifiedRes {

    @Builder.Default
    String errMsg = "";

    @Builder.Default
    int errCode = 200;

    Object dto;
}
