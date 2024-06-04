package com.example.MikoEvents.user;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PatchMapping
	public ResponseEntity<?> changePassword(
			@RequestBody ChangePasswordRequest request,
			Principal connectedUser
	) {
		userService.changePassword(request, connectedUser);
		return ResponseEntity.ok().build();
	}
}
