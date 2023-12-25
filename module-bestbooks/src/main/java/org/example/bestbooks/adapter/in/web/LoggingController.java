package org.example.bestbooks.adapter.in.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/logging")
@Tag(name = "check", description = "logging")
public class LoggingController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Operation(summary = "logging", description = "logging check")
	@GetMapping()
	public ResponseEntity<Object> logging() {

		logger.trace("trace");
		logger.debug("debug");
		logger.info("info"); // root level
		logger.warn("warn");
		logger.error("error");

		return ResponseEntity.noContent().build();
	}
}
