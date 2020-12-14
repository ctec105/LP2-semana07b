package www.google.intranet.matricula.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import www.google.intranet.matricula.entidad.ProductoDTO;
import www.google.intranet.util.MySqlDBConn;

public class ProductoDaoImpl implements ProductoDao{

	@Override
	public int insertaProducto(ProductoDTO bean) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="insert into tb_producto values(null,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,bean.getNombre());
			pstm.setDouble(2,bean.getPrecio());
			pstm.setInt(3,bean.getStock());
			pstm.setInt(4,bean.getIdCategoria());
			pstm.setString(5,bean.getFecha());
			return pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm!= null)
					pstm.close();
				if(conn!= null)
					conn.close();
			} catch (Exception e2) {}
		}
		return -1;
	}

	@Override
	public int actualizaProducto(ProductoDTO bean) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="update tb_producto set nom_pro=?, pre_pro=?, " +
					"stk_pro=?,cod_cat=?,fec_reg_pro=? where cod_pro=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,bean.getNombre());
			pstm.setDouble(2,bean.getPrecio());
			pstm.setInt(3,bean.getStock());
			pstm.setInt(4,bean.getIdCategoria());
			pstm.setString(5,bean.getFecha());
			pstm.setInt(6,bean.getIdProducto());
			return pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm!= null)
					pstm.close();
				if(conn!= null)
					conn.close();
			} catch (Exception e2) {}
		}
		return -1;
	}

	@Override
	public int eliminaProducto(Integer idProducto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="delete from tb_producto where cod_pro=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,idProducto);
			return pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm!= null)
					pstm.close();
				if(conn!= null)
					conn.close();
			} catch (Exception e2) {}
		}
		return -1;
	}

	@Override
	public ProductoDTO buscaProducto(Integer idProducto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ProductoDTO dto = new ProductoDTO();
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="select * from tb_producto where cod_pro=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idProducto);
			rs = pstm.executeQuery();
			if(rs.next()){
				dto.setIdProducto(rs.getInt("cod_pro"));// cod_pro o 1
				dto.setNombre(rs.getString("nom_pro"));
				dto.setPrecio(rs.getDouble("pre_pro"));
				dto.setStock(rs.getInt("stk_pro"));
				dto.setFecha(rs.getString("fec_reg_pro"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!= null)
					rs.close();
				if(pstm!= null)
					pstm.close();
				if(conn!= null)
					conn.close();
			} catch (Exception e2) {}
		}
		return dto;
	}

	@Override
	public ArrayList<ProductoDTO> listaProducto() {
		Connection con=new MySqlDBConn().getConnection();
		ArrayList<ProductoDTO> lista=new ArrayList<ProductoDTO>();
		ProductoDTO objPro=null;
		try {
			String sql="select * from tb_producto";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				// Creamos el objeto ProductoDTO
				objPro=new ProductoDTO();
				objPro.setIdProducto(rs.getInt(1));
				objPro.setNombre(rs.getString(2));
				objPro.setPrecio(rs.getDouble(3));
				objPro.setStock(rs.getInt(4));
				objPro.setIdCategoria(rs.getInt(5));
				objPro.setFecha(rs.getString(6));
				// Agregamos el objeto al ArrayList
				lista.add(objPro);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return lista;
	}

}
