package com.company;

import java.util.ArrayList;

public class Mobile {
    private final ArrayList<Contact> myContacts;

    public Mobile() {
        myContacts = new ArrayList<>();
    }

    private int findItem(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findItem(String name) {
        for(int i=0; i<this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(name))
                return i;
        }
        return -1;
    }

    public boolean addContact(Contact contact) {
        if(findItem(contact.getName()) >=0) {
            System.out.println("Contact already on file");
            return false;
        }
        this.myContacts.add(contact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        if(findItem(contact) <0) {
            System.out.println("Contact not found. Try another!");
            return false;
        }
        this.myContacts.remove(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int nr = findItem(oldContact);
        if (nr < 0) {
            System.out.println("Contact not found. Try another!");
            return false;
        } else if (findItem(newContact.getName()) != -1) {
            System.out.println("Contact name " + newContact.getName() +
                    " already exists. Error updating contact!");
            return false;
        }
        this.myContacts.set(nr,newContact);
        System.out.println("Contact" + oldContact + " replaced with " + newContact);
        return true;
    }

    /* public String queryContact(Contact contact) {
        if(findItem(contact) >=0)
            return contact.getName();
        return null;
    }*/

    public Contact makeContact(String name) {
        int pos = findItem(name);
        if(pos >= 0)
            return this.myContacts.get(pos);
        return null;
    }

    public void printContacts() {
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println(i + 1 + " " + this.myContacts.get(i).getName() + " -> " +
                                    this.myContacts.get(i).getNumber() + "; \r");
        }
    }
}