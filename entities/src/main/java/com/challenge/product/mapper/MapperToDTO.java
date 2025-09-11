package com.challenge.product.mapper;

import com.challenge.product.dto.ProductDTO;
import com.challenge.product.entities.Product;

import java.util.Optional;
import java.util.function.Function;

public class MapperToDTO implements Function<Product, Optional<ProductDTO>> {


  @Override
  public Optional<ProductDTO> apply(Product product) {
    return Optional.of(
            new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getValidity()
            )
    );
  }
}
