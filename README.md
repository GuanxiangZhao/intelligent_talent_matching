# Intelligent Talent Matching

Intelligent Talent Matching is a Spring Boot backend project for a talent recruitment and job matching platform. The current codebase establishes the core database schema, Java domain model, MyBatis-Plus persistence layer, service layer boundaries, and REST controller package structure.

The project is currently a backend foundation rather than a complete production API. Most modules have generated entity, mapper, service, service implementation, controller, and XML mapping files. Candidate profile management has the most explicit service methods at this stage.

## Technology Stack

- Java 17
- Spring Boot 3.5.14
- Spring Web
- Spring JDBC
- Spring Security dependency included
- MyBatis Spring Boot Starter 3.0.5
- MyBatis-Plus 3.5.16
- MyBatis-Plus Generator 3.5.16
- Freemarker template engine for code generation
- MySQL
- Lombok
- Maven Wrapper
- JUnit 5 and Spring Boot Test

## Architecture Overview

The project follows a common layered backend architecture:

```text
Client / API Consumer
        |
        v
Controller Layer
        |
        v
Service Layer
        |
        v
Mapper / Persistence Layer
        |
        v
MySQL Database
```

### Layer Responsibilities

`controller`

Defines REST entry points for each business domain. Current controllers are mapped to module-level paths such as `/user`, `/candidate-profile`, `/job`, and `/job-application`. Most controllers are currently placeholders and should be extended with concrete HTTP methods.

`service`

Defines business service contracts. Services extend MyBatis-Plus `IService<T>` to inherit common CRUD capabilities. `CandidateProfileService` also defines explicit profile operations such as insert, update, delete, list, lookup by ID, and lookup by name.

`service.impl`

Contains service implementations. Implementations extend MyBatis-Plus `ServiceImpl<Mapper, Entity>` and call mapper methods for database operations.

`mapper`

Contains MyBatis-Plus mapper interfaces. Each mapper extends `BaseMapper<Entity>`, which provides standard CRUD operations without requiring manual SQL for simple use cases.

`resources/mapper`

Contains MyBatis XML mapping files. These files define result maps and base column lists generated from the database schema.

`entity`

Contains Java entity classes mapped to database tables. The project uses MyBatis-Plus annotations such as `@TableName`, `@TableId`, and `@TableField`, and Lombok annotations such as `@Getter`, `@Setter`, and `@ToString`.

`generator`

Contains `MybatisPlusGenerator`, a local code generation utility used to generate entity, mapper, service, service implementation, controller, and XML mapper files from MySQL tables.

## Project Structure

```text
.
|-- pom.xml
|-- mvnw
|-- mvnw.cmd
|-- sql/
|   `-- talent_system.sql
|-- src/
|   |-- main/
|   |   |-- java/com/example/intelligent_talent_matching/
|   |   |   |-- IntelligentTalentMatchingApplication.java
|   |   |   |-- controller/
|   |   |   |-- entity/
|   |   |   |-- generator/
|   |   |   |-- mapper/
|   |   |   |-- service/
|   |   |   `-- service/impl/
|   |   `-- resources/
|   |       |-- application.properties
|   |       `-- mapper/
|   `-- test/
|       `-- java/com/example/intelligent_talent_matching/
`-- target/
```

## Database Design

The database schema is stored in:

```text
sql/talent_system.sql
```

The configured database name is:

```text
intelligent_talent_matching_platform
```

Main tables:

| Table | Purpose |
| --- | --- |
| `user` | Stores platform user account, password, status, and login timestamps. |
| `candidate_profile` | Stores candidate personal profile information, including name, age, experience years, phone, email, location, major, and introduction. |
| `candidate_education` | Stores candidate education history. |
| `candidate_experience` | Stores candidate work experience history. |
| `skill` | Stores normalized skill records. |
| `candidate_skill` | Links candidate profiles to skills. |
| `employer_profile` | Intended for employer profile data. In the current SQL, this table has the same structure as `candidate_skill`, so it should be reviewed before production use. |
| `job` | Stores job postings, descriptions, requirements, salary range, headcount, and employer reference. |
| `job_application` | Stores candidate applications for jobs. |
| `job_skill` | Links jobs to required skills. |
| `file` | Stores uploaded file metadata such as owner, name, URL, and type. |

## Module Overview

### User Module

Package files:

- `User`
- `UserMapper`
- `UserService`
- `UserServiceImpl`
- `UserController`

This module represents platform users and login-related account data. Spring Security is included as a dependency, but no custom authentication flow is implemented yet.

### Candidate Profile Module

Package files:

- `CandidateProfile`
- `CandidateProfileMapper`
- `CandidateProfileService`
- `CandidateProfileServiceImpl`
- `CandidateProfileController`

This is the most developed module in the current codebase. The service layer supports:

- Insert candidate profile
- Update candidate profile
- Delete candidate profile
- Query all candidate profiles
- Query candidate profile by ID
- Query candidate profiles by name

### Candidate Education Module

Represents a candidate's education history, including school, major, start date, end date, and related candidate profile ID.

### Candidate Experience Module

Represents a candidate's work history, including company, job title, date range, and related candidate profile ID.

### Skill Module

Stores reusable skill definitions. Skills can be linked to both candidates and jobs through relation tables.

### Candidate Skill Module

Links candidate profiles to skills. This enables matching candidate capabilities against job requirements.

### Employer Profile Module

Intended to represent employer information. The current database definition appears to be copied from `candidate_skill`, so this module should be corrected before building employer-facing features.

### Job Module

Represents job postings, including employer ID, job name, description, requirements, salary range, headcount, and timestamps.

### Job Skill Module

Links jobs to required skills. This table is important for future matching logic.

### Job Application Module

Represents applications submitted by candidates to jobs. It stores candidate ID, employer ID, job ID, and timestamps.

### File Module

Stores file metadata. This can be used for resumes, attachments, certificates, or other uploaded candidate or employer files.

## How to Build the Project from 0 to 1

This section describes how to recreate and run the project from a clean environment.

### 1. Install Prerequisites

Install the following tools:

- JDK 17
- MySQL 8.x or compatible MySQL server
- Git
- An IDE such as IntelliJ IDEA

Maven does not need to be installed globally because the project includes Maven Wrapper scripts.

### 2. Clone the Project

```bash
git clone <repository-url>
cd intelligent_talent_matching
```

On Windows PowerShell:

```powershell
cd E:\idea_project\intelligent_talent_matching
```

### 3. Create the MySQL Database

Log in to MySQL:

```bash
mysql -u root -p
```

Create the database:

```sql
CREATE DATABASE intelligent_talent_matching_platform
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_0900_ai_ci;
```

Import the schema:

```bash
mysql -u root -p intelligent_talent_matching_platform < sql/talent_system.sql
```

### 4. Configure Database Connection

Edit:

```text
src/main/resources/application.properties
```

Current default configuration:

```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/intelligent_talent_matching_platform?serverTimezone=UTC&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=root

