# Personal Loan Management System

A Spring Boot-based application for managing personal loan applications, eligibility checks, loan approvals, EMI calculation, and repayment tracking.

## Features
- Loan application management
- Configurable loan eligibility criteria
- Loan approval and rejection
- EMI calculation
- Automatic repayment schedule generation
- Repayment tracking
- Outstanding balance calculation

## Technology Stack
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman

## Eligibility Criteria
- Minimum annual income: ₹3,00,000
- Minimum loan amount: ₹50,000
- Maximum loan amount: ₹10,00,000
- Minimum tenure: 1 month
- Maximum tenure: 60 months
- Loan amount must not exceed five times the annual income

## Setup Instructions
1. Clone this repository.
2. Open the project in IntelliJ IDEA.
3. Configure your MySQL database.
4. Update the database connection settings in `application.properties`.
5. Run the Spring Boot application.
6. Test the REST APIs using Postman.

## Assumptions
- Income is considered annual income.
- Eligibility does not guarantee loan approval.
- Only approved applications receive repayment schedules.
- Interest rate is provided during the approval process.

## Project Type
Academic Mini Project
