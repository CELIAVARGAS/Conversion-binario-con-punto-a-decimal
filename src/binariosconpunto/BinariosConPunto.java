/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binariosconpunto;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

/**
 *
 * @author esmeralda
 */
public class BinariosConPunto {

    /**
     * @param args the command line arguments
     */
    
        static Scanner lectura = new Scanner(System.in);

    static void compiladorBinarioConPunto() {
        try {
            String ruta = "src/binariosconpunto/";
            String opcFlex[] = {ruta + "lexico.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            String opcCUP[] = {"-destdir", ruta, "-parser", "parseO", ruta + "sintactico.cup"};
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void analisisBInarioConPunto(String texto) {
        try {
            System.out.println("Inicia analisis...");
            scanner scan = new scanner(new BufferedReader(new StringReader(texto)));
            parseO parser = new parseO(scan);
            parser.parse();
            System.out.println("\n Finaliza analisis...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        compiladorBinarioConPunto();
        String numero;
        System.out.println(" CONVERSION DE BINARIO CON PUNTO A DECIMAL ");
        System.out.println("Introduzca un numero binario.     Para salir presione 's'");
        do {
            numero = lectura.nextLine();
            analisisBInarioConPunto(numero);
        } while (!"s".equals(numero));
    }
    
}
