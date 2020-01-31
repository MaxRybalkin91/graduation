## GRADUATION PROJECT

This is a graduation app of the [TOPJAVA](https://topjava.ru/) course I highly recommend you:)

[Click here to see a task and description](https://github.com/JavaOPs/topjava/blob/master/graduation.md)

There are used: 
* Java 11, Maven, IntelliJ IDEA
* Spring Framework(Boot 2, Security, Data)
* Hibernate ORM 
* H2 Database
* REST API(JSON)
* Integration and service tests(SpringBootTest(MOCK), JUnit).

## CURL-requests to get data:

##### ***Please, start the "Application.java" to run the app***

#### Abilities of user:
- Get all restaurants with today's menu  
`curl -s http://localhost:8080/restaurants --user user:password`  

- Get all counts of votes for different restaurants  
`curl -s http://localhost:8080/restaurants/100003/votes --user user:password`  
`curl -s http://localhost:8080/restaurants/100004/votes --user user2:password`  
`curl -s http://localhost:8080/restaurants/100005/votes --user admin:admin`  

- Create new vote  
`curl -s -X PUT http://localhost:8080/restaurants/100003/votes --user user:password`  

#### Abilities of admin:
- Get all restaurants for edit  
`curl -s http://localhost:8080/admin/restaurants --user admin:admin`

- Get meals history of restaurant  
`curl -s http://localhost:8080/admin/restaurants/100003/meals/history --user admin:admin`    

- Get votes statistic of restaurant  
`curl -s http://localhost:8080/admin/restaurants/100003/votes --user admin:admin`  

- Create new restaurant  
`curl -s -X POST -d '{"name":"Italian pizza","address":"1st cental str, 10"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/admin/restaurants --user admin:admin`  

- Get restaurant  
`curl -s http://localhost:8080/admin/restaurants/100003 --user admin:admin`  

- Delete restaurant  
`curl -s -X DELETE http://localhost:8080/admin/restaurants/100004 --user admin:admin`  

- Update restaurant  
`curl -s -X PUT -d '{"name":"Burger King","address":"1st cental str, 10"}' -H 'Content-Type: application/json' http://localhost:8080/admin/restaurants/100003 --user admin:admin`  

- Create new meal  
`curl -s -X POST -d '{"name":"Big Mexican Burger","price":199}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/admin/restaurants/100003/meals --user admin:admin`  

- Get meal  
`curl -s http://localhost:8080/admin/restaurants/100003/meals/100006 --user admin:admin`  

- Delete meal  
`curl -s -X DELETE http://localhost:8080/admin/restaurants/100003/meals/100006 --user admin:admin`  

- Update meal  
`curl -s -X PUT -d '{"name":"New Burger","price":199}' -H 'Content-Type: application/json' http://localhost:8080/admin/restaurants/100003/meals/100007 --user admin:admin`  