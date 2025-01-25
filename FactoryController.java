package controller;

import model.CarProducingMachine;
import model.Employee;
import repository.CarProducingMachineRepository;
import repository.EmployeeRepository;

import java.math.BigDecimal;
import java.util.List;

public class FactoryController {
    private final EmployeeRepository employeeRepo = new EmployeeRepository();
    private final CarProducingMachineRepository machineRepo = new CarProducingMachineRepository();

    public void addEmployee(String name, String position, BigDecimal salary) {
        Employee employee = new Employee(0, name, position, salary);
        employeeRepo.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    public void listEmployees() {
        List<Employee> employees = employeeRepo.getAllEmployees();
        employees.forEach(System.out::println);
    }

    public void addMachine(String name, int capacity, boolean operational) {
        CarProducingMachine machine = new CarProducingMachine(0, name, capacity, operational);
        machineRepo.addMachine(machine);
        System.out.println("Machine added successfully.");
    }

    public void listMachines() {
        List<CarProducingMachine> machines = machineRepo.getAllMachines();
        machines.forEach(System.out::println);
    }
}
