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

- [Step 1: Setup `Dockerfile`, `docker-compose.yml`, & `buildspec.yml` in source code]()
- [Step 2: Setup Deployment Environment in Elastic Beanstalk]()
- [Step 3: Connect GitHub to CodePipeline]()
- [Step 4: Setup CodeBuild Project]()
- [Step 5: Commit, Build, Deploy!]()

<br>

<img src="imgs/flow.png">