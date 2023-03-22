/**
 * 
 */
package com.promineotech.dress.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.dress.entity.Dress;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultDressDao implements DressDao{
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  //Get method to read a list of dresses from the database
  @Override
  public List<Dress> fetchDress(String dressStyle) {
    log.info("DAO: dressStyle={}", dressStyle);
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM dress "
        + "WHERE dress_style = :dress_style";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<> ();
    params.put("dress_style", dressStyle);

    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      //Map every column name to corresponding instance variables in Dress table
      @Override
      public Dress mapRow(ResultSet rs, int rowNums) throws SQLException {
        //formatter:off
      return Dress.builder()  
        .dressPK(rs.getLong("dress_pk"))
        .dressId(rs.getString("dress_id"))
        .dressStyle(rs.getString("dress_style"))
        .price(rs.getBigDecimal("price"))
        .build();
      //formatter:on
      } });
      
  }

  //Post method to create a new dress
  @Override
  public Optional<Dress> createDress(String dressID, String dressStyle, BigDecimal price) {
    log.info("DAO: dressID={}, dressStyle={}, price={}", dressID, dressStyle, price);
    
    //@formatter:off
    String sql = ""
        + "INSERT INTO dress ("
        + "dress_id, dress_style, price, customer_fk"
        + ") VALUES ("
        + ":dress_id, :dress_style, :price, :customer_fk)";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("dress_id", dressID);
    params.put("dress_style", dressStyle);
    params.put("price", price);
    
  
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Dress.builder().dressId(dressID).dressStyle(dressStyle).price(price).build());
  }

  //Put method for updating the dress price
  @Override
  public Optional<Dress> updateDressPrice(String dressID, Dress newPrice) {
    log.info("DAO: dressID={}, price{}", dressID, newPrice);
    
    //formatter:off
    String sql = ""
        + "UPDATE dress SET price = :price "
        + "WHERE dress_id = :dress_id";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("dress_id", dressID);
    params.put("new_price", newPrice);
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Dress.builder().dressId(dressID).price(newPrice).build());
  }

  //Delete method to delete a dress
  @Override
  public Optional<Dress> deleteDress(Long dressPK) {
    //@formatter:off
    String sql = ""
        + "DELETE FROM dress WHERE "
        + "dress_pk = :dress_pk";
    //@formatter:on
    
    Map <String, Object> params = new HashMap<>();
    params.put("dress_pk", dressPK);
    
    jdbcTemplate.update(sql, params); //returns number of rows affected
    
    //throw an exception here so if deleted value is re-deleted it will throw an error
    return Optional.ofNullable(Dress.builder().dressPK(dressPK).build());
  }

}
