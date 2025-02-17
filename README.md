# RabbitMQ Pub Sub with Routing Key Example

- Spring Boot
  - Spring Web
  - Cloud Stream
  - Spring for RabbitMQ
- Docker
- RabbitMQ

## Getting started

- Docker compose up
- Run each microservice
- Login at http://localhost:15672/ with `guest` username and password
- Make HTTP Pix Request
```
http post :8080 channel=pf from=bruno to=joao value=20.2
```