use emociones_db;
create table equipo(
	id int auto_increment primary key, 
    nombre varchar(25),
    miembro_del_equipo varchar(25)
);

create table empleado(
	id int auto_increment  primary key, 
    nombre varchar(25) , 
    apellidos varchar(50),
    email varchar(75),
    password varchar(50),
    es_jefe bool default false,
    id_equipo int default 1,
    foreign key (id_equipo) references equipo(id) on delete cascade, 
    fecha_nacimiento date
);

create table test(
	id int auto_increment primary key, 
    tipo varchar(25)
);

create table testEquipo(
	id int auto_increment primary key, 
    id_test int,
    FOREIGN KEY (id_test) references test(id) on delete cascade,
    respuesta1 varchar(25),
	respuesta2 varchar(25),
    sobra varchar(25) default "Nadie"
);

create table testLider(
	id int auto_increment primary key, 
        id_test int,
    FOREIGN KEY (id_test) references test(id) on delete cascade,
    evalua float
);

create table testEstadoAnimico(
	id int auto_increment primary key, 
        id_test int,
            id_empleado int,
    FOREIGN KEY (id_test) references test(id) on delete cascade,
	FOREIGN KEY (id_empleado) references empleado(id) on delete cascade,
	
    sentimiento1 varchar(25),
    sentimiento2 varchar(25),
    sentimiento3 varchar(25),
    sentimiento4 varchar(25),
    fecha_realizado datetime
);



