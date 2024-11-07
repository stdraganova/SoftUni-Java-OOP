import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        //Exercise 2
        //changeCasing(entityManager);

        //Exercise 3
        //containsEmployee(entityManager);

        //Exercise 4
        //getNameWithSalaryOver50000(entityManager);

        //Exercise 5
        //employeesFromResearchDepartment(entityManager);

        //Exercise 6
        //newAddress(entityManager);

        //Exercise 7
        //addressesWithEmployeeCount(entityManager);

        //Exercise 8
        //getEmployeesWithProject(entityManager);

        //Exercise 9
        //findTheLast10Projects(entityManager);

        //Exercise 10
        //increaseSalaries(entityManager);

        //Exercise 11
        //findEmployeeByFirstName(entityManager);

        //Exercise 12
        //employeesMaximumSalaries(entityManager);

        //Exercise 13
        //removeTowns(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void removeTowns(EntityManager entityManager) throws IOException {
        String townName = READER.readLine();

        List<Employee> employees = entityManager.createQuery("FROM Employee WHERE address.town.name = :name", Employee.class)
                .setParameter("name", townName)
                .getResultList();

        employees.forEach(e -> {
            e.setAddress(null);
            entityManager.persist(e);
        });

        List<Address> addresses = entityManager.createQuery("FROM Address WHERE town.name = :name", Address.class)
                .setParameter("name", townName)
                .getResultList();

        addresses.forEach(entityManager::remove);

        Town town = entityManager.createQuery("FROM Town WHERE name = :name", Town.class)
                .setParameter("name", townName)
                .getSingleResult();

        entityManager.remove(town);

        System.out.printf("%d addresses in %s deleted", addresses.size(), townName);
    }

    private static void employeesMaximumSalaries(EntityManager entityManager) {
        //With JPQL/HQL
        List<Object[]> resultList = entityManager.createQuery("SELECT d.name, MAX(e.salary) FROM Department d " +
                        "JOIN d.employees e " +
                        "GROUP BY d.name HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList();

        resultList.forEach(r -> System.out.printf("%s %.2f%n", r[0], r[1]));

        //With Java Code
//        entityManager.createQuery("FROM Department ", Department.class)
//                .getResultStream()
//                .forEach(d -> {
//                        double max = d.getEmployees()
//                                .stream()
//                                .mapToDouble(e -> e.getSalary().doubleValue())
//                                .max()
//                                .getAsDouble();
//
//                        if (max < 30000 || max > 70000) {
//                            System.out.printf("%s %.2f%n", d.getName(), max);
//                        }
//                });
    }

    private static void findEmployeeByFirstName(EntityManager entityManager) throws IOException {
        String pattern = READER.readLine() + "%";

        entityManager.createQuery("FROM Employee WHERE firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", pattern)
                .getResultList()
                .forEach(e ->{
                    System.out.printf("%s %s - %s - ($%.2f)%n",
                            e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary());
                });
    }

    private static void increaseSalaries(EntityManager entityManager) {
       entityManager.createQuery("FROM Employee WHERE department.name " +
                        "IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class)
                .getResultList()
                .forEach(employee -> {
                    employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
                    entityManager.persist(employee);
                    System.out.printf("%s %s ($%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
                });
    }

    private static void findTheLast10Projects(EntityManager entityManager) {
        entityManager.createQuery("FROM Project ORDER BY startDate DESC, name", Project.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(p -> System.out.printf("Project name: %s\n" +
                        "\tProject Description: %s\n" +
                        "\tdevelopment of …\n" +
                        "\tProject Start %s\n" +
                        "\tProject End Date: %s\n",
                        p.getName(), p.getDescription(), p.getStartDate(), p.getEndDate()));
    }

    private static void getEmployeesWithProject(EntityManager entityManager) throws IOException {
        int employeeId = Integer.parseInt(READER.readLine());

        Employee employee = entityManager.find(Employee.class, employeeId);
        if (employee.getProjects().isEmpty()){
            return;
        }

        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> System.out.printf("%s%n", project.getName()));
    }

    private static void addressesWithEmployeeCount(EntityManager entityManager) {
        entityManager.createQuery("FROM Address ORDER BY employees.size DESC", Address.class)
                .setMaxResults(10)  // = LIMIT 10
                .getResultList()
                .forEach(a -> System.out.printf("%s %s - %d employees%n",
                        a.getText(), a.getTown().getName(), a.getEmployees().size()));
    }

    private static void newAddress(EntityManager entityManager) throws IOException {
        String lastName = READER.readLine();

        Address address = new Address();
        address.setText("Vitoshka 15");
        entityManager.persist(address); //CREATE || UPDATE

        Employee employee = entityManager.createQuery("FROm Employee WHERE lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getSingleResult();

        employee.setAddress(address);
        entityManager.persist(employee);
    }

    private static void employeesFromResearchDepartment(EntityManager entityManager) {
        entityManager
                .createQuery("FROM Employee e WHERE e.department.name = 'Research and Development' " +
                    "ORDER BY salary, id " , Employee.class)
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                        e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));
    }

    private static void getNameWithSalaryOver50000(EntityManager entityManager) {
        entityManager.createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultStream()
                .forEach(e -> System.out.println(e.getFirstName()));
    }

    private static void containsEmployee(EntityManager entityManager) throws IOException {
        String[] fullName = READER.readLine().split("\\s+");
        List<Employee> resultList = entityManager.
                createQuery("FROM Employee WHERE firstName = :firstName AND lastName = :lastName", Employee.class)
                .setParameter("firstName", fullName[0])
                .setParameter("lastName", fullName[1])
                .getResultList();

        System.out.println(resultList.isEmpty() ? "No" : "Yes");
    }


    private static void changeCasing(EntityManager entityManager) {
        List<Town> towns = entityManager.createQuery("FROM Town WHERE LENGTH(name) > 5", Town.class).getResultList();
        towns.forEach(town -> {
            town.setName(town.getName().toUpperCase());
            entityManager.persist(town);
//        Or:
//        entityManager.createQuery("UPDATE Town SET name = UPPER(name) WHERE LENGTH(name) > 5").executeUpdate();
        });
    }
}
