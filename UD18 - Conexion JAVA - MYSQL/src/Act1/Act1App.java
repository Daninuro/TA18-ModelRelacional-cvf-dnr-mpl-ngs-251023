package Act1;

import Conexion.Mysql_conect;

public class Act1App 
{

	public static void main(String[] args) 
	{
		
		Mysql_conect conect = new Mysql_conect();
		conect.connect("localhost", "33060", "root", "password");
		conect.createDB("Ud18_Ej1");
		conect.useDB("Ud18_Ej1");

		conect.createTable("create table if not exists fabricante ("		+
										"identity int primary key not null, "	+
										"nombre nvarchar(100) );"
								);
		
		
		conect.createTable("create table if not exists articulos ("
							
							+"identity int primary key not null, "	
							+"nombre nvarchar(100), "				
							+"precio int, "							
							+"fabricante int, "						
							+"constraint fk_fabricante foreign key(fabricante) references fabricante(identity) );"
							);
		
		
		conect.insertData("insert into fabricante(identity, nombre) values (1, 'Adidas')");
		conect.insertData("insert into fabricante(identity, nombre) values (2, 'Nike')");
		conect.insertData("insert into fabricante(identity, nombre) values (3, 'Puma')");
		conect.insertData("insert into fabricante(identity, nombre) values (4, 'Asics')");
		conect.insertData("insert into fabricante(identity, nombre) values (5, 'Lacoste')");
		
		conect.insertData("insert into articulos(identity, nombre, precio, fabricante) values (1, 'Camiseta', 15, 1)");
		conect.insertData("insert into articulos(identity, nombre, precio, fabricante) values (2, 'Pantalon', 20, 2)");
		conect.insertData("insert into articulos(identity, nombre, precio, fabricante) values (3, 'Zapato', 50, 3)");
		conect.insertData("insert into articulos(identity, nombre, precio, fabricante) values (4, 'Zapato', 70, 4)");
		conect.insertData("insert into articulos(identity, nombre, precio, fabricante) values (5, 'Polo', 60, 5)");
		
		conect.closeConnection();
		System.out.println("FIN");

	}

}