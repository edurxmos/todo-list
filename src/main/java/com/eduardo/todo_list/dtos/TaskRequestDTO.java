package com.eduardo.todo_list.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskRequestDTO(

        @NotBlank(message = "Required field")
        @Size(min = 3, max = 80)
        String title,

        @Size(max = 80)
        String description

) {
}
