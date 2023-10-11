import java.util.Scanner;

class Employee {
    private String employeeName;
    private int ID;
    private String firstDayWork;
    private int phoneNumber;
    private String address;
    private int workHours;
    private double salary;
    private Employee next;

    public Employee(String name, int ID, String firstDayWork, int phoneNumber, String address, int workHours, double salary) {
        this.employeeName = name;
        this.ID = ID;
        this.firstDayWork = firstDayWork;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.workHours = workHours;
        this.salary = salary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstDayWork() {
        return firstDayWork;
    }

    public void setFirstDayWork(String firstDayWork) {
        this.firstDayWork = firstDayWork;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getNext() {
        return next;
    }

    public void setNext(Employee next) {
        this.next = next;
    }
}

class LinkedList {
    private Employee head;

    public LinkedList() {
        head = null;
    }

    public int search(int id) {
        Employee temp = head;
        while (temp != null) {
            if (temp.getID() == id) {
                return temp.getID();
            }
            temp = temp.getNext();
        }
        return -1;
    }

    public void insert() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter ID: ");
        int id = in.nextInt();
        while (search(id) != -1) {
            System.out.println("ID already exists in the list. Please enter a new ID: ");
            id = in.nextInt();
        }
        System.out.println("Enter name: ");
        String name = in.nextLine();
        name = in.nextLine();
        System.out.println("Enter first day of work: ");
        String firstDayWork = in.next();
        System.out.println("Enter phone number: ");
        int phoneNumber = in.nextInt();
        System.out.println("Enter address: ");
        String address = in.nextLine();
        address = in.nextLine();
        System.out.println("Enter work hours: ");
        int workHours = in.nextInt();
        while (workHours < 32) {
            System.out.println("Work hours must be greater than 32. Please enter again: ");
            workHours = in.nextInt();
        }
        System.out.println("Enter salary: ");
        double salary = in.nextDouble();
        Employee newEmployee = new Employee(name, id, firstDayWork, phoneNumber, address, workHours, salary);
        if (head == null) {
            head = newEmployee;
        } else {
            Employee temp = head;
            while (temp.getNext() != null && temp.getNext().getID() < newEmployee.getID()) {
                temp = temp.getNext();
            }
            newEmployee.setNext(temp.getNext());
            temp.setNext(newEmployee);
            System.out.println("successfully added");
        }
    }

    public int delete(int id) {
        Employee temp = head;
        if (temp.getID() == id) {
            head = temp.getNext();
            return 0;
        }
        while (temp.getNext() != null) {
            if (temp.getNext().getID() == id) {
                temp.setNext(temp.getNext().getNext());
                return 0;
            }
            temp = temp.getNext();
        }
        return -1;
    }

    public void update() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter id of employee to update: ");
        int id = in.nextInt();
        if (search(id) == -1) {
            System.out.println("Employee not found!");
        } else {
            System.out.println("Enter new name: ");
            String name = in.nextLine();
            name = in.nextLine();
            System.out.println("Enter new first day of work: ");
            String firstDayWork = in.next();
            System.out.println("Enter new phone number: ");
            int phoneNumber = in.nextInt();
            System.out.println("Enter new address: ");
            String address = in.nextLine();
            address = in.nextLine();
            System.out.println("Enter new work hours: ");
            int workHours = in.nextInt();
            while (workHours<32) {
                System.out.println("Work hours must be greater than 32. Please enter again: ");
                workHours = in.nextInt();
            }
            System.out.println("Enter new salary: ");
            double salary = in.nextDouble();
            Employee temp = head;
            while (temp.getID() != id) {
                temp = temp.getNext();
            }
            temp.setEmployeeName(name);
            temp.setFirstDayWork(firstDayWork);
            temp.setPhoneNumber(phoneNumber);
            temp.setAddress(address);
            temp.setWorkHours(workHours);
            temp.setSalary(salary);
            System.out.println("successfully updated!");
        }
    }

    public void updateSalary() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter id of employee to update salary: ");
        int id = in.nextInt();
        if (search(id) == -1) {
            System.out.println("Employee not found!");
        } else {
            Employee temp = head;
            while (temp.getID() != id) {
                temp = temp.getNext();
            }
            int hours = temp.getWorkHours();
            double salary = temp.getSalary();
            if (hours > 32) {
                int extraHours = hours - 32;
                int extraSalary = (int) (salary * 0.02 * extraHours);
                salary += extraSalary;
                temp.setSalary(salary);
                System.out.println("Successfully updated salary!");
            } else {
                System.out.println("Salary is not updated!");
            }
        }
    }

    public void printAll() {
        Employee temp = head;
        if (temp == null) {
            System.out.println("List is empty!");
        } else {
            System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%-20s %n", "ID", "Name", "First day of work", "Phone number", "Address", "Work hours", "Salary");
            while (temp != null) {
                System.out.printf("%-10d%-20s%-20s%-20d%-20s%-20d%-20.2f %n", temp.getID(), temp.getEmployeeName(), temp.getFirstDayWork(), temp.getPhoneNumber(), temp.getAddress(), temp.getWorkHours(), temp.getSalary());
                temp = temp.getNext();
            }
        }
    }
}

public class finalProject {
    public static void main(String[] args) {
        System.out.println("Welcome to the employee management system!");
        System.out.println("Please choose one of the following options: ");
        System.out.println("******************************************");
        LinkedList list = new LinkedList();
        Scanner in = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("******************************************");
            System.out.println("1:- Add new employee");
            System.out.println("2:- Delete an employee");
            System.out.println("3:- Update an employee");
            System.out.println("4:- Update salary");
            System.out.println("5:- Search for an employee");
            System.out.println("6:- Print all employees");
            System.out.println("7:- Exit");
            System.out.println("******************************************");
            n = in.nextInt();
            switch (n) {
                case 1:
                    list.insert();
                    break;
                case 2:
                    System.out.println("Enter id of employee to delete: ");
                    int id = in.nextInt();
                    if (list.delete(id) == -1) {
                        System.out.println("Employee not found!");
                    } else {
                        System.out.println("Successfully deleted!");
                    }
                    break;
                case 3:
                    list.update();
                    break;
                case 4:
                    list.updateSalary();
                    break;
                case 5:
                    System.out.println("Enter id of employee to search: ");
                    int id1 = in.nextInt();
                    if (list.search(id1) == -1) {
                        System.out.println("Employee not found!");
                    } else {
                        System.out.println("Employee found!");
                    }
                    break;
                case 6:
                    list.printAll();
                    break;
                case 7:
                    System.out.println("Thank you for using the employee management system!");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while (n != 7);
    }
}