mybatis.mapper-locations=classpath:mapper/*.xml
```

Update `spring.datasource.username` and `spring.datasource.password` if your local MySQL credentials are different.

### 5. Build the Project

On Windows:

```powershell
.\mvnw.cmd clean package
```

On macOS or Linux:

```bash
./mvnw clean package
```

### 6. Run the Application

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

On macOS or Linux:

```bash
./mvnw spring-boot:run
```

By default, Spring Boot starts on:

```text
http://localhost:8080
```

### 7. Run Tests

On Windows:

```powershell
.\mvnw.cmd test
```

On macOS or Linux:

```bash
./mvnw test
```

The existing test class focuses on `CandidateProfileService`. These tests require a reachable MySQL database configured in `application.properties`.

## API Status

Controller route prefixes currently exist for the main modules, for example:

| Controller | Base Path |
| --- | --- |
| `UserController` | `/user` |
| `CandidateProfileController` | `/candidate-profile` |
| `CandidateEducationController` | `/candidate-education` |
| `CandidateExperienceController` | `/candidate-experience` |
| `CandidateSkillController` | `/candidate-skill` |
| `EmployerProfileController` | `/employer-profile` |
| `JobController` | `/job` |
| `JobApplicationController` | `/job-application` |
| `JobSkillController` | `/job-skill` |
| `SkillController` | `/skill` |
| `FileController` | `/file` |

Most controllers do not yet expose concrete `GET`, `POST`, `PUT`, or `DELETE` methods. The next development step is to add request DTOs, response DTOs, validation, and REST endpoints for each module.

## Code Generation Workflow

The project includes a MyBatis-Plus generator:

```text
src/main/java/com/example/intelligent_talent_matching/generator/MybatisPlusGenerator.java
```

The generator connects to the local MySQL database and generates:

- Entity classes
- Mapper interfaces
- Mapper XML files
- Service interfaces
- Service implementation classes
- REST controller classes

Before using the generator, verify:

- Database URL
- Username
- Password
- Package name
- Output directory
- Target table names

The generator asks for table names from the console. Multiple table names can be separated by commas.

## Development Notes

- The current code uses generated MyBatis-Plus CRUD foundations.
- The SQL schema does not define foreign key constraints, although several columns are intended as references.
- `candidate_profile.profile_localtion` appears to contain a spelling mistake in the database column name. The generated Java field is therefore `profileLocaltion`.
- `employer_profile` should be redesigned before employer profile features are implemented.
- Passwords are stored as plain text in the current schema. Production code should use secure password hashing.
- Spring Security is included, but custom security configuration is not implemented yet.
- API response models, request validation, exception handling, and pagination are not yet implemented.

## Recommended Next Steps

1. Fix the `employer_profile` table structure.
2. Add foreign keys or enforce relationships in service logic.
3. Add REST CRUD endpoints for each controller.
4. Add DTO classes for request and response models.
5. Add validation with Jakarta Bean Validation.
6. Add global exception handling.
7. Implement authentication and password hashing.
8. Add matching logic based on candidate skills, job skills, experience years, location, and salary expectations.
9. Add integration tests using a test database or Testcontainers.

## License

No license has been specified yet.
