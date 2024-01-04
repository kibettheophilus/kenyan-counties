## A Simple graphql api

## How to setup

- Clone the repo

```
 git clone https://github.com/kibettheophilus/kenyan-counties.git
```

- Create a database in MongoDB with name `counties` and add the uri to the `application.yml`
- Run the project

```
./gradlew bootRun 
```

- Open [http://localhost:8080/graphiql](http://localhost:8080/graphiql) to access using graphiql(or connect
  to http://localhost:8080/graphql using postman or altair Graphql Client )
- Add data to the db using the `addCounty` `mutation`, below is a sample

```
mutation {
  addCounty(county: {
    code:"001",
    name:"Mombasa"
    constituencies: {
      name: "Jomvu",
      wards:"Shanzu South, Shanzu North"
    }
  }){
  status
    message
    details {
      code
      name
    }
  }
}
```

- Fetch data using the `getCounties` `query`, below is a sample

 ```
query{
  getCounties(name:"Mombasa") {
    status
    message
    details {
      name
      code
      constituencies {
        name
        wards
      }
    }
  }
}
```

## Technologies

- Spring Boot
- Java
- Grapqhl - Using [DGS framework](https://netflix.github.io/dgs/)
- MongoDb

## Screenshots
<img width="1429" alt="Screenshot 2024-01-04 at 13 13 15" src="https://github.com/kibettheophilus/kenyan-counties/assets/61080898/50872b4b-4df1-42bf-847f-b34704a4b19a">
<img width="1429" alt="Screenshot 2024-01-04 at 13 13 49" src="https://github.com/kibettheophilus/kenyan-counties/assets/61080898/0d3be9ba-b1cd-46ee-9b4f-d0c477e52ee5">
<img width="1429" alt="Screenshot 2024-01-04 at 13 14 03" src="https://github.com/kibettheophilus/kenyan-counties/assets/61080898/bf3ff8ae-f36b-4fb7-a2d4-91ef771192af">

