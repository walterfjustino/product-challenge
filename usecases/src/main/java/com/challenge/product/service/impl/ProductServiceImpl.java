package com.challenge.product.service.impl;

import com.challenge.product.dto.ProductDTO;
import com.challenge.product.repository.ProductRepository;
import com.challenge.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public ProductDTO findById(Long id) {
    return productRepository.findById(String.valueOf(id));
  }

  @Override
  public ProductDTO findByName(String name) {
    return productRepository.findByName(name);
  }

  @Override
  public List<ProductDTO> findByNameContaining(String name) {
    return productRepository.findByNameContaining(name);
  }

  @Override
  public List<ProductDTO> findAll() {
    return productRepository.findAll();
  }
}
