use quizdb;

-- Insert user table
insert into quizdb.user(username, password, email) 
values 
	('admin1','admin1','admin1@gmail.com'), 
	('member1','member1','member1@gmail.com'),
    ('member2','member2','member2gmail.com'),
    ('member3','member3','member3gmail.com'),
    ('member4','member4','member4gmail.com'),
    ('member5','member5','member5gmail.com')
;

-- Insert app_role table
insert into quizdb.app_role(role_id, role_name)
values
	(1, 'ROLE_ADMIN'), 
    (2, 'ROLE_MEMBER')
;

-- Insert user_role table
insert into quizdb.user_role (id, user_id, role_id) 
values 
	(1, 1, 1), 
    (2, 1, 2), 
    (3, 2, 2),
    (4, 3, 2),
    (5, 4, 2),
    (6, 5, 2),
    (7, 6, 2)
;

-- Insert quiz table
insert into quizdb.quiz(host_id, title, score, starts_at, ends_at, content)
values 
	(1, 'Quiz 1', 100, '2021-08-27 08:00:00', '2021-08-27 08:30:00', 'Chapter 1 Test'),
    (1, 'Quiz 2', 100, '2021-09-03 08:00:00', '2021-09-03 08:30:00', 'Chapter 2 Test')
;

-- Insert question table
insert into quizdb.question(quiz_id, type, score, content)
values 
	(1, 'Default', 25, '1 + 2 = ?'),
    (1, 'Default', 25, '3 - 2 = ?'),
    (1, 'Default', 25, '3 * 4 = ?'),
    (1, 'Default', 25, '6 / 2 = ?'),
    (2, 'Default', 25, 'Ai đẹp nhất vậy quý dị?'),
    (2, 'Default', 25, 'Con vịt có mấy chân?'),
    (2, 'Default', 25, 'Tại sao năm nay phải thi online?'),
    (2, 'Default', 25, '27/08/2021 là ngày gì?')
;

-- Insert answer table
insert into quizdb.answer(quiz_id, question_id, content, correct)
values 
	(1, 1, '0', 0), (1, 1, '3', 1), (1, 1, '1', 0), (1, 1, '2', 0),
    (1, 2, '-1', 0), (1, 2, '6', 0), (1, 2, '1', 1), (1, 2, '5', 0),
    (1, 3, '12', 1), (1, 3, '7', 0), (1, 3, '1', 0), (1, 3, '-1', 0),
    (1, 4, '8', 0), (1, 4, '12', 0), (1, 4, '4', 0), (1, 4, '3', 1),
    (2, 1, 'Phương Hằng Tui', 1), (2, 1, 'Anh Bốn', 0), (2, 1, 'Thần Y', 0), (2, 1, 'Mít Tơ Đờm', 0),
    (2, 2, '1', 0), (2, 2, '2', 1), (2, 2, '3', 0), (2, 2, '4', 0),
    (2, 3, 'Do Bão', 0), (2, 3, 'Do Lũ', 0), (2, 3, 'Do Lốc', 0), (2, 3, 'Do COVID-19', 1),
    (2, 4, 'Tân Gia', 0), (2, 4, 'Tổng kết thực tập', 0), (2, 4, 'Báo cáo demo thực tập', 1), (2, 4, 'Nghỉ lễ', 0)
;

-- Insert take table
insert into quizdb.take(user_id, quiz_id, score, starts_at, ends_at)
values 
	(2, 1, 75, '2021-08-27 08:00:00', '2021-08-27 08:30:00'),
    (5, 1, 25, '2021-08-27 08:00:00', '2021-08-27 08:30:00'),
    (3, 1, 100, '2021-08-27 08:00:00', '2021-08-27 08:30:00'),
    (3, 2, 50, '2021-09-03 08:00:00', '2021-09-03 08:30:00'),
    (2, 2, 100, '2021-09-03 08:00:00', '2021-09-03 08:30:00'),
    (4, 2, 25, '2021-09-03 08:00:00', '2021-09-03 08:30:00'),
    (5, 2, 75, '2021-09-03 08:00:00', '2021-09-03 08:30:00')
;

-- Insert take_answer table
insert into quizdb.take_answer(take_id, question_id, answer_id)
values 
	(1, 1, 2), (1, 2, 6), (1, 3, 9), (1, 4, 16),
    (2, 1, 1), (2, 2, 6), (2, 3, 12), (2, 4, 15),
    (3, 1, 2), (3, 2, 7), (3, 3, 12), (3, 4, 16),
    (4, 5, 17), (4, 6, 21), (4, 7, 28), (4, 8, 30),
    (5, 5, 17), (5, 6, 22), (5, 7, 28), (5, 8, 31),
    (6, 5, 20), (6, 6, 22), (6, 7, 25), (6, 8, 32),
    (6, 5, 17), (6, 6, 22), (6, 7, 25), (6, 8, 32)
;
    