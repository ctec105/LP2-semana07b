package www.google.intranet.matricula.service;

import java.sql.SQLException;
import java.util.ArrayList;

import www.google.intranet.matricula.entidad.ProductoDTO;

public interface ProductoService {

	public int regsitraProducto(ProductoDTO bean) throws SQLException;
	public abstract int actualizaProducto(ProductoDTO bean) throws SQLException;
	public abstract int eliminaProducto(Integer idProducto) throws SQLException;
	public abstract ProductoDTO buscaProducto(Integer idProducto) throws SQLException;
	public abstract ArrayList<ProductoDTO> listaProducto() throws SQLException;

}