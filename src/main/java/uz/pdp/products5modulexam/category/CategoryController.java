package uz.pdp.products5modulexam.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryDao categoryDao;

    @GetMapping("/{pageStr}")
    public String showCategory(@PathVariable String pageStr, Model model){

        int size = 2;
        int page = 1;

        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }

        List<Category> allCategories = categoryDao.getAllCategories(size,page);
        model.addAttribute("categories",allCategories);
        model.addAttribute("totalElementsCount",categoryDao.getCountOfCategories());
        model.addAttribute("size",size);
        model.addAttribute("currentPage",page);
        return "view-category-form";


    }


    @GetMapping("/add-category-form")
    public String addCategory(){

        return "add-category-form";
    }

    @PostMapping
    public String saveCategory(Category category){
        categoryDao.saveCategory(category);


        return "redirect:/category/1";

    }


    @GetMapping("edit/{id}")
    public String updateCategory(@PathVariable("id") int id,Model model){

        Category category = categoryDao.getCategory(id);
        model.addAttribute("category",category);
        return "update-category-form";

    }


    @RequestMapping(value = "/update-category",method = RequestMethod.POST)
    public String update(Category category){
        categoryDao.updateCategory(category);
        return "redirect:/category/1";

    }


    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id){
        categoryDao.delete(id);
        return "redirect:/category/1";
    }





}
