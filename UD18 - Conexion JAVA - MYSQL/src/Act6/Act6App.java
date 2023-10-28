package Act6;

import Conexion.Mysql_conect;

public class Act6App 
{
	
	public static void main(String[] args) 
	{
		
		Mysql_conect conect = new Mysql_conect();

		conect.connect("localhost", "33060", "root", "password");
		conect.createDB("Ud18_Ej6");
		conect.useDB("Ud18_Ej6");

		conect.createTable("create table if not exists piezas(codigo int, nombre varchar(100), "
				+ "primary key (codigo));");
		conect.createTable("create table if not exists proveedores(id char(4), nombre varchar(100), "
				+ "primary key (id));");
		conect.createTable("create table if not exists suministra(codigo_pieza int, id_proveedor char(4),"
				+ " precio int, primary key (codigo_pieza, id_proveedor), foreign key (codigo_pieza) "
				+ "references piezas (codigo), foreign key (id_proveedor) references proveedores (id));");
		
		conect.insertData("insert into piezas values(1, 'Tornillo');");
		conect.insertData("insert into piezas values(2, 'Tuerca');");
		conect.insertData("insert into piezas values(3, 'Martillo');");
		conect.insertData("insert into piezas values(4, 'Maza');");
		conect.insertData("insert into piezas values(5, 'Hacha');");
		
		conect.insertData("insert into proveedores values('a', 'Toyota');");
		conect.insertData("insert into proveedores values('s', 'Ferrari');");
		conect.insertData("insert into proveedores values('d', 'Kia');");
		conect.insertData("insert into proveedores values('f', 'Hyundai');");
		conect.insertData("insert into proveedores values('g', 'Seat');");
		
		conect.insertData("insert into suministra values(1, 'a', 240);");
		conect.insertData("insert into suministra values(2, 's', 150);");
		conect.insertData("insert into suministra values(3, 'd', 830);");
		conect.insertData("insert into suministra values(4, 'f', 450);");
		conect.insertData("insert into suministra values(5, 'g', 130);");
		
		conect.closeConnection();
		System.out.println("FIN");


	}
	
}
