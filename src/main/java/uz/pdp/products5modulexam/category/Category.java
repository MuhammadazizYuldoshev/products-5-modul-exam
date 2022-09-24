package uz.pdp.products5modulexam.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Category {

    private Integer id;

    private String category_name;

    private String description;


}
