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
  //automatic dependency injection 
  @Autowired DressDao dressDao;
  
  //Get Dress
  //Applied a transactional annotation for read only bc nothing will change
  @Transactional(readOnly=true)
  @Override
  public List<Dress> fetchDress(String dressStyle) {
   log.info("The fetchDress method was called with dressStyle={}", dressStyle);
   
   return dressDao.fetchDress(dressStyle);
  }

  //Post (create) Dress
  //No @Transactional here
  @Override
  public Optional<Dress> createDress(String dressID, String dressStyle, BigDecimal price, Long customerFk) {
    log.info("The createDress method was called with dressID={}, dressStyle={}, price={}, customerFk={}", dressID, dressStyle, price, customerFk);
    
    return dressDao.createDress(dressID, dressStyle, price, customerFk);
  }

  //Put (update) dress
  //No @Transactional here
  @Override
  public Optional<Dress> updateDressPrice(String dressID, BigDecimal price) {
   log.info("The updateDressPrice method was called with dressID={}, price={}", dressID, price);
   
   return dressDao.updateDressPrice(dressID, price);
   
  }

  //Delete Dress
  //No @Transactional here
  @Override
  public Optional<Dress> deleteDress(Long dressPK) {
    
    return dressDao.deleteDress(dressPK);
  }

}
