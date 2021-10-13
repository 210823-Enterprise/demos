# Microservices

* Compare the microservice and monolithic architectures. What are the advantages / disadvantages of each?

  * Monolith - all code deployed together in single, large application
    * Harder to scale, single point of failure
    * Easier to deploy
    * Code can get messy, complex, tightly coupled
 
 * Microservices - application composed of independently deployed services
    * Services governed by single responsibility principle
    * Enforces loose coupling of application
    * Complex to deploy and manage relative to monolith
    * Easier to scale
    * Teams can work independently on different services

* How do you solve the different problems inherent to microservices?
  * Use container orchestration tools for deployment
  * Use service discovery and API gateway

* What's the difference between a MSA and a SOA?
  * MSA (microservice architecture) is an extension of SOA to services within an application

* Can a Java microservice communicate with a Node.js microservice? Why or why not?
  * Yes, this is polyglot pattern and a benefit of microservices
  * Services communicate through requests sent to APIs, typically use JSON or XML data formats (language agnostic)

* What's the difference between horizontal and vertical scalability? Which way do monoliths and microservices typically scale?
  * Vertically scale - upgrade single server CPU, memory, storage, etc
  * Horizontal scale - replicate service on another server
  * Monoliths - typically vertically scale; harder / costly to scale horizontal
  * Microservices - typically scale horizontal; easier with smaller services

* What are some best practices for building microservices?
  * Keep services independent and minimize dependencies where possible
  * Have each service manage its own data store / database; other services access the data through its API
  * Use distributed logging, tracing, and monitoring tools
  * Implement circuit breaking pattern for fault tolerance
  * Containerize each service for rapid deployment and scaling of infrastructure

* How large should each service in a microservice be?
  * Follow single responsibility principle

* Explain strong vs eventual consistency and which one applies to microservices?
  * Eventual consistency applies - data may be inconsistent between services for a while until messages get resolved

* What is a messaging queue and how is using one different from calling service APIs directly?
  * Messaging queues store messages that other services consume
  * Prevents messages / data from being lost in network outage or service disruption
  * Keeps services loosely coupled; not dependent on other service API

* What is a "replica"?
  * A copy of a service; e.g. one service may be replicated n times across servers when horizontal scaling required

* What is the circuit breaker pattern? What are the different circuit states?
  * Monitor status of services, if one is unavailable, provide a fallback implementation
  * Prevent cascading failure in the system if other services depend on unavailable service
  * Circuit state changes from "closed" to "open" (breaker triggered) when number of unsuccessful requests exceed a threshold

## Netflix Stack
* Explain the Netflix OSS stack for microservices (Eureka, Zuul, Hystrix)

* How would you setup and configure Eureka? Zuul? Hystrix?

* What is the purpose of an API gateway and how does Zuul perform this?

* What is service discovery and how does Eureka do this?

* Is there any order in which you need to spin up these services?

* One of my microservices is throwing a TransportException! What might be the problem?
