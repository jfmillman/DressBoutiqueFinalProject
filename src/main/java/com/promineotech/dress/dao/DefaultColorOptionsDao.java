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
import com.promineotech.dress.entity.Color_Options;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultColorOptionsDao implements ColorOptionsDao{
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  //Get method to read the list of colors
  public List<Color_Options> fetchColors(Long dressFk) {
    log.info("DAO: dressFk={}", dressFk);
    
    //SQL statement
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM color_options "
        + "WHERE dress_fk = :dress_fk";
    //@formatter:on
    
  //prepared statement
    Map<String, Object> params = new HashMap<>();
    params.put("dress_fk", dressFk.toString()); 
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Color_Options mapRow(ResultSet rs, int rowNum) throws SQLException {
      //this builds the color_options info
        //@formatter:off
        return Color_Options.builder()
            .colorFk (rs.getLong("color_fk"))
            .dressFk(rs.getLong("dress_fk"))
            .build();
      } } );
      
      
   

  }

}
