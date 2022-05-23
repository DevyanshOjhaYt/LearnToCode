package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/users", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = "application/json")
	public ResponseEntity saveUsers(@RequestParam(value = "files") MultipartFile[] files) throws Exception {
		for (MultipartFile file : files) {
			userService.saveUsers(file);
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping(value = "/users", produces = "application/json")
	public CompletableFuture<ResponseEntity> findAllUsers() {
		return userService.findAllUsers().thenApply(ResponseEntity::ok);
	}

	@GetMapping(value = "/getUsersByThread", produces = "application/json")
	public ResponseEntity getUsers() {
		CompletableFuture<List<User>> user1 = userService.findAllUsers();
		CompletableFuture<List<User>> user2 = userService.findAllUsers();
		CompletableFuture<List<User>> user3 = userService.findAllUsers();
		CompletableFuture.allOf(user1, user2, user3).join();
		return ResponseEntity.status(HttpStatus.OK).build();

	}

}
