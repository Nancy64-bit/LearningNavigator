## Learning Navigator - Exam Enrollment API

This project implements a RESTful API service using Spring Boot for managing the exam enrollment process in a Learning Management System (LMS). It uses MySQL for persistent data storage.

**Features:**

* CRUD operations for Students, Subjects, and Exams.
* Foreign key relationships between entities.
* Validation for student enrollment in a subject before exam registration.
* Global error handling with appropriate HTTP status codes.
* Basic unit tests using MockMvc and Mockito.

**Technologies:**

* Spring Boot
* Spring Data JPA
* MySQL
* JUnit
* Mockito

**Getting Started:**

1. Clone this repository.
2. Install the required dependencies (Maven or Gradle).
3. Configure your MySQL connection details in `application.properties`.
4. Run the application using `mvn spring-boot:run` (Maven) or similar command (Gradle).

**Run in postman**

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/30359334-740dca64-7c0c-4e16-bba2-ffc6c3bb4abc?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D30359334-740dca64-7c0c-4e16-bba2-ffc6c3bb4abc%26entityType%3Dcollection%26workspaceId%3D5ce135f8-2a72-4136-886b-2b6dff060ef7)

Feel free to fork this project and contribute by adding new features or improving existing functionalities.


