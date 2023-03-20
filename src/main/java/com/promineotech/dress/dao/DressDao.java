/**
 * 
 */
package com.promineotech.dress.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.dress.entity.Dress;

/**
 * @author jessicamillman
 *
 */
public interface DressDao {

  /**
   * @param colorPK
   * @param dressPK
   * @return
   */
  List<Dress> fetchDress(String dressStyle);

  /**
   * @param dressID
   * @param dressStyle
   * @param price
   * @return
   */
  Optional<Dress> createDress(String dressID, String dressStyle, BigDecimal price);

  /**
   * @param dressID
   * @param dressStyle
   * @return
   */
  Optional<Dress> updateDressPrice(String dressID, String dressStyle, BigDecimal newPrice);

  /**
   * @param dressPK
   * @return
   */
  Optional<Dress> deleteDress(Long dressPK);

}
