package tarea3;

import libtarea3.ComeCocos;
import libtarea3.Direccion;
import static libtarea3.Direccion.ESTE;

/**
 * Ejercicio 1: esqueleto para escribir las instrucciones que le demos al comecocos
 * 
 * @author David López Coronel
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // 1. Declarar una variable referencia a objetos instancia de la clase ComeCocos
        // (variable miComeCocos).
        ComeCocos miComeCocos;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("MOVIENDO LOS COMECOCOS");
        System.out.println("----------------------");
        // 2. Instanciar un objeto de la clase ComeCocos ubicado en la posición x=120, y=215 
        // y mirando hacia el ESTE.
        // Asignar a la variable anterior la referencia al objeto recién creado.
        miComeCocos = new ComeCocos (120, 215, ESTE);

        //----------------------------------------------
        //       Procesamiento + Salida de Resultados
        //----------------------------------------------
        // 3. Mostrar por pantalla el estado  inicial del objeto.
        // Dispones para ello del método toString.
        System.out.println("3.Estado inicial de miComeCocos: " + miComeCocos.toString());
        
        // 4. Hacer avanzar 10 posiciones al comecocos.
        miComeCocos.avanzar(10); 
        
        // 5. Mostrar por pantalla el estado del comecocos.
        System.out.println("\n5.Estado de miComeCocos, tras avanzar 10 posiciones: " + miComeCocos.toString());
        
        // 6. Girar hacia la derecha el comecocos.
        miComeCocos.giraDerecha();
        
        // 7. Hacer avanzar otras 10 posiciones al comecocos.
        miComeCocos.avanzar(10); 
        
        // 8. Mostrar por pantalla el estado del comecocos.
        System.out.println("\n8.Estado de miComeCocos, tras girar a la derecha y avanzar(10): " + miComeCocos); //Recordando lo leido en el temário y probando, no es necesario poner .toString
        /*
        Si vamos a interpretar una variable referencia (objeto) como un String, no es necesario invocar explícitamente al método toString pues Java lo hará implícitamente por nosotros.
        */
        // 9. Hacer avanzar 25 posiciones al comecocos.
        miComeCocos.avanzar(25);
        
        // 10. Mostrar por pantalla el estado del comecocos.
        System.out.println("\n10.Avanzar 25 posiciones miComeCocos: " + miComeCocos);
        
        // 11. Girar hacia la izquierda el comecocos.
        miComeCocos.giraIzquierda();
        
        //12. Volver a girar hacia la izquierda el comecocos.
        miComeCocos.giraIzquierda();
        
        // 13. Hacer avanzar 20 posiciones al comecocos.
        miComeCocos.avanzar(20);
        
        // 14. Mostrar por pantalla el estado del comecocos.
        System.out.println("\n14.Estado de miComeCocos, tras giraIzquierda dos veces y avanzar 20 posiciones: " + miComeCocos);
        
        // 15. Hacer avanzar 45 posiciones al comecocos.
        miComeCocos.avanzar(45);
        
        // 16. Mostrar por pantalla el estado del comecocos.
        System.out.println("\n16.Avanzar 45 posiciones miComeCocos: " + miComeCocos);
        
        // 17. Obtener la dirección a la que está mirando el comecocos y 
        // convertirla a grados con la herramienta que proporciona la clase 
        // (método estático direccionAGrados.             
        System.out.println("\nObtener los (grados) de miComeCocos, tras convertir mi dirección a grados: " + ComeCocos.direccionAGrados(miComeCocos.getDireccion()));
    }
    
}
