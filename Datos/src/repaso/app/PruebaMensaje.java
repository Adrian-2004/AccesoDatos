package repaso.app;

import repaso.modelo.Mensaje;

public class PruebaMensaje {
public static void main(String[] args) {
  Mensaje mensaje = new Mensaje();
    System.out.println(mensaje.getTexto());
    
}
// Si la clase Mensaje no fuera pública, no podríamos acceder a ella desde este paquete.
// Solo podriamos acceder a ella importando el paquete repaso.modelo y haciendo uso de la clase Mensaje,
// pero no podríamos instanciarla ni llamar a sus métodos desde este paquete.
}
