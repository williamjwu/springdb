# Springdb
A student class system made with Spring Cloud

# Install
Import all project as maven. entity-module needs to be compiled and installed by maven to be used by the two microservices.

# Ports
http://localhost:9090/ is the landing page, all external requests should go through there.
Student Server: http://localhost:9082/ (internal) | http://localhost:9090/student
School Server: http://localhost:9081/ (internal) | http://localhost:9090/school/
Config Server: http://localhost:9085/
