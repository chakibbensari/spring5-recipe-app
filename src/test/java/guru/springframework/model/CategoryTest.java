package guru.springframework.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

    private Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @Test
    public void getId() {
        Long id = 4l;
        category.setId(id);
        Assert.assertEquals(id, category.getId());
    }

    @Test
    public void getDescription() {
        String description = "description";
        category.setDescription(description);
        Assert.assertEquals(description, category.getDescription());
    }
}