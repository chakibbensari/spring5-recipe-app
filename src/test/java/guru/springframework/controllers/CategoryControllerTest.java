package guru.springframework.controllers;

import guru.springframework.model.Category;
import guru.springframework.services.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class CategoryControllerTest {

    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @Mock
    private Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        categoryController = new CategoryController(categoryService);
    }

    @Test
    public void testExample() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/categories/"))
                .andExpect(status().isOk())
                .andExpect(view().name("categories/index"));

    }

    @Test
    public void index() {
        String view = "categories/index";
        Set<Category> categories = new HashSet<>();
        categories.add(new Category());
        Category cat = new Category();
        cat.setId(1L);
        categories.add(cat);
        when(categoryService.findAll()).thenReturn(categories);
        ArgumentCaptor<Set<Category>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
        String theView = categoryController.index(model);
        assertEquals(view, theView);
        verify(model, times(1)).addAttribute(eq("categories"), argumentCaptor.capture());
        Set<Category> finalCats = argumentCaptor.getValue();
        verify(categoryService, times(1)).findAll();
        assertEquals(2, finalCats.size());
    }
}