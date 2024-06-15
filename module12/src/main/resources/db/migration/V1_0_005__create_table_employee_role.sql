create table employee_role
(
    employee_id varchar(255) not null,
    role_id     varchar(255) not null,
    primary key (employee_id, role_id)
)