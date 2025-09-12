package com.challenge.product.repository;

import com.challenge.product.dto.ProductDTO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import java.util.List;

@Component
public class FileUtils {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  public List<ProductDTO> loadGeneratedFile() throws IOException, URISyntaxException {
    try (InputStream is = FileUtils.class.getResourceAsStream("/products.json")) {
      if (is == null) {
        throw new IllegalArgumentException("Arquivo products.json não encontrado no classpath!");
      }
      return objectMapper.readValue(is, new TypeReference<List<ProductDTO>>() {
      });
    }
  }
}
