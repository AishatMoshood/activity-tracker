package com.aishatmoshood.activitytracker.services;

import com.aishatmoshood.activitytracker.dtos.taskdto.CreateTaskDto;
import com.aishatmoshood.activitytracker.entities.ApiResponse;
import com.aishatmoshood.activitytracker.entities.Task;
import com.aishatmoshood.activitytracker.entities.User;
import com.aishatmoshood.activitytracker.enums.Status;
import com.aishatmoshood.activitytracker.exceptions.NotFoundException;
import com.aishatmoshood.activitytracker.exceptions.NotNullException;


import java.util.List;

public interface TaskService {
    User findLoggedInUser();

    Task getTaskById(Long taskId);

    ApiResponse<Task> createTask(CreateTaskDto createTaskDto) throws NotNullException;
    ApiResponse<List<Task>> getAllUserTasks();
    ApiResponse<Task> viewTaskById(Long taskId) throws NotFoundException;
    ApiResponse<List<Task>> getTaskByStatus(Status status) throws NotFoundException;

    ApiResponse<Task> updateTaskStatus(Long taskId, Task newTask);

    ApiResponse<Task> updateTaskTitleOrDescription(Long taskId, Task newTask) throws NotFoundException;
    void deleteTask(Long taskId);
}
