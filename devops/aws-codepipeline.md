# Set up an AWS CodePipeline for CI/CD
This document wil guide you through setting up a DevOps pipeline using AWS CodePipeline and deploying it onto AWS Elastic Beanstalk running an AWS managed Docker platform, deploying the app into a Docker container.

<br>

### Tech Stack
- Spring Boot App with JDK 8
- GitHub (CI) with SonarCloud
- Docker
- AWS CodeBuild
- AWS CodeDeploy -> AWS Elastic Beanstalk


<br>

## Outline:

- [Step 1: Setup `Dockerfile`, `docker-compose.yml`, & `buildspec.yml` in source code](#step1)

- [Step 2: Setup Deployment Environment in Elastic Beanstalk](#step-2)
- [Step 3: Connect GitHub to CodePipeline](#step-3)
- [Step 4: Setup CodeBuild Project](#step-4)
- [Step 5: Commit, Build, Deploy!](#step-5)

<br>

<img src="imgs/flow.png">

<br>

## Step 1: Setup `Dockerfile`, `docker-compose.yml`, & `buildspec.yml` <a name="step1"></a>


