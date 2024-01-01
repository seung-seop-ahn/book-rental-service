package org.example.members.adapter.in.web.v1;

import org.example.common.annotation.controller.UserController;
import org.example.common.annotation.service.WebAdapter;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "user", description = "api for user")
@UserController("v1/members")
@RequiredArgsConstructor
@WebAdapter
public class SignMemberController {
	// todo: login (+ apis authorization logic)
	// todo: logout
}
