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
`curl -s http://localhost:8080/restaurants --user user1:password`  

- Get all counts of votes for different restaurants  
`curl -s http://localhost:8080/restaurants/11/votes --user user1:password`  
`curl -s http://localhost:8080/restaurants/12/votes --user user2:password`  
`curl -s http://localhost:8080/restaurants/13/votes --user user3:password`  

- Create new vote  
`curl -s -X PUT http://localhost:8080/restaurants/11/votes --user user1:password`  
`curl -s -X PUT http://localhost:8080/restaurants/12/votes --user user2:password`  
`curl -s -X PUT http://localhost:8080/restaurants/13/votes --user user3:password`  

#### Abilities of admin:
- Get admin's own restaurants for edit  
`curl -s http://localhost:8080/admin/restaurants --user admin1:admin`  
`curl -s http://localhost:8080/admin/restaurants --user admin2:admin`  
`curl -s http://localhost:8080/admin/restaurants --user admin3:admin`  

- Get today's meals for editing  
`curl -s http://localhost:8080/admin/restaurants/11/meals --user admin1:admin`  
`curl -s http://localhost:8080/admin/restaurants/12/meals --user admin2:admin`  
`curl -s http://localhost:8080/admin/restaurants/13/meals --user admin3:admin`  

- Get meals history of restaurant  
`curl -s http://localhost:8080/admin/restaurants/11/meals/history --user admin1:admin`  
`curl -s http://localhost:8080/admin/restaurants/12/meals/history --user admin2:admin`  
`curl -s http://localhost:8080/admin/restaurants/13/meals/history --user admin3:admin`  

- Get meals that will be shown in future  
`curl -s http://localhost:8080/admin/restaurants/11/meals/future --user admin1:admin`  
`curl -s http://localhost:8080/admin/restaurants/12/meals/future --user admin2:admin`  
`curl -s http://localhost:8080/admin/restaurants/13/meals/future --user admin3:admin`  

- Get votes statistic of restaurant  
`curl -s http://localhost:8080/admin/restaurants/11/votes --user admin1:admin`  
`curl -s http://localhost:8080/admin/restaurants/12/votes --user admin2:admin`  
`curl -s http://localhost:8080/admin/restaurants/13/votes --user admin3:admin`  

- Create new restaurant  
`curl -s -X POST -d '{"name":"Italian pizza","address":"1st cental str, 10"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/admin/restaurants --user admin1:admin`  

- Get restaurant  
`curl -s http://localhost:8080/admin/restaurants/11 --user admin1:admin`  

- Delete restaurant  
`curl -s -X DELETE http://localhost:8080/admin/restaurants/12 --user admin2:admin`  

- Update restaurant  
`curl -s -X PUT -d '{"name":"Burger King","address":"1st cental str, 10"}' -H 'Content-Type: application/json' http://localhost:8080/admin/restaurants/13 --user admin3:admin`  

- Create new meal  
`curl -s -X POST -d '{"name":"Big Mexican Burger","price":199}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/admin/restaurants/11/meals --user admin1:admin`  

- Get meal  
`curl -s http://localhost:8080/admin/restaurants/11/meals/21 --user admin1:admin`  

- Delete meal  
`curl -s -X DELETE http://localhost:8080/admin/restaurants/12/meals/24 --user admin2:admin`  

- Update meal  
`curl -s -X PUT -d '{"name":"New Burger","price":199}' -H 'Content-Type: application/json' http://localhost:8080/admin/restaurants/13/meals/26 --user admin3:admin`  