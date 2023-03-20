/**
 * 
 */
package com.promineotech.dress.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.dress.dao.DressDao;
import com.promineotech.dress.entity.Dress;
import lombok.extern.slf4j.Slf4j;

//Service tells Spring to manage(bean) defaultDressService b/c it is a candidate for injection
//Dress service interface

@Service
@Slf4j
public class DefaultDressService implements DressService{
  
  @Autowired DressDao dressDao;
  
  //Get Dress
  @Transactional(readOnly=true)
  @Override
  public List<Dress> fetchDress(String dressStyle) {
   log.info("The fetchDress method was called with dressStyle={}", dressStyle);
   
   return dressDao.fetchDress(dressStyle);
  }

  //Post (create) Dress
  @Override
  public Optional<Dress> createDress(String dressID, String dressStyle, BigDecimal price) {
    log.info("The createDress method was called with dressID={}, dressStyle={}, price={}", dressID, dressStyle, price);
    
    return dressDao.createDress(dressID, dressStyle, price);
  }

  //Put (update) dress
  @Override
  public Optional<Dress> updateDressPrice(String dressID, String dressStyle, BigDecimal newPrice) {
   log.info("The updateDressPrice method was called with dressID={}, dressStyle={}, newPrice={}", dressID, dressStyle, newPrice);
   
   return dressDao.updateDressPrice(dressID, dressStyle, newPrice);
  }

  //Delete Dress
  @Override
  public Optional<Dress> deleteDress(Long dressPK) {
    
    return dressDao.deleteDress(dressPK);
  }

}
