/**
 * 
 */
package com.promineotech.dress.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

//The Dress class has all of the dress options and details: dress ID, style, and price
@Data
@Builder
public class Dress {
  private Long dressPK;
  private String dressId;
  private String dressStyle;
  private BigDecimal price;
  private Long customerFk;

}
