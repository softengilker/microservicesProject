### Content

The repository has intent to be included some microservice applications and integrations between them. The application is about tracking a person's daily calorie intakes, food and drink calorie charts. The microservices architecture design is illustrated below.

Microservice | Language      | Frameworks   | Data Persistence Layer	| Description
------------ | ------------- | -------------| ------------------------- | ---------------------
UserManagement|Java8|Spring 4.3, Spring Data, Spring Boot 1.5.6|MongoDB|Management and storing the users, user authentication and autherization to verify the identity and access controls to the modules/components in the other microservices.
CalorieManagement|Javascript|Node Js, Express|Redis|Management and storing food and drink calori values.

**Not:** More services are willing to be added to the table once some initial submits are pushed to the repository.
