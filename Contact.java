package com.contact.service;

/**
 * Represents a Contact with validation for ID, name, phone number, and address.
 * This class provides constructors and methods to manage and validate contact information.
 * Gonzalo Patino
 */
public class Contact {
    // Fields representing contact details
    private final String contactId;  // Contact ID is immutable once set
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Constructor to create a Contact object with proper validation.
     * 
     * @param contactId The unique ID for the contact, must not exceed 10 characters
     * @param firstName The first name of the contact, must not exceed 10 characters
     * @param lastName The last name of the contact, must not exceed 10 characters
     * @param phone The contact's phone number, must be exactly 10 digits
     * @param address The contact's address, must not exceed 30 characters
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate contact ID
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        // Validate first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        // Validate last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        // Validate phone number
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter for contact ID (contact ID is immutable, so no setter is provided)
    public String getContactId() {
        return contactId;
    }

    // Getters for other fields
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setter for first name with validation
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    // Setter for last name with validation
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    // Setter for phone with validation
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    // Setter for address with validation
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
