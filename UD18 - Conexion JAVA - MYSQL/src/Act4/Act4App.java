package Act4;

import Conexion.Mysql_conect;


public class Act4App 
{

	public static void main(String[] args) 
	{
		
		Mysql_conect conect = new Mysql_conect();
		conect.connect("localhost", "33060", "root", "password");
		conect.createDB("Ud18_Ej4");
		conect.useDB("Ud18_Ej4");
		conect.createTable("create table if not exists peliculas(codigo int, nombre varchar(100), calificacion_edad"
				+ " int, primary key (codigo));");
		
		conect.createTable("create table if not exists salas(codigo int, nombre varchar(100), pelicula int, primary "
				+ "key (codigo),foreign key (pelicula) references peliculas (codigo));");
		
		conect.insertData("insert into peliculas values(1,'Inception', 7)");
		conect.insertData("insert into peliculas values(2,'Gravity', 3)");
		conect.insertData("insert into peliculas values(3,'Arrival', 7)");
		conect.insertData("insert into peliculas values(4,'Joker', 12)");
		conect.insertData("insert into peliculas values(5,'Interstellar', 7)");

		
		conect.insertData("insert into salas values(1,'Sala A', 1)");
		conect.insertData("insert into salas values(2,'Sala B', 2)");
		conect.insertData("insert into salas values(3,'Sala C', 3)");
		conect.insertData("insert into salas values(4,'Sala D', 4)");
		conect.insertData("insert into salas values(5,'Sala E', 5)");
		
		conect.closeConnection();
		System.out.println("FIN");
		
	}
	
}
