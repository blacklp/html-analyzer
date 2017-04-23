# HTMl Analyzer

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

## Assumptions:

## Limitations:
