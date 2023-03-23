/**
 * 
 */
package com.promineotech.dress.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.dress.entity.Color_Options;
import com.promineotech.dress.service.ColorOptionsService;
import lombok.extern.slf4j.Slf4j;

@RestController
//This means we can log something
@Slf4j
public class BasicColorOptionsController implements ColorOptionsController {

//Tells Spring that we want an object to be injected here
  @Autowired
  private ColorOptionsService colorOptionsService;
  
  //fetchColors will read the list of colors
  @Override
  public List<Color_Options> fetchColors(Long dressFk) {
    log.info("dressFk={}", dressFk);
    
    return colorOptionsService.fetchColors(dressFk);
  }

}
