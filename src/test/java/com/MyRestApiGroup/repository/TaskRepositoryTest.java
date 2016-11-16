package com.MyRestApiGroup.repository;

import com.MyRestApiGroup.entity.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

//te dwie adnotacje podnosza context Springa
@RunWith(SpringRunner.class)
@SpringBootTest
//zeby nowy context
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TaskRepositoryTest {

    @Autowired
    private TaskDao taskRepository;

    //bo dalismy autowired
   // @Before
    //public void setUp() throws Exception {
   //     taskRepository = new TaskRepositoryImpl();
   // }

    @Test
    public void getAllTasks() throws Exception {
        //given

        //when
        Collection<Task> tasks = taskRepository.getAllTasks();
        //then
        Assert.assertEquals(3, tasks.size());
    }

    @Test
    public void getTaskById() throws Exception {
        Task task = taskRepository.getTaskById(2L);
        Assert.assertNotNull(task);
        Assert.assertEquals("task2", task.getName());
    }

    @Test
    public void deleteTaskById() throws Exception {
        taskRepository.deleteTaskById(1L);
        Task taskDeleted = taskRepository.getTaskById(1L);
        Assert.assertNull(taskDeleted);
    }

    @Test
    public void addTask() throws Exception {
        taskRepository.addTask(new Task(10L, "task10", "task10desc", true));
        Task taskAdded = taskRepository.getTaskById(10L);
        Assert.assertNotNull(taskAdded);

    }

    @Test
    public void updateTask() throws Exception {
        taskRepository.updateTask(new Task(1L, "task01", "task01desc", true));
        Task taskUpdated = taskRepository.getTaskById(1L);
        Assert.assertEquals("task01", taskUpdated.getName());
    }

}