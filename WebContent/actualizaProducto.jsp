<html>
<head>
<title>Bienvenido a la Intranet</title>
<!-- Referenciamos los recursos para trabajar con displaytag -->
<link rel="stylesheet" type="text/css" media="screen"
	href="css/screen.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery.metadata.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#formProducto").validate();
	});
</script>
</head>
<body>
	<!-- Recuperamos los datos que han sido cargados en el request -->
	<%@page import="www.google.intranet.matricula.entidad.ProductoDTO"%>
	<%
		ProductoDTO p = (ProductoDTO) request.getAttribute("producto");
	%>
	<h1>Actualiza Producto</h1>
	<form action="producto" id="formProducto">
		<input type="hidden" name="metodo" value="actualiza"> <input
			type="hidden" name="codigo" value="<%=p.getIdProducto()%>">
		<table cellspacing="0" cellpadding="4">
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="txtNombre" size="30"
					value="<%=p.getNombre()%>" class="required">
				</td>
			</tr>
			<tr>
				<td>Precio</td>
				<td><input type="text" name="txtPrecio" size="30"
					value="<%=p.getPrecio()%>" class="{required:true,number:true}">
				</td>
			</tr>
			<tr>
				<td>Stock</td>
				<td><input type="text" name="txtStock" size="30"
					value="<%=p.getStock()%>" class="{required:true,digits:true}">
				</td>
			</tr>
			<tr>
				<td>Categoria</td>
				<td><select name="cboCategoria" class="required">
						<option value="">[Seleccione]</option>
						<option value="1">Oficina</option>
						<option value="2">Informatica</option>
						<option value="3">Laboratorio</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Fecha</td>
				<td><input type="text" name="txtFecha" size="30"
					value="<%=p.getFecha()%>" class="{required:true,dateISO:true}">
				</td>
			</tr>
			<tr>
				<td><input type="reset" value="limpiar"></td>
				<td><input type="submit" value="enviar"></td>
			</tr>
		</table>
	</form>
</body>
</html>