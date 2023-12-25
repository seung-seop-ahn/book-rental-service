package org.example.members.adapter.in.web.v1;

import org.example.common.annotation.controller.AdminController;

import io.swagger.v3.oas.annotations.tags.Tag;

@AdminController("v1/members")
@Tag(name = "admin-test", description = "api for admin test")
public class TestController {
}
