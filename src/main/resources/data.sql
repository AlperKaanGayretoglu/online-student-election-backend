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
VALUES ('5b8a3d25-2a7a-4683-89ed-ac0e42cdc123', 'Bioengineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'Environmental Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
INSERT INTO department (id, name, faculty_id)
VALUES ('5b8b3d25-2a7a-4683-89ed-ac0e42cdc911', 'Energy Systems Engineering', '76ef51dd-ff39-4a3d-9dfd-c26d8f07d687');
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
VALUES (gen_random_uuid(), 'Architecture', '3426ca98-7afd-481e-91e6-315046570bef');
INSERT INTO department (id, name, faculty_id)
VALUES (gen_random_uuid(), 'City and Regional Planning', '3426ca98-7afd-481e-91e6-315046570bef');

---------------------------------------------------------------------------------- EdevletUserRepository ----------------------------------------------------------------------------------
INSERT INTO edevlet_user (id, tc_no, name, surname, is_member_ofapolitical_party_organ, hasacriminal_record,
                          is_affiliated_withabad_organization)
VALUES (gen_random_uuid(), '00000000000', 'Efe', 'İncir', false, false, false);

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

INSERT INTO edevlet_user (id, tc_no, name, surname, is_member_ofapolitical_party_organ, hasacriminal_record,
                          is_affiliated_withabad_organization)
VALUES (gen_random_uuid(), '00000000005', 'Ahmet', 'Altın', false, false, false);

INSERT INTO edevlet_user (id, tc_no, name, surname, is_member_ofapolitical_party_organ, hasacriminal_record,
                          is_affiliated_withabad_organization)
VALUES (gen_random_uuid(), '00000000006', 'Mahmut', 'Gümüş', true, true, true);

INSERT INTO edevlet_user (id, tc_no, name, surname, is_member_ofapolitical_party_organ, hasacriminal_record,
                          is_affiliated_withabad_organization)
VALUES (gen_random_uuid(), '00000000007', 'Murat', 'Bronz', false, false, false);

INSERT INTO edevlet_user (id, tc_no, name, surname, is_member_ofapolitical_party_organ, hasacriminal_record,
                          is_affiliated_withabad_organization)
VALUES (gen_random_uuid(), '00000000008', 'Melis', 'Elmas', false, false, false);

---------------------------------------------------------------------------------- ObsUserRepository ----------------------------------------------------------------------------------
INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name, tc_no)
VALUES (gen_random_uuid(), 'Efe', 'İncir', 'efeincir@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '280201097', 4.0, 'Computer Engineering',
        '00000000000');

INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name, tc_no)
VALUES (gen_random_uuid(), 'Tuğçe', 'Türkmenler', 'tugceturkmenler@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '290201097', 4.0, 'Computer Engineering',
        '00000000001');

INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name, tc_no)
VALUES (gen_random_uuid(), 'Kerem Yavuz', 'Şenyurt', 'keremsenyurt@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '290201100', 4.0, 'Computer Engineering',
        '00000000002');

INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name, tc_no)
VALUES (gen_random_uuid(), 'Aylin', 'Kocaman', 'aylinkocaman@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '000000003', 4.0, 'Chemical Engineering',
        '00000000003');

INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name, tc_no)
VALUES (gen_random_uuid(), 'Ali', 'Kaya', 'alikaya@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '000000004', 4.0, 'Chemical Engineering',
        '00000000004');

INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name, tc_no)
VALUES (gen_random_uuid(), 'Ahmet', 'Altın', 'ahmetaltin@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '000000005', 3.5, 'Energy Systems Engineering',
        '00000000005');

INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name, tc_no)
VALUES (gen_random_uuid(), 'Mahmut', 'Gümüş', 'mahmutgumus@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '000000006', 3.0, 'Energy Systems Engineering',
        '00000000006');

INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name, tc_no)
VALUES (gen_random_uuid(), 'Murat', 'Bronz', 'muratbronz@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '000000007', 3.0, 'Bioengineering',
        '00000000007');

