package repaso.Banco;

public class Cuenta {
//private int saldo;
//String codigo;
//protected String oficina;
//public String titular;

//otra clase banco = mismo paquete
//Clase tienda != paquete

/*
a) Para la otra clase de banco como esta en el mismo paquete podra recibir todos los atributos de Cuenta
excepto saldo que es privado, por el otro lado la clase tienda, que no esta en el mismo paquete,
so tiene acceso al String de titular que es publico
b) protected solo permite el acceso a las clases que estan en el mismo paquete y a las clases hijas,
Si quieres usar la clase a del paquete A en el paquete B, tienes que instanciar la clase a y aun asi solo podras
ejecutar la herencia y los metodos con las clases hijas previas.
c) Para que el constructor Cuenta() pueda ser accedido desde otra clase, necesita tener el modificador public, porque
aunque uses new Cuenta() desde otra clase, te dara error de compilacion, ya que no tienes permiso de acceso al constructor.
d) El unico modificador que permite acceso a una clase superior es public. Ya que permite el acceso a todos
*/
}
