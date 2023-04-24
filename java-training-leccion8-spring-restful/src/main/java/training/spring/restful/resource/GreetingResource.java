package training.spring.restful.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import training.spring.restful.domain.Greeting;

@RestController
public class GreetingResource {

	private static final String template = "<h1>Hello, %s!</h1>";
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(12, String.format(template, name));
	}
	
}
