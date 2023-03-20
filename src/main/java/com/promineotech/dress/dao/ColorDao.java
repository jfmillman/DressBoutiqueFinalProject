/**
 * 
 */
package com.promineotech.dress.dao;

import java.util.List;
import com.promineotech.dress.entity.Color;

/**
 * @author jessicamillman
 *
 */
public interface ColorDao {

//Method to read colors from the color options table
  List<Color> fetchListOfColors(Long colorPK);

}
