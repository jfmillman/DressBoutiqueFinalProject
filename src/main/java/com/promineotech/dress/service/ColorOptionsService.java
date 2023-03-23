/**
 * 
 */
package com.promineotech.dress.service;

import java.util.List;
import com.promineotech.dress.entity.Color;
import com.promineotech.dress.entity.Color_Options;

/**
 * @author jessicamillman
 *
 */
public interface ColorOptionsService {

  List<Color_Options> fetchColors(Long dressFk);
}
