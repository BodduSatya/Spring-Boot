###### Save Product
POST http://localhost:8080/api/product-client/add

{
    "name": "Docker",
    "quantity": 2,
    "price": 1200.00
}

###### Get All Product
GET http://localhost:8080/api/product-client

###### Get Product details by ID
GET http://localhost:8080/api/product-client/37

###### Update Product
PUT http://localhost:8080/api/product-client/update/37

{
    "name": "Struts",
    "quantity": 10,
    "price": 299.0
}

###### DELETE Product
DELETE http://localhost:8080/api/product-client/update/37

