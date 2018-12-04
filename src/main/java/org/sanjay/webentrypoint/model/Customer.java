/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sanjay.webentrypoint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

	@NotEmpty
	private String name;

	@NotEmpty
	@Column(unique = true, nullable = false)
	private String login;

	@NotEmpty
	private String password;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "customer_role", joinColumns = { @JoinColumn(name = "customer_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();

	public Customer() {
	}

	public Customer(Customer customer) {
		super();
		this.customerId = customer.getCustomerId();
		this.name = customer.getName();
		this.login = customer.getLogin();
		this.password = customer.getPassword();
		this.roles = customer.getRoles();
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
