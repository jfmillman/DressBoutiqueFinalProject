/**
 * 
 */
package com.promineotech.dress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;


//This starts Spring Boot
@SpringBootApplication (scanBasePackageClasses = {ComponentScanMarker.class})
public class DressBoutique {

  /**
   * @param args
   */
  //This is how we run our Spring Boot Application
  public static void main(String[] args) {
   SpringApplication.run(DressBoutique.class, args);

  }

}
