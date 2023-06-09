/**
 * 
 */
package com.promineotech.dress.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.dress.entity.Dress;

//Interface allows Dao level to be built after Interface is created. At the same time, I created the Service level while working on the Controller
public interface DressService {

  List<Dress> fetchDress(String dressStyle);

  /**
   * @param dressID
   * @param dressStyle
   * @param price
   * @return
   */
  Optional<Dress> createDress(String dressID, String dressStyle, BigDecimal price, Long customerFk);
  
  Optional<Dress> updateDressPrice(String dressID, BigDecimal price);

  Optional<Dress> deleteDress(Long dressPK);


}
