/**
 * 
 */
package com.promineotech.dress.entity;

import lombok.Builder;
import lombok.Data;

//The color class has the color name and IDs
@Data
@Builder
public class Color {
  private Long colorPK;
  private String colorId;
}
