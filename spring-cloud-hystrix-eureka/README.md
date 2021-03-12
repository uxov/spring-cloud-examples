# Spring Cloud Eureka With Hystrix

![img_3.png](img/img_3.png)  
  
1. Start `eureka-server`  
2. Start `order-service` and `user-service`(port:8081)  
3. Test request : from  `user-service` to  `order-service` : http://localhost:8081/user/getOrderList     
request successful:  
![img_1.png](img/img_1.png)  
stop the `order-service`,it goes down(not available) and request failed:  
![img_2.png](img/img_2.png)
