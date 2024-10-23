package com.contact.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the ContactService class.
 * Gonzalo Patino
 */
public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St.");
        assertTrue(service.addContact(contact));

        // Test adding the same contact ID again (should throw an exception)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact);
        });
        assertEquals("Contact with this ID already exists", exception.getMessage());
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St.");
        service.addContact(contact);
        assertTrue(service.deleteContact("1234567890"));

        // Test deleting a non-existent contact
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("0000000000");
        });
        assertEquals("Contact with this ID does not exist", exception.getMessage());
    }

    @Test
    void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St.");
        service.addContact(contact);

        // Update contact details
        assertTrue(service.updateContact("1234567890", "Jane", "Doe", "0987654321", "456 Elm St."));
        assertEquals("Jane", contact.getFirstName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm St.", contact.getAddress());

        // Test updating a non-existent contact
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("0000000000", "John", "Doe", "0123456789", "123 Main St.");
        });
        assertEquals("Contact with this ID does not exist", exception.getMessage());
    }
}
