# Spring Batch Application
Project name: spring-batch

## What it's in this commit:
- Previously was creating everything to support a Job.
- A configuration class (*BatchJobConfiguration*) has been created to define a **Job** with a single **Step**. This **Step** returns a **Tasklet**.
- A simple unit test has been created to validate that if the **Job** exists in the batch context.
- Some extra beans were added (mx.edev.springbatch.domain) to create an **Job** with a reader/processor/writer in the future.
- Hibernate dependencies were added in the pom file to support the Entity class (PatientEntity)
- Until this point, the Batch Job is correctly configured.