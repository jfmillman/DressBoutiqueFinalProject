/**
 * 
 */
package com.promineotech.dress.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author jessicamillman
 *
 */
@Data
@Builder
public class Color_Options {


  Long colorFk;
  Long dressFk;

  
}
