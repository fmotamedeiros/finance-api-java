package br.com.cpsoftware.finance.controller;

import br.com.cpsoftware.finance.model.Category;
import br.com.cpsoftware.finance.model.User;
import br.com.cpsoftware.finance.repository.CategoryRepository;
import br.com.cpsoftware.finance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
    User user = userRepository.findById(category.getUser().getId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."));
    
    Category savedCategory = categoryRepository.save(category);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
}


    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found."));
        return ResponseEntity.ok(category);
    }

}
