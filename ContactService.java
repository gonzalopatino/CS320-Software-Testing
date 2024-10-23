package com.contact.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class to manage contact operations such as adding, deleting, and updating contacts.
 * Gonzalo Patino
 */
public class ContactService {
    // Using a HashMap to store contacts with the contact ID as the key for quick lookups
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the system if the contact ID is unique.
     * 
     * @param contact The contact object to be added
     * @return true if the contact is added successfully, false if the contact ID already exists
     * @throws IllegalArgumentException if the contact with the same ID already exists
     */
    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact with this ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    /**
     * Deletes a contact from the system by its ID.
     * 
     * @param contactId The unique ID of the contact to be deleted
     * @return true if the contact is deleted successfully, false if the contact ID doesn't exist
     * @throws IllegalArgumentException if the contact with the given ID does not exist
     */
    public boolean deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with this ID does not exist");
        }
        contacts.remove(contactId);
        return true;
    }

    /**
     * Updates the contact's information based on its contact ID.
     * 
     * @param contactId The unique ID of the contact to be updated
     * @param firstName The new first name of the contact
     * @param lastName The new last name of the contact
     * @param phone The new phone number of the contact
     * @param address The new address of the contact
     * @return true if the contact is updated successfully, false if the contact ID doesn't exist
     * @throws IllegalArgumentException if the contact with the given ID does not exist
     */
    public boolean updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with this ID does not exist");
        }
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
        return true;
    }
}
