# Product Challenge API

Uma API REST para gerenciamento de produtos com funcionalidade de busca parcial, desenvolvida em Java com Spring Boot e arquitetura modular.

## 📋 Sobre o Projeto

Esta API permite gerenciar produtos com as seguintes funcionalidades:
- Listar todos os produtos
- Buscar produto por ID
- Buscar produtos por nome (busca parcial, similar ao LIKE do SQL)
- Busca case-insensitive
- Retorno de múltiplos resultados

## 🚀 Como Executar Localmente

### Pré-requisitos
- Java 21
- Gradle (wrapper incluído no projeto)

### Executando a Aplicação

```bash
# Clone o repositório
git clone <repository-url>
cd product-challenge

# Execute a aplicação
./gradlew :application:bootRun
```

A aplicação estará disponível em: `http://localhost:8080`

### Executando os Testes

```bash
# Todos os testes
./gradlew test

# Testes de um módulo específico
./gradlew :repository:test
```

## 📚 Documentação da API

### Endpoints Disponíveis

#### 1. Listar Todos os Produtos
```http
GET /products/
```

**Exemplo:**
```bash
curl --location 'http://localhost:8080/products/'
```

**Resposta:**
```json
[
  {
    "id": "01",
    "name": "Smartphone Galaxy S23",
    "description": "Smartphone Samsung Galaxy S23 com 128GB",
    "validity": "2025-12-31"
  },
  {
    "id": "02", 
    "name": "Notebook Dell Inspiron",
    "description": "Notebook Dell Inspiron 15 com Intel i5",
    "validity": "2026-06-15"
  }
]
```

#### 2. Buscar Produto por ID
```http
GET /products/{id}
```

**Exemplo:**
```bash
curl --location 'http://localhost:8080/products/02'
```

**Resposta:**
```json
{
  "id": "02",
  "name": "Notebook Dell Inspiron", 
  "description": "Notebook Dell Inspiron 15 com Intel i5",
  "validity": "2026-06-15"
}
```

#### 3. Buscar Primeiro Produto por Nome (Busca Parcial)
```http
GET /products/search?name={termo}
```

**Exemplo:**
```bash
curl --location 'http://localhost:8080/products/search?name=Smart'
```

**Resposta:**
```json
{
  "id": "01",
  "name": "Smartphone Galaxy S23",
  "description": "Smartphone Samsung Galaxy S23 com 128GB", 
  "validity": "2025-12-31"
}
```

#### 4. Buscar Todos os Produtos por Nome (Busca Parcial)
```http
GET /products/search/all?name={termo}
```

**Exemplo:**
```bash
curl --location 'http://localhost:8080/products/search/all?name=console'
```

**Resposta:**
```json
[
  {
    "id": "15",
    "name": "Console PlayStation 5",
    "description": "Console de videogame Sony PlayStation 5",
    "validity": "2027-11-20"
  },
  {
    "id": "16", 
    "name": "Console Xbox Series X",
    "description": "Console de videogame Microsoft Xbox Series X",
    "validity": "2027-12-05"
  }
]
```

## 📖 Documentação Swagger

A API inclui documentação interativa gerada automaticamente com Swagger/OpenAPI 3.0.

### Acessando o Swagger UI

Com a aplicação em execução, acesse:

**🔗 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

### Funcionalidades do Swagger UI

- **Documentação Interativa**: Visualize todos os endpoints disponíveis
- **Teste Direto**: Execute requisições diretamente pela interface
- **Esquemas de Dados**: Veja a estrutura completa dos objetos JSON
- **Exemplos de Resposta**: Visualize exemplos de retorno para cada endpoint
- **Validação de Parâmetros**: Interface para testar diferentes parâmetros

### Endpoints Documentados no Swagger

- `GET /products/` - Lista todos os produtos
- `GET /products/{id}` - Busca produto por ID
- `GET /products/search` - Busca primeiro produto por nome parcial
- `GET /products/search/all` - Busca todos os produtos por nome parcial

### Como Usar

1. Execute a aplicação: `./gradlew :application:bootRun`
2. Abra o navegador em: `http://localhost:8080/swagger-ui/index.html`
3. Explore os endpoints disponíveis
4. Clique em "Try it out" para testar as requisições
5. Insira os parâmetros necessários e clique em "Execute"

## 🔍 Funcionalidade de Busca Parcial

### Como Funciona

A busca por nome implementa funcionalidade similar ao operador `LIKE` do SQL:

