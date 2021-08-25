# Phần login Quizz-Project

**Các lệnh thêm dữ liệu vào DB**
(do mode hiện tại của app luôn tạo và xóa các bảng trong DB khi run/stop app)

ALTER TABLE user AUTO_INCREMENT = 1;

insert into user (username, password, email) values
('quizadmin1','$2a$12$B/rSZsKP4HE/uCYrgGsVZOYTEMWS6tnjpeVHez.LTS.9mSSG7/9Qa','admin1@gmail.com'),
('quizmember1','$2a$12$B/rSZsKP4HE/uCYrgGsVZOYTEMWS6tnjpeVHez.LTS.9mSSG7/9Qa','member1@gmail.com');

insert into app_role (role_id, role_name) values
(1, 'ROLE_ADMIN'),
(2, 'ROLE_MEMBER');

insert into user_role (id, user_id, role_id) values
(1, 1, 1),
(2, 1, 2),
(3, 2, 2);


** Thay đổi trong file application.properties **

 Tắt # server.servlet.context-path=/quiz-test

 spring.datasource.password=admin (gốc là 1234)