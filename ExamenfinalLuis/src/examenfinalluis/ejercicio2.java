package examenfinalluis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ejercicio2 {
    //EJERCICIO2
    static void guardarM(int m[][]) throws IOException {
        File matrixg = new File("matrix.txt");
        if(matrixg.exists()){
            matrixg.delete();
        }
        for (int[] m1 : m) {
            String l = "";
            for (int j = 0; j < m1.length; j++) {
                l += m1[j];
                if (j != m1.length - 1) {
                    l += ","; 
                }
            }
            try ( FileWriter fw = new FileWriter(matrixg, true);  BufferedWriter bw = new BufferedWriter(fw);  PrintWriter out = new PrintWriter(bw)) {
                out.println(l);
            } catch (IOException e) {
                //exception handling left as an exercise for the reader
            }
        }
    }
    static int[][] leerArchivo()throws IOException{
        int matrixg[][] = new int [2][2];
        Scanner matrix = new Scanner(new File("matrix.txt"));
        for (int[] mg1 : matrixg) {
            if(!matrix.hasNextLine()){
                break;
            }   String [] datos = matrix.nextLine().split(",");
            for (int j = 0; j < datos.length; j++) {
                mg1[j] = Integer.parseInt(datos[j]);
            }
        }
        return matrixg;
    } 
    public static void main(String[] args)throws IOException {
        int matrix[][] = new int [2][2];
        int matrix2[][] = new int [2][2];
        matrix[0][0] = 6;
        matrix[0][1] = 3;
        matrix[1][0] = 9;
        matrix[1][1] = 2;
        guardarM(matrix);
        int matrixc[][] = leerArchivo();
        Scanner s = new Scanner (System.in);
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Ingrese los valores en la posicion i " + i + " y j "+ j + ": "); 
                matrix2[i][j] = s.nextInt();
            }   
        }
        Boolean e = true;
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                if(matrix2[i][j] != matrixc[i][j]){
                    e= false;
                    break;
                }          
           }
        }
        if (!e){
            System.out.println("Las matrices son diferentes");  
        } else {
            System.out.println("Las matrices son iguales");
            
        }
    }
}    

