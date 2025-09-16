package com.challenge.product.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .info(new io.swagger.v3.oas.models.info.Info()
                    .title("Product Challenge API - Product Management System")
                    .description("""
                            # Objetivo
                            A Product Challenge API é uma solução REST para gerenciamento de produtos com funcionalidade avançada de busca parcial. Esta API permite consultar, listar e pesquisar produtos de forma eficiente, implementando busca similar ao operador LIKE do SQL com suporte case-insensitive.
                            
                            # Funcionalidades Principais
                            ## 🔍 Busca Parcial Inteligente
                            - Busca por nome de produto com correspondência parcial
                            - Busca case-insensitive (não diferencia maiúsculas/minúsculas)
                            - Retorno do primeiro resultado ou lista completa de resultados
                            - Funcionalidade similar ao operador LIKE do SQL
                            
                            ## 📋 Gestão de Produtos
                            - Listagem completa de produtos disponíveis
                            - Consulta individual de produtos por ID
                            - Estrutura de dados otimizada para performance
                            - Validação de dados de entrada
                            
                            ## 🎯 Endpoints Disponíveis
                            - **GET /products/** - Lista todos os produtos
                            - **GET /products/{id}** - Busca produto por ID específico
                            - **GET /products/search?name={termo}** - Busca primeiro produto por nome parcial
                            - **GET /products/search/all?name={termo}** - Busca todos os produtos por nome parcial
                            
                            # Público-Alvo
                            Esta API é destinada a desenvolvedores e sistemas que necessitam de funcionalidades de catálogo de produtos com busca flexível. Ideal para:
                            - E-commerce e marketplaces
                            - Sistemas de gestão de inventário
                            - Aplicações de catálogo de produtos
                            - Integrações com sistemas de vendas
                            
                            # Contexto Técnico
                            A API utiliza arquitetura modular baseada em Clean Architecture com separação clara de responsabilidades. Implementa persistência baseada em arquivos JSON para simplicidade e portabilidade, garantindo alta performance para consultas e buscas.
                            
                            ## Estrutura de Dados
                            Cada produto contém as seguintes informações:
                            - **id**: Identificador único do produto
                            - **name**: Nome do produto (usado para buscas parciais)
                            - **description**: Descrição detalhada do produto
                            - **validity**: Data de validade do produto (formato: YYYY-MM-DD)
                            
                            ## Exemplos de Busca
                            - Buscar "galaxy" encontra "Smartphone Galaxy S23"
                            - Buscar "SMART" encontra produtos com "Smart" no nome
                            - Buscar "phone" encontra "Smartphone Galaxy S23"
                            """)
                    .version("1.0.0")
                    .contact(new Contact()
                            .name("Walter Fernandes Justino")
                            .email("walterfjustino@gmail.com")
                            .url("https://github.com/walterfjustino/product-challenge"))
                    .license(new License()
                            .name("MIT License")
                            .url("https://opensource.org/licenses/MIT"))
                    .termsOfService("https://github.com/product-challenge/terms-of-service"));
  }
}
