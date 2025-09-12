package com.challenge.product.controller;

import com.challenge.product.controller.swagger.ProductControllerSwagger;
import com.challenge.product.dto.ProductDTO;
import com.challenge.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController implements ProductControllerSwagger {

  private final ProductService productService;

  @GetMapping("/{id}")
  @Override
  public ProductDTO findById(@PathVariable Long id) {
    return productService.findById(id);
  }

  @GetMapping("/search")
  @Override
  public ProductDTO findByName(@RequestParam("name") String name) {
    return productService.findByName(name);
  }

  @GetMapping("/search/all")
  public List<ProductDTO> findByNameContaining(@RequestParam("name") String name) {
    return productService.findByNameContaining(name);
  }

  @GetMapping("/")
  @Override
  public List<ProductDTO> findAll() {
    return productService.findAll();
  }
}
