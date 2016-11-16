package com.MyRestApiGroup.controller;

import com.MyRestApiGroup.entity.Task;
import com.MyRestApiGroup.service.TaskService;
import com.MyRestApiGroup.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /*@RequestMapping(method= RequestMethod.GET)
    public Collection<Task> getAllTasks(){

        return taskService.getAllTasks();
    }*/

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView getAllTasks(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tasks");
        modelAndView.addObject("tasks", taskService.getAllTasks());
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void deleteTaskById(@PathVariable Long id){
        taskService.deleteTaskById(id);
    }

    @RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTask(@RequestBody Task task){
        taskService.addTask(task);
    }

    @RequestMapping(method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTask(@RequestBody Task task){
        taskService.updateTask(task);
    }
}


