package com.challenge.product.dto;

public record ProductDTO(
        Long id,
        String name,
        String description,
        String validity
) {
}
