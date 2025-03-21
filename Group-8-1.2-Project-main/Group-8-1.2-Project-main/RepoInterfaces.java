import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Long> {
}

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}

public interface DishRepository extends JpaRepository<Dish, Long> {
}

public interface SweetsRepository extends JpaRepository<Sweets, Long> {
}

public interface DessertRepository extends JpaRepository<Dessert, Long> {
}
