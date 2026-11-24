package com.Examen1;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;




public class ConexionNorth {
/*
Crea una aplicación Java de consola con JDBC y MySQL Connector/J sobre la copia de Northwind de tu equipo. Puedes ejecutar las operaciones desde el main() o desde un menú sencillo. Cierra los recursos que abras e informa de los errores.
Tabla de referencia · Products(ProductID, ProductName, CategoryID, UnitPrice, UnitsInStock).
A. Consultar productos (2 puntos)
Consulta los productos de la categoría 1 con precio igual o superior a 18.00, ordenados por ProductID ascendente. Usa un PreparedStatement con ambos parámetros y ejecuta la consulta con executeQuery(). Crea un objeto Producto (crea la clase) con ID, nombre, precio y existencias por cada fila devuelta, guarda los objetos en una List<Producto> y muestra la lista por consola. Si está vacía, muestra un aviso.

B. Reponer existencias (1,75 puntos)
Suma 5 unidades a las existencias del producto 1 de la categoría 1 mediante un único UPDATE preparado. Pasa el incremento, el ID y la categoría como parámetros. Usa el resultado de executeUpdate() (número de filas actualizadas) para indicar si se actualizó el producto o si no hubo coincidencias.
 
C. Generar el informe de texto (1,25 puntos)
Usa la lista del apartado A para crear o sobrescribir informe_existencias.txt. Escribe la cabecera ID|NOMBRE|PRECIO|EXISTENCIAS y después una línea por producto, en el orden de la lista, con | como separador. Si la lista está vacía, escribe solo la cabecera.
 */


private static Connection conexion;
private static ArrayList<Producto> productos = new ArrayList<>();

public ConexionNorth(Connection conexion){
    this.conexion = conexion;
    // Comprobamos si la conexión es válida antes de usarla
    try {
        if (this.conexion == null || this.conexion.isClosed()) {
            
            return;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }


}
public static ArrayList<Producto> getProductos(){
    String sql = "SELECT ProductID, ProductName, UnitPrice"+
    ", UnitsInStock FROM Products WHERE CategoryID = 1 AND UnitPrice >= ? ORDER BY ProductID ASC";
    try(Connection cn = conexion;
        PreparedStatement ps = conexion.prepareStatement(sql)){
        ps.setDouble(1, 18.00);
    try(ResultSet rs = ps.executeQuery()){
        while(rs.next()){
            int id = rs.getInt("ProductID");
            String nombre = rs.getString("ProductName");
            double precio = rs.getDouble("UnitPrice");
            int existencias= rs.getInt("UnitsInStock");
            Producto prod = new Producto(id, nombre, precio, existencias);
            productos.add(prod);

        }
    }catch(SQLException e){
        System.err.println("Error al ejecutar la consulta: " + e.getMessage());

    }
}catch(SQLException e){
    System.err.println("Error al preparar la consulta: " + e.getMessage());
}
return productos;
}

public static void reponerExistencias(String nombre, int existencias){
    String sql= "UPDATE Productos SET UnitsInStock = UnitsInStock+? WHERE ProductName = ?";
    try(Connection conexion = null;
        PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, existencias);
            ps.setString(2, nombre);

}catch(SQLException e){
            System.err.println("Ha habido un error: "+e.getMessage());
        }
}

public static void main(String[] args) {
try(Connection conexion = BD.abrir()){
    System.out.println("Conexion abierta");
}catch(SQLException sqle){
    System.err.println(sqle.getMessage());


}

    Scanner sc = new Scanner(System.in);
    System.out.println("Quieres consultar o reponer existencias?");
    String respuesta = sc.nextLine().toLowerCase();
    if(respuesta.equals("consultar")){
        System.out.println("Vamos a consultar todos los productos de la categoria 1 que superen los 18 euros de precio");
      getProductos();
        
    }else if(respuesta.equals("reponer")||respuesta.equals("reponer existencias")){
        System.out.println("Introduce el nombre del producto");
        String nombre = sc.nextLine();
        System.out.println("Introduce la cantidad de stock a añadir");
        int stock = sc.nextInt();
        reponerExistencias(nombre, stock);
    }
}

}


