SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS pokemon;
DROP TABLE IF EXISTS trainer;
DROP TABLE IF EXISTS app_user;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE trainer
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    team		VARCHAR(10) NOT NULL
);

CREATE TABLE pokemon
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    type           	VARCHAR(20),
    region          VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES trainer (id)
);

CREATE TABLE app_user
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname  VARCHAR(255) NOT NULL,
    username  VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    role      VARCHAR(255) NOT NULL
);

INSERT INTO trainer (name, team)
VALUES ('Jenrai', 'Instinct');
INSERT INTO trainer (name, team)
VALUES ('Janau', 'Valor');
INSERT INTO trainer (name, team)
VALUES ('Nenoham', 'Mystique');

INSERT INTO pokemon (name, type, region, id)
VALUES ('Eevee', 'Normal', 'Kanto', 1);

INSERT INTO pokemon (name, type, region, id)
VALUES ('Mudkip', 'Water', 'Hoenn', 2);

INSERT INTO pokemon (name, type, region, id)
VALUES ('Cyndaquil', 'Fire', 'Johto', 3);

INSERT INTO app_user (firstname, lastname, username, password, role)
VALUES ('Jenna', 'Räihä', 'admin', '$2b$10$o0liCdP9lzTgCHarj9JCdeoyWICDjRpQCYS4TP97jSnRc5tlriKPS', 'ADMIN');
INSERT INTO app_user (firstname, lastname, username, password, role)
VALUES ('Janne', 'Autio', 'admin2', '$2b$10$o0liCdP9lzTgCHarj9JCdeoyWICDjRpQCYS4TP97jSnRc5tlriKPS', 'ADMIN');


