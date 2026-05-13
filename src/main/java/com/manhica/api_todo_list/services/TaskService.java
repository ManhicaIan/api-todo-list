package com.manhica.api_todo_list.services;

import com.manhica.api_todo_list.dtos.task.TaskRequest;
import com.manhica.api_todo_list.dtos.task.TaskResponse;
import com.manhica.api_todo_list.entities.Task;
import com.manhica.api_todo_list.entities.TaskStatus;
import com.manhica.api_todo_list.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<TaskResponse> getAllTasks(){
        return taskRepository.findAll().stream().map(TaskResponse::new).toList();
    }

    @Transactional
    public TaskResponse saveTask(TaskRequest request){
        Task task = new Task();
        dtoToTask(task, request);
        return new TaskResponse(taskRepository.save(task));
    }

    @Transactional
    public TaskResponse updateTask(UUID id, TaskRequest request){
        Task task = taskRepository.getReferenceById(id);
        dtoToTaskOnUpdate(task, request);
        task.setUpdated_at(LocalDateTime.now());
        return new TaskResponse(taskRepository.save(task));
    }

    @Transactional
    public TaskResponse completeTask(UUID id){
        Task task = taskRepository.getReferenceById(id);
        task.setTaskStatus(TaskStatus.COMPLETED);
        task.setCompleted_at(LocalDateTime.now());
        return new TaskResponse(taskRepository.save(task));
    }

    private void dtoToTask(Task task, TaskRequest request){
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDue_date(request.due_date());
    }
    private void dtoToTaskOnUpdate(Task task, TaskRequest request){
        if(request.title() != null){
            task.setTitle(request.title());
        }
        if(request.description() != null){
            task.setDescription(request.description());
        }
        if (request.due_date() != null) {
            task.setDue_date(request.due_date());
        }
    }
}
