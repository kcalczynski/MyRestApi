package com.MyRestApiGroup.repository;


import com.MyRestApiGroup.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TaskDaoImpl implements TaskDao {
    private Map<Long, Task> tasks;

    public TaskDaoImpl(){
        tasks = new HashMap<>();
        tasks.put(1L, new Task(1L, "task1", "task1desc", true));
        tasks.put(2L, new Task(2L, "task2", "task2desc", false));
        tasks.put(3L, new Task(3L, "task3", "task3desc", false));
    }

    @Override
    public Collection<Task> getAllTasks(){
        return tasks.values();
    }

    @Override
    public Task getTaskById(Long id){
        return tasks.get(id);
    }

    @Override
    public void deleteTaskById(Long id){
        tasks.remove(id);
    }

    @Override
    public void addTask(Task task){
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateTask(Task task){
        tasks.replace(task.getId(), task);
    }
}


