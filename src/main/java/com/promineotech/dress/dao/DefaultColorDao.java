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
import com.promineotech.dress.entity.Color;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultColorDao implements ColorDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
//Get method to read the list of colors
  public List<Color> fetchListOfColors(Long colorPK) {
    log.info("DAO: colorPK={}", colorPK);
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM color "
        + "WHERE color_pk = :color_pk";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("color_pk", colorPK.toString());
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Color mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Color.builder()
            .colorPK(rs.getLong("color_pk"))
            .colorId(new String(rs.getString("color_id")))
            .build();
      } } );
      
  }

}
