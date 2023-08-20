package com.javinha.api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javinha.api.models.Task;
import com.javinha.api.repositories.TasksRepository;

@Service
public class TaskService {
    private final TasksRepository tasksRepository;

    @Autowired
    public TaskService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Task> getTasks() {
        return tasksRepository.findAll();
    }

    public Task createTask(String title, String description) {
        Task task = new Task(title, description, false);
        return tasksRepository.save(task);
    }

    public void deleTask(UUID id) {
        tasksRepository.deleteById(id);
    }

    public Task updateTask(UUID id, Task updatedTask) {
        Task tasktoUpdate = tasksRepository.findById(id).orElseThrow(null);

        if (tasktoUpdate != null) {
            tasktoUpdate.setTitle(updatedTask.getTitle());
            tasktoUpdate.setDescription(updatedTask.getDescription());
            tasktoUpdate.setConcluded(updatedTask.getConcluded());
            return tasksRepository.save(tasktoUpdate);
        }
        return null;
    }
}
