create database bd_examen_lpii_pc1;

use bd_examen_lpii_pc1;

create table tb_estudiante(
codigo           smallint not null auto_increment,
nombre_apellido	 varchar(30),	
correo           varchar(30),
fecha_nacimineto            char(10),
tarjeta_credito	 char(16),
dni		           varchar(30),
sexo            char(1),
pais	           varchar(30),
pasaporte		     char(12),
PRIMARY KEY (codigo)
);

insert into tb_estudiante values(null,'Elba Flores','eflores@gmail.coms','2000-10-10','8754875487548778','87548754','M','Perú','785487548754');



create table tb_distrito(
cod_dis      smallint not null auto_increment,
nom_dis		 varchar(30),	
PRIMARY KEY (cod_dis)
);
insert into tb_distrito values(null,'San Isidro');
insert into tb_distrito values(null,'Miraflores');
insert into tb_distrito values(null,'Lince');


create table tb_estado_civil(
cod_est      smallint not null auto_increment,
nom_est		 varchar(30),	
PRIMARY KEY (cod_est)
);

insert into tb_estado_civil values(null,'Soltero');
insert into tb_estado_civil values(null,'Casado');
insert into tb_estado_civil values(null,'Viudo');
insert into tb_estado_civil values(null,'Divorciado');

create table tb_vendedor(
cod_ven      smallint not null auto_increment,
nom_ven		 varchar(30),	
ape_ven      varchar(30),
eda_ven      smallint,
fec_nac_ven	 date,
cod_est		 smallint,
cod_dis		 smallint,
PRIMARY KEY (cod_ven),
foreign key (cod_est) references tb_estado_civil(cod_est),
foreign key (cod_dis) references tb_distrito(cod_dis)
);

insert into tb_vendedor values(null,'Jorge','Arcos',15,'1979-10-10',1,1);
insert into tb_vendedor values(null,'Maria','Gutarra',25,'1940-02-20',2,2);
insert into tb_vendedor values(null,'Patricia','Vivas',28,'1980-05-15',2,1);
insert into tb_vendedor values(null,'Wendy','Camarena',30,'1974-12-23',3,2);
insert into tb_vendedor values(null,'Milagros','Jacinto',31,'1975-04-17',3,3);
insert into tb_vendedor values(null,'Pablo','Milanes',22,'1979-03-24',2,3);

create table tb_categoria(
cod_cat      smallint not null auto_increment,
nom_cat		 varchar(30),	
PRIMARY KEY (cod_cat)
);

insert into tb_categoria values(null,'Oficina');
insert into tb_categoria values(null,'Informatica');
insert into tb_categoria values(null,'Laboratorio');

create table tb_producto(
cod_pro      smallint not null auto_increment,
nom_pro      varchar(30),
pre_pro      real,
stk_pro 	 int,
cod_cat      smallint,
fec_reg_pro	 date,
PRIMARY KEY (cod_pro),
foreign key (cod_cat) references tb_categoria(cod_cat)
);

insert into tb_producto values(null,'Hojas Bulki',10,30,1,'2007-03-01'); 
insert into tb_producto values(null,'Teclado',200.5,15,2,'2007-03-09'); 
insert into tb_producto values(null,'Lapiceros Faber Castell',20.5,35,1,'2007-03-15'); 
insert into tb_producto values(null,'Mouse',30.5,50,2,'2007-03-20'); 
insert into tb_producto values(null,'Perforador',50,40,1,'2007-03-01'); 
insert into tb_producto values(null,'Camaras',25,35,2,'2007-03-09'); 
insert into tb_producto values(null,'Plumones',60,35,1,'2007-03-15'); 
insert into tb_producto values(null,'Memorias',150,47,2,'2007-03-20'); 
insert into tb_producto values(null,'Hojas Bond',10.5,69,1,'2007-03-01'); 
insert into tb_producto values(null,'Disco Duro',300,70,2,'2007-03-09'); 
insert into tb_producto values(null,'Cuadernos',25,78,1,'2007-03-15'); 
insert into tb_producto values(null,'Microprocesadores',500,90,2,'2007-03-20'); 


create table tb_sede(
cod_sed      smallint not null auto_increment,
nom_sed		 varchar(30),	
dir_sed      varchar(30),
fec_ina_sed  date,
ger_sed		 varchar(30),
cod_dis		 smallint,
PRIMARY KEY (cod_sed),
foreign key (cod_dis) references tb_distrito(cod_dis)
);

insert into tb_sede values(null,'Crisol Magdalena 1','Av. Magdalena 124','2000-05-10','Juan Perez',1);
insert into tb_sede values(null,'Crisol Magdalena 2','Av. Magdalena 542','2000-05-10','Ana Quispe',2);
insert into tb_sede values(null,'Crisol Lince','Av. Lince 345','1999-10-10','Felipe Len',1);
insert into tb_sede values(null,'Crisol Miraflores','Av. Miraflores 124','1998-10-10','Javier Astupillo',2);
insert into tb_sede values(null,'Crisol San Isidro','Av. ChinChon 124','2000-10-10','Fernado Salcedo',3);