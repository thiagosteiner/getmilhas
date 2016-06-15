# getmilhas
Airline Tickets Store - Cloud Server and Android Client

1) Description: 
  
  - GetMilhas is an Airline Ticket Store that sells tickets cheaper than Airlines Stores. 
  - GetMilhas uses Air Miles to pay Airline Companies for the tickets.
  - Customers pay cash to GetMilhas using credit card.
  - GetMilhas has a search engine and web scraper that compares the prices using Air Miles and Cash. Latam Airlines       
  (www.latam.com) and Multiplus (www.pontosmultiplus.com.br) will be the targets for the web scraper and benchmarks for the prices.
  - GetMilhas calculates the price of the ticket based on the Air Miles amount scraped from Multiplus (www.pontosmultiplus.com.br) and the price in cash scraped from Latam Airlines (www.latam.com).


2) Concept:
  
  - There is a low performance pre-alpha version of the search engine working in https://thiagosteiner.shinyapps.io/Shiny/
  - This version is just a concept and software architecture test and it uses low performance technology

3) Technology:
  
  3.1) Cloud Server:
    
    -Java Rest Webservice - using Apache Axis 2 Engine
    -MySql
    -Tomcat
  
  3.2) Client:
  
    -Android
  
