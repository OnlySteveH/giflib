package uk.co.bigdogconsultants.giflib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.co.bigdogconsultants.giflib.data.CategoryRepository;
import uk.co.bigdogconsultants.giflib.data.GifRepository;
import uk.co.bigdogconsultants.giflib.model.Category;
import uk.co.bigdogconsultants.giflib.model.Gif;

import java.util.List;

/**
 * Created by Steve on 28/01/2016.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping (value = "/categories")
    public String listCategories(ModelMap modelMap){
        List<Category> allCategories = categoryRepository.getAllCategories();
        modelMap.put("categories", allCategories);
        return "categories";
    }

    @RequestMapping (value = "/category/{id}")
    public String getCategory(@PathVariable int id, ModelMap modelMap){
        Category category = categoryRepository.findById(id);
        modelMap.put("category", category);

        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);

        return "category";
    }

}
