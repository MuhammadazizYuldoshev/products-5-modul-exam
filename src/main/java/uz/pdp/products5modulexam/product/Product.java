package uz.pdp.products5modulexam.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.products5modulexam.category.Category;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    private Integer id;
    private String name;
    private Integer cost;
    private String description;
    private Category category;
    private Integer category_id;



//    private Character character;
}

