    Hibernate: drop table if exists department cascade
    Hibernate: drop table if exists department cascade
    Hibernate: drop table if exists employee cascade
    Hibernate: drop table if exists employee_project cascade
    Hibernate: drop table if exists employee_role cascade
    Hibernate: drop table if exists project cascade
    Hibernate: drop table if exists role cascade
    Hibernate: create table department (employee_id varchar(255) unique, id varchar(255) not null, name varchar(255), primary key (id))
    Hibernate: create table employee (department_id varchar(255), id varchar(255) not null, name varchar(255), surname varchar(255), primary key (id))
    Hibernate: create table employee_project (employee_id varchar(255) not null, project_id varchar(255) not null, primary key (employee_id, project_id))
    Hibernate: create table employee_role (employee_id varchar(255) not null, role_id varchar(255) not null, primary key (employee_id, role_id))
    Hibernate: create table project (id varchar(255) not null, name varchar(255), primary key (id))
    Hibernate: create table role (id varchar(255) not null, name varchar(255), project_id varchar(255), primary key (id))
    Hibernate: alter table if exists department add constraint FKr45epddmrka0nkg3fkqcj28r4 foreign key (employee_id) references employee
    Hibernate: alter table if exists employee add constraint FKbejtwvg9bxus2mffsm3swj3u9 foreign key (department_id) references department
    Hibernate: alter table if exists employee_project add constraint FK4yddvnm7283a40plkcti66wv9 foreign key (project_id) references project
    Hibernate: alter table if exists employee_project add constraint FKb25s5hgggo6k4au4sye7teb3a foreign key (employee_id) references employee
    Hibernate: alter table if exists employee_role add constraint FK7jol9jrbtlt6ctiehegh6besp foreign key (role_id) references role
    Hibernate: alter table if exists employee_role add constraint FKo7rvk7ejtx29vru9cyhf7o68a foreign key (employee_id) references employee
    Hibernate: alter table if exists role add constraint FK82u6w3dkiooc7msaqc1e2cs0v foreign key (project_id) references project