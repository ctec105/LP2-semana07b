package www.google.intranet.matricula.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.google.intranet.matricula.entidad.ProductoDTO;
import www.google.intranet.matricula.service.ProductoService;
import www.google.intranet.matricula.service.ProductoServiceImpl;

/**
 * Servlet implementation class ServletProducto
 */
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductoService servicio = new ProductoServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		if (metodo.equals("inserta")) {
			inserta(request, response);
			lista(request, response);
		} else if (metodo.equals("elimina")) {
			elimina(request, response);
			lista(request, response);
		} else if (metodo.equals("actualiza")) {
			actualiza(request, response);
			lista(request, response);
		} else if (metodo.equals("lista")) {
			lista(request, response);
		} else if (metodo.equals("busca")) {
			busca(request, response);
		}
	}

	private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// El ArrayList contiene la lista de productos
		ArrayList<ProductoDTO> lista = null;
		try {
			lista = servicio.listaProducto();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Cargar la data del ArrayList en una sesión para poder paginar los datos
		request.getSession().setAttribute("productos", lista);
		request.getRequestDispatcher("/listaProducto.jsp").forward(request,response);
	}

	protected void inserta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductoDTO p = new ProductoDTO();
			p.setNombre(request.getParameter("txtNombre"));
			p.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
			p.setStock(Integer.parseInt(request.getParameter("txtStock")));
			p.setIdCategoria(Integer.parseInt(request.getParameter("cboCategoria")));
			p.setFecha(request.getParameter("txtFecha"));
			servicio.regsitraProducto(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			servicio.eliminaProducto(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductoDTO p = new ProductoDTO();
			p.setIdProducto(Integer.parseInt(request.getParameter("codigo")));
			p.setNombre(request.getParameter("txtNombre"));
			p.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
			p.setStock(Integer.parseInt(request.getParameter("txtStock")));
			p.setIdCategoria(Integer.parseInt(request.getParameter("cboCategoria")));
			p.setFecha(request.getParameter("txtFecha"));
			servicio.actualizaProducto(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void busca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			ProductoDTO bean = servicio.buscaProducto(codigo);
			request.setAttribute("producto", bean);
			request.getRequestDispatcher("/actualizaProducto.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}