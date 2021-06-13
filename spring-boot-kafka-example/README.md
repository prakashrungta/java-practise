# java-practise
 A new repo for java practise
 
# For Spotless check and apply
 mvn spotless:check
 mvn spotless:apply

#For Compiling and creating the pushing the build to the docker repository prungat82.
#Ensure that the .m2/settings.xml has the follwoing
	<server>
		<id>registry.hub.docker.com</id>
		<username>prungta82</username>
		<password>PASSWORD</password>
	</server>
 
 mvn compile jib:build
 
#For running the Docker Images Locally
docker run -d --name secureapp1 -p 8091:8091 prungta82/spring-boot-kafka-example

#For various Rest Requests are as below
 GET  -->	https://localhost:8091/users/all
 GET  -->	https://localhost:8091/users/{prakash}
 POST -->	https://localhost:8091/users/load  	{ "name": "prakash", "department": "CC-DEV", "salary":10000 }
 
#Endpoints for Kafka 
 GET  ->   https://localhost:8091/kafka/publish/{message}
 POST -->  https://localhost:8091/kafka/publish/message {"id" : 123 , "name": "prakash", "department": "CC-DEV", "salary":10000 }
 POST -->  https://localhost:8091/kafka/publish/messagewithresponse    	{ "id" : 123 , "name": "prakash", "department": "CC-DEV", "salary":10000 }  
   //This should return BANDWIDTH_LIMIT_EXCEEDED 
