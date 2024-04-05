-- Had to run commands directly in terminal on container to work
-- Login command (will be prompted to give password)
mysql -u root -p
-- Drop user first if they exist
DROP USER if exists 'springstudent'@'%' ;

-- Now create user with prop privileges
CREATE USER 'springstudent'@'%' IDENTIFIED BY 'Spring-student123';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'%';

-- Check user exists
select user from mysql.user;

-- May need to refresh connection in DBeaver to see changes