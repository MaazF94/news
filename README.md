# News API

## Run The Application
- PreReqs: JDK17 (Can install directly in IDE such as IntelliJ)
- Open the application into your IDE and run the following Gradle command from the `article` sub-project: `./gradlew bootRun`. 
- Alternatively, you can create a run configuration in the IDE.

### Limitations
- Total 100 requests per day.

## Fetching N News Articles (/limit/{number})
- Paste the following URL into your browser:
`http://localhost:8080/news/admin/articles/limit/5`, replacing the number at the end with the number of articles to retrieve.
- Maximum limit of 100.
## Searching News Articles for Specific Title or Author (/search/{"text"})
- Paste the following URL into your browser:
  `http://localhost:8080/news/admin/articles/search/""`, placing the exact text you're searching for within the double quotations.
## Searching News Articles for Keywords (/search/{text})
- Paste the following URL into your browser:
  `http://localhost:8080/news/admin/articles/search/Dinosaur`, replacing the text at the end with what keywords you're searching for. This should not be encapsulated in quotations.