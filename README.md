# Water Billing System

The Water Billing System is a Java-based web application designed to generate, manage, and view water bills based on consumer meter readings.
The application follows the Model–View–Controller (MVC) architecture and is developed using Java Servlets, JSP, MySQL, and Apache Tomcat.

This project was created as an academic exercise to gain practical experience in full-stack Java web development, database connectivity (JDBC), and structured application design.


# Key Features

## Bill Generation
- Input consumer number, billing month, and year
- Enter start and current meter readings
- Select connection type (Domestic or Industrial)

## Automatic Bill Calculation
- Total water consumption calculation
- Fixed charge computation
- Slab-based variable charge calculation for different connection types
- Final total payable amount generation

## Bill Retrieval
- Search and view existing bills using:
- Consumer number
- Month
- Year

## Data Validation
- Mandatory field validation
- Current reading must not be less than start reading
- Validation of connection type inputs
- Prevention of duplicate bills for the same consumer and billing period

## User Interface
- Menu dashboard
- Bill generation form
- Bill viewing form
- Detailed bill display page
- Success and error notification pages


# Technology Stack

## Backend:
- Java Servlets
- JavaServer Pages (JSP)

## Database:
- MySQL with JDBC connectivity

## Server:
- Apache Tomcat 10

# Project Architecture

## The application follows a layered MVC structure:
- util – Database utility classes and custom exception handling
- bean – Data model (WaterBillBean) representing bill details
- dao – Database interaction layer (WaterBillDAO) using JDBC
- service – Business logic, validation, and slab-based charge calculation
- servlets – Controller (MainServlet) handling request flow
- views – JSP/HTML pages providing the user interface


# Learning Objectives

## This project helped develop practical skills in:
- Java web application development
- JDBC database connectivity
- MVC architecture implementation
- Input validation and business logic handling
- Basic UI design with JSP and HTML
