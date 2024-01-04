## A Simple graphql api

## How to setup

- Clone the repo

```
 git clone https://github.com/kibettheophilus/kenyan-counties.git
```

- Create a database in MongoDB and add the uri to the `application.yml`
- Run the project

```
./gradlew bootRun 
```

- Open [http://localhost:8080/graphiql](http://localhost:8080/graphiql) to access using graphiql(or connect
  to http://localhost:8080/graphql using postman or altair Graphql Client )

###### Sample query

 ```
query{
  getCounties(name:"Mombasa") {
    status
    message
    details {
      constituencies {
        name
      }
    }
  }
}

```

## Technologies

- Spring Boot
- Java
- Grapqhl - Using [DGS framework](https://netflix.github.io/dgs/)

## Screenshots

![Screenshot 2024-01-04 at 13.13.15.png](..%2F..%2FDesktop%2FScreenshot%202024-01-04%20at%2013.13.15.png)
![Screenshot 2024-01-04 at 13.13.49.png](..%2F..%2FDesktop%2FScreenshot%202024-01-04%20at%2013.13.49.png)
![Screenshot 2024-01-04 at 13.14.03.png](..%2F..%2FDesktop%2FScreenshot%202024-01-04%20at%2013.14.03.png)