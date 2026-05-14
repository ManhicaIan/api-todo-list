package com.manhica.api_todo_list.dtos.errors.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FieldMessage {
    private String field;
    private String message;
}
