package com.aishatmoshood.activitytracker.repositories;

import com.aishatmoshood.activitytracker.entities.Task;
import com.aishatmoshood.activitytracker.entities.User;
import com.aishatmoshood.activitytracker.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTasksByUser(User user);
    Task findTaskByUserAndId(User user, Long taskId);
    List<Task> findTasksByUserAndStatus(User user, Status status);
    //Task findTaskByUserAndIdAndStatus(User user, Long id, Status status);
}
