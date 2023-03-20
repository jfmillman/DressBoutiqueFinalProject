/**
 * 
 */
package com.promineotech.dress.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.dress.entity.Customers;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultCustomerDao implements CustomerDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  //Get method to read the list of customers from the Dress database
  @Override
  public List<Customers> fetchCustomers (String firstName) {
    log.info("DAO: firstName={}", firstName);
    
    //@formatter:off
    String sql =""
        + "SELECT * "
        + "FROM customers "
        + "WHERE first_name = :first_name";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", firstName);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
     //Maps every column name to corresponding instance variables within the Customer table
      @Override
      public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
        //formatter:off
        return Customers.builder()
            .customerPK(rs.getLong("customer_pk"))
            .customerId(new String (rs.getString("customer_id")))
            .firstName(new String(rs.getString("first_name")))
            .lastName(new String(rs.getString("last_name")))
            .build();
      } });
      
      
    
  }

}
