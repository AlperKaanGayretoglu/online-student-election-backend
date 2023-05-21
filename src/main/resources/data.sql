---------------------------------------------------------------------------------- FacultyRepository ----------------------------------------------------------------------------------
INSERT INTO faculty (id, name)
VALUES ('d9254aa2-1e4e-4c16-94a8-1221c7be859a', 'Science');
INSERT INTO faculty (id, name)
VALUES ('76ef51dd-ff39-4a3d-9dfd-c26d8f07d687', 'Engineering');
INSERT INTO faculty (id, name)
VALUES ('3426ca98-7afd-481e-91e6-315046570bef', 'Architecture');

---------------------------------------------------------------------------------- DepartmentRepository ----------------------------------------------------------------------------------
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
VALUES ('5b8a3d25-2a7a-4683-89ed-ac0e42cdc879', 'Computer Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
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
VALUES ('5b8a3d25-2a7a-4683-89ed-ac0e42cdc987', 'Chemical Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
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

---------------------------------------------------------------------------------- EdevletUserRepository ----------------------------------------------------------------------------------
INSERT INTO edevlet_user (id, tc_no, name, surname, is_member_ofapolitical_party_organ, hasacriminal_record, -- USER
                          is_affiliated_withabad_organization)
VALUES (gen_random_uuid(), '00000000000', 'USER', 'USER', false, false, false);

INSERT INTO edevlet_user (id, tc_no, name, surname, is_member_ofapolitical_party_organ, hasacriminal_record,
                          is_affiliated_withabad_organization)
VALUES (gen_random_uuid(), '00000000001', 'Tuğçe', 'Türkmenler', false, false, false);

INSERT INTO edevlet_user (id, tc_no, name, surname, is_member_ofapolitical_party_organ, hasacriminal_record,
                          is_affiliated_withabad_organization)
VALUES (gen_random_uuid(), '00000000002', 'Kerem Yavuz', 'Şenyurt', false, false, false);

INSERT INTO edevlet_user (id, tc_no, name, surname, is_member_ofapolitical_party_organ, hasacriminal_record,
                          is_affiliated_withabad_organization)
VALUES (gen_random_uuid(), '00000000003', 'Aylin', 'Kocaman', false, false, false);

INSERT INTO edevlet_user (id, tc_no, name, surname, is_member_ofapolitical_party_organ, hasacriminal_record,
                          is_affiliated_withabad_organization)
VALUES (gen_random_uuid(), '00000000004', 'Ali', 'Kaya', false, false, false);

---------------------------------------------------------------------------------- ObsUserRepository ----------------------------------------------------------------------------------
INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name) -- USER
VALUES (gen_random_uuid(), 'USER', 'USER', 'user@mail.com',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '000000000', 4.0, 'Computer Engineering');

INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name)
VALUES (gen_random_uuid(), 'Tuğçe', 'Türkmenler', 'tugceturkmenler@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '000000001', 4.0, 'Computer Engineering');

INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name)
VALUES (gen_random_uuid(), 'Kerem Yavuz', 'Şenyurt', 'keremsenyurt@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '000000002', 4.0, 'Computer Engineering');

INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name)
VALUES (gen_random_uuid(), 'Aylin', 'Kocaman', 'aylinkocaman@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '000000003', 4.0, 'Chemical Engineering');

INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name)
VALUES (gen_random_uuid(), 'Ali', 'Kaya', 'alikaya@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '000000004', 4.0, 'Chemical Engineering');

---------------------------------------------------------------------------------- UserRepository ----------------------------------------------------------------------------------
INSERT INTO users (id, name, surname, email, password, role) -- ADMIN
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cdc871', 'ADMIN', 'ADMIN', 'admin@mail.com',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'ADMIN');

INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id)
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cdc878', 'Tuğçe', 'Türkmenler', 'tugceturkmenler@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'REPRESENTATIVE', '00000000001', '000000001',
        4.0, '5b8a3d25-2a7a-4683-89ed-ac0e42cdc879');

INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id)
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cdc879', 'Kerem Yavuz', 'Şenyurt', 'keremsenyurt@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'VOTER', '00000000002', '000000002', 4.0,
        '5b8a3d25-2a7a-4683-89ed-ac0e42cdc879');

INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id)
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cac878', 'Aylin', 'Kocaman', 'aylinkocaman@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'CANDIDATE', '00000000003', '000000003',
        4.0, '5b8a3d25-2a7a-4683-89ed-ac0e42cdc987');

INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id)
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cac879', 'Ali', 'Kaya', 'alikaya@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'CANDIDATE', '00000000004', '000000004', 4.0,
        '5b8a3d25-2a7a-4683-89ed-ac0e42cdc987');

---------------------------------------------------------------------------------- ElectionRepository ----------------------------------------------------------------------------------
INSERT INTO election (id, name, department_id, term, year, start_date, end_date,
                      is_finished, winner_id) -- FINISHED ELECTION
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc800',
        '2022-2023 Spring | Computer Engineering Department Representative Election',
        '5b8a3d25-2a7a-4683-89ed-ac0e42cdc879', 1, 2023, '2023-5-14', '2023-5-15',
        true, '5b8a3d25-2b7a-4683-89ed-ac0e42cdc878');

INSERT INTO election (id, name, department_id, term, year, start_date, end_date,
                      is_finished, winner_id) -- ONGOING ELECTION
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc801',
        '2022-2023 Spring | Chemical Engineering Department Representative Election',
        '5b8a3d25-2a7a-4683-89ed-ac0e42cdc987', 1, 2023, '2023-5-14', '2023-7-20',
        false, null);

---------------------------------------------------------------------------------- Candidates of Election ----------------------------------------------------------------------------------
-- '2022-2023 Spring | Computer Engineering Department Representative Election' (FINISHED)
INSERT INTO election_candidates (election_id, candidates_id)
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc800', '5b8a3d25-2b7a-4683-89ed-ac0e42cdc878');

-- '2022-2023 Spring | Chemical Engineering Department Representative Election' (ONGOING)
INSERT INTO election_candidates (election_id, candidates_id)
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc801', '5b8a3d25-2b7a-4683-89ed-ac0e42cac878');

INSERT INTO election_candidates (election_id, candidates_id)
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc801', '5b8a3d25-2b7a-4683-89ed-ac0e42cac879');

---------------------------------------------------------------------------------- Vote ----------------------------------------------------------------------------------
INSERT INTO vote (id, voter_id, for_election_id, for_candidate_id, date_time)
VALUES ('5baaaa25-2b7a-4683-89ab-ac0e42cdc800', '5b8a3d25-2b7a-4683-89ed-ac0e42cdc878',
        '5b8a3d25-2b7a-4683-89ab-ac0e42cdc800', '5b8a3d25-2b7a-4683-89ed-ac0e42cdc878', '2023-5-14:12:00:00');

---------------------------------------------------------------------------------- Votes of Election ----------------------------------------------------------------------------------
INSERT INTO election_votes (election_id, votes_id)
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc800', '5baaaa25-2b7a-4683-89ab-ac0e42cdc800');
