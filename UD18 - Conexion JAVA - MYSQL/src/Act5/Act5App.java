package Act5;

import Conexion.Mysql_conect;

public class Act5App 
{
	
	public static void main(String[] args) 
	{
		
		Mysql_conect conect = new Mysql_conect();

		conect.connect("localhost", "33060", "root", "password");
		conect.createDB("Ud18_Ej5");
		conect.useDB("Ud18_Ej5");

		conect.createTable("create table if not exists despacho(numero int, capacidad int, "
				+ "primary key (numero));");
		
		conect.createTable("create table if not exists directores(dni varchar(8), nom_apels varchar(100),"
				+ " dni_jefe varchar(8), despacho int, primary key (dni), foreign key (despacho) references "
				+ "despacho (numero), foreign key (dni_jefe) references directores (dni));");
		
		conect.insertData("insert into despacho values(1, 80);");
		conect.insertData("insert into despacho values(2, 50);");
		conect.insertData("insert into despacho values(3, 30);");
		conect.insertData("insert into despacho values(4, 70);");
		conect.insertData("insert into despacho values(5, 90);");
		
		conect.insertData("insert into directores values('48003310', 'María García', null, 1);");
		conect.insertData("insert into directores values('48456313', 'Alejandro López', '48003310', 2);");
		conect.insertData("insert into directores values('48942850', 'Sofia Martinez', null, 3);");
		conect.insertData("insert into directores values('59776813', 'Juan Rodriguez', '48942850', 4);");
		conect.insertData("insert into directores values('69778563', 'Ana Fernandez', null, 5);");
		conect.closeConnection();
		System.out.println("FIN");
		
	}
	
}
