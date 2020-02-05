# Implementation notes
## Maven plugins problem   
The source and javadoc plugins run fine standalone - i.e., when executed like
 this:
 
 `mvn source:jar`
 
 But they don't run as part of a full build:
 
 `mvn clean install`
