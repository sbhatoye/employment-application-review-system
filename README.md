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


## Project Walkthrough

### Login Screen 

The login screen is the start screen of the application which allows
users to enter the system by entering valid credentials. 

![Login Screen](https://user-images.githubusercontent.com/121978043/211227181-54afc71c-97bf-4848-a358-04126c601f23.PNG)

Figure 1. 

### Main Menu

Once the user has entered credentials matching the system's records, 
they will be able to view the main menu screen (Figure 2) . 

The main menu gives user three options to choose from: perform a faculty search, manage accounts, 
or exit the application. The 'Manage Accounts' drop down menu has two
options: add a new account or update an existing account (Figure 3). 

![Main Menu](https://user-images.githubusercontent.com/121978043/211228505-0ab99fd6-493c-4b4f-81be-7d0744751528.PNG)

Figure 2.

![Main Menu 2](https://user-images.githubusercontent.com/121978043/211228529-379c0da0-e5a1-4807-a0d8-6da0615809d8.PNG)

Figure 3. 

### Add Account

If the user selects the 'Add a new account' option in the main menu,
they can add another user to the system (Figure 4). 

![Add a New Account Screen](https://user-images.githubusercontent.com/121978043/211228563-9ab375d6-9f52-4dea-afd4-5df7a5666984.PNG)

Figure 4.

### Update Account

If the user wishes to update any personal information on their account, 
they can select the 'Udate account' option in the main menu (Figure 5). 

![Update Account Screen](https://user-images.githubusercontent.com/121978043/211228584-b6a915f9-49ff-408d-8874-91d7e2581ef4.PNG)

Figure 5.

### Faculty search

If the user selects 'Faculty Search' from the main menu, they will be 
directed to the faculty search page (Figure 6). Upon clicking the 'Load' button, 
all existing faculty searches will be displayed in the table.

In order to add a faculty search for a job opening, the user can make 
appropriate selections based on criteria such as job position, 
duration of the job position, the acting committee chair and 
committee members, and the status of the application. 

The 'Load' button refreshes the table and displays new entries. 
The 'Application ID' in the table marks each entry as unique and 
automatically increments itself as additional faculty searches 
are added. 

![Faculty Search Screen](https://user-images.githubusercontent.com/121978043/211405065-a48a9ef9-8308-402a-a385-d5eb36a52cd3.PNG)

Figure 6. 

### Review Applications

Upon clicking the 'Review Applications' button, the user is directed
to a page displaying all the submitted applications pending review 
by other faculty members (Figure 7). 

![Review Applications](https://user-images.githubusercontent.com/121978043/211405799-7d005465-b149-4023-89e4-ef1dd555b6c6.PNG)

Figure 7.

### Applicant page

The applicant page (Figure 8) contains the candidate's contact information, 
the position they applied for, any ubmitted documents such as CV, and
status of the applicant. 

A general comment box is provided for users to leave any general
updates on the application. 

The performance review section allows all faculty members to
review the application collaboratively in order to arrive at 
a final decision. A faculty review can also be specifically assigned to a faculty
member. 

![Applicant Page Screen](https://user-images.githubusercontent.com/121978043/211406172-f0cde301-1338-4a39-826e-5ec64db200be.PNG)

Figure 8.


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










