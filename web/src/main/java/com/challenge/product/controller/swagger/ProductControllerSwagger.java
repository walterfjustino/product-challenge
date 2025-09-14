package com.challenge.product.controller.swagger;

import com.challenge.product.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ProblemDetail;

import java.util.List;

public interface ProductControllerSwagger {

  @Tag(name = "Product Challenge API", description = "Api to get products localy in a json file")
  @Operation(summary = "findById product",
          description = "Retrieve the product in json file passing the parameter id")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "success",
                  content = @Content(
                          examples = {
                                  @ExampleObject("""
                                              {
                                                  "id": "2",
                                                  "name": "Notebook Dell Inspiron",
                                                  "description": "Notebook com processador Intel Core i5, 8GB RAM, SSD 256GB e tela de 15.6 polegadas",
                                                  "validity": "2026-06-30"
                                              }
                                          """)
                          }, schema = @Schema(implementation = ProductDTO.class))),
          @ApiResponse(responseCode = "400", description = "Invalid Parameters",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
          @ApiResponse(responseCode = "401", description = "Invalid Credentials",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
          @ApiResponse(responseCode = "404", description = "Product Not Found",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
          @ApiResponse(responseCode = "500", description = "Internal Server Error",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
  })
  ProductDTO findById(Long id);

  @Tag(name = "Product Challenge API", description = "Api to get products localy in a json file")
  @Operation(summary = "findByName product",
          description = "Retrieve the product in json file passing the parameter name")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "success",
                  content = @Content(
                          examples = {
                                  @ExampleObject("""
                                              {
                                                  "id": "2",
                                                  "name": "Notebook Dell Inspiron",
                                                  "description": "Notebook com processador Intel Core i5, 8GB RAM, SSD 256GB e tela de 15.6 polegadas",
                                                  "validity": "2026-06-30"
                                              }
                                          """)
                          }, schema = @Schema(implementation = ProductDTO.class))),
          @ApiResponse(responseCode = "400", description = "Invalid Parameters",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
          @ApiResponse(responseCode = "401", description = "Invalid Credentials",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
          @ApiResponse(responseCode = "404", description = "Product Not Found",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
          @ApiResponse(responseCode = "500", description = "Internal Server Error",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
  })
  ProductDTO findByName(String name);

  @Tag(name = "Product Challenge API", description = "Api to get products localy in a json file")
  @Operation(summary = "findByName product",
          description = "Retrieve a list the product in json file passing the parameter containing the name")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "success",
                  content = @Content(
                          examples = {
                                  @ExampleObject("""
                                              {
                                                  "id": "2",
                                                  "name": "Notebook Dell Inspiron",
                                                  "description": "Notebook com processador Intel Core i5, 8GB RAM, SSD 256GB e tela de 15.6 polegadas",
                                                  "validity": "2026-06-30"
                                              }
                                          """)
                          }, schema = @Schema(implementation = ProductDTO.class))),
          @ApiResponse(responseCode = "400", description = "Invalid Parameters",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
          @ApiResponse(responseCode = "401", description = "Invalid Credentials",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
          @ApiResponse(responseCode = "404", description = "Product Not Found",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
          @ApiResponse(responseCode = "500", description = "Internal Server Error",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
  })
  List<ProductDTO> findByNameContaining(String name);

  @Tag(name = "Product Challenge API", description = "Api to get products localy in a json file")
  @Operation(summary = "findAll products",
          description = "Retrieve all products in json file")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "success",
                  content = @Content(
                          examples = {
                                  @ExampleObject("""
                                          [
                                              {
                                                  "id": "1",
                                                  "name": "Smartphone Galaxy S23",
                                                  "description": "Smartphone Android com tela de 6.1 polegadas, 128GB de armazenamento e câmera tripla de 50MP",
                                                  "validity": "2025-12-31"
                                              },
                                              {
                                                  "id": "2",
                                                  "name": "Notebook Dell Inspiron",
                                                  "description": "Notebook com processador Intel Core i5, 8GB RAM, SSD 256GB e tela de 15.6 polegadas",
                                                  "validity": "2026-06-30"
                                              }
                                          ]""")
                          }, schema = @Schema(implementation = ProductDTO.class))),
          @ApiResponse(responseCode = "400", description = "Invalid Parameters",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
          @ApiResponse(responseCode = "401", description = "Invalid Credentials",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
          @ApiResponse(responseCode = "404", description = "Product Not Found",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
          @ApiResponse(responseCode = "500", description = "Internal Server Error",
                  content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
  })
  List<ProductDTO> findAll();
}
