package com.management.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private T data;
    private Integer code;
    private String msg;

}
