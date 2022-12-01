package io.lhysin.java17;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.lhysin.java17.entity.Customer;
import io.lhysin.java17.repository.CustomerRepoitory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class LombokTests {

    @Autowired
    private CustomerRepoitory customerRepoitory;

    @Test
    void lombokToBuilderTest() {

        Customer customer1 = Customer.builder()
            .custNo("1")
            .firstName("John")
            .lastName("Doe")
            .build();

        Customer customer2 = customer1.toBuilder()
            .firstName("Simpson")
            .build();

        assertNotEquals(customer1.getFirstName(), customer2.getFirstName());

    }

    @Test
    void lombokDefaultValueTest() {
        Customer firstNameIsNullCustomer = Customer.builder()
            .custNo("1")
            .build();

        Customer firstNameIsDefaultValueCustomer = Customer.builder()
            .custNo("1")
            .withDefaultValue()
            .build();

        assertNull(firstNameIsNullCustomer.getFirstName());
        assertNotNull(firstNameIsDefaultValueCustomer.getFirstName());

        String firstName = "myFirstName";
        Customer customer1 = Customer.builder()
            .firstName(firstName)
            .withDefaultValue()
            .build();
        assertEquals(firstName, customer1.getFirstName());
        Customer customer2 = Customer.builder()
            .withDefaultValue()
            .firstName(firstName)
            .build();
        assertNotEquals(firstName, customer2.getFirstName());
    }

    @Test
    void jpaAndLombokToBuilderTest() {

        Customer customer1 = Customer.builder()
            .custNo("1")
            .firstName("John")
            .lastName("Doe")
            .build();
        customerRepoitory.save(customer1);
        Customer customer2 = customer1.toBuilder().firstName("Simpson").build();
        log.debug("customer1.equals(customer2) : {}", customer1.equals(customer2));

        customerRepoitory.save(customer2);
        log.debug("customer1.equals(customer2) : {}", customer1.equals(customer2));

    }

}