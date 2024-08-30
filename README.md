# Project Demonstration: Comparing Trivy and Quay.io for Detecting CVE-2020-10683

## Project Purpose

This project was created to demonstrate the difference between the vulnerability scanning tools Trivy and Quay.io in detecting CVE-2020-10683, a known vulnerability in the `dom4j` library version `1.6.1`. Specifically, the project shows that Trivy is able to detect this vulnerability while Quay.io does not.

## Project Structure

- **`src/`**: Contains the source code of the Java web application.
- **`Dockerfile`**: The Dockerfile to build the container image.
- **`pom.xml`**: The Maven file that manages dependencies, including `dom4j` version `1.6.1`.
- **`README.md`**: This file, which explains the purpose and usage of the project.

## Prerequisites

- **Podman**: An alternative to Docker for managing containers.
- **Trivy**: A vulnerability scanning tool for containers.
- **Quay.io**: A container registry with vulnerability scanning capabilities.

## Demonstration Steps

### 1. Clone the Repository

Clone the repository to your local environment:

```bash
git clone https://github.com/abozzoni/my-tomcat-app.git
cd my-tomcat-app
```

### 2. Build the Project
Build the project using Maven to generate the WAR file:
```bash
mvn clean package
```
### 3. Build the Docker Image
Build the Docker image using Podman:

```bash
podman build -t my-tomcat-app .
```
### 4. Push the Image to Quay.io
Authenticate with Quay.io and push the image to your Quay.io repository:

```bash
podman login quay.io
podman tag my-tomcat-app quay.io/<your-quay-username>/my-tomcat-app:latest
podman push quay.io/<your-quay-username>/my-tomcat-app:latest
```
### 5. Scan the Image on Quay.io
After pushing the image to Quay.io, Quay.io will automatically run a security scan. You can check the results by visiting your repository on Quay.io. You'll notice that Quay.io does not detect CVE-2020-10683.

### 6. Scan the Image with Trivy
Use Trivy to scan the image and detect CVE-2020-10683:

```bash
trivy image quay.io/<your-quay-username>/my-tomcat-app:latest
Trivy should detect CVE-2020-10683, highlighting the difference compared to Quay.io.
```

### Conclusion
This project demonstrates that Trivy can detect CVE-2020-10683 in the dom4j library version 1.6.1, while Quay.io seems does not.
