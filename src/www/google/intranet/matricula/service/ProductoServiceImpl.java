package www.google.intranet.matricula.service;

import java.sql.SQLException;
import java.util.ArrayList;

import www.google.intranet.matricula.dao.FabricaDao;
import www.google.intranet.matricula.dao.ProductoDao;
import www.google.intranet.matricula.dao.FabricaDao.TipoFabrica;
import www.google.intranet.matricula.entidad.ProductoDTO;

public class ProductoServiceImpl implements ProductoService{
	
	FabricaDao fabrica = FabricaDao.getFabrica(TipoFabrica.MYSQL);
	ProductoDao dao = fabrica.getProducto();

	@Override
	public int regsitraProducto(ProductoDTO bean) throws SQLException {
		return dao.insertaProducto(bean);
	}
	
	@Override
	public int actualizaProducto(ProductoDTO bean) throws SQLException {
		return dao.actualizaProducto(bean);
	}
	
	@Override
	public int eliminaProducto(Integer idProducto) throws SQLException {
		return dao.eliminaProducto(idProducto);
	}
	
	@Override
	public ProductoDTO buscaProducto(Integer idProducto) throws SQLException {
		return dao.buscaProducto(idProducto);
	}
	
	@Override
	public ArrayList<ProductoDTO> listaProducto() throws SQLException {
		return dao.listaProducto();
	}
	
}




