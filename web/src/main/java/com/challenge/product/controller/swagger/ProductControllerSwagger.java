package com.challenge.product.controller.swagger;

import com.challenge.product.dto.ProductDTO;

import java.util.List;

public interface ProductControllerSwagger {

  ProductDTO findById(Long id);

  ProductDTO findByName(String name);

  List<ProductDTO> findAll();
}
