package uz.pdp.products5modulexam.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.products5modulexam.category.Category;
import uz.pdp.products5modulexam.category.CategoryDao;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductDao productDao;
    private final CategoryDao categoryDao;

    @GetMapping("/{pageStr}")
    public String viewProduct(@PathVariable String pageStr, Model model){
        int size = 2;
        int page = 1;

        if (pageStr != null){
            page = Integer.parseInt(pageStr);
        }

        List<Product> allProducts = productDao.getAllProducts(size, page);
        int countOfProducts = productDao.getCountOfProducts();
        model.addAttribute("products",allProducts);
        model.addAttribute("count",countOfProducts);
        model.addAttribute("size",size);
        model.addAttribute("page",page);
        return "view-product-form";
    }

    @GetMapping("/add-form")
    public String addProductForm(Model model){
        model.addAttribute("categoryList",categoryDao.getAllCategoriesForSelect());
        return "add-product-form";
    }

    @PostMapping
    public String saveProduct(Product product){
        productDao.saveProduct(product);
        return "redirect:/products/1";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id,Model model){
        Product product = productDao.getProductById(id);
        System.out.println(product);
        List<Category> allCategoriesForSelect = categoryDao.getAllCategoriesForSelect();
        model.addAttribute("product",product);
        model.addAttribute("category",allCategoriesForSelect);
        return "update-product-form";
    }

    @PostMapping("/update-form")
    public String updateProduct(Product product){
        System.out.println(product);
        productDao.updateProduct(product);
        return "redirect:/products/1";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        productDao.delete(id);
        return "redirect:/products/1";
    }



}
