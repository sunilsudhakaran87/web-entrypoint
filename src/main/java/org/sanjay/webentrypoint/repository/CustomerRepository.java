package org.sanjay.webentrypoint.repository;

import org.sanjay.webentrypoint.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByLogin(String login);
}
