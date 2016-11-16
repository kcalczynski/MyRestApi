package com.MyRestApiGroup.repository;


import com.MyRestApiGroup.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
}
