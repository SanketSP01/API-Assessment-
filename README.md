# Spring Boot CRUD Application with Pagination

This Spring Boot application demonstrates how to build a RESTful API for performing CRUD (Create, Read, Update, Delete) operations on categories and products with pagination.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Pagination](#pagination)

## Features

- CRUD operations for categories and products.
- One-to-many relationship between categories and products.
- RESTful API endpoints.
- Pagination for efficient data retrieval.
- Exception handling for error responses.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

## Getting Started

To run this application locally, follow these steps:

1. Clone the repository:

   ```bash
   git clone <repository_url>
2. Navigate to the project directory:

``bash
cd <project_directory>``

3. Run the application using Maven:

``bash
  mvn spring-boot:run``

4. The application will start running at
   `http://localhost:8080`.

## Usage
You can use tools like Postman to interact with the API endpoints. See API Endpoints section for more details.

## API Endpoints
- Categories
  - GET /api/categories: Get all categories
  - GET /api/categories/{id}: Get category by ID
  - POST /api/categories: Create a new category
  - PUT /api/categories/{id}: Update category by ID
  - DELETE /api/categories/{id}: Delete category by ID
- Products
   - GET /api/products: Get all products
   - GET /api/products/{id}: Get product by ID
   - POST /api/products: Create a new product
   - PUT /api/products/{id}: Update product by ID
   - DELETE /api/products/{id}: Delete product by ID
  
## Pagination
- Pagination parameters can be used to control the pagination behavior:

- page: Page number (default: 0)
- size: Number of items per page (default: 10)
- sort: Sorting options (e.g., price,desc for sorting by price in descending order)




