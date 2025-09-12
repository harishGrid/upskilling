package com.composite;

public class Company {
    public static void main(String[] args) {
    	
        Employee dev1 = new Developer("Harish", "Backend Developer");
        Employee dev2 = new Developer("Mahesh", "Frontend Developer");
        Employee designer1 = new Designer("Ganesh", "UI Designer");

        Manager manager = new Manager("Murali", "Manager");
        manager.add(dev1);
        manager.add(dev2);
        manager.add(designer1);

        Manager ceo = new Manager("Srinivas", "CEO");
        ceo.add(manager);

        ceo.showDetails();
    }
}
