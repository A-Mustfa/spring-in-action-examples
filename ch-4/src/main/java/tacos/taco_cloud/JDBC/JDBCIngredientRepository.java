// package tacos.taco_cloud.JDBC;

// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.stereotype.Repository;

// import tacos.taco_cloud.domains.Ingredients;
// import tacos.taco_cloud.repositories.IngredientRepository;

// @Repository
// public class JDBCIngredientRepository implements IngredientRepository {

//     private JdbcTemplate template;

//     @Autowired
//     public JDBCIngredientRepository(JdbcTemplate template) {
//         this.template = template;
//     }

//     @Override
//     public Iterable<Ingredients> findAll() {

//         String sql = "select id,name,type from Ingredient";

//         return template.query(sql, this::rowToIngredient);

//     }

//     @Override
//     public Optional<Ingredients> findById(String id) {
//        List<Ingredients> result = template.query("select id, name, type from Ingredient where id=?", this::rowToIngredient,id);

//        return result.size() == 0 ? Optional.empty() : Optional.of(result.get(0));
//     }

//     @Override
//     public Ingredients save(Ingredients ingredient) {
        
//         String sql = "insert into ingredient values(?,?,?)";
//         template.update(sql,ingredient.getId(),ingredient.getName(),ingredient.getType().toString());

//         return ingredient;
//     }


//     private Ingredients rowToIngredient(ResultSet rs, int row) throws SQLException {
        
//         return new Ingredients(
//             rs.getString("id"),
//             rs.getString("name"),
//             Ingredients.Type.valueOf(rs.getString("type"))
//         );


//     }


    
// }
