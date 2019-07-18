# Springdb
A student class system made with Spring Cloud

# Install
Import all project as maven and install mysql. entity-module needs to be compiled and installed by maven to be used by the two microservices. Run table.sql to make all tables. Database name is springdb.

# Ports
http://localhost:9090/ is the landing page, all external requests should go through there.
Student Server: http://localhost:9082/ | http://localhost:9090/student
School Server: http://localhost:9081/ | http://localhost:9090/school/teacher/ or http://localhost:9090/school/subject/
Config Server: http://localhost:9085/
