/**
 * 
 */
package com.promineotech.dress.entity;

import lombok.Builder;
import lombok.Data;

//@Data generates getters for all fields
//Customer class has info for each customer
@Data
@Builder
public class Customers {
  private Long customerPK;
  private String customerId;
  private String firstName;
  private String lastName;
}
