package com.leaf.details;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 错误详情
 */
@Data
public class ErrorDetails {
    private LocalDateTime timestamp;

    private Integer status;

    private String error;

    private String message;

    private String path;
}
