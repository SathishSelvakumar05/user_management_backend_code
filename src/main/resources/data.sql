INSERT INTO roles (name) VALUES ('ROLE_USER'), ('ROLE_ADMIN'), ('ROLE_SUPER_ADMIN');

INSERT INTO users (username, password, is_active) VALUES
('superadmin', '$2a$10$xyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyz', true);

INSERT INTO user_roles (user_id, role_id) VALUES (1, 3);
