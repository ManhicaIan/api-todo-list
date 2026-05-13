package com.manhica.api_todo_list.repositories;

import com.manhica.api_todo_list.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

}
