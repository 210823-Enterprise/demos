# How to Deploy this RESTful API within a Docker Container on an EC2

1. Launch a free-tier EC2 instance on AWS.
  - Make sure that within the security groups you include a Custom TCP protocol for port `8090` accepting requests from anywhere.
    - *This is because the Spring Boot application is running on an embedded Tomcat server on port 8090 as specified in the `application.properties` file.*

2. On your Instance Dashboard click `Connect` > SSH in with the EC2 Instance connect browser based SSH platform.

3. Run the following commands to set up the Linux environment, build the Docker image, and run the container:

<br>

```sh
sudo yum install maven -y

sudo yum install git -y

git clone <your-repo>

cd <your-repo>

# This will allow you to utilize the Maven Wrapper
mvn -N io.takari:maven:wrapper

# This will utilize the Maven Wrapper to generate the deployable JAR file inside your root project directory
sudo ./mvnw clean package

# start the Docker service in the background before you build the image
sudo service docker start

# Build an image from the Dockerfile within the root directory of your project
sudo docker build -t my-image:latest .

# Run the Container from the image on port 8090
sudo docker run -p 8090:8090 my-image
```

<br>

Your app is now running within a Docker container exposed on port 8090 of your EC2 instance.

4. Copy the public IPv4 address from the EC2 instance dashboard.

5. Paste it in your browser or postman to test the api, eg: `http://32.442.182:8090/api/actuator/health` or send a `GET` request to `http://32.442.182:8090/api/users` in postman.  
