# HTML Analyzer

This project is a web application that allows a user to input a url and display a report regarding the content of the url.
The report contains the following fields:
- The HTML version of the document
- The page title
- The number of headings (i.e. H1, H2, H3, H4, H5 and H6) grouped by heading level
- The number of hypermedia links grouped into "internal" and "external"
- The information about whether the page contains or not a login form

## How to run:
- In order to build this project execute:
```
mvn clean install -Dmaven.test.skip
```
- In order to start the project:
```
mvn spring-boot:run
```
- In order to run all the tests:
```
mvn clean install
```
- Open http://localhost:8080/ on a web browser in order to use the program

## Assumptions:
Some assumptions have been made in order to make the analysis a bit easier. For example, this program considers login forms in which an input of type "password" is used.

## Limitations and future work:
As future work I would like to change a little bit the implementation of the "has login form" detection. Concretely, I would like to make sure that the password input field belongs to a form that only contains two inputs: one is the password input and the other one is the user name or email. In this way, I would be able to distinguish between a login form and registration form.
