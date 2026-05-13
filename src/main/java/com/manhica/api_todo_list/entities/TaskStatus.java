package com.manhica.api_todo_list.entities;

import lombok.Getter;

@Getter
public enum TaskStatus {
    PENDING("pending"),
    COMPLETED("completed");

    private String status;

    TaskStatus(String status){
        this.status = status;
    }

}
