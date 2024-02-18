# Spring Security Exception Handling | HandlerExceptionResolver | ProblemDetail

## mysql docker image pull

```bash
docker compose up -d
```

## ADD NEW USERS

```json
POST http://localhost:9090/products/addUser    
    {
    "id":1,
    "name":"satya",
    "email":"satya123@gmail.com",
    "password":"satya123",
    "roles":"ADMIN"
    }

POST http://localhost:9090/products/addUser
    {
    "id": 1,
    "name": "narayana",
    "email": "narayana123@gmail.com",
    "password": "narayana123",
    "roles": "USER"
    }
 
```

## Get Auth Token
```json
POST http://localhost:9090/products/authenticate 
    {
    "username":"satya",
    "password":"satya123"
    }
    
    output : jwt_token

```

## Get All Products
```json
http://localhost:9090/products/all
Authorization: Bearer <jwt_token>
```

``` json
    * Get Auth Token
    POST http://localhost:9090/products/authenticate
    
    {
    "username":"narayana",
    "password":"narayana123"
    }
    
    output : jwt_token
    
    * Get Product by ID
    http://localhost:9090/products/1
    Authorization: Bearer <jwt_token>
    
    output:
    {
    "productId": 1,
    "name": "product 1",
    "qty": 2,
    "price": 1300.0
    }
```
