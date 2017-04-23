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
During testing it has been observed that some urls such as https://www.spiegel.de/meinspiegel/login.html don't work correctly with this project. Concretely this fails with the following error message: 

`Illegal character in path at index 96: /wirtschaft/service/versicherung-check-fuer-haftpflicht-hausrat-berufsunfaehigkeit-a-960380.html`.

The exact reason why this happens is not yet clear and needs to be further investigated.
