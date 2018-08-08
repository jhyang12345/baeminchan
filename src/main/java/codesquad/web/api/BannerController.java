package codesquad.web.api;

import codesquad.domain.Category;
import codesquad.domain.CategoryDTO;
import codesquad.domain.EventCategory;
import codesquad.domain.Product;
import codesquad.service.CategoryService;
import codesquad.service.EventCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BannerController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private EventCategoryService eventCategoryService;

    @GetMapping("/api/categories/root")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> rootCategories() {
        return categoryService.findCategoriesByParent(null);
    }

    @GetMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO fetchCategoryById(@PathVariable Long id) {
        return categoryService.findCategoryDTOById(id);
    }

    @GetMapping("/api/categories/event")
    public List<EventCategory> fetchEventCategories() {
        return eventCategoryService.findAll();
    }

    @GetMapping("/api/categories/event/{id}")
    public List<Product> fetchProductsInEventCategory(@PathVariable Long id) {
        return eventCategoryService.findProductsByEventCategoryId(id);
    }

    @GetMapping("/api/categories/category/{id}")
    public List<Product> fetchProductsInCategory(@PathVariable Long id) {
        return categoryService.findProductsByCategoryId(id);
    }

}
