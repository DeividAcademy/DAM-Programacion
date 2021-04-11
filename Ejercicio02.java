package tarea3;

import libtarea3.Dado;
//Importamos la clase dicha para el punto 1. (IllegalArgumentException).
import java.lang.IllegalArgumentException;

/**
 * Ejercicio 2: esqueleto para escribir las instrucciones que le demos a los
 * dados
 *
 * @author David López Coronel
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("LANZANDO LOS DADOS");
        System.out.println("------------------");
        // No se requiere que el usuario introduzca ningún dato

        // 1. Pruebas del constructor
        // Se intentan crear 21 dados: desde 0 caras hasta 20 caras (bucle)
        // Sólo algunas llamadas al constructor funcionarán
        // Otras harán que salte una excepcíon IllegalArgumentException
        // Habrá que recogerla y mostrar el mensaje de error por pantalla
        
        for (int contador = 0; contador <= Dado.DEFAULT_NUMERO_CARAS + 14; contador++) {

            try {
                System.out.println("Intentando crear dado de " + contador + " caras. Correcto. Creado dado de " + (new Dado((byte) contador).getNumeroCaras()) + "caras.");
            } catch (IllegalArgumentException error) {
                System.out.println("Intentando crear dado de " + contador + " caras. Numero de caras no válido: " + contador);
            }
        }
        
        // 2. Creación de un dado de 6 caras 
        // Esta instanciación no debería dar problema 
        // (no es necesario encerrarla en un try-catch)
        Dado miDado = new Dado();
        System.out.println("\n\n2.Creación de un dado con " + miDado.getNumeroCaras() + " caras usando el constructor sin parámetros.");
        //----------------------------------------------
        //      Procesamiento + Salida de resultados 
        //----------------------------------------------

        // 3. Pruebas de lanzamiento: primer lanzamiento
        System.out.println("\n3.Llevamos a cabo un primer lanzamiento: " + miDado.lanzar());
        System.out.println("Número total de lanzamientos llevados a cabo hasta el momento: " + miDado.getNumeroLanzamientos());

        // 4. Pruebas de lanzamiento: otros 9 lanzamientos (bucle que se realiza nueve veces)
        System.out.println("\n4.Llevamos a cabo otros 9 lanzamientos. ");

        for (int contador = 1; contador <= 9; contador++) {
            System.out.print(miDado.lanzar() + " ");
        }

        // 5. Análisis de resultados        
        // 5.1. Número total de lanzamientos
        System.out.println("\n\n5.1.Número total de lanzamientos llevados a cabo hasta el momento: " + miDado.getNumeroLanzamientos());

        // 5.2. Análisis de los lanzamientos realizados (bucle desde 1 hasta el número de caras)
        System.out.println("\n5.2.Análisis de los lanzamientos llevados a cabo hasta el momento: ");
        for (int contador = 1; contador <= 6; contador++) {
            System.out.println("Número de veces que se ha obtenido " + contador + ": " + miDado.getNumeroVecesCara((byte) contador));
        }
        System.out.println(); //Simplemente para dar un espacio, para separame el resultado final del programa.
        
    }
}
