package com.MyRestApiGroup.repository;

import com.MyRestApiGroup.entity.Task;

import java.util.Collection;

public interface TaskDao {
    Collection<Task> getAllTasks();

    Task getTaskById(Long id);

    void deleteTaskById(Long id);

    void addTask(Task task);

    void updateTask(Task task);
}
