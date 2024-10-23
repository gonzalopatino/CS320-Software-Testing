package com.contact.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Contact class.
 * Gonzalo Patino
 */
public class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St.");
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("123 Main St.", contact.getAddress());
    }

    @Test
    void testInvalidContactId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "0123456789", "123 Main St.");
        });
        assertEquals("Invalid contact ID", exception.getMessage());
    }

    @Test
    void testInvalidPhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "123", "123 Main St.");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }
}
