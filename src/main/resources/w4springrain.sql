DROP TABLE IF EXISTS W4_USER;

CREATE TABLE W4_USER (
	userId		varchar(12) not null,
	password	varchar(12)	not null,
	name		varchar(20)	not null,
	email		varchar(50),
	
	PRIMARY KEY(userId)
);

INSERT INTO W4_USER VALUES('admin', 'gkswlstjr81', 'admin', 'w4springrain@gmail.com');