package com.amigoscode;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

	@GetMapping("/")
	public String Hello(){
		return "Welcome to my first Spring Boot project!" +
				"Go to 8080/greet for some JSON objects :)";
	}

	@GetMapping("/greet")
	public GreetResponse greet(){
		return new GreetResponse("Hello!",
				List.of("Java, Python, C++"),
				new Person("Hubert", 21));
	}

	@GetMapping("/secret")
	public String user(){
		return "How did you find it?";
	}

	record Person(String name, int age){}
	record GreetResponse(
			String greet,
			List<String> favProgrammingLanguages,
			Person person
	){}

//	class GreetResponse{
// 	private final String greet;
// 	GreetResponse(String greet){
// 		this.greet = greet;
// 	}
//
// 	public String getGreet() {
// 		return this.greet;
// 	}
// }
}
