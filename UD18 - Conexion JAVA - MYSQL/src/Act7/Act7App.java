package Act7;

import Conexion.Mysql_conect;

public class Act7App 
{
	
	public static void main(String[] args) 
	{
		
		Mysql_conect conect = new Mysql_conect();

		conect.connect("localhost", "33060", "root", "password");
		conect.createDB("Ud18_Ej7");
		conect.useDB("Ud18_Ej7");


		conect.createTable("create table if not exists cientificos(" + "DNI varchar(8),"
				+ "nom_apell varchar(255)," + "primary key(DNI)" + ");");

		conect.createTable(
				"create table if not exists proyectos(id char(4),nombre varchar(255),horas int, primary key(id));");

		conect.createTable(
				"create table if not exists asignado_a(cientifico varchar(8),proyecto char(4),primary key(cientifico,proyecto),"
						+ "constraint fk_asignado_cientificos foreign key(cientifico) references cientificos(DNI)"
						+ "on delete cascade on update cascade,"
						+ "constraint fk_asignado_proyectos foreign key(proyecto) references proyectos(id)"
						+ "on delete cascade on update cascade);");


		conect.insertData("insert into cientificos(DNI,nom_apell) values" + "('1111111a','pepito grillo'),"
				+ "('2222222a','mari carmen lara')," + "('3333333a','pollito piolin'),"
				+ "('4444444a','consuelo martinez')," + "('5555555a','joselito perez');");

		conect.insertData("insert into proyectos(id,nombre,horas) values ('123a','explotar una estrella',987),"
				+ "('123b','reproduccion mariposas',45)," + "('123c','analisis conducta hormigas',675),"
				+ "('123d','patron y diseño casas sostenibles',564)," + "('123e','canto sirenas analisis',452);");

		conect.insertData("insert into asignado_a(cientifico,proyecto) values('1111111a','123a'),"
				+ "('2222222a','123b')," + "('3333333a','123c')," + "('4444444a','123d')," + "('5555555a','123e');");

		conect.closeConnection();
		System.out.println("FIN");


	}
	
}
