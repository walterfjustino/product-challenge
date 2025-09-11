package com.challenge.product.service;

import com.challenge.product.dto.ProductDTO;

import java.util.List;

public interface ProductService {

  ProductDTO findById(Long id);
  ProductDTO findByName(String name);
  List<ProductDTO> findAll();

}
