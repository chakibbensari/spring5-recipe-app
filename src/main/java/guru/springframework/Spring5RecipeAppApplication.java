package guru.springframework;

import guru.springframework.model.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Spring5RecipeAppApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(Spring5RecipeAppApplication.class, args);
		Category category = new Category();
		category.setDescription("My description");
		System.out.println(category.getDescription());
	}
}
