package com.MyRestApiGroup.service;

import com.MyRestApiGroup.entity.Task;
import com.MyRestApiGroup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    //usuwamy bo Autowired nam to zalatwia
   // public TaskServiceImpl(){
       // taskRepository = new TaskRepositoryImpl();
    //}

    @Override
    public Collection<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id){
        return taskRepository.findOne(id);
    }

    @Override
    public void deleteTaskById(Long id){
        taskRepository.delete(id);
    }

    @Override
    public void addTask(Task task){
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Task task){
        taskRepository.save(task);
    }
}
