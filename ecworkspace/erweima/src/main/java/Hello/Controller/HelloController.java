package Hello.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/str")
    public String hello(){
        return "Greetings from Spring Boot!";
    }

}
