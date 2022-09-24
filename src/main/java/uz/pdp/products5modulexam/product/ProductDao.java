package uz.pdp.products5modulexam.product;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.products5modulexam.category.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static uz.pdp.products5modulexam.category.CategoryDao.getConnection;

@Component
@RequiredArgsConstructor
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Product> getAllProducts(int size,int page){
        List<Product> productList = new ArrayList<>();
        Connection connection = getConnection();
        String sql = "select product.id,product.name,product.cost,product.category_id,c.category_name from product  join categories c on product.category_id=c.id  limit ? offset (?-1) * ?";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, size);
            preparedStatement.setInt(2, page);
            preparedStatement.setInt(3, size);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int cost = resultSet.getInt(3);
                int categoryId = resultSet.getInt(4);
                String categoryName = resultSet.getString(5);

                productList.add(
                        Product.builder()
                                .id(id)
                                .name(name)
                                .cost(cost)
                                .category(Category.builder()
                                        .id(categoryId)
                                        .category_name(categoryName)
                                        .build())
                                .build()
                );

            }
            return productList;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public int getCountOfProducts(){
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from product");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public void saveProduct(Product product) {
        String sql = "insert into product (name,cost,description,category_id) values(?,?,?,?)";
        jdbcTemplate.update(sql,product.getName(),product.getCost(),product.getDescription(),product.getCategory_id());
    }

    public static Product getProductById(int productId) {

        try (Connection connection = getConnection()) {

            String sql = "select p.id,p.name,p.cost,p.description,p.category_id,c.id from product p join categories c on c.id = p.category_id where p.id = ?"; // TODO: 25/08/22 select additional informations...
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = Product.builder()

                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .cost(resultSet.getInt(3))
                        .description(resultSet.getString(4))
                        .category_id(resultSet.getInt(5))
                        .build();
                return product;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void updateProduct(Product product) {
        String sql = "update product set name=?,cost=?,description=?,category_id=? where id=?";
        jdbcTemplate.update(sql,product.getName(),product.getCost(),product.getDescription(),product.getCategory_id(),product.getId());
    }

    public void delete(int id) {
        String sql = "delete from product where id=?";
        jdbcTemplate.update(sql,id);
    }
}
