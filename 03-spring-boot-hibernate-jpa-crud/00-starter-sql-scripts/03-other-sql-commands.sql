-- Get all students:
SELECT * FROM student_tracker.student;

-- Adjust starting point of AUTO_INCREMENT for a table
ALTER TABLE student_tracker.student AUTO_INCREMENT=3000

-- Remove all data from database table and reset AUTO_INCREMENT starting with 1
TRUNCATE student_tracker.student;
