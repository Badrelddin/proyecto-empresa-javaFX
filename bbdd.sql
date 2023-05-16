create table empleado(
	id int auto_increment, 
    nombre varchar(25) , 
    primer_apellido varchar(25), 
    segundo_apellido varchar(25),
    fecha_de_nacimiento date
);

create table equipo(
	id int auto_increment, 
    nombre varchar(25),
    miembro_del_equipo varchar(25)
);

create table test(
	id int auto_increment, 
    tipo varchar(25)
);

