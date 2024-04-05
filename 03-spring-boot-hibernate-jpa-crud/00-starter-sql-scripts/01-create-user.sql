-- Drop user first if they exist
DROP USER if exists 'springstudent'@'%' ;

-- Now create user with prop privileges
CREATE USER 'springstudent'@'%' IDENTIFIED BY 'Spring-student123';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'%';