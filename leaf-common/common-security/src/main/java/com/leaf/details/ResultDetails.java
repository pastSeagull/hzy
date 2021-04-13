package com.leaf.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResultDetails {
    private LocalDateTime timestamp;

    private Integer status;

    private String message;

    private Boolean success;

}
