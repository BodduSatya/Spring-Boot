### springboot-aws-lambda
AWS Lambda is a serverless computing service provided by Amazon to reduce the configuration of servers, OS .

AWS Lambda lets you run code without provisioning or managing servers—it scales automatically and only charges for the time your code is running

# check lambda locally
* add web dependency in pom.xml, while building jar for aws upload, comment web dependency.

* curl -H "Content-Type: text/plain" localhost:8080/getOrders
Output : [{"id":101,"name":"Mobile","price":20000.0,"quantity":1},{"id":102,"name":"Book","price":799.0,"quantity":2},{"id":103,"name":"Book","price":499.0,"quantity":3},{"id":104,"name":"Laptop","price":75000.0,"quantity":1}]

* curl -H "Content-Type: text/plain" localhost:8080/findOrderByName -d "Book"
Output : [{"id":102,"name":"Book","price":799.0,"quantity":2},{"id":103,"name":"Book","price":499.0,"quantity":3}]

