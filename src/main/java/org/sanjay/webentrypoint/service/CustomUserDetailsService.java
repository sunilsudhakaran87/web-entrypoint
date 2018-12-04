package org.sanjay.webentrypoint.service;

import org.sanjay.webentrypoint.model.Customer;
import org.sanjay.webentrypoint.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByLogin(s);

        if (customer == null) {
            throw new UsernameNotFoundException(String.format("Cannot find customer %s", s));
        }

        return new User(customer.getLogin(), customer.getPassword(), customer.getRoles());
    }
}
