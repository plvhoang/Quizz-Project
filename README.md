# Quizz-Project
# Lệnh tạo dữ liệu login cho DB trước khi dùng

insert into user (username, password, email) values
('quizadmin1','admin','admin1@gmail.com'),
('quizmember1','member','member1@gmail.com');

insert into app_role (role_id, role_name) values
(1, 'ROLE_ADMIN'),
(2, 'ROLE_MEMBER');

insert into user_role (id, user_id, role_id) values
(1, 1, 1),
(2, 1, 2),
(3, 2, 2);