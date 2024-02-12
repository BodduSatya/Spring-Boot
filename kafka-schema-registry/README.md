### Spring Boot | Kafka Schema Registry & Avro with Practical Example and Implementation

* docker compose up -d

* Go to IDE Maven Section => Lifecycle => install => it will generate avro class using maven plugin
  or
* Right click on proget => Maven => Generate Sources and update folder option to generate avro class

* http://localhost:9021/ ( confluent kafka tool )


POST http://localhost:8181/events
 
{
    "id":"1",
    "firstname":"Satya",
    "middlename":"Narayana",
    "lastname":"Boddu",
    "emailId":"boddusatya@gmail.com"
}

![image](https://github.com/BodduSatya/Spring-Boot/assets/24984593/10742740-9892-4ff8-8060-e21e1458f854)



