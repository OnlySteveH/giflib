package uk.co.bigdogconsultants.giflib.data;

import org.springframework.stereotype.Component;
import uk.co.bigdogconsultants.giflib.model.Category;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Steve on 27/01/2016.
 */
@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Lolz"),
            new Category(2, "Animals"),
            new Category(3, "Cars")
    );

    public List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }

    public Category findById(int id){
        for(Category category : ALL_CATEGORIES) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}
