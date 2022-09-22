For the development of the back-end, it was used spring boot (Model, DAO, Service, Controller), with database connection Postgres
For the development of the front-end, it was used Angular + boostrap

====================================================================================

Load back-end service and database in Docker


*** Postgres Container ***
Open a new command window, and run the command given below.
	docker pull postgres
To obtain the list of existing Docker Images, run the following command.
	docker images
In the next step, you can enter the command you copied from the Docker Hub in the Command Prompt.
	docker run --name postgres_container -e POSTGRES_PASSWORD=Abc123 -d postgres
The above-given command should be customized and added with the necessary parameters to work properly for setting up PostgreSQL on Docker.
	docker run --name postgresql -e POSTGRES_USER=myusername -e POSTGRES_PASSWORD=mypassword -p 5432:5432 -v /data:/var/lib/postgresql/data -d postgres
	
	docker exec -it postgres_container postgres -upostgres -p
	docker network connect my-net postgres
 

Use PgAdmin to create the database, connecting to the created postgres container
 
 
 *** Docker change net ***
docker network create --driver bridge pos-net
docker network ls
docker network inspect pos-net

docker network disconnect bridge postgres_container
docker network connect pos-net postgres_container

Change the datasource of the application properties file to:

spring.datasource.url=jdbc:jdbc:postgresql://postgres_container/pos?useSSL=false

==================================================================
built proyect with Maven
Open console of the project directory

> mvn clean package

With this you will create the jar

===================================================================
*** Build DockerFile Api REST ***
pos_service=nobre jar de compilación

docker build -t pos_service:V1 .

ImageID = id de pos_service

docker run --network pos-net -d -p 19090:9090 --name pos_container ImageID

docker logs -f pos_container

====================================================================================


You can also upload project (jar including Target folder) to a Tomcat server

=====================================================================================

We must upload the application to our real server on the Internet, for this we must execute the following Angular CLI command:
project directory> ng build 


After this process, a folder called 'dist' is generated that contains all the files that we must upload to our server

