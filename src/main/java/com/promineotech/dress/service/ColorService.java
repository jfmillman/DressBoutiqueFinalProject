/**
 * 
 */
package com.promineotech.dress.service;

import java.util.List;
import com.promineotech.dress.entity.Color;

/**
 * @author jessicamillman
 *
 */
public interface ColorService {

  /**
   * @param colorPK
   * @return
   */
  List<Color> fetchListOfColors(Long colorPK);

}
