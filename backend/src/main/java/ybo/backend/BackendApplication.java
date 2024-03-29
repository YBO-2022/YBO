package ybo.backend;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class BackendApplication {

	public static void main(String[] args)  {
		ApplicationContext context = SpringApplication.run(BackendApplication.class, args);
		Test test = context.getBean(Test.class);
		test.say();
	}

	@Component
	class Test {
		@Value("${spring.profiles.active}")
		private String active;
		private void say() {
			System.out.println("*************************");
			System.out.println("active: " + active );
			System.out.println("*************************");
		}
	}
}
