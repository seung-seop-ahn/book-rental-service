package org.example.members.adapter.in.web.v1;

import org.example.common.annotation.controller.UserController;
import org.example.common.annotation.service.WebAdapter;
import org.example.members.adapter.in.web.v1.dto.request.ModifyMemberRequest;
import org.example.members.adapter.in.web.v1.dto.request.RegisterMemberRequest;
import org.example.members.adapter.in.web.v1.dto.response.MemberResponse;
import org.example.members.application.port.in.IFindMemberUsecase;
import org.example.members.application.port.in.IModifyMemberUsecase;
import org.example.members.application.port.in.IRegisterMemberUsecase;
import org.example.members.application.port.in.command.ModifyMemberCommand;
import org.example.members.application.port.in.command.RegisterMemberCommand;
import org.example.members.domain.vo.MemberId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "user", description = "api for user")
@UserController("v1/members")
@RequiredArgsConstructor
@WebAdapter
public class UserMemberController {

	private final IRegisterMemberUsecase registerMemberUsecase;
	private final IFindMemberUsecase findMemberUsecase;
	private final IModifyMemberUsecase modifyMemberUsecase;

	@Operation(summary = "register", description = "register member")
	@ApiResponses(value = {
		@ApiResponse(
			responseCode = "201",
			description = "created",
			content = {
				@Content(
					mediaType = "application/json",
					schema = @Schema(implementation = MemberId.class))
			}),
		@ApiResponse(
			responseCode = "500",
			description = "IllegalArgumentException(email, zipcode, birth)",
			content = {
				@Content(
					mediaType = "application/json",
					schema = @Schema(implementation = IllegalArgumentException.class))
			})
	})
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

	@Operation(summary = "find", description = "find member")
	@ApiResponses(value = {
		@ApiResponse(
			responseCode = "200",
			description = "ok",
			content = {
				@Content(
					mediaType = "application/json",
					schema = @Schema(implementation = MemberResponse.class))
			}),
		@ApiResponse(
			responseCode = "500",
			description = "IllegalArgumentException(member)",
			content = {
				@Content(
					mediaType = "application/json",
					schema = @Schema(implementation = IllegalArgumentException.class))
			})
	})
	@GetMapping("{memberId}")
	public ResponseEntity<MemberResponse> findMember(
		@Parameter(description = "memberId", in = ParameterIn.PATH)
		@PathVariable("memberId") Long memberId
	) {
		MemberResponse member = this.findMemberUsecase.findById(memberId);
		return ResponseEntity.ok(member);
	}

	@Operation(summary = "modify", description = "modify member")
	@ApiResponses(value = {
		@ApiResponse(
			responseCode = "200",
			description = "ok",
			content = {
				@Content(
					mediaType = "application/json",
					schema = @Schema(implementation = MemberResponse.class))
			}),
		@ApiResponse(
			responseCode = "500",
			description = "IllegalArgumentException(member)",
			content = {
				@Content(
					mediaType = "application/json",
					schema = @Schema(implementation = IllegalArgumentException.class))
			})
	})
	@PutMapping("{memberId}")
	public ResponseEntity<MemberResponse> modifyMember(
		@Parameter(description = "memberId", in = ParameterIn.PATH)
		@PathVariable("memberId") Long memberId,
		@RequestBody ModifyMemberRequest request
	) {
		// todo: spring security
		ModifyMemberCommand command = ModifyMemberCommand.builder()
			.name(request.getName())
			.zipcode(request.getZipcode())
			.address1(request.getAddress1())
			.address2(request.getAddress2())
			.cellPhone(request.getCellPhone())
			.birth(request.getBirth())
			.build();

		// MemberResponse member = this.modifyMemberUsecase.save(memberId, command);
		MemberResponse member = this.modifyMemberUsecase.modify(memberId, command);

		return ResponseEntity.ok(member);
	}
}
