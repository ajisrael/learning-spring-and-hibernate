# Notes

## Authentication

Default username is user and password is generated and logged in console by default

## Integration with Database for Users and Roles (Authorities)

Run the `04-setup-spring-security-demo-database-plaintext.sql` script to setup the users and authorities tables to integrate with Spring Security and JDBC

Use the other scripts for the corresponding scenarios in their names.

Did manually delete the Users and Authorities tables in MySQL to ensure no accidental usage for `06-setup-spring-security-demo-database-bcrypt-custom-table-names`