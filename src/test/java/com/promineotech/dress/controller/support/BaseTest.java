/**
 * 
 */
package com.promineotech.dress.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import lombok.Getter;

//here is how we get the random port to run the test. We put @LocalServerPort here so it is available to all of our tests
public class BaseTest {
  @LocalServerPort
  private int serverPort;
  
  //Test rest template is used to send http to the running application
  //@autowired tells spring boot to inject whatever copy of test rest template that it had created for us
  @Autowired
  @Getter
  private TestRestTemplate restTemplate;
  
  //Here is where we retrieve the URI of the request that gets sent to the application
  protected String getBaseUri() {
    return String.format("http://localhost:%d/dress", serverPort);
  }

}
