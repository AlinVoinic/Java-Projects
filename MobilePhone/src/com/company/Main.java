package com.company;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Mobile mobilePhone = new Mobile();

    public static void main(String[] args) {
        boolean flag = false;
        printInstructions();

        while (!flag) {
            System.out.print("Enter your preference: ");
            int sw = scanner.nextInt();
            scanner.nextLine();
            switch (sw) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContacts();
                    break;
                case 3:
                    removeContacts();
                    break;
                case 4:
                    updateContacts();
                    break;
                case 5:
                    makeContacts();
                    break;
                case 6:
                    flag = true;
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("Choose from the following: \n" +
                "0. Print the menu;\n" +
                "1. Print the contact list; \n" +
                "2. Add a contact; \n" +
                "3. Remove a contact; \n" +
                "4. Update a contact; \n" +
                "5. make a contact;  \n" +
                "6. Exit the menu; \n" );
    }

    private static void addContacts() {
        System.out.println("Add contact name: ");
        String name = scanner.nextLine();
        System.out.println("Add contact number: ");
        String number = scanner.nextLine();

        Contact newContact = Contact.createContact(name, number);
        if(mobilePhone.addContact(newContact))
            System.out.println("Contact with name " + name + " and number " + number + " added");
        else System.out.println("Couldn't add contact.");
    }

    private static void removeContacts() {
        System.out.println("Contact name: ");
        String name = scanner.nextLine();

        Contact contact = mobilePhone.makeContact(name);
        if (contact == null) {
            System.out.println("Contact not found");
            return;
        }

        if (mobilePhone.removeContact(contact)) {
            System.out.println("Succesfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void updateContacts() {
        System.out.println("Current contact name: ");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.makeContact(name);
        if (contact == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("New contact name: ");
        String newName = scanner.nextLine();
        Contact newContact = mobilePhone.makeContact(newName);
        if (mobilePhone.updateContact(contact, newContact)) {
            System.out.println("Contact updates succesfully");
        } else {
            System.out.println("Error updating contact");
        }
    }

    private static void makeContacts() {
        System.out.println("Contact name: ");
        String name = scanner.nextLine();

        Contact contact = mobilePhone.makeContact(name);
        if(contact == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + contact.getName() + ", number: " + contact.getNumber());
    }

}
