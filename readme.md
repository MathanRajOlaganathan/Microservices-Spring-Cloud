# Microservices

Microservices concepts using Spring Cloud.

>In short, the microservice architectural style is an approach to developing a single application
as a suite of small services, each
running in its own process and communicating with lightweight mechanisms,
often an HTTP resource API.

### Principles of Microservices
1. _Single Responsibility_ - At no point in time, one microservice should have more than one responsibility.
2. _Built around business capabilities_ - Microservices should focus on certain business functions and ensure that it helps in getting things done
no tech barrier
3. _You build it, you own it!_
4. _Infrastructure Automation_ - . A service shall be independently deployable
One of the major differences between microservices and SOA is in their level of autonomy. While most SOA implementations provide service-level abstraction,
microservices go further and abstract the realization and execution environment.
5. _Design for Failure_ - A microservice shall be designed with failure cases in mind..
his philosophy advocates systems that expect failures versus building systems that never fail
Microservice applications put a lot of emphasis on real-time monitoring of the application


#### Monolithic Architecture

###### Strength
1. Less cross-cutting concerns.
2. Easier debugging and testing
3. Simple to deploy.

###### Weakness
1. Understanding - when it scales up, becomes hard to understand
2. Making changes - tightly coupled, so making changes will be diff
3. Scalability - You cannot scale components independently, only the whole application.
4. New technology barriers - because the entire app has to be rewritten

#### Microservices

###### Strength
1. Independent components
2. Easier understanding
3. Better scalability.
4. Flexibility in choosing the technology.
5. The higher level of agility. - if any fault, only that will be affected.

###### Weakness
1. Extra complexity - distriute, so sep db connecitons, deployment invid
2. System distribution
3. Cross-cutting concerns
4. Testing

###### How to Choose between Micro vs Mono
* small team, startup, quick start - monoli
* complex and scalable app - microservices

###### Challenges of Microservices Architecture
1. _Bounded Context_ - the service owns its data and is responsible for its integrity and mutability. It supports the most important feature of microservices, which is independence and decoupling
2. _Dynamic Scale up and Scale Down_ - auto-scaling up your microservice should auto-scale down, reduces the cost of the microservices.
3. _Monitoring_ - Trad Monitoring will not be effective, When an error arises in the application, finding the root cause can be challenging.
4. _Fault Tolerance_ - Fault tolerance is the individual service that does not bring down the overall system
5. _Cyclic dependencies_ - can create a problem, if not identified and resolved promptly.
6. _DevOps Culture_ - fits perfectly into the DevOps.

* As we add more microservices, we have to be sure they can scale together. More granularity means more moving parts, which increase complexity.
* The traditional logging is ineffective because microservices are stateless, distributed, and independent. The logging must be able to correlate events across several platforms.
* When more services interact with each other, the possibility of failure also increases.

**SOA Vs MSA**

![SOA Vs MSA](https://miro.medium.com/max/2400/1*8-uN932TKtSjNwLw3XuoJQ.png)

**Mono Vs SOA Vs MSA**
![Mono Vs SOA Vs MSA](https://www.velvetech.com/wp-content/uploads/2019/08/software-architecture.png)

##### Components of Microservices
* Spring Cloud Config Server -  provides the HTTP resource-based API for external configuration in the distributed system,
  can be enabled using @EnableConfigServer.
* Netflix Eureka Naming Server - is a discovery server.It provides the REST interface to the outside for communicating with it.
  Eureka client interacts with the Eureka server for service discovery.
* Hystrix Server -  fault-tolerance robust system using Circuit Breaker mechanism. If there is an error encountered in the application, the Hystrix Server opens the circuit.
  The Hystrix server stops the further request to calling service
* Netflix ZuulAPI Gateway Server - is a gateway server from where all the client request has passed through, also has
  inbuilt load balancer to load the balance of all incoming request from the client.
* Netflix Ribbon - is the client-side Inter-Process Communication (IPC) library. It provides the client-side balancing algorithm. It uses a Round Robin Load Balancing:
* Zipkin Distributed Tracing Serve - is a Java-based application that is used for distributed tracing and identifying latency issues.


##### Spring Cloud
>  is a framework for building robust cloud applications. The framework facilitates the development of applications by providing solutions to many of the common problems faced when moving to a distributed environment.

###### Netflix Eureka
> It is a service Registry or we can say it is an embedded server provided by Netflix third party which integrate with spring framework.
  
*  Micro service Registration and Discovery with Spring Cloud and Netflix's Eureka.

##### Micorservice Service Registration and discovery
_**Two key parts of service discover in Microservice**_:
 1. _Service Registration_ - The process of a service registering its location to central registry.
                              Usually, It register its host and port and may also authentication and environment details.
 2. _Service Discovery_ - The process of a client get information from central registry to know about the location of services

* Service discovery is how applications and (micro)services locate each other on a network
* Spring CLoud uses client side discovery

1. _Client Side Service Discovery_ - In systems that use client-side service discovery, clients query the service registry, select an available instance, and make a request.
2. _Server Side Service Discovery_ - In systems that use server-side discovery, clients make requests via a router, which queries the service registry and forwards the request to an available instance.
                                  
We will create a demo app to demonstrate this,

1. _discovery-server_ - Discovery Server using Eureak Server to register the services

2. _@EnableEurekaServer_ -  annotation is used to make your Spring Boot application acts as a Eureka Server.
 Make sure Spring cloud Eureka server dependency is added in your build configuration file. By default, the Eureka Server registers itself into the discovery.  
 
3. By default it runs on 8761. And to disable itself from registering, set the following props,
    eureka:
      client:
        register-with-eureka: false
        fetch-registry: false

4. _gaming-server_ - Rest application to give the list of gaming products using spring boot.

5. _@EnableEurekaClient_ - makes the app into both a Eureka "instance" (i.e. it registers itself) and a "client" (i.e. it can query the registry to locate other services
we can also use **@EnableDiscoveryClient** - can work with any Discovery Client implementations which implements in your project ( Eureka, Consul, Zookeeper )