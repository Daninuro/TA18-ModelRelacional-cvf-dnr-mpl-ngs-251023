package Act8;

import Conexion.Mysql_conect;

public class Act8App 
{

	public static void main(String[] args) 
	{
		
		Mysql_conect conect = new Mysql_conect();
		conect.connect("localhost", "33060", "root", "password");
		conect.createDB("Ud18_Ej8");
		conect.useDB("Ud18_Ej8");

		conect.createTable(
				"create table if not exists cajeros(codigo int,nom_apell varchar(255),primary key(codigo));");
		conect.createTable(
				"create table if not exists productos(codigo int,nombre varchar(100),precio int,primary key(codigo));");
		conect.createTable(
				"create table if not exists maquinas_registradoras(codigo int,piso int,primary key(codigo));");
		conect.createTable(
				"create table if not exists venta(cajero int,maquina int,producto int,primary key(cajero,maquina,producto),"
						+ "constraint fk_venta_cajeros foreign key(cajero) references cajeros(codigo) "
						+ "on delete cascade on update cascade,"
						+ "constraint fk_venta_maquinas foreign key(maquina) references maquinas_registradoras(codigo)"
						+ "on delete cascade on update cascade,"
						+ "constraint fk_venta_productos foreign key(producto) references productos(codigo)"
						+ "on delete cascade on update cascade);");

		conect.insertData("insert into cajeros(codigo,nom_apell) values (1,'pepe pepito'),"
				+ "(2,'jose joselito'),(3,'ana anita'),(4,'andres andresito'),(5,'maria antonieta');");

		conect.insertData("insert into productos(codigo,nombre,precio) values (111,'agua',2),"
				+ "(222,'galletas',4),(333,'leche',2),(444,'pasta',3),(555,'vino',9);");

		conect.insertData(
				"insert into maquinas_registradoras(codigo,piso) values (1001,1),(1002,1),(1003,2),(1004,2),(1005,3);");

		conect.insertData("insert into venta(cajero,maquina,producto) values "
				+ "(1,1003,111),(1,1001,222),(3,1002,333),(2,1005,444),(1,1001,111);");
		
		
		conect.closeConnection();
		System.out.println("FIN");

		
	}
	
}
