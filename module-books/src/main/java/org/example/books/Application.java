package org.example.books;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		// System.setProperty("logging.file.name", setLogFileName());
		SpringApplication.run(Application.class, args);
	}

	private static String setLogFileName() {
		return "./logs/books-" + LocalDate.now();
	}
}