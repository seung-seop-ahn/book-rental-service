package org.example.books.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;

@RestController
@RequestMapping("/api/ping")
@Tag(name = "check", description = "ping")
public class PingController {

	@Operation(summary = "ping", description = "ping check")
	@Parameter(name = "path", description = "path", required = true)
	@Parameter(name = "query", description = "query")
	@GetMapping("{path}")
	public ResponseEntity<Ping> ping(
		@PathVariable("path") String path,
		@RequestParam(name = "query", required = false) String query
	) {
		System.out.println("path: " + path);
		System.out.println("parameter: " + query);

		return ResponseEntity.ok(new Ping("ok"));
	}

	@Getter
	public static class Ping {
		String ping;

		public Ping(String ping) {
			this.ping = ping;
		}
	}
}
