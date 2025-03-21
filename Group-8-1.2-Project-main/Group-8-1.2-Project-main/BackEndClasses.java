import javax.persistence.*;
import java.util.List;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Recipe> recipes;

}

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String ingredients;
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private RecipeCategory category;

    @OneToOne(mappedBy = "recipe")
    private Dish dish;

    @OneToOne(mappedBy = "recipe")
    private Sweets sweets;

    @OneToOne(mappedBy = "recipe")
    private Dessert dessert;

}

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String spiceLevel;
    private int cookingTime;

    @OneToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}

@Entity
public class Sweets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sweetnessLevel;
    private boolean isSugarFree;

    @OneToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}

@Entity
public class Dessert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean hasDairy;
    private boolean isFrozen;

    @OneToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    // Getters and Setters
}
