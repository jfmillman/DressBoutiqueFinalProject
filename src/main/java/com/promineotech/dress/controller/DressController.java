/**
 * 
 */
package com.promineotech.dress.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.dress.entity.Dress;
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
@RequestMapping ("/Dress")
@OpenAPIDefinition(info = @Info(title = "Dress Boutique Dress Service"), servers = {
  @Server(url = "http://localhost:8080", description = "Localserver.")})

public interface DressController {
//@formatter:off
//here are our parameters. Response codes are:
//200 = OK
//400 = bad input
//404 = not found
//500 = unplanned exception
  @Operation(
      summary = "Returns a list of dresses",
      description = "Returns a list of dresses given an optional dressStyle",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of dresses is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Dress.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No dresses were found with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json")) },
 
      parameters = {
          @Parameter(
              name = "dressStyle", 
              allowEmptyValue = false, 
              required = false, 
              description = "The dressStyle (i.e., 'strapless')")
     }
  )
  //@formatter:on
     
 //This is what will return a list of dresses
  @GetMapping 
  @ResponseStatus(code = HttpStatus.OK)
  List<Dress> fetchDress(
      @RequestParam(required = false)
      String dressStyle);
    
  
  
  @Operation(
      summary = "Create a new dress",
      description = "Create a dress using the required dressID, dressStyle, and price",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A dress is created.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Dress.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to create a dress with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json")) },
 
      parameters = {
          @Parameter(
              name = "dressID", 
              allowEmptyValue = false, 
              required = true, 
              description = "The dressID (i.e., 'Venice')"), 
          @Parameter(
              name = "dressStyle",
              allowEmptyValue = false,
              required = true,
              description = "The dressStyle (i.e., 'strapless')"), 
          @Parameter(
              name = "price",
              allowEmptyValue = false,
              required = true,
              description = "The price (i.e., '100.00')") 
     }
  )
  //@formatter:on
     
 //This will create a new dress dresses
  @PostMapping 
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Dress> createDress(
      @RequestParam (required = true)
      String dressID,
      @RequestParam (required = true)
      String dressStyle,
      @RequestParam (required = true)
      BigDecimal price);
  
  @Operation(
      summary = "Update the price of a dress",
      description = "Update the price of a dress using the required dressID and dressStyle",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "The dress price is updated.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Dress.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to update the dress price with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json")) },
 
      parameters = {
          @Parameter(
              name = "dressID", 
              allowEmptyValue = false, 
              required = true, 
              description = "The dressID (i.e., 'Venice')"), 
          @Parameter(
              name = "dressStyle",
              allowEmptyValue = false,
              required = true,
              description = "The dressStyle (i.e., 'strapless')"),
          @Parameter (
              name = "newPrice",
              allowEmptyValue = false, 
              required = true, 
              description = "The newPrice"
              )
     }
  )
  //@formatter:on
     
 //This will update the price of an existing dress
  @PutMapping 
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Dress> updateDressPrice(
      @RequestParam (required = true)
      String dressID,
      @RequestParam (required = true)
      String dressStyle);
  
  @Operation(
      summary = "Delete a dress",
      description = "Delete a dress using the required dressPK",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "The dress is deleted.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Dress.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to delete the dress with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json")) },
 
      parameters = {
          @Parameter(
              name = "dressPK", 
              allowEmptyValue = false, 
              required = true, 
              description = "The dressPK (i.e., '8')"), 
     }
  )
  //@formatter:on
     
 //This will delete a dress dress
  @DeleteMapping 
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Dress> deleteDress(
      @RequestParam (required = true)
      Long dressPK);
}
