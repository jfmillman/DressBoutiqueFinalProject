/**
 * 
 */
package com.promineotech.dress.service;

import java.util.List;
import com.promineotech.dress.entity.Customers;

/**
 * @author jessicamillman
 *
 */
public interface CustomerService {

  List<Customers> fetchCustomers (String firstName);
  
}
