create table employee_project
(
    employee_id varchar(255) not null,
    project_id  varchar(255) not null,
    primary key (employee_id, project_id)
)