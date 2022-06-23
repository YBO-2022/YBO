package ybo.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ybo.backend.global.response.DefaultResponse;

@SpringBootApplication
@EnableWebMvc
public class BackendApplication {

	@Autowired
	RestTemplate restTemplate;

	@Value("${flask.server.url}")
	private String flaskServerUrl;

	public static void main(String[] args)  {
		ApplicationContext context = SpringApplication.run(BackendApplication.class, args);
		Test test = context.getBean(Test.class);
		test.say();
		test.realtimeCrawling();
	}

	@Component
	class Test {
		@Value("${spring.profiles.active}")
		private String active;
		private void say() {
			System.out.println("*************************");
			System.out.println("active: " + active);
			System.out.println("*************************");
		}
		private void realtimeCrawling(){
			restTemplate.getForObject(flaskServerUrl+"/ranking", DefaultResponse.class);
			restTemplate.getForObject(flaskServerUrl+"/game", DefaultResponse.class);
		}
	}
}
