CREATE TABLE `USERS` (
                         `ID` int PRIMARY KEY AUTO_INCREMENT,
                         `USER_NAME` varchar(255),
                         `FULL_NAME` varchar(255),
                         `EMAIL` VARCHAR,
                         `PASSWORD` VARCHAR,
                         `USER_TYPE` VARCHAR,
                         `REGISTER_DATE` timestamp
);

CREATE TABLE `CUSTOMERS` (
                             `ID` int PRIMARY KEY AUTO_INCREMENT,
                             `USER_ID` INT
);

CREATE TABLE `ORDERS` (
                          `id` int PRIMARY KEY,
                          `user_id` int UNIQUE NOT NULL,
                          `status` varchar(255),
                          `created_at` varchar(255) COMMENT 'When order created'
);

CREATE TABLE `PRODUCTS` (
                            `ID` int PRIMARY KEY,
                            `NAME` varchar(255),
                            `DESCRIPTION` varchar(255),
                            `PRICE` int,
                            `CANT` int,
                            `created_at` datetime DEFAULT (now())
);
