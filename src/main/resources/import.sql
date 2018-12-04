CREATE SCHEMA IF NOT EXISTS PUBLIC;
insert into customer(customer_id, name, login, password) values (1,'Roy','roy','{noop}spring');
insert into customer(customer_id, name, login, password) values (2,'Craig','craig','{noop}spring');
insert into customer(customer_id, name, login, password) values (3,'Greg','greg','{noop}spring');
 
insert into role(role_id, name) values (1,'ROLE_USER');
insert into role(role_id, name) values (2,'ROLE_ADMIN');
insert into role(role_id, name) values (3,'ROLE_GUEST');

insert into customer_role(customer_id, role_id) values (1,1);
insert into customer_role(customer_id, role_id) values (1,2);
insert into customer_role(customer_id, role_id) values (2,1);
insert into customer_role(customer_id, role_id) values (3,1);

