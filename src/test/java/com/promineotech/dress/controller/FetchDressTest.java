package com.promineotech.dress.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.promineotech.dress.controller.support.FetchDressTestSupport;

//This is how the test runs under the spring boot framework. We tell the test to run in a web environment and to use a random port so the tests don't run on top
//of each other
@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
class FetchDressTest extends FetchDressTestSupport {

  @Test
  void test() {
    System.out.println(getBaseUri());
  }

}
