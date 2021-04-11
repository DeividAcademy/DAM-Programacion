package tarea3;

import java.time.DateTimeException;
import java.time.DayOfWeek; // La dejo aqui aunque no hago uso de DayOfWeek, pero como lo intente de hacer con el operador de comparación '==' para los dias de Sabado y Domingo.
import java.time.LocalDate;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ejercicio 3: esqueleto para el programa de fechas y turnos.
 *
 * @author David López Coronel
 */
public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        int lecturaTecladoAnyo = 0; //Inicializo las variables a 0 para evitar posibles errores de inicialización.
        int lecturaTecladoMes = 0;
        int lecturaTecladoDia = 0;
        String sabado = "SATURDAY";
        String domingo = "SUNDAY";
        int numAlumnos = 12;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ASIGNANDO TURNOS A FECHAS");
        System.out.println("-------------------------");

        // 1. Creación un objeto de la clase LocalDate con fecha de inicio de curso 
        // Fecha de inicio del curso
        LocalDate inicioCurso = LocalDate.of(2020, Month.SEPTEMBER, 15);

        // 2. Creación un objeto de la clase LocalDate con fecha de fin de curso 
        // Fecha de fin de curso
        LocalDate finCurso = LocalDate.of(2021, Month.JUNE, 22);

        // 3. Lectura por teclado y comprobación de año, mes y día
        // Clase Scanner para petición de datos
        Scanner teclado = new Scanner(System.in); // Lo declaro aqui como un nuevo objeto de la clase scanner.

        System.out.println("Introduzca la fecha para asiganar turno");

        // 3.1. Leer y comprobar del año (debe ser 2020 o bien 2021)        
        do {
            try {
                System.out.print("Introduzca año (debe ser 2020 o 2021: ");
                lecturaTecladoAnyo = teclado.nextInt();
            } catch (InputMismatchException excepcionAnyo) {
                System.out.print("\033[31mError de lectura: no es un número entero válido.\n\033[30m"); //Mirando extras para darle a esto un toque "red" a los mensajes de error.. Pues añadiendo (\033[31m) lo conseguimos.  
                teclado.nextLine(); // Para recoger la basura o en este caso el error.
            }
        } while (lecturaTecladoAnyo < 2020 || lecturaTecladoAnyo > 2021);

        // 3.2.  Leer y comprobar el mes (Lógicamente entre 1 y 12) 
        do {
            try {
                System.out.print("Introduzca el mes (entre 1 y 12): ");
                lecturaTecladoMes = teclado.nextInt();
            } catch (InputMismatchException excepcionMes) {
                System.out.print("\033[31mError de lectura: no es un número entero válido.\n\033[30m");
                teclado.nextLine();
            }
        } while (lecturaTecladoMes < 1 || lecturaTecladoMes > 12);

        // 3.3.  Leer y comprobar el día
        do {
            try {
                System.out.print("Introduzca el día (entre 1 y 31): ");
                lecturaTecladoDia = teclado.nextInt();
            } catch (InputMismatchException excepcionDia) {
                System.out.print("\033[31mError de lectura: no es un número entero válido.\n\033[30m");
                teclado.nextLine();
            }
        } while (lecturaTecladoDia < 1 || lecturaTecladoDia > 31);

        // 4. Creación de objeto LocalDate (si es posible) 
        // a partir de esos datos de fecha
        // Fecha leída (Saltará una excepción DateTimeException si por
        // ejemplo se intenta crear una fecha con 31 de febrero)
        try {
            LocalDate lecturaTeclado = LocalDate.of(lecturaTecladoAnyo, lecturaTecladoMes, lecturaTecladoDia); //Observo que este objeto se crea de manera temporal creo por el hecho de estar dentro del try - catch.           
            //Voy hacer un único bloque try - catch que me abarca los puntos 4.5.6.7 de este ejercicio, para no hacer redundancia a la hora de tener que volver a crear el LocalDate, creo está sería la mejor manera y más eficiente.

            //----------------------------------------------
            //      Procesamiento + Salida de resultados 
            //----------------------------------------------
            // 5. Comprobar si la fecha está dentro del período escolar, si no
            // lo está se informará y no haremos nada más        
            if (lecturaTeclado.isBefore(inicioCurso) || lecturaTeclado.isAfter(finCurso)) {
                System.out.println("\nResultado: está fuera del período escolar del curso.");
            } // 6. Si es sábado o domingo, no procede calcular nada 
            //   (lecturaTeclado.getDayOfWeek() == DayOfWeek.SATURDAY) || (lecturaTeclado.getDayOfWeek() == DayOfWeek.SUNDAY) //Lo intente probando hasta con Calendar.SATURDAY, etc, y tras ver la clase online lo volvi a intertar a ver si funcionaba pero no..
            else if (lecturaTeclado.getDayOfWeek().toString().equalsIgnoreCase(sabado) || lecturaTeclado.getDayOfWeek().toString().equalsIgnoreCase(domingo)) { //Lo voy a dejar de está manera, ya asi lo consegui hacer antes de ver las clases online.
                System.out.println("El día no puede ser sábado o domingo.");
            } // 7. Si la fecha es apropiada (correcta y no fin de semana)
            // se muestra por pantalla cuándo debe ir cada alumno a clase:
            // turno de mañana o de tarde
            else {
                if (lecturaTeclado.lengthOfMonth() % 2 == 1) {
                    for (int contador = 1; contador <= numAlumnos; contador++) {
                        System.out.print("El alumno número " + contador + " debe asistir por ");
                        if (contador % 2 == 1) {
                            System.out.println("la mañana el día " + lecturaTeclado);
                        } else {
                            System.out.println("la tarde el día " + lecturaTeclado);
                        }
                    }
                } else {
                    for (int contador = 1; contador <= numAlumnos; contador++) {
                        System.out.print("El alumno número " + contador + " debe asistir por ");
                        if (contador % 2 == 0) {
                            System.out.println("la mañana el día " + lecturaTeclado);
                        } else {
                            System.out.println("la tarde el día " + lecturaTeclado);
                        }
                    }
                }
            }

        } catch (DateTimeException excepcionLt) {
            System.out.println("\033[31mError! la fecha introducida no es valida!!\n\033[30m");
        }

        System.out.println(); //Simplemente para dejar un espacio con el resultado final del proceso del programa.
    }
}

