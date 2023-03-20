/**
 * 
 */
package com.promineotech.dress.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.dress.entity.Color;
import com.promineotech.dress.service.ColorService;
import lombok.extern.slf4j.Slf4j;

@RestController
//This means we can log something
@Slf4j
public class BasicColorController implements ColorController {

  @Autowired
  private ColorService colorService;
  
  
  @Override
  public List<Color> fetchListOfColors(Long colorPK) {
   log.info("colorPK={}", colorPK);
    
    return colorService.fetchListOfColors(colorPK);
  }

}
