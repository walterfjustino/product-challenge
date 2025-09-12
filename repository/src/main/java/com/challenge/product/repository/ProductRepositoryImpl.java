package com.challenge.product.repository;

import com.challenge.product.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

  private final FileUtils fileUtils;

  @Override
  public ProductDTO findById(String id) {
    try {
      List<ProductDTO> products = fileUtils.loadGeneratedFile();
      
      return products.stream()
          .filter(product -> id.equals(product.id()))
          .findFirst()
          .orElse(null);
    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException("Erro ao ler arquivo de produtos", e);
    }
  }

  @Override
  public ProductDTO findByName(String name) {
    try {
      List<ProductDTO> products = fileUtils.loadGeneratedFile();
      
      return products.stream()
          .filter(product -> product.name().toLowerCase().contains(name.toLowerCase()))
          .findFirst()
          .orElse(null);
    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException("Erro ao ler arquivo de produtos", e);
    }
  }

  @Override
  public List<ProductDTO> findByNameContaining(String name) {
    try {
      List<ProductDTO> products = fileUtils.loadGeneratedFile();
      
      return products.stream()
          .filter(product -> product.name().toLowerCase().contains(name.toLowerCase()))
          .toList();
    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException("Erro ao ler arquivo de produtos", e);
    }
  }

  @Override
  public List<ProductDTO> findAll() {
    try {
      return fileUtils.loadGeneratedFile();
    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException("Erro ao ler arquivo de produtos", e);
    }
  }
}
