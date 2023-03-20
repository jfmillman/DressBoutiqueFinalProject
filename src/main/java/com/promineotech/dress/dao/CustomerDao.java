/**
 * 
 */
package com.promineotech.dress.dao;

import java.util.List;
import com.promineotech.dress.entity.Customers;

/**
 * @author jessicamillman
 *
 */
public interface CustomerDao {

  //This method reads customers from the customer table
  /**
   * @param customerPK
   * @param customerId
   * @return
   */
  List<Customers> fetchCustomers(String firstName);

}
