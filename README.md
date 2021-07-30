# Tuition Reimbursement Management System

## Project Description

A tuition reimbursment management system with different tiers of approval so far there are supervisors and a benefits coordinator. All reimbursement requests are managed through email addresses. Every employee registered must login in order to submit a request and each request is first sent to their supervisor for approval before being sent to the benefits coordinator for final approval. Each user is also able to view the requests they have sent as well as any requests that they may have to approve. These features are denied if the user is not logged in and the user will not be able to view any requests have no relation to them.

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
        primary key (id),
        CONSTRAINT fk_emp_dep
          FOREIGN KEY(dep_id) 
            REFERENCES departments(id)
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
        primary key (id),
        CONSTRAINT req_reimbursement_fk
          FOREIGN KEY(reimbursement_id) 
            REFERENCES reimbursements(id),
        CONSTRAINT req_reviewer_fk
          FOREIGN KEY(reviewer_id) 
            REFERENCES employees(id),
        CONSTRAINT req_sender_fk
          FOREIGN KEY(sender_id) 
            REFERENCES employees(id)
      );

      create table reimbursements (
        id serial,
        employee_id int not null,
        event_id int not null,
        amount numeric(8,2),
        missed_hours int not null,
        description varchar(200) not null,
        grade varchar(20) not null,
        primary key (id),
        CONSTRAINT rbm_employee_fk
          FOREIGN KEY(employee_id) 
            REFERENCES employees(id),
        CONSTRAINT rbm_event_id
          FOREIGN KEY(event_id) 
            REFERENCES events(id)
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
        primary key (id),
        CONSTRAINT event_type_fk
          FOREIGN KEY(event_type_id) 
            REFERENCES event_types(id),
        CONSTRAINT grade_format_id
          FOREIGN KEY(grade_format_id) 
            REFERENCES grade_formats(id)
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
        primary key (id),
        CONSTRAINT presentation_fk
          FOREIGN KEY(reimbursement_id) 
            REFERENCES reimbursements(id)
      );

      create table attachments (
        id serial,
        reimbursement_id int not null,
        attachment varchar(50) not null,
        primary key (id),
        CONSTRAINT attachment_fk
          FOREIGN KEY(reimbursement_id) 
            REFERENCES reimbursements(id)
      );
     ```

2. This should set up the database after you run the script. Test to make sure the foreign keys are there, if not you may have to create them manually through a application      like DBeaver or MySQLWorkbench.
3. Populate the database with some values:

   The employees Sam Adams and Supervisor Smith can be named whatever you like but one must be the supervisor for both the other and Ben Co must have one of them as a supervisor as supervisor_id is a not null value. Approved Requests is a special employee value meant to store all approved request from the application.
   ```
   insert into employees values(default,'Sam', 'Adams', 'sadam@gmail.com', 'samadams12', true, 2, 5, 1);
   insert into employees values(default, 'Supervisor', 'Smith', 'ssmith@gmail.com', 'ssmith86', true, 1, 5, 1);
   insert into employees values(default, 'Ben', 'Co', 'benco@gmail.com', 'benco32', true, 2, 5, 1);
   insert into employees values(default, 'Approved', 'Requests', 'ApprovedRequests', 'ar', true, 2, 5, 1);

   insert into departments values(default, 1, 'Department1');
   
   insert into event_types values(default, 0.60, 'Seminar');
   insert into event_types values(default, 0.80, 'University Course');
   insert into event_types values(default, 1.00, 'Certification');
   insert into event_types values(default, 0.75, 'Certification Preparation Class');
   insert into event_types values(default, 0.90, 'Technical Training');
   insert into event_types values(default, 0.3, 'Other');
   insert into grade_formats values(default, 'Performance based: as in how well they can dance');
   insert into grade_formats values(default, '0-10 Rating');
   insert into grade_formats values(default, 'Short response from trainer.');
   ```

### Testing the backend

At this point the backend should be operational if all the prior instructions were correct and everything worked out okay.
To make sure the basics work run the file TuitionSystem\src\main\java\com\revature\app\App.java. If everything works the console should look something like this:
![image](https://user-images.githubusercontent.com/85519524/127674155-e8408357-07fd-4c23-9725-16431cb71364.png)

To confirm go to: http://localhost:7000/ in your web browser and it should return a page with the text "Tuition System Home Page".

### Testing the Frontend

Navigate to TuitionSystem\JScript and open the index.html file. This should bring you to a page that looks like this:
![image](https://user-images.githubusercontent.com/85519524/127675569-9786d4e1-530e-494b-b25b-e35b5e56139c.png)

## Usage
If the homepage is open try logging in as one of your users in the database.
Enter the email and password for one of the employees you have created. If correct you should see a message below the login section that greets them by name.
![image](https://user-images.githubusercontent.com/85519524/127675799-706edc30-e424-4339-8ac1-abcab42a79ea.png)

If the login credentials were incorrect you should see a message like this:
![image](https://user-images.githubusercontent.com/85519524/127676221-91982592-1c3c-451a-b38a-01a1546066a8.png)

Now to start the process of sending a request you will first have to go to the events page by clicking on the 'Go to the Events Page' link in the top navigation bar.
This should take you to a page like this:
![image](https://user-images.githubusercontent.com/85519524/127676489-ebcf3aa6-095c-4842-8d36-27963f5cd7e1.png)

To enter an event scroll down to the Create a New Event form below. Fill out the data. Just remember that the first date is the start date of the event and the second date is the end date.

![image](https://user-images.githubusercontent.com/85519524/127676732-353862cd-ff3e-4e44-8290-c8c0840d4603.png)

Upon clicking submit if the creation is successful an alert box should provide us the id of the new event. Mark down the id from the alert. We will need it for creating the reimbursement. You can also use the Get an Event area at the top of the screen to make sure that an event with that id indeed exists.
![image](https://user-images.githubusercontent.com/85519524/127676843-62a2aa38-d5ae-49bd-9c70-5b860385b053.png)

Next, navigate to the Reimbursements Page and scroll down to create a new reimbursement. Let's try creating a reimbursement for Sam Adams.
![image](https://user-images.githubusercontent.com/85519524/127677353-ad89068b-efa3-4eff-b291-fb7cc5ba23e9.png)

Click create and we should be shown an alert upon success just like the events page.
![image](https://user-images.githubusercontent.com/85519524/127677436-aad92e4e-3dfe-49b8-a754-d9475f8e90f8.png)

Now for the final step in the creation process we have to submit the request. So navigate to the Requests Page.
Let's make a request for Sam Adams to his supervisor Supervisor Smith.
![image](https://user-images.githubusercontent.com/85519524/127677797-c8660df0-cf12-41f4-8b9d-7de70a48ea92.png)

Now it is fully possible to send your request to yourself. Just know that even if you approve it, it will still go to the benefits coordinator for a final decision.
Create the request and you should get the same alert as before.
![image](https://user-images.githubusercontent.com/85519524/127677943-42962ab8-0619-4aec-93d0-96a6821e8f62.png)

Now to see the request you can click on the View Sent Requests button and your request should appear. You can also check View Reviewable Requests but an alert should pop up saying that you have no results for that.
You can also try to approve your own request on the View Sent Requests page but an alert should pop up that tells you that you lack permission to do so.

To see Supervisor Smith's section return to the Home Page and log out.
Log back in using Supervisor Smith's credentials.
![image](https://user-images.githubusercontent.com/85519524/127678287-1111ddf6-397c-4f8f-a62c-347e26ec2d0f.png)

Now navigate back to the requests page but click on View Reviewable Requests. You should see the request sent by Sam Adams.
![image](https://user-images.githubusercontent.com/85519524/127678427-e587669d-96e9-49ce-95c7-3abb0e6d1627.png)

As the supervisor you can approve the request using the Approve button and should recieve a notice that it has been sent to the benefits coordinator.
![image](https://user-images.githubusercontent.com/85519524/127678616-017b77c3-5d95-491e-a7a9-643ebeda3f46.png)

Now log out of Supervisor Smith's account and into Ben Co's. Do so and navigate back to the Requests Page and click on View Reviewable Requests.
You should see the same request sent to Supervisor Smith but now the reviewer is marked as Ben Co. Note that the status of the request is still false since the supervisor alone does not have the ability to fully approve a request.

As the benefits coordinator you can select Approve and finalize the approval process. Do so and you should get this message:
![image](https://user-images.githubusercontent.com/85519524/127679039-a09e948f-639c-4d2b-81ba-83e7ef003ee1.png)

Now the request should no longer appear for Ben Co so if you refresh the page the request will no longer show up.
Now we can log back into Sam Adams' account to see what happened to his request.

Navigating to the Request page and viewing requests for Sam Adam will show that his request status is now true and is under our special employee ApprovedRequests.
![image](https://user-images.githubusercontent.com/85519524/127679312-aed90e87-7322-4198-bd38-8865e79e41a5.png)




