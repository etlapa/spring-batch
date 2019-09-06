# Spring Batch Application
Project name: spring-batch

## What it's in this commit:
- Previously the Batch Job was correctly configured.
- SpringBoot version was updated to 2.1.1
- Restful service is created to execute the Job (instead of a scheduler)
- *JobResource* creates the endpoint */job/FILE_NAME* for the **Job** (Hello World Tasklet)
- To execute the **Job**, call: *localhost:8080/job/FILE_NAME*
- An additional endpoint is added to manage H2: *localhost:8080/console*
- *WebConfiguration* initializes the **Servlet Context**