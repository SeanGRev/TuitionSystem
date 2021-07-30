# Tuition Reimbursement Management System

## Project Description

A tuition reimbursment management system with different tiers of approval so far there are supervisors and a benefits coordinator. All reimbursement requests are managed through email addresses. Every employee registered must login in order to submit a request and each request is first sent to their supervisor for approval before being sent to the benefits coordinator for final approval. Each user is also able to view the requests they have sent as well as any requests that they may have to approve. These features are denied if the user is not logged in and the user will not be able to view any requests have no relation to them.

A request contains information for:
- id                (unique id value for the request)
- reimbursement_id  (the specific reimbursement that the request is for)
- reviewer_id       (the id value for the employee that is to review this request)
- sender_id         (the id value for the employee that sent the request)
- message           (a short message to the reviewer, written by the sender)
- approval_status   (the current approval status for the request)
- submission_date   (the date that the request was submitted on)
- urgent            (true or false value for if the request is urgent or not)

## Technologies Used

* Javalin - Version 3.13.6
* PostgreSQL - Version 42.2.20
* Java -  JavaScript, HTML, CSS
* Hibernate - Version 5.5.3.Final
* JDBC
* JUnit4
* Selenium - Version 3.8.1

## Features

List of features ready and TODOs for future development
* After initial creation of a request the reviewer is automatically updated requiring no further action from the user
* Currently supports the creation of new events, reimbursements, and requests
* No matter who approves a request a benefits coordinator will always be the final approval step

To-do list:
* Have the login page show that a user is still logged in even after switching pages
* Events and reimbursements should be searched for based on something other than their id values
* Currently only one benefits coordinator is supported
* Reimbursment amounts are not automatically calculated based on company standard coverage amounts

## Getting Started
   
1. Start with this GitHub Repository.
2. Git Clone to a directory of your choice
   $ git clone https://github.com/libgit2/libgit2 mylibgit
3. If there is not currently a src/main/resources directory create it either manually or using the command line
  a. In this folder create a file called 'hibernate.cfg.xml'
  b. The file contents should look like the code below:
  
        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE hibernate-configuration SYSTEM "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

        <hibernate-configuration>
          <session-factory>

            <property name="hibernate.connection.driver_class">
              org.postgresql.Driver
            </property>

            <property name="hibernate.dialect">
              org.hibernate.dialect.PostgreSQLDialect
            </property>

            <property name="hibernate.connection.url">
              * your database connection url (should resemble what I have below as mine)
              jdbc:postgresql://seangpostgres.cgkgf1bdwgdz.us-east-2.rds.amazonaws.com/postgres
            </property>

            <property name="hibernate.connection.username">
              * your current database username
            </property>

            <property name="hibernate.connection.password">
              * your current database password
            </property>

            <!-- Optional Properties -->
            <property name="show_sql">
              true
            </property>

            <property name="hbm2ddl.auto">
              none
            </property>

            <!-- Class Mappings -->
            <mapping class="com.revature.models.Attachment"/>
            <mapping class="com.revature.models.Department" />
            <mapping class="com.revature.models.Employee"/>
            <mapping class="com.revature.models.Event"/>
            <mapping class="com.revature.models.EventType"/>
            <mapping class="com.revature.models.GradeFormat"/>
            <mapping class="com.revature.models.Presentation"/>
            <mapping class="com.revature.models.Reimbursement"/>
            <mapping class="com.revature.models.Request"/>

          </session-factory>
        </hibernate-configuration>
  
  c. The hbm2ddl.auto property can be set to values such as create or update. None worked best for me but in a working application update is also an option. Create is better      for testing.
4. Assuming that the above was done the backend should be set up. Try running the application and see if there are any errors. At this step there may be some involving the databsae which we will set up next.

### Setting up the database

1. To set up the database navigate to where you run your database scripts and run the following:
   This should work fine with Postgresql and SQL, other database scripts may have different syntax.
   ```
      create table employees (
        id serial,
        first_name varchar(20) not null,
        last_name varchar(20) not null,
        email varchar(50) not null,
        password varchar(50) not null,
        active boolean not null,
        supervisor_id int not null,
        ben_co_id int not null,
        dep_id int not null,
        primary key (id)
      );

      create table departments (
        id serial,
        dep_head_id int not null,
        dep_name varchar(50) not null,
        primary key (id)
      );

      create table requests (
        id serial,
        reimbursement_id int not null,
        reviewer_id int not null,
        sender_id int not null,
        message varchar(300),
        approval_status boolean not null,
        submission_date date not null,
        urgent boolean not null,
        primary key (id)
      );

      create table reimbursements (
        id serial,
        employee_id int not null,
        event_id int not null,
        amount numeric(8,2),
        missed_hours int not null,
        description varchar(200) not null,
        grade varchar(20) not null,
        primary key (id)
      );

      create table events (
        id serial,
        event_type_id int not null,
        grade_format_id int not null,
        start_date date not null,
        end_date date,
        tuition numeric(10,2) not null,
        location varchar(50) not null,
        description varchar(300) not null,
        primary key (id)
      );

      create table event_types (
        id serial,
        coverage numeric(3,2) not null,
        type varchar(50) not null,
        primary key (id)
      );

      create table grade_formats (
        id serial,
        description varchar(200) not null,
        primary key (id)
      );

      create table presentations (
        id serial,
        reimbursement_id int not null,
        description varchar(200) not null,
        primary key (id)
      );

      create table attachments (
        id serial,
        reimbursement_id int not null,
        attachment varchar(50) not null,
        primary key (id)
      );
     ```

2. Now set up some foreign key relationships.
  a. Employees should have a foreign key relation between dep_id and the primary key in the departments table
     Foreign Key Creation Syntax:
       
       CONSTRAINT fk_emp_dep
          FOREIGN KEY(dep_id) 
            REFERENCES departments(id)
  b. 

## Usage

> Here, you instruct other people on how to use your project after they’ve installed it. This would also be a good place to include screenshots of your project in action.

## Contributors

> Here list the people who have contributed to this project. (ignore this section, if its a solo project)

## License

This project uses the following license: [<license_name>](<link>).
