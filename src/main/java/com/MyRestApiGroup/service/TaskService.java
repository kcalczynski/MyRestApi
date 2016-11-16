package com.MyRestApiGroup.service;

import com.MyRestApiGroup.entity.Task;

import java.util.Collection;

public interface TaskService {
    Collection<Task> getAllTasks();

    Task getTaskById(Long id);

    void deleteTaskById(Long id);

    void addTask(Task task);

    void updateTask(Task task);
}
