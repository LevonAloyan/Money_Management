CREATE TABLE IF NOT EXISTS  admin
(id SERIAL PRIMARY KEY,
name VARCHAR(50) NOT NULL,
surname VARCHAR(50) NOT NULL,
phone_number VARCHAR(50) NOT NULL);

INSERT INTO admin (name, surname, phone_number)
VALUES ('Benedict', 'Cumberbatch', '+37433333333');