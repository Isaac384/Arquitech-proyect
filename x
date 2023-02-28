create database isaacdb;
use isaacdb;
create table alumno(id int primary key auto_increment, mensaje varchar(50));

DELIMITER $$
CREATE PROCEDURE sp_cre_isaacbd(in Mensaje Varchar(50))
BEGIN
insert into alumno(msg) values (Mensaje);
END$$

DELIMITER $$
CREATE PROCEDURE sp_upd_isaacbd(in id int, in Mensaje Varchar(50))
BEGIN
UPDATE alumno SET msg = Mensahe where id = num;
END$$

DELIMITER $$
CREATE PROCEDURE sp_del_isaacbd(in id Varchar(50))
BEGIN
DELETE FROM alumno WHERE id = num;
END$$

CREATE VIEW vc_tab AS
SELECT * FROM alumno