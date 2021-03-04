package guru.springframework.services.springdata;

import guru.springframework.model.Category;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.services.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CategoryServiceSDImplTest {

    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceSDImpl(categoryRepository);

    }

    @Test
    public void findAll() {
        Set<Category> categories = new HashSet<>();
        categories.add(new Category());
        when(categoryRepository.findAll()).thenReturn(categories);
        int size = categories.size();
        assertEquals(size, categoryService.findAll().size());
        verify(categoryRepository,times(1)).findAll();
    }
}