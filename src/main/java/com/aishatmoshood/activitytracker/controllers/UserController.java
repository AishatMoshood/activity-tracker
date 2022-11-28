package com.aishatmoshood.activitytracker.controllers;

import com.aishatmoshood.activitytracker.dtos.userdto.UserResponseDto;
import com.aishatmoshood.activitytracker.dtos.userdto.UserSignupDto;
import com.aishatmoshood.activitytracker.entities.ApiResponse;
import com.aishatmoshood.activitytracker.entities.User;
import com.aishatmoshood.activitytracker.exceptions.AlreadyExistsException;
import com.aishatmoshood.activitytracker.exceptions.NotFoundException;
import com.aishatmoshood.activitytracker.exceptions.NotNullException;
import com.aishatmoshood.activitytracker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/activity-tracker")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<User>> signup(@RequestBody UserSignupDto userSignupDto) throws AlreadyExistsException, NotNullException {
        ApiResponse<User> user = userService.signup(userSignupDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<ApiResponse<UserResponseDto>> login(@RequestBody User user) throws NotFoundException, NotNullException {
        ApiResponse<UserResponseDto> userResponseDtoApiResponse = userService.login(user.getEmail(), user.getPassword());
        return new ResponseEntity<>(userResponseDtoApiResponse, HttpStatus.ACCEPTED);
    }


}
