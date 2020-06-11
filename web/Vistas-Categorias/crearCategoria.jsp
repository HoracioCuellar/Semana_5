<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="categoria" scope="session" class="Model.Categoria"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Inventario</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf"%>
        <script type="text/javascript">
            function regresar(url){
                location.href=url;
            }
        </script>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf"%>
        
        <h1>Mantenimiento de Categorias</h1>
        <form class="form-horizontal" id="frmCategoria" action="<%=request.getContextPath()%>/Categorias" method="post">
            <input type="hidden" name="id_categoria" value="<%=categoria.getId_categoria()%>"/>
            <div class="form-group">
                <label for="txtNomCategoria" class="col-sm-2 control-label">Nombre:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtNomCategoria" value="<%= categoria.getNombre()%>">
                </div>
            </div>
                <div class="form-group">
                      <label for="txtEstadoCategoria" class="col-sm-2 control-label">Estado:</label>
                      <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtEstadoCategoria" value="<%= categoria.getEstado_categoria()%>">
                </div>
                </div>
                <div class="form-group">
                      <label for="txtEstadoCategoria" class="col-sm-2 control-label">Estado:</label>
                      <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar"/>
                    <input type="submit" class="btn btn-danger btn-sm"  name="btnRegresar" value="Regresar" onclick="regresar('<%=request.getContextPath()%>/Categorias?opcion=listar'')">
                    <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf"%>
                </div>
                </div>
        </form>
    </body>
</html>
