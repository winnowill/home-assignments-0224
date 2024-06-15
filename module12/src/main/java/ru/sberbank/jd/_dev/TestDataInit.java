package ru.sberbank.jd._dev;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.jd.entity.Department;
import ru.sberbank.jd.entity.Employee;
import ru.sberbank.jd.entity.Project;
import ru.sberbank.jd.entity.Role;
import ru.sberbank.jd.repository.DepartmentRepository;
import ru.sberbank.jd.repository.EmployeeRepository;
import ru.sberbank.jd.repository.ProjectRepository;
import ru.sberbank.jd.repository.RoleRepository;


@Profile("test-data")
@Component
@AllArgsConstructor
@Slf4j
public class TestDataInit {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ProjectRepository projectRepository;
    private final RoleRepository roleRepository;

    @Transactional
    @PostConstruct
    public void initData() {
        log.info("Start init test data");
        log.info("Load department data");
        Department department = new Department();
        department.setName("Department  1");

        Employee employee = new Employee();
        employee.setName("Ivan");
        employee.setSurname("Naumov");
        department.setHeadDepartment(employee);
        employeeRepository.save(employee);
        departmentRepository.save(department);

        log.info("Load employee data");
        Employee employee1 = new Employee();
        employee1.setName("Alex");
        employee1.setDepartment_id(department);
        employee1.setSurname("Ivanov");

        Employee employee2 = new Employee();
        employee2.setName("Nina");
        employee2.setDepartment_id(department);
        employee2.setSurname("Sidorova");

        Employee employee3 = new Employee();
        employee3.setName("Max");
        employee3.setDepartment_id(department);
        employee3.setSurname("Petrov");

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);

        log.info("Load project data");
        Project project1 = new Project();
        project1.setName("Project payroll");
        project1.getEmployees().add(employee1);
        project1.getEmployees().add(employee2);
        Project project2 = new Project();
        project2.setName("Project finance");
        project1.getEmployees().add(employee1);
        project1.getEmployees().add(employee3);

        log.info("Load connect employee  and project");
        employee1.getProjects().add(project1);
        employee1.getProjects().add(project2);
        employee2.getProjects().add(project1);
        employee3.getProjects().add(project2);


        log.info("Load role data");
        Role role1 = new Role();
        role1.setName("Developer");
        role1.getEmployees().add(employee1);
        role1.setProject(project1);
        project1.getRoles().add(role1);
        Role role2  = new Role();
        role2.setName("Tester");
        role2.getEmployees().add(employee1);
        project2.getRoles().add(role2);
        Role role3   = new Role();
        role3.setName("Manager");
        role3.getEmployees().add(employee2);
        project1.getRoles().add(role3);
        Role role4    = new Role();
        role4.setName("Manager");
        role4.getEmployees().add(employee3);
        project2.getRoles().add(role4);
        employee1.getRoles().add(role1);
        employee1.getRoles().add(role2);
        employee2.getRoles().add(role3);
        employee3.getRoles().add(role4);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);

        projectRepository.save(project1);
        projectRepository.save(project2);

        roleRepository.save(role1);
        roleRepository.save(role2);
        roleRepository.save(role3);
        roleRepository.save(role4);


    }
}
