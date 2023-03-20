/**
 * 
 */
package com.promineotech.dress.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.dress.entity.Customers;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
//any URI that comes in with /customers after port number will get mapped to this class
@RequestMapping ("/Customers")
@OpenAPIDefinition(info = @Info(title = "Dress Boutique Customer Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Localserver.")})

public interface CustomerController {
//@formatter:off
//here are our parameters. Response codes are:
//200 = OK
//400 = bad input
//404 = not found
//500 = unplanned exception
  @Operation(
      summary = "Returns a list of customers",
      description = "Returns a list of customers given an optional first name",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of customers is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Customers.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No customers were found with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json")) },
 
      parameters = {
          @Parameter(
              name = "firstName", 
              allowEmptyValue = false, 
              required = false, 
              description = "The firstName (i.e., 'Jessica')")
     }
  )
  //@formatter:on
     
 //This is what will return a list of customers 
  @GetMapping 
  @ResponseStatus(code = HttpStatus.OK)
  List<Customers> fetchCustomers(
      @RequestParam(required = false)
      String firstName);   
  
}
