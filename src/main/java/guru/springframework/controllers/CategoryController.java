package guru.springframework.controllers;

import guru.springframework.model.Category;
import guru.springframework.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping({"/index", "/"})
    public String index(Model model){
        Set<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories/index";
    }
}
