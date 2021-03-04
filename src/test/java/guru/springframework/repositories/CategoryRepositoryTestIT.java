package guru.springframework.repositories;

import guru.springframework.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTestIT {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void test(){
        Optional<Category> cat = categoryRepository.findByDescription("Vegetable");

        assertEquals("Vegetable", cat.get().getDescription());
    }

}