package com.in28minutes.rest.webservices.restfulwebservices.hellobean;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	///hello-world/path-variable/Sanjeev
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null,
				LocaleContextHolder.getLocale());
	}

}
