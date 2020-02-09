## GRADUATION PROJECT

This is a graduation app of the [TOPJAVA](https://topjava.ru/) course I highly recommend you:)

[Click here to see a task and description](https://github.com/JavaOPs/topjava/blob/master/graduation.md)

There are used: 
* Java 11, Gradle, IntelliJ IDEA
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

#### Abilities of restaurants owner:
- Get own restaurants for edit  
`curl -s http://localhost:8080/my/restaurants --user 'owner1':'owner'`  
`curl -s http://localhost:8080/my/restaurants --user 'owner2':'owner'`  
`curl -s http://localhost:8080/my/restaurants --user 'owner3':'owner'`  

- Get today's meals for editing  
`curl -s http://localhost:8080/my/restaurants/11/meals --user 'owner1':'owner'`  
`curl -s http://localhost:8080/my/restaurants/12/meals --user 'owner2':'owner'`  
`curl -s http://localhost:8080/my/restaurants/13/meals --user 'owner3':'owner'`  

- Get meals history of restaurant  
`curl -s http://localhost:8080/my/restaurants/11/meals/history --user 'owner1':'owner'`  
`curl -s http://localhost:8080/my/restaurants/12/meals/history --user 'owner2':'owner'`  
`curl -s http://localhost:8080/my/restaurants/13/meals/history --user 'owner3':'owner'`  

- Get meals that will be shown in future  
`curl -s http://localhost:8080/my/restaurants/11/meals/future --user 'owner1':'owner'`  
`curl -s http://localhost:8080/my/restaurants/12/meals/future --user 'owner2':'owner'`  
`curl -s http://localhost:8080/my/restaurants/13/meals/future --user 'owner3':'owner'`  

- Get votes statistic of restaurant  
`curl -s http://localhost:8080/my/restaurants/11/votes --user 'owner1':'owner'`  
`curl -s http://localhost:8080/my/restaurants/12/votes --user 'owner2':'owner'`  
`curl -s http://localhost:8080/my/restaurants/13/votes --user 'owner3':'owner'`  

- Create new restaurant  
`curl -s -X POST -d '{"name":"Italian pizza","address":"1st cental str, 10"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/my/restaurants --user 'owner1':'owner'`  

- Get restaurant  
`curl -s http://localhost:8080/my/restaurants/11 --user 'owner1':'owner'`  

- Delete restaurant  
`curl -s -X DELETE http://localhost:8080/my/restaurants/12 --user 'owner2':'owner'`  

- Update restaurant  
`curl -s -X PUT -d '{"name":"Burger King","address":"1st cental str, 10"}' -H 'Content-Type: application/json' http://localhost:8080/my/restaurants/13 --user 'owner3':'owner'`  

- Create new meal  
`curl -s -X POST -d '{"name":"Big Mexican Burger","price":199}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/my/restaurants/11/meals --user 'owner1':'owner'`  

- Get meal  
`curl -s http://localhost:8080/my/restaurants/11/meals/21 --user 'owner1':'owner'`  

- Delete meal  
`curl -s -X DELETE http://localhost:8080/my/restaurants/12/meals/24 --user 'owner2':'owner'`  

- Update meal  
`curl -s -X PUT -d '{"name":"New Burger","price":199}' -H 'Content-Type: application/json' http://localhost:8080/my/restaurants/13/meals/26 --user 'owner3':'owner'`  