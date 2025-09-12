package com.challenge.product.repository;

import com.challenge.product.dto.ProductDTO;

import java.util.List;

public interface ProductRepository {

  ProductDTO findById(String id);

  ProductDTO findByName(String name);

  List<ProductDTO> findByNameContaining(String name);

  List<ProductDTO> findAll();

}