INSERT INTO obs_user (id, name, surname, email, password, student_no, gpa, department_name, tc_no)
VALUES (gen_random_uuid(), 'Melis', 'Elmas', 'muratbronz@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', '000000008', 3.0, 'Energy Systems Engineering',
        '00000000008');

---------------------------------------------------------------------------------- UserRepository ----------------------------------------------------------------------------------
INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id) -- ADMIN
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cdc871', 'Efe', 'İncir', 'efeincir@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'ADMIN', '00000000000', '280201097',
        4.0, '5b8a3d25-2a7a-4683-89ed-ac0e42cdc879');

INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id)
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cdc878', 'Tuğçe', 'Türkmenler', 'tugceturkmenler@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'REPRESENTATIVE', '00000000001', '290201097',
        4.0, '5b8a3d25-2a7a-4683-89ed-ac0e42cdc879');

INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id)
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cdc879', 'Kerem Yavuz', 'Şenyurt', 'keremsenyurt@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'VOTER', '00000000002', '290201100', 4.0,
        '5b8a3d25-2a7a-4683-89ed-ac0e42cdc879');

INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id)
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cac878', 'Aylin', 'Kocaman', 'aylinkocaman@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'CANDIDATE', '00000000003', '000000003',
        4.0, '5b8a3d25-2a7a-4683-89ed-ac0e42cdc987');

INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id)
VALUES ('5b8a3d25-2b7a-4683-89ed-ac0e42cac879', 'Ali', 'Kaya', 'alikaya@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'CANDIDATE', '00000000004', '000000004', 4.0,
        '5b8a3d25-2a7a-4683-89ed-ac0e42cdc987');

INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id)
VALUES ('6b8a3d25-2b7a-4683-89ed-ac0e42cac900', 'Ahmet', 'Altın', 'ahmetaltin@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'VOTER', '00000000005', '000000005', 3.5,
        '5b8b3d25-2a7a-4683-89ed-ac0e42cdc911');

INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id)
VALUES ('7b8a3d25-2b7a-4683-89ed-ac0e42cac901', 'Mahmut', 'Gümüş', 'mahmutgumus@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'VOTER', '00000000006', '000000006', 3.0,
        '5b8b3d25-2a7a-4683-89ed-ac0e42cdc911');

INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id)
VALUES ('7b8a3d25-2b7a-4683-89ed-ac0e42cac914', 'Murat', 'Bronz', 'muratbronz@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'CANDIDATE', '00000000007', '000000007', 3.0,
        '5b8a3d25-2a7a-4683-89ed-ac0e42cdc123');

INSERT INTO users (id, name, surname, email, password, role, tc_no, student_no, gpa, department_id)
VALUES ('7b8a3d25-2b7a-4683-89ed-ac0e42cac915', 'Melis', 'Elmas', 'meliselmas@std.iyte.edu.tr',
        '$2a$10$0O6EQhphylcVjjrcu0OTMehTmHZsOdJhgxfCofE3CYWO8zOjN8eg2', 'CANDIDATE', '00000000008', '000000008', 3.0,
        '5b8b3d25-2a7a-4683-89ed-ac0e42cdc911');

---------------------------------------------------------------------------------- ElectionRepository ----------------------------------------------------------------------------------
INSERT INTO election (id, name, department_id, term, year, start_date, end_date,
                      is_finished, winner_id) -- FINISHED ELECTION
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc800',
        '2022-2023 SPRING | Computer Engineering Department Representative Election',
        '5b8a3d25-2a7a-4683-89ed-ac0e42cdc879', 0, 2022, '2023-5-14', '2023-5-15',
        true, '5b8a3d25-2b7a-4683-89ed-ac0e42cdc878');

