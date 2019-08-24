create table role(
   role_id int NOT NULL AUTO_INCREMENT,
   role_name VARCHAR(12) NOT NULL,
   PRIMARY KEY (role_id)
);
insert into role (role_name) values('student'),('owner');

create table property_type(
   property_id int NOT NULL AUTO_INCREMENT,
   property_type VARCHAR(20) NOT NULL,
   PRIMARY KEY (property_id)
);
insert into property_type (property_type) values('A'),('B');

create table user(
   user_id int NOT NULL AUTO_INCREMENT,
   email VARCHAR(255) NOT NULL UNIQUE,
   password VARCHAR(32) NOT NULL,
   first_name VARCHAR(20) NOT NULL,
   last_name VARCHAR(20) NOT NULL,
   address VARCHAR(255) NOT NULL,
   telephone_number VARCHAR(10) NOT NULL,
   role_id int NOT NULL,
   student_id VARCHAR(20) NOT NULL,
   in_rent BOOLEAN,
   is_active BOOLEAN,
   PRIMARY KEY (user_id)
);

create table property(
   property_id int NOT NULL AUTO_INCREMENT,
   user_id int NOT NULL,
   address VARCHAR(255) NOT NULL,
   property_type VARCHAR(20) NOT NULL,
   tenants int NOT NULL,
   image LONGBLOB NOT NULL,
   amount int NOT NULL,
   is_available BOOLEAN,
   PRIMARY KEY (property_id),
   FOREIGN KEY (user_id)
   REFERENCES user (user_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

create table booking(
   booking_id int NOT NULL AUTO_INCREMENT,
   property_id int NOT NULL,
   user_id int NOT NULL,
   PRIMARY KEY (booking_id)
);
