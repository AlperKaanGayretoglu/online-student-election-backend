----------------------------------------- ObsUserRepository -----------------------------------------
INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name)
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cdc879', 'user', 'user', 'user@mail.com',
        '$2a$10$OU9/JC80FudcjfuAj1.X5OopuhG6Trs3JHQEOHdH.Xnm7VSIpW0OC', '000000000', 4.0, 'Computer Engineering');

----------------------------------------- UserRepository -----------------------------------------
INSERT INTO users (id, name, surname, email, password, role)
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cdc871', 'admin', 'admin', 'admin@mail.com',
        '$2a$10$OU9/JC80FudcjfuAj1.X5OopuhG6Trs3JHQEOHdH.Xnm7VSIpW0OC', 'ADMIN');

----------------------------------------- FacultyRepository -----------------------------------------
INSERT INTO faculty (id, name)
VALUES ('d9254aa2-1e4e-4c16-94a8-1221c7be859a', 'Science');
INSERT INTO faculty (id, name)
VALUES ('76ef51dd-ff39-4a3d-9dfd-c26d8f07d687', 'Engineering');
INSERT INTO faculty (id, name)
VALUES ('3426ca98-7afd-481e-91e6-315046570bef', 'Architecture');

----------------------------------------- DepartmentRepository -----------------------------------------
-- Science
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Physics', 'd9254aa2-1e4e-4c16-94a8-1221c7be859a');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Photonics', 'd9254aa2-1e4e-4c16-94a8-1221c7be859a');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Chemistry', 'd9254aa2-1e4e-4c16-94a8-1221c7be859a');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Mathematics', 'd9254aa2-1e4e-4c16-94a8-1221c7be859a');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Molecular Biology and Genetics', 'd9254aa2-1e4e-4c16-94a8-1221c7be859a');

-- Engineering
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Computer Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Bioengineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Environmental Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Energy Systems Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Electrical-Electronics Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Food Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Civil Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Chemical Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Mechanical Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Materials Science and Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');

-- Architecture
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Industrial Design', '3426ca98-7afd-481e-91e6-315046570bef');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Conservation and Restoration Cultural Heritage', '3426ca98-7afd-481e-91e6-315046570bef');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Architecture', '3426ca98-7afd-481e-91e6-315046570bef');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'City and Regional Planning', '3426ca98-7afd-481e-91e6-315046570bef');
