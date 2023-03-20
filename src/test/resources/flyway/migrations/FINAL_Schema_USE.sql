USE dress;
DROP TABLE IF EXISTS color_options;
DROP TABLE IF EXISTS color;
DROP TABLE IF EXISTS dress;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
  customer_pk int NOT NULL AUTO_INCREMENT,
  customer_id varchar(40) NOT NULL,
  first_name varchar(45) NOT NULL, 
  last_name varchar(45) NOT NULL,
  PRIMARY KEY (customer_pk)
);


CREATE TABLE dress (
  dress_pk int unsigned NOT NULL AUTO_INCREMENT,
  dress_id varchar(30) NOT NULL,
  dress_style varchar(60) NOT NULL,
  price decimal(9, 2) NOT NULL,
  customer_fk int NOT NULL,
  FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE,
  PRIMARY KEY (dress_pk)
);

CREATE TABLE color (
color_pk int NOT NULL AUTO_INCREMENT,
color_name varchar(60) NOT NULL,
color_id varchar(30) NOT NULL,
PRIMARY KEY (color_pk)
);

CREATE TABLE color_options (
  color_fk int NOT NULL,
  dress_fk int unsigned NOT NULL,
  FOREIGN KEY (color_fk) REFERENCES color (color_pk) ON DELETE CASCADE,
  FOREIGN KEY (dress_fk) REFERENCES dress (dress_pk) ON DELETE CASCADE
);
