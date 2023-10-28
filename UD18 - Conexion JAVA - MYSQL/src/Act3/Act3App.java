package Act3;

import Conexion.Mysql_conect;


public class Act3App
{
	
	public static void main(String[] args) 
	{
		
		Mysql_conect conect = new Mysql_conect();
		conect.connect("localhost", "33060", "root", "password");
		conect.createDB("Ud18_Ej3");
		conect.useDB("Ud18_Ej3");

		conect.createTable("create table if not exists almacen (" 	+
									"identity int primary key not null, "	+
								    "lugar nvarchar(100), "					+
								    "capacidad int"
								);

		conect.createTable("create table if not exists caja ("											+
									"num_referencia char(5) primary key not null, "								+
								    "contenido nvarchar(100), "													+
								    "valor int, "																+
								    "almacen int, "																+
								    "constraint fk_almacen foreign key(almacen) references almacen(identity)"
								);
			
		conect.insertData("INSERT INTO almacen(identity, lugar, capacidad) VALUES (1, 'Almacén principal', 10000)");
		conect.insertData("INSERT INTO almacen(identity, lugar, capacidad) VALUES (2, 'Almacén secundario', 5000)");
		conect.insertData("INSERT INTO almacen(identity, lugar, capacidad) VALUES (3, 'Almacén de herramientas', 3000)");
		conect.insertData("INSERT INTO almacen(identity, lugar, capacidad) VALUES (4, 'Almacén de productos perecederos', 2000)");
		conect.insertData("INSERT INTO almacen(identity, lugar, capacidad) VALUES (5, 'Almacén de productos secos', 4000)");
		
		conect.insertData("INSERT INTO caja(num_referencia, contenido, valor, almacen) VALUES ('1', 'Computadora portátil', 800, 1)");
		conect.insertData("INSERT INTO caja(num_referencia, contenido, valor, almacen) VALUES ('2', 'Teléfono móvil', 500, 2)");
		conect.insertData("INSERT INTO caja(num_referencia, contenido, valor, almacen) VALUES ('3', 'Tablet', 300, 3)");
		conect.insertData("INSERT INTO caja(num_referencia, contenido, valor, almacen) VALUES ('4', 'Cámara digital', 700, 4)");
		conect.insertData("INSERT INTO caja(num_referencia, contenido, valor, almacen) VALUES ('5', 'Impresora', 400, 5)");
		
		conect.closeConnection();
		System.out.println("FIN");

	}

}
	

