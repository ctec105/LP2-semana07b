package www.google.intranet.matricula.dao;

public abstract class FabricaDao {

	public enum TipoFabrica {
		MYSQL, SQL, ORACLE
	};

	// Declarar los daos(Tablas) que se tiene, por cada DAO crear un método get
	// incluido el DAOFactory
	public abstract ProductoDao getProducto();

	public static FabricaDao getFabrica(TipoFabrica tipo) {
		FabricaDao salida = null;
		switch (tipo) {
		case MYSQL:
			salida = new FabricaMysqlDao();
			break;
		case SQL:
			salida = null; // se invoca a la fabrica de para SQLServer
			break;
		case ORACLE:
			salida = null; // se invoca a la fabrica de para Oracle
			break;
		default:
			break;
		}
		return salida;
	}

}