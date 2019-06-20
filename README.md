# Spring Batch Application
Project name: spring-batch

## What it's in this commit:
- Setting up the class *BatchConfiguration*. In this class is enabling the batch processing (@EnableBatchProcessing) and creating the beans for **JobRepository**, **JobExplorer** and **JobLauncher** through ***BatchConfigurer***.
- The** TransactionManager**, **JpaRepositories** and **data source** are declared at *DatabaseConfiguration* . **Liquibase** is also setup here. 
- *ApplicationProperties* is matching some properties from the yaml file
- *DefaultProfileUtil* is used to setup a default profile while starting up the SpringBoot App
- No errors were found when executed, but it's doing nothing yet