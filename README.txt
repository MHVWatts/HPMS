============================
Team //Insert Team Name Here
============================
Mason White
Grayson Blanchard
Malcolm Watts
Collin Moran
Seven Herd


=====================
FILES IN THIS PROJECT
=====================
//HPMS FOLDER//
HPMS.class : Main Application
HPMS.java : Main Application 
HPMS_Billing.jar : Billing Jar File
HPMS_Portal.jar : Portal Jar File
json-20190722.jar : External JSON library
UML_Diagram.io : UML Diagram for the application

//TESTING FOLDER//
HPMS.class
HPMS.java
HPMS_Billing.class
HPMS_Billing.java
HPMS_Billing_Test.class : Billing Unit Tests
HPMS_Billing_TestRunner.class : Billing Unit Test Runner
HPMS_Portal.class
HPMS_Portal.java
HPMS_Portal_Test.class : Portal Unit Tests
HPMS_Portal_TestRunner.class : Portal Unit Test Runner
HPMS_Test.class : HPMS Unit Tests
HPMS_TestRunner.class : HPMS Unit Test Runner
java-json.jar : External JSON library
json-20190722.jar : External JSON library
junit-4.10.jar : External junit library
JUnit.jar : External junit library


//TESTING JAVA FILES FOLDER//
(TEST AND TEST RUNNERS AS JAVA FILES)
HPMS_Billing_Test.java : Billing Unit Test Runner
HPMS_Billing_TestRunner.java : Billing Unit Test Runner
HPMS_Portal_Test.java : Portal Unit Test Runner
HPMS_Portal_TestRunner.java : Portal Unit Test Runner
HPMS_Test.java : HPMS Unit Tests
HPMS_TestRunner.java : HPMS Unit Test Runner


==============================
INSTRUCTIONS FOR RUNNING FILES
==============================

//THE HPMS APPLICATION//
Change directory to HPMS folder
java HPMS (your arguments here)

arguments:
--billing
--patient-portal
--customer-id (ID# Here)

ID #s:
100003
100025

//TESTING//
Change directory to TESTING folder

FOR TESTING BILLING
java -cp .:/path/to/the/files/HPMS/TESTING/java-json.jar:junit-4.10.jar:json-20190722.jar HPMS_Billing_TestRunner

FOR TESTING PORTAL
java -cp .:/path/to/the/files/HPMS/TESTING/java-json.jar:junit-4.10.jar:json-20190722.jar HPMS_Portal_TestRunner

FOR TESTING HPMS
java -cp .:/path/to/the/files/HPMS/TESTING/JUnit.jar:junit-4.10.jar HPMS_TestRunner


