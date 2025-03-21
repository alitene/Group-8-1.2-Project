package  Group-8-1.2-Project-main.Group-8-1.2-Project-main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

     @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userRepository.findById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        userRepository.save(user);
        return ResponseEntity.ok("User created successfully with encrypted password.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User submittedUser) {
        User user = userRepository.findByUsername(submittedUser.getUsername());
        if (user != null && passwordEncoder.matches(user.getPassword(), user.getPassword())) {
            return ResponseEntity.ok("Login successful.");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password.");
        }
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        recipe.setId(id);
        return recipeService.saveRecipe(recipe);
        return rowsAffected > 0 ? ResponseEntity.ok("User updated.") : ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        int rowsAffected = userRepository.deleteById(id);
        return rowsAffected > 0 ? ResponseEntity.ok("User deleted.") : ResponseEntity.notFound().build();
    }
}
