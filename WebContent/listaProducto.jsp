<html>
<head>
<title>Bienvenido a la Intranet</title>
<!-- Referenciamos los recursos para trabajar con displaytag -->
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<link rel="stylesheet" type="text/css" media="screen" href="css/displaytag.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/screen.css" />
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
	<font size="6" color="blue"><b>Mantenimiento de Productos</b></font>

	<br>

	<h1>
		Lista Producto<a href="producto?metodo=lista">ver</a>
	</h1>
	
	<h1>
		Registra Producto<a href="registraProducto.jsp">ver</a>
	</h1>
	
	<!--Configurar el display tag con los datos de la sesión -->
	<display:table name="${sessionScope.productos}" pagesize="3" export="true">
		<display:column title="IdProducto" property="idProducto" sortable="true" />
		<display:column title="Nombre" property="nombre" sortable="true" />
		<display:column title="Precio" property="precio" sortable="true" />
		<display:column title="Stock" property="stock" sortable="true" />
		<display:column title="Categoría" property="idCategoria" sortable="true" />
		<display:column title="Fecha" property="fecha" sortable="true" />
	</display:table>
	
	<br/>

	<form action="producto">
		<input type="hidden" name="metodo" value="busca"/>
		Código: <input type="text" name="codigo" />
		<input type="submit" value="Modificar"/>
	</form>
	
	<form action="producto">
		<input type="hidden" name="metodo" value="elimina"/>
		Código: <input type="text" name="codigo" />
		<input type="submit" value="Eliminar"/>
	</form>
</body>
</html>