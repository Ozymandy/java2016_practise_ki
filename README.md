EPAM Practice 2016
=============
Domain
------
Customer/Product/Order
Task01
------
Create command line application that will prints Customer Information. Example output:
> Effective Java (2nd Edition) May 28, 2008, by Joshua Bloch, published  by Addison-Wesley

Task02
-------
Implement searching orders by one customer. Example:
>It's Constantine Ihnatsenka ordered 4 items

Task03
-------
Update maven pom.xml to package war application (web-app). Create HTTP servlet that will render in response for request GET /hello
> Hello from App developed by $yourName
- Use standalone Jetty to launch your war file.

Task04
-------
Add logging in application using SLF4J + Logback. 
- Configure console appender (to see time, threads, logging level, class and method, message)
- Refactor your code to use  logger instead of System.out or ex.printstacktrace().

Task05
-------
Create pages for displaying information about books and editing/creating books:
GET   /list - shows page with the list of Books
GET   /edit?cardId={cardId} - shows edits form for editing book. If {bookId == 'new'} - происходит создание книги.
POST /edit?cardId={cardId} - handles edits form and redirects to page List of Books
GET  /search - shows page with the filtered list of books 
Extract application logic into Service tier
