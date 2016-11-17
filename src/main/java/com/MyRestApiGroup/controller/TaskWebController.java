package com.MyRestApiGroup.controller;

import com.MyRestApiGroup.entity.Task;
import com.MyRestApiGroup.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskWebController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/")
    public ModelAndView getAllTasks(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tasks");
        modelAndView.addObject("tasks", taskService.getAllTasks());
        return modelAndView;
    }

    //delete web task
    @RequestMapping(value="/deleteTask/{id}", method = RequestMethod.POST)
    public ModelAndView deleteTask (@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return finishAction("Task successfully deleted...");
    }

    //add web task
    @RequestMapping(value="/appendTask", method = RequestMethod.POST)
    public ModelAndView appendTask (@RequestParam("Tname") String name,
                              @RequestParam("Tdesc") String description) {

        taskService.addTask(new Task(name, description));
        return finishAction("Task successfully added..");
    }

    //enter into editing mode
    @RequestMapping(value="/editTask/{id}", method = RequestMethod.POST)
    public ModelAndView editTask (@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit-task");
        modelAndView.addObject("thisOne", taskService.getTaskById(id));
        return modelAndView;
    }

    //save changes
    @RequestMapping(value="/modifyTask/{id}", method = RequestMethod.POST)
    public ModelAndView modifyTask (@PathVariable Long id, @RequestParam("ETname") String name,
                                                          @RequestParam("ETdesc") String description, @RequestParam(required=false, value="ETstat") boolean stat) {

        taskService.updateTask(new Task(id, name, description, stat));
        return finishAction("Successfully updated!!!");

    }

    public ModelAndView finishAction(String s){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("done");
        modelAndView.addObject("arg", s);
        return modelAndView;
    }
}
