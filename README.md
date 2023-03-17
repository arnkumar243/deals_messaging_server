# Messaging Server for Deals Application

Provides an API to create, delete subscribers & publish a deals. On publish of deals it queries for all subscribers and sends them email about the deals.

## Tech

Deals Messaging server is developed upon the following projects:
- [Spring Boot] - To develop and deploy rest endpoints
- [MySql] - To persist user and deals information

## Building Project

For building the package
```sh
mvn clean package
```
After building the jar will be available under target folder.