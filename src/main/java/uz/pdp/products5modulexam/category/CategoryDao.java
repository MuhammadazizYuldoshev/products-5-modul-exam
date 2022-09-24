package uz.pdp.products5modulexam.category;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryDao {

    private final JdbcTemplate jdbcTemplate;


    public List<Category> getAllCategoriesForSelect() {
        String sql = "select c.id, c.category_name\n" +
                "from categories c;";
        return jdbcTemplate.query(sql, (rs, row) ->
                Category.builder()
                        .id(rs.getInt(1))
                        .category_name(rs.getString(2))
                        .build()
        );
    }


    public void saveCategory(Category category) {


        //add category
        String sql = "insert into categories (category_name,description) values (?,?)";

        jdbcTemplate.update(sql,category.getCategory_name(),category.getDescription());

    }




//    public List<Category> getAllCategories(int size, int page) {
//        List<Category> list= new ArrayList<>();
//
//        try{
//            Connection con = getConnection();
//            PreparedStatement ps=con.prepareStatement("select * from categories limit ? offset (?-1) * ?;");
//
//            ps.setInt(1, size);
//            ps.setInt(2, page);
//            ps.setInt(3, size);
//            ResultSet rs=ps.executeQuery();
//            while(rs.next()){
//                Category category = new Category();
//                category.setId(rs.getInt(1));
//                category.setName(rs.getString(2));
//                category.setDescription(rs.getString(3));
//
//                list.add(category);
//            }
//            con.close();
//        }catch(Exception e){e.printStackTrace();}
//
//
//        return list;
//    }




    public Category getCategory(int id) {
        String sql = "select * from categories where id="+id;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Category.class));
    }

    public void updateCategory(Category category) {
        //update category
        String sql = "update categories set category_name=?,description=? where id=?";

        jdbcTemplate.update(sql,category.getCategory_name(),category.getDescription(),category.getId());
    }



    public void delete(int id) {
        String sql = "delete from categories where id=?";
        jdbcTemplate.update(sql,id);

    }


    public  int getCountOfCategories() {
        try (Connection connection = getConnection()) {

            String sql = "select count(*) from categories";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Category> getAllCategories(int size,int page){

        List<Category> categoryList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from categories limit ? offset (? - 1) * ?");
            preparedStatement.setInt(1,size);
            preparedStatement.setInt(2,page);
            preparedStatement.setInt(3,size);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = Category.builder()
                        .id(resultSet.getInt(1))
                        .category_name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .build();

                categoryList.add(category);
            }

            connection.close();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categoryList;
    }


    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static String username = "postgres";
    static String password = "root123";
    public static Connection getConnection(){

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
