# utilities

This is a file utility web application which is responsible to read a **.txt** file and take all json records from it. It will find all events from file which took more than 4 ms to process, and will store them into HSQL in-memory DB.
This is a spring-boot web application which will be running on port 9095 and it will required

System requirements:
Java: version 8 or above
maven

This project can be run from command line using below command:
**mvn spring-boot:run -Dspring-boot.run.arguments="src/sampleLogs.txt"**

**sampleLogs.txt**__ is available on src path for testing purpose

Here file and it's path can be modified to process different files.
once we ran application for any file, we can find details for all file-events which took more than 4 msec to proceesed using below API from postman/any other client tool.

**http://localhost:9095/logsManagement/logs**
