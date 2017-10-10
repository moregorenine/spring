DROP TABLE IF EXISTS W4_USER;

CREATE TABLE W4_USER (
	user_id		int not null AUTO_INCREMENT PRIMARY KEY,
	password	varchar(12)	not null,
	email		varchar(50)
);