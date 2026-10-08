package IO;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

public class GestionProductos {
    final static int CANTIDAD_PRODUCTOS = 5;

public static void main(String[] args) {
    Producto[] productos = new Producto[CANTIDAD_PRODUCTOS];
    Scanner sc = new Scanner(System.in);
RandomAccessFile raf = null;
    productos[0] = new Producto(1, "Plátano Canarias", 1.5, 10);
    productos[1] = new Producto(2, "Manzana", 0.8, 20);
    productos[2] = new Producto(3, "Galletas Oreo", 2.47, 7);
    productos[3] = new Producto(4, "Leche", 1.2, 15);
    productos[4] = new Producto(5, "Pan", 0.9, 25);

    try {
         raf = new RandomAccessFile("productos.dat", "rw");
        raf.setLength(0);
        for(Producto p : productos){
            raf.writeInt(p.getId()); //4 bytes 
            raf.writeChars(p.getNombre()); // 12*2 = 24 bytes
            raf.writeDouble(p.getPrecio()); // 8 bytes
            raf.writeInt(p.getExistencias()); // 4 bytes 
        }

        raf.seek(0);

        for(int i = 0; i < CANTIDAD_PRODUCTOS; i++){

            int id = raf.readInt();

            String nombre = " ";
            for(int j = 0; j< 12;j++){
             nombre += raf.readChar();
            }

            double precio = raf.readDouble();
            int existencias = raf.readInt();
            
            Producto p = new Producto(id, nombre, precio, existencias);
            System.out.println(p);
        }


    }catch(IOException e){
        System.out.println("Error al utilizar el archivo: "+e.getMessage());
    }finally {
    try{
        if (raf != null){
        raf.close();
    }
    }catch(IOException e){
        e.printStackTrace();
    }
    
}

        System.out.print("\nIntroduce el ID del producto a buscar (1 a 5): ");
        int idBuscar = sc.nextInt();

        if (idBuscar >= 1 && idBuscar <= 5) {
            try (RandomAccessFile rafBusqueda = new RandomAccessFile("productos.dat", "r")) {
                long posicion = (idBuscar - 1) * 40;
                rafBusqueda.seek(posicion);
                
                int id = rafBusqueda.readInt();
                String nombre = "";
                for (int j = 0; j < 12; j++) {
                    nombre += rafBusqueda.readChar();
                }
                double precio = rafBusqueda.readDouble();
                int existencias = rafBusqueda.readInt();
                
                Producto p = new Producto(id, nombre.trim(), precio, existencias);
                System.out.println("Producto encontrado");
                System.out.println(p);
            } catch (IOException e) {
                System.out.println("Error al buscar: " + e.getMessage());
            }
        } else {
            System.out.println("Identificador no válido. Debe estar entre 1 y 5.");
        }

        
        System.out.print("\nIntroduce el ID del producto para actualizar existencias: ");
        int idStock = sc.nextInt();
        System.out.print("Introduce la nueva cantidad de existencias: ");
        int nuevasExistencias = sc.nextInt();

        if (idStock >= 1 && idStock <= 5 && nuevasExistencias >= 0) {
            try (RandomAccessFile rafStock = new RandomAccessFile("productos.dat", "rw")) {
                // Posición base del registro + 36 bytes (4 de id + 24 de nombre + 8 de precio)
                long posExistencias = ((idStock - 1) * 40) + 36;
                rafStock.seek(posExistencias);
                rafStock.writeInt(nuevasExistencias);
                System.out.println("¡Existencias actualizadas con éxito!");
            } catch (IOException e) {
                System.out.println("Error al actualizar existencias: " + e.getMessage());
            }
        } else {
            System.out.println("Datos no válidos. Revisa que el ID sea de 1 a 5 y las existencias no sean negativas.");
        }

        System.out.print("\n Introduce el ID del producto para actualizar precio: ");
        int idPrecio = sc.nextInt();
        System.out.print("Introduce el nuevo precio: ");
        double nuevoPrecio = sc.nextDouble();

        if (idPrecio >= 1 && idPrecio <= 5 && nuevoPrecio >= 0) {
            try (RandomAccessFile rafPrecio = new RandomAccessFile("productos.dat", "rw")) {
                // Posición base del registro + 28 bytes (4 de id + 24 de nombre)
                long posPrecio = ((idPrecio - 1) * 40) + 28;
                rafPrecio.seek(posPrecio);
                rafPrecio.writeDouble(nuevoPrecio);
                System.out.println("¡Precio actualizado con éxito!");
            } catch (IOException e) {
                System.out.println("Error al actualizar precio: " + e.getMessage());
            }
        } else {
            System.out.println("Datos no válidos. Revisa que el ID sea de 1 a 5 y el precio no sea negativo.");
        }

        
        System.out.println("\nLista de productos tras las modificaciones:");
        try (RandomAccessFile rafFinal = new RandomAccessFile("productos.dat", "r")) {
            rafFinal.seek(0);
            for (int i = 0; i < 5; i++) {
                int id = rafFinal.readInt();
                String nombre = "";
                for (int j = 0; j < 12; j++) {
                    nombre += rafFinal.readChar();
                }
                double precio = rafFinal.readDouble();
                int existencias = rafFinal.readInt();
                
              Producto p = new Producto(id, nombre.trim(), precio, existencias);
              System.out.println(p);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo final: " + e.getMessage());
        }
}
}