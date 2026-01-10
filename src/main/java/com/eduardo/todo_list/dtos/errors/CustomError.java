package com.eduardo.todo_list.dtos.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class CustomError {

    private Instant timestamp;
    private int status;
    private String error;
    private String path;

}
