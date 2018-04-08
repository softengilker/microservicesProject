### Content

The repository has intent to be included some microservice applications and integrations between them. The application is about tracing a person's daily calorie gettings, food and drink calorie values. The microservice architecture plan is like below.

Microservice | Language      | Frameworks   | Data Persistence Layer	| Description
------------ | ------------- | -------------| ------------------------- | ---------------------
UserManagement|Java8|Spring 4.3, Spring Data, Spring Boot 1.5.6|MongoDB|Management and storing the users, user authentication and autherization to verify the identity and access controls to the modules/components in the other microservices.
CalorieManagement|Javascript|Node Js, Express|Redis|Management and storing food and drink calori values.

**Not:** More services is willing to be added once some drafts are pushed.