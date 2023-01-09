# Employment Application Review System 

*This is a team project that I worked on in my software engineering
class - COSC 3506.* 

## Authors

- Atul K 
- Jenny S
- Rohan B
- Saumya B

## Objective

To use the waterfall methodology framework to develop a software 
product that allows University faculty members to collaborate and review applicants
and select the best candidate for the job opening.

## Purpose

The main purpose for creating this software product is to help reduce
overhead costs incurred by the University and to assist hiring 
faculty members by reducing their workload during the applicant-searching 
process. 

## My Role

In this project, I was responsible for the front-end development
of the login screen, the review applications page and the applicant
page. 

## Overview

### Product Scope 

The overall scope of the product is to enable the faculty members to:
1. Log-in to the EARS system
2. Manage system users (add new accounts)
3. Add a new faculty search (committee chair, committee members,
 job position, search starting date and ending date, 
 status of application)
4. List and review applications (view profile, 
post comments on applicants, change applicants’ status, 
perform a faculty review, assign faculty review)
5. Update account settings (email, name, title, password)


### Product Overview 

Below is a diagram that gives an overview of the system design:

![System Overview](https://user-images.githubusercontent.com/121978043/211221435-7fb7b61e-2521-4409-a39c-f7983aec8775.PNG)

## Demo

## Project Walkthrough

### Login Screen 

The login screen is the start screen of the application which allows
users to enter the system by entering valid credentials. 

![Login Screen](https://user-images.githubusercontent.com/121978043/211227181-54afc71c-97bf-4848-a358-04126c601f23.PNG)
Figure 1. 


## Interface Requirements

### User Interfaces

![User Interfaces](https://user-images.githubusercontent.com/121978043/211222182-5ffb3f46-b303-48d5-9b20-901ece9d0d3e.PNG)

### Software Interfaces

![Software Interfaces](https://user-images.githubusercontent.com/121978043/211222209-96e683c4-c609-43e5-9f59-835f422434e3.PNG)

## Use Case Models

### Manage Accounts

**Pre-conditions:**  The credentials provided match the user

**Post-conditions:** The account has been successfully added/removed from the system

**Actors:** User

![Manage Accounts](https://user-images.githubusercontent.com/121978043/211222850-32650ca6-73b7-486b-b31f-6fabe9c18cde.PNG)


### Enter the System as a User

**Pre-conditions:** The credentials provided match a user in the database

**Post-conditions:** The user entered the system successfully and may proceed

**Actors:** User

![Enter System as User](https://user-images.githubusercontent.com/121978043/211222860-558ebb6a-badc-4f91-86b3-762c96d66b26.PNG)

### Modify Faculty Searches

**Pre-conditions:** The user has entered the system successfully

**Post-conditions:** The faculty searches are presented and the changes performed (if any) have been saved successfully

**Actors:** User

![Modify Faculty Searches](https://user-images.githubusercontent.com/121978043/211222875-3486aaba-d398-4c64-b515-e7ce16a1ca70.PNG)

### Modify Applications for a Faculty Search

**Pre-conditions:** The user has entered the system successfully and chooses to view the faculty search table.

**Post-conditions:** - The relevant applications are presented and the changes performed (if any) have been saved successfully

**Actors:** User

![Modify Applications](https://user-images.githubusercontent.com/121978043/211222884-9231e1b5-c7c3-42d9-b4b4-508e49d2977d.PNG)

## Data Design

The ER diagram provides an overview of the system's database design:

![ER diagram](https://user-images.githubusercontent.com/121978043/211225326-03843876-3985-4664-94a8-c48eba60307a.PNG)