INSERT INTO election (id, name, department_id, term, year, start_date, end_date,
                      is_finished, winner_id) -- ONGOING ELECTION
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc801',
        '2022-2023 SPRING | Chemical Engineering Department Representative Election',
        '5b8a3d25-2a7a-4683-89ed-ac0e42cdc987', 0, 2022, '2023-5-14', '2023-7-20',
        false, null);

INSERT INTO election (id, name, department_id, term, year, start_date, end_date,
                      is_finished, winner_id) -- ONGOING ELECTION
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc834',
        '2022-2023 SPRING | Bioengineering Department Representative Election',
        '5b8a3d25-2a7a-4683-89ed-ac0e42cdc123', 0, 2022, '2023-5-14', '2023-7-20',
        false, null);

INSERT INTO election (id, name, department_id, term, year, start_date, end_date,
                      is_finished, winner_id) -- NOT STARTED ELECTION
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc802',
        '2022-2023 SPRING | Energy Systems Engineering Department Representative Election',
        '5b8b3d25-2a7a-4683-89ed-ac0e42cdc911', 0, 2022, '2023-7-03', '2023-7-04',
        false, null);

---------------------------------------------------------------------------------- Candidates of Election ----------------------------------------------------------------------------------
-- '2022-2023 SPRING | Computer Engineering Department Representative Election' (FINISHED)
INSERT INTO election_candidates (election_id, candidates_id)
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc800', '5b8a3d25-2b7a-4683-89ed-ac0e42cdc878');

-- '2022-2023 SPRING | Chemical Engineering Department Representative Election' (ONGOING)
INSERT INTO election_candidates (election_id, candidates_id)
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc801', '5b8a3d25-2b7a-4683-89ed-ac0e42cac878');

INSERT INTO election_candidates (election_id, candidates_id)
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc801', '5b8a3d25-2b7a-4683-89ed-ac0e42cac879');

-- '2022-2023 SPRING | Bioengineering Department Representative Election' (ONGOING)
INSERT INTO election_candidates (election_id, candidates_id)
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc834', '7b8a3d25-2b7a-4683-89ed-ac0e42cac914');

-- '2022-2023 SPRING | Energy Systems Engineering Department Representative Election' (NOT STARTED)
INSERT INTO election_candidates (election_id, candidates_id)
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc802', '7b8a3d25-2b7a-4683-89ed-ac0e42cac915');

---------------------------------------------------------------------------------- Vote ----------------------------------------------------------------------------------
INSERT INTO vote (id, voter_id, for_election_id, for_candidate_id, date_time)
VALUES ('5baaaa25-2b7a-4683-89ab-ac0e42cdc800', '5b8a3d25-2b7a-4683-89ed-ac0e42cdc878',
        '5b8a3d25-2b7a-4683-89ab-ac0e42cdc800', '5b8a3d25-2b7a-4683-89ed-ac0e42cdc878', '2023-5-14:12:00:00');

INSERT INTO vote (id, voter_id, for_election_id, for_candidate_id, date_time)
VALUES ('5baaaa25-2b7a-4683-89ab-ac0e42cdc801', '5b8a3d25-2b7a-4683-89ed-ac0e42cdc878',
        '5b8a3d25-2b7a-4683-89ab-ac0e42cdc801', '5b8a3d25-2b7a-4683-89ed-ac0e42cac878', '2023-5-15:12:00:00');

---------------------------------------------------------------------------------- Votes of Election ----------------------------------------------------------------------------------
INSERT INTO election_votes (election_id, votes_id)
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc800', '5baaaa25-2b7a-4683-89ab-ac0e42cdc800');

INSERT INTO election_votes (election_id, votes_id)
VALUES ('5b8a3d25-2b7a-4683-89ab-ac0e42cdc801', '5baaaa25-2b7a-4683-89ab-ac0e42cdc801');

---------------------------------------------------------------------------------- Join Representative to Department ----------------------------------------------------------------------------------
UPDATE department
SET representative_id = '5b8a3d25-2b7a-4683-89ed-ac0e42cdc878'
WHERE id = '5b8a3d25-2a7a-4683-89ed-ac0e42cdc879';