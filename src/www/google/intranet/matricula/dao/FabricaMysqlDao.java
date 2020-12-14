package www.google.intranet.matricula.dao;

public class FabricaMysqlDao extends FabricaDao {

	@Override
	public ProductoDao getProducto() {
		return new ProductoDaoImpl();
	}

}
