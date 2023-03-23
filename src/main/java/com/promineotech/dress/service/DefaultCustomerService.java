/**
 * 
 */
package com.promineotech.dress.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.dress.dao.CustomerDao;
import com.promineotech.dress.entity.Customers;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCustomerService implements CustomerService {

  @Autowired
  private CustomerDao customerDao;
  
  //Read customers
  //Applied a transactional annotation for read only bc nothing will change
  @Transactional(readOnly = true)
  @Override
  public List<Customers> fetchCustomers(String firstName) {
    log.info("The fetchCustomers method was called with firstName={}", firstName);
    
    return customerDao.fetchCustomers(firstName);
  }

}
