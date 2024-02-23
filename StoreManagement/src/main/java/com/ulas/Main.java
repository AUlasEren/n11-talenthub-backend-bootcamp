package com.ulas;

import com.ulas.entity.Customer;
import com.ulas.entity.Order;
import com.ulas.entity.Product;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = initializeCustomers();

        listAllCustomers(customers);
        createAndAddNewCustomer(customers, "New Customer", LocalDate.now(),"Technologhy");
        listCustomersContainingLetterC(customers);
        printTotalInvoiceAmountInJune(customers);
        listAllInvoices(customers);
        listInvoicesOverAmount(customers, 1500);
        printAverageOfInvoicesOverAmount(customers, 1500);
        listCustomersWithInvoiceUnderAmount(customers, 500);
        listSectorsWithAverageInvoiceBelowInJune(customers, 750);
    }
    private static void listSectorsWithAverageInvoiceBelowInJune(List<Customer> customers, double threshold) {
        customers.stream()
                .collect(Collectors.groupingBy(Customer::getSector,
                        Collectors.averagingDouble(c -> c.getOrders().stream()
                                .filter(o -> o.getOrderDate() != null && o.getOrderDate().getMonth() == Month.JUNE)
                                .mapToDouble(Order::calculateTotalPrice)
                                .average().orElse(0.0))))
                .entrySet().stream()
                .filter(entry -> entry.getValue() < threshold)
                .forEach(entry -> System.out.println("Sector with Average Invoice Below " + threshold + " in June: " + entry.getKey()));
    }


    private static void listAllCustomers(List<Customer> customers) {
        customers.stream()
                .forEach(c -> System.out.println("Customer Name: " + c.getName()));
    }

    private static void createAndAddNewCustomer(List<Customer> customers, String name, LocalDate registrationDate,String sector) {
        Customer newCustomer = new Customer(name, registrationDate,sector);
        customers.add(newCustomer);
    }

    private static void listCustomersContainingLetterC(List<Customer> customers) {
        customers.stream()
                .filter(c -> c.getName().contains("C"))
                .forEach(c -> System.out.println("Customer with 'C' in Name: " + c.getName()));
    }

    private static void printTotalInvoiceAmountInJune(List<Customer> customers) {
        double totalInJune = customers.stream()
                .filter(c -> c.getRegistrationDate().getMonth() == Month.JUNE)
                .flatMap(c -> c.getOrders().stream())
                .mapToDouble(Order::calculateTotalPrice)
                .sum();
        System.out.println("Total Invoice Amount in June: " + totalInJune);
    }

    private static void listAllInvoices(List<Customer> customers) {
        customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .map(Order::calculateTotalPrice)
                .forEach(total -> System.out.println("Invoice Amount: " + total));
    }

    private static void listInvoicesOverAmount(List<Customer> customers, double amount) {
        customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .map(Order::calculateTotalPrice)
                .filter(total -> total > amount)
                .forEach(total -> System.out.println("Invoice Over " + amount + "TL: " + total));
    }

    private static void printAverageOfInvoicesOverAmount(List<Customer> customers, double amount) {
        double averageAboveAmount = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .mapToDouble(Order::calculateTotalPrice)
                .filter(total -> total > amount)
                .average()
                .orElse(0.0);
        System.out.println("Average of Invoices Over " + amount + "TL: " + averageAboveAmount);
    }

    private static void listCustomersWithInvoiceUnderAmount(List<Customer> customers, double amount) {
        customers.stream()
                .filter(c -> c.getOrders().stream()
                        .anyMatch(o -> o.calculateTotalPrice() < amount))
                .forEach(c -> System.out.println("Customer with Invoice Under " + amount + "TL: " + c.getName()));
    }

    private static List<Customer> initializeCustomers() {
        List<Customer> customers = new ArrayList<>();


        Customer customer1 = new Customer("Ali", LocalDate.of(2024, 1, 15), "Technology");
        Customer customer2 = new Customer("Ayşe", LocalDate.of(2024, 6, 10), "Retail");
        Customer customer3 = new Customer("Mehmet", LocalDate.of(2024, 3, 5), "Manufacturing");



        Product product1 = new Product("Laptop", 3000);
        Product product2 = new Product("Phone", 1500);
        Product product3 = new Product("Headphones", 300);


        Order order1 = new Order();
        order1.addProduct(product1);
        order1.addProduct(product3);

        Order order2 = new Order();
        order2.addProduct(product2);

        Order order3 = new Order();
        order3.addProduct(product3);
        order3.addProduct(product2);

        customer1.addOrder(order1);
        customer2.addOrder(order2);
        customer3.addOrder(order3);


        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        return customers;
    }
}