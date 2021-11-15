. **[Prerequisites]()**

**[.Compilation]()**

.**[Running Shopping Kart]()**

**[Testing]()**

Prerequisites

    .Java

    .Maven

     .Git

    .Postman to run the API 

Compilation

    mvn clean install

Running Shopping Kart

    mvn spring-boot:run

Testing

      Use postman to test the API. 
        http://localhost:8080/getBasketItemsPrice

    Sample Request in postman

    [{
    "productName": "Orange",
    "prductQuantity": 2
    },
    {
    "productName": "Banana",
    "prductQuantity": 2
    }
    ]



