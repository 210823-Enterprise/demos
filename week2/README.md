# Week 2: SQL, JDBC, and Cloud Computing
- QC questions which will be asked in week 5 QC (*Monday Sept 20th*) [here](https://github.com/210823-Enterprise/demos/blob/main/week2/qc-questions.md) 👈
- On Tuesday we will begin working with PostgreSQL, DBeaver, and SQL querying & data manipulation
- Wednesday - Friday we will connect our Java Applications to our databases and migrate our database to one hosted on the AWS cloud through an RDS.

<br>

## `Thursday`
- What is a **Transaction** in SQL?

- What does `A.C.I.D` mean regarding **Transactions** in SQL?

- What is `PL/pgSQL`?

- How do you call Stored Procedures in SQL from JDBC? (_Think about the Interfaces availble in JDBC API_)

<br>

## `Wednesday`
- What is `JDBC`? Where does this API come from?

- What are the 5 main classes and interfaces included in the JDBC API?
  - `DriverManager` Class
  - `Connection` Interface
  - `Statement` Interface
  - `ResultSet` Interface
  - `CallableStatement` Interface

- How do we protect against **SQL Injection**?
  - This is very important for interviews.  Take a look at [OWASP top 10](https://owasp.org/www-project-top-ten/)

- Explain the `DAO` Design Pattern.  What is it's purpose? Great resource [here](https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm) 👈
  - **Data Access Object Interface** - (*i.e `IUserDao.java`*) This interface defines the standard operations to be performed on a model object(s).
  
  - **Data Access Object concrete Class** - (*i.e `UseroDao.java`*) This class implements above interface. This class is responsible to get data from a data source which can be database / xml or any other storage mechanism.
  
  - **Model Object or Value Object** - (*i.e `User.java`*) This object is simple POJO containing get/set methods to store data retrieved using DAO class.

- Why is **Logging** important?  Name some logging levels.

- What is Multiplicity/ Cadinality in SQL?
  - 1:1 - one to one relationship
  - 1:n - one to many relationship
  - n:n - many to many relationship, best expressed with join tables



<br>

## `Tuesday`
- What is SQL? The sublanguages of SQL?
  - DDL
  - DML
  - DCL
  - TCL
  - DQL

- What is an RDBMS? What does it mean for a database to be a *relational* database?

- What is Normalization?

- Define 0NF, 1NF, 2NF, 3NF. Here's a great [resource on Normalization](https://www.guru99.com/database-normalization.html)

- Define **Referential Integrity**

- What is an **aggregate function**? Example?

- What is a **scalar function**? Example?

- What are the different **set oprators**? (*i.e `UNION` vs. `UNION ALL` vs `INTERSECT`*)


<br>

## `Monday`
- 10:00am ET Quiz 📝

- 1:00pm ET BlackRock First Impressions (*come with questions for them*) 🕴️
  - Research [BlackRock](https://www.blackrock.com/us/individual) beforehand

- 2:00pm Week 1 QC: Java Fundamentals ❓







<br>

