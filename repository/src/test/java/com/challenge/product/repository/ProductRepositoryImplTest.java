package com.challenge.product.repository;

import com.challenge.product.dto.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryImplTest {

    @Mock
    private FileUtils fileUtils;

    @InjectMocks
    private ProductRepositoryImpl productRepository;

    private List<ProductDTO> mockProducts;

    @BeforeEach
    void setUp() {
        mockProducts = List.of(
            new ProductDTO("1", "Smartphone Galaxy S23", "Smartphone Android com tela de 6.1 polegadas", "2025-12-31"),
            new ProductDTO("2", "Notebook Dell Inspiron", "Notebook com processador Intel Core i5", "2026-06-30")
        );
    }

    @Test
    void testFindById_WhenProductExists_ShouldReturnProduct() throws Exception {
        // Given
        when(fileUtils.loadGeneratedFile()).thenReturn(mockProducts);

        // When
        ProductDTO result = productRepository.findById("1");

        // Then
        assertNotNull(result);
        assertEquals("1", result.id());
        assertEquals("Smartphone Galaxy S23", result.name());
        assertEquals("Smartphone Android com tela de 6.1 polegadas", result.description());
        assertEquals("2025-12-31", result.validity());
    }

    @Test
    void testFindById_WhenProductNotExists_ShouldReturnNull() throws Exception {
        // Given
        when(fileUtils.loadGeneratedFile()).thenReturn(mockProducts);

        // When
        ProductDTO result = productRepository.findById("999");

        // Then
        assertNull(result);
    }

    @Test
    void testFindByName_WhenProductExists_ShouldReturnProduct() throws Exception {
        // Given
        when(fileUtils.loadGeneratedFile()).thenReturn(mockProducts);

        // When
        ProductDTO result = productRepository.findByName("Smartphone Galaxy S23");

        // Then
        assertNotNull(result);
        assertEquals("1", result.id());
        assertEquals("Smartphone Galaxy S23", result.name());
        assertEquals("Smartphone Android com tela de 6.1 polegadas", result.description());
        assertEquals("2025-12-31", result.validity());
    }

    @Test
    void testFindByName_WithPartialName_ShouldReturnProduct() throws Exception {
        // Given
        when(fileUtils.loadGeneratedFile()).thenReturn(mockProducts);

        // When
        ProductDTO result = productRepository.findByName("Galaxy");

        // Then
        assertNotNull(result);
        assertEquals("1", result.id());
        assertEquals("Smartphone Galaxy S23", result.name());
    }

    @Test
    void testFindByName_CaseInsensitive_ShouldReturnProduct() throws Exception {
        // Given
        when(fileUtils.loadGeneratedFile()).thenReturn(mockProducts);

        // When
        ProductDTO result = productRepository.findByName("galaxy");

        // Then
        assertNotNull(result);
        assertEquals("1", result.id());
        assertEquals("Smartphone Galaxy S23", result.name());
    }

    @Test
    void testFindByName_WhenProductNotExists_ShouldReturnNull() throws Exception {
        // Given
        when(fileUtils.loadGeneratedFile()).thenReturn(mockProducts);

        // When
        ProductDTO result = productRepository.findByName("Produto Inexistente");

        // Then
        assertNull(result);
    }

    @Test
    void testFindByNameContaining_ShouldReturnMatchingProducts() throws Exception {
        // Given
        when(fileUtils.loadGeneratedFile()).thenReturn(mockProducts);

        // When
        List<ProductDTO> result = productRepository.findByNameContaining("Galaxy");

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Smartphone Galaxy S23", result.get(0).name());
    }

    @Test
    void testFindByNameContaining_CaseInsensitive_ShouldReturnMatchingProducts() throws Exception {
        // Given
        when(fileUtils.loadGeneratedFile()).thenReturn(mockProducts);

        // When
        List<ProductDTO> result = productRepository.findByNameContaining("notebook");

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Notebook Dell Inspiron", result.get(0).name());
    }

    @Test
    void testFindByNameContaining_NoMatches_ShouldReturnEmptyList() throws Exception {
        // Given
        when(fileUtils.loadGeneratedFile()).thenReturn(mockProducts);

        // When
        List<ProductDTO> result = productRepository.findByNameContaining("Produto Inexistente");

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindAll_ShouldReturnAllProducts() throws Exception {
        // Given
        when(fileUtils.loadGeneratedFile()).thenReturn(mockProducts);

        // When
        List<ProductDTO> result = productRepository.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Smartphone Galaxy S23", result.get(0).name());
        assertEquals("Notebook Dell Inspiron", result.get(1).name());
    }
}