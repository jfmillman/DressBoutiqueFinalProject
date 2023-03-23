/**
 * 
 */
package com.promineotech.dress.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.dress.entity.Customers;
import com.promineotech.dress.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@RestController
//This means we can log something
@Slf4j
public class BasicCustomerController implements CustomerController {
  
//Tells Spring that we want an object to be injected here
  @Autowired
  private CustomerService customerService;
  
  //fetchCustomers will read customers
  //{} will allow for any value to be input 
  //fetchCustomers is in the service package
  @Override
  public List<Customers> fetchCustomers(String firstName) {
    log.info("firstName={}", firstName);
    return customerService.fetchCustomers(firstName);
  }

}
