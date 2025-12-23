# water-billing-system

This is a simple web application that allows an administrator to generate and view water bills based on meter readings. It is built using Java, JSP, Servlets (MVC pattern), and MySQL, and runs on Apache Tomcat.



Features:

Generate water bills by entering:
Consumer number
Month and year
Start reading and current reading
Connection type (Domestic / Industrial)






Automatic calculation of:

Total consumption
Fixed charges
Variable charges using slab‑wise rates for Domestic and Industrial connections
Total payable amount
View existing bills by consumer number, month, and year






Proper validation:

All mandatory inputs required
Current reading must be ≥ start reading
Only valid connection types allowed
Prevents duplicate bills for the same consumer/month/year






Clear UI with:

Menu page
Generate Bill form
View Bill form
Bill details display page
Success and error pages






Tech Stack:

Java (Servlets, JSP)
MySQL (JDBC)
Apache Tomcat 9
Eclipse (Dynamic Web Project)






Architecture:

The project follows a layered architecture:

util – database utility and custom exception
bean – WaterBillBean to hold bill data
dao – WaterBillDAO for all JDBC operations
service – Administrator for validation and business logic (slab calculations)
servlets – MainServlet as the controller handling Generate/View operations
JSP/HTML pages for the views



This project was developed as an academic assignment to practice full‑stack Java web development, JDBC, and basic MVC design.

