package www.google.intranet.matricula.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import www.google.intranet.matricula.entidad.ProductoDTO;

public interface ProductoDao {

	public abstract int insertaProducto(ProductoDTO bean) throws SQLException;
	public abstract int actualizaProducto(ProductoDTO bean) throws SQLException;
	public abstract int eliminaProducto(Integer idProducto) throws SQLException;
	public abstract ProductoDTO buscaProducto(Integer idProducto) throws SQLException;
	public abstract ArrayList<ProductoDTO> listaProducto();

}
