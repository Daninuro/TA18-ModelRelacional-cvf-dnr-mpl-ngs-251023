package Act2;

import Conexion.Mysql_conect;


public class Act2App
{
	
	public static void main(String[] args) 
	{
		
		Mysql_conect conect = new Mysql_conect();
		conect.connect("localhost", "33060", "root", "password");
		conect.createDB("Ud18_Ej2");
		conect.useDB("Ud18_Ej2");

		conect.createTable("create table if not exists departamento ("	+
									"codigo int primary key not null, "			+
								    "nombre nvarchar(100), "					+
								    "presupuesto int )"
								);

		conect.createTable("create table if not exists empleado ("													+
									"dni varchar(8) primary key not null, "													+
								    "nombre nvarchar(100), "																+
								    "apellidos nvarchar(255), "																+
								    "departamento int, "																	+
								    "constraint fk_departamento foreign key(departamento) references departamento(codigo)) "
								);
			
		conect.insertData("insert into departamento(codigo, nombre, presupuesto) values (1, 'Finanzas', 50,000)");
		conect.insertData("insert into departamento(codigo, nombre, presupuesto) values (2, 'Recursos Humanos', 80,000)");
		conect.insertData("insert into departamento(codigo, nombre, presupuesto) values (3, 'Marketing', 100,000)");
		conect.insertData("insert into departamento(codigo, nombre, presupuesto) values (4, 'Logistica', 50,000)");
		conect.insertData("insert into departamento(codigo, nombre, presupuesto) values (5, 'Directivo', 30,000)");
		
		conect.insertData("INSERT INTO empleado(dni, nombre, apellidos, departamento) VALUES ('12345678A', 'Juan', 'Pérez García', 'Recursos Humanos')");
		conect.insertData("INSERT INTO empleado(dni, nombre, apellidos, departamento) VALUES ('45678901C', 'Carlos', 'González Rodríguez', 'Finanzas')");
		conect.insertData("INSERT INTO empleado(dni, nombre, apellidos, departamento) VALUES ('98765432B', 'María', 'López Fernández', 'Marketing')");
		conect.insertData("INSERT INTO empleado(dni, nombre, apellidos, departamento) VALUES ('23456789D', 'Laura', 'Sánchez Pérez', 'Logistica')");
		conect.insertData("INSERT INTO empleado(dni, nombre, apellidos, departamento) VALUES ('34567890E', 'Javier', 'Martínez Sánchez', 'Directivo')");
		
		conect.closeConnection();
		System.out.println("FIN");

	}
	
}
