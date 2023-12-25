package org.example.common.config;

import org.example.common.annotation.controller.AdminController;
import org.example.common.annotation.controller.UserController;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer
			.addPathPrefix("/api/admin", HandlerTypePredicate.forAnnotation(AdminController.class))
			.addPathPrefix("/api/user", HandlerTypePredicate.forAnnotation(UserController.class))
			.setPathMatcher(new AntPathMatcher())
			.setUrlPathHelper(new UrlPathHelper());
	}
}
