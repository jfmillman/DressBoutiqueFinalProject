/**
 * 
 */
package com.promineotech.dress.dao;

import java.util.List;
import com.promineotech.dress.entity.Color_Options;

/**
 * @author jessicamillman
 *
 */
public interface ColorOptionsDao {

//Method to read colors from the color options table
  List<Color_Options> fetchColors(Long colorPK);

}
