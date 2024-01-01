package org.example.members.adapter.in.web.v1;

import org.example.common.annotation.controller.UserController;
import org.example.common.annotation.service.WebAdapter;
import org.example.members.adapter.in.web.v1.dto.RegisterMemberRequest;
import org.example.members.application.port.in.IRegisterMemberUsecase;
import org.example.members.application.port.in.command.RegisterMemberCommand;
import org.example.members.domain.vo.MemberId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "user", description = "api for user")
@UserController("v1/members")
@RequiredArgsConstructor
@WebAdapter
public class UserMemberController {

	private final IRegisterMemberUsecase registerMemberUsecase;

	@Operation(summary = "register", description = "register member")
	@ApiResponse(responseCode = "201", description = "created")
	@PostMapping()
	public ResponseEntity<MemberId> registerMember(
		@RequestBody RegisterMemberRequest request
	) {
		RegisterMemberCommand command = RegisterMemberCommand.builder()
			.email(request.getEmail())
			.password(request.getPassword())
			.name(request.getName())
			.zipCode(request.getZipcode())
			.address1(request.getAddress1())
			.address2(request.getAddress2())
			.cellPhone(request.getCellPhone())
			.birth(request.getBirth())
			.build();

		MemberId memberId = this.registerMemberUsecase.register(command);

		return ResponseEntity.status(HttpStatus.CREATED).body(memberId);
	}
}
