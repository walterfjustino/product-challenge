package com.challenge.product.service;


import com.challenge.product.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

  @Override
  public ProductDTO findById(Long id) {
    return null;
  }

  @Override
  public ProductDTO findByName(String name) {
    return null;
  }

  @Override
  public List<ProductDTO> findAll() {
    return List.of();
  }
}