- **Busca Parcial**: Encontra produtos que contêm o termo pesquisado
- **Case-Insensitive**: Funciona independente de maiúsculas/minúsculas
- **Flexível**: Não precisa digitar o nome exato do produto

### Exemplos de Busca

```bash
# Busca por "galaxy" (minúsculo) encontra "Smartphone Galaxy S23"
curl "http://localhost:8080/products/search?name=galaxy"

# Busca por "SMART" (maiúsculo) encontra produtos com "Smart"  
curl "http://localhost:8080/products/search?name=SMART"

# Busca por "phone" encontra "Smartphone Galaxy S23"
curl "http://localhost:8080/products/search?name=phone"

# Busca todos os produtos que contêm "Smart"
curl "http://localhost:8080/products/search/all?name=Smart"
```

### Comportamento dos Métodos

#### `/products/search?name={termo}`
- ✅ Busca parcial (contém o termo)
- ✅ Case-insensitive 
- ✅ Retorna o **primeiro** produto encontrado
- ✅ Retorna `404` se não encontrar

#### `/products/search/all?name={termo}`
- ✅ Busca parcial (contém o termo)
- ✅ Case-insensitive
- ✅ Retorna **lista** com todos os produtos encontrados
- ✅ Retorna lista vazia se não encontrar

## 🏗️ Arquitetura do Projeto

```
product-challenge/
├── entities/                # Módulo de entidades
├── repository/              # Módulo de repositório e persistência
├── usecases/               # Módulo de casos de uso/serviços
├── web/                    # Módulo web/controllers
├── application/            # Módulo principal da aplicação
└── build.gradle            # Configuração principal do Gradle
```

## ⚙️ Configuração do VS Code

### Extensões Recomendadas

O projeto inclui configurações para VS Code com as seguintes extensões:

**Essenciais:**
- Extension Pack for Java
- Language Support for Java  
- Debugger for Java
- Test Runner for Java
- Maven for Java
- Gradle for Java

**Spring Boot:**
- Spring Boot Extension Pack
- Spring Boot Dashboard

**Utilitários:**
- Lombok Annotations Support
- SonarLint
- XML

### Como Configurar

1. **Automático**: Abra o projeto no VS Code e aceite instalar as extensões recomendadas
2. **Manual**: Vá em Extensions (Ctrl+Shift+X) e instale cada uma individualmente

### Executando no VS Code

#### Executar a Aplicação
```bash
# Via terminal
./gradlew :application:bootRun

# Via VS Code
Ctrl+Shift+P -> "Tasks: Run Task" -> "gradle: bootRun"
```

#### Debug da Aplicação
1. Pressione F5 ou vá em Run and Debug
2. Selecione "Debug Spring Boot App"
3. A aplicação iniciará em modo debug

#### Executar Testes
```bash
# Via terminal
./gradlew test

# Via VS Code  
Ctrl+Shift+P -> "Java: Run Tests"
```

### Atalhos Úteis

- **F5**: Iniciar Debug
- **Ctrl+F5**: Executar sem Debug
- **Shift+F5**: Parar Debug
- **F9**: Toggle Breakpoint
- **F10**: Step Over
- **F11**: Step Into
- **Shift+F11**: Step Out

## 🧪 Testes

O projeto inclui testes unitários para validar:

- Busca parcial por nome
- Busca case-insensitive
- Retorno de múltiplos resultados
- Cenários sem resultados
- Busca por ID
- Listagem de todos os produtos

Execute os testes com:
```bash
./gradlew test
```

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Gradle**
- **JUnit 5**
- **Jackson** (para JSON)
- **Arquitetura Modular** (Clean Architecture)

## 📝 Dados de Exemplo

O projeto inclui um arquivo `products.json` com 30 produtos fictícios para teste, incluindo:
- Smartphones
- Notebooks  
- Consoles
- Smart TVs
- Smartwatches
- E muito mais...

## 🔧 Troubleshooting

### Problema: Java não encontrado
**Solução**: Verifique se o JAVA_HOME está configurado corretamente

### Problema: Gradle não funciona
**Solução**: Execute `./gradlew --version` para verificar se o wrapper está funcionando

### Problema: Porta 8080 em uso
**Solução**: Pare outros serviços na porta 8080 ou configure uma porta diferente em `application.properties`

### Problema: Testes não executam
**Solução**: Verifique se as dependências de teste estão no `build.gradle`