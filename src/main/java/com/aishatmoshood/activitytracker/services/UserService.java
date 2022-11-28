package com.aishatmoshood.activitytracker.services;

import com.aishatmoshood.activitytracker.dtos.userdto.UserResponseDto;
import com.aishatmoshood.activitytracker.dtos.userdto.UserSignupDto;
import com.aishatmoshood.activitytracker.entities.ApiResponse;
import com.aishatmoshood.activitytracker.entities.User;
import com.aishatmoshood.activitytracker.exceptions.AlreadyExistsException;
import com.aishatmoshood.activitytracker.exceptions.NotFoundException;
import com.aishatmoshood.activitytracker.exceptions.NotNullException;

public interface UserService {
    boolean isUserExist(String email);

    boolean isUserExistByEmailAndPassword(String email, String Password);

    ApiResponse<User> signup(UserSignupDto userSignupDto) throws AlreadyExistsException, NotNullException;
    ApiResponse<UserResponseDto> login(String email, String password) throws NotNullException, NotFoundException;
}
