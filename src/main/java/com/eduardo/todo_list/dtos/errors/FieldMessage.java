package com.eduardo.todo_list.dtos.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FieldMessage {

    private String fieldName;
    private String message;

}
