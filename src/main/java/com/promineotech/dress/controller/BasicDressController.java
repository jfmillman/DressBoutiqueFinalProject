/**
 * 
 */
package com.promineotech.dress.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.dress.entity.Dress;
import com.promineotech.dress.service.DressService;
import lombok.extern.slf4j.Slf4j;

//This class is controller class that tells spring to marshal and unmarshal JSON to Java.

@RestController
@Slf4j
public class BasicDressController implements DressController {

  @Autowired
  private DressService dressService;

  //Get (read dresses)
  @Override
  public List<Dress> fetchDress (String dressStyle) {
    log.info("dressStyle={}", dressStyle);
    
    return dressService.fetchDress(dressStyle);
  }
  
  //Post (create dress)
  @Override
  public Optional<Dress> createDress(String dressID, String dressStyle, BigDecimal price) {
    log.info("dressID={}, dressStyle={}, price={}", dressID, dressStyle, price);
    
    return dressService.createDress(dressID, dressStyle, price);
  }

  //Put (update dress price)
  @Override
  public Optional<Dress> updateDressPrice(String dressID, Dress newPrice) {
    log.info("dressID={}, newPrice={}", dressID, newPrice);
    
    return dressService.updateDressPrice(dressID, newPrice);
  }

  //Delete (delete dress)
  @Override
  public Optional<Dress> deleteDress(Long dressPK) {
    log.info("dressPK={}", dressPK);
    
    return dressService.deleteDress(dressPK);
  }

}
