-- ObsUserRepository
INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name)
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cdc879', 'user', 'user', 'user@mail.com',
        '$2a$10$OU9/JC80FudcjfuAj1.X5OopuhG6Trs3JHQEOHdH.Xnm7VSIpW0OC', '000000000', 4.0, 'Computer Engineering');

-- UserRepository
INSERT INTO users (id, name, surname, email, password, role)
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cdc871', 'admin', 'admin', 'admin@mail.com',
        '$2a$10$OU9/JC80FudcjfuAj1.X5OopuhG6Trs3JHQEOHdH.Xnm7VSIpW0OC', 'ADMIN');