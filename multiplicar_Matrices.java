package com.mycompany.matrices;

import java.util.Scanner;

public class Matrices {
    
    static Scanner sca = new Scanner(System.in);
    
    //atributos 
    private int matriz[][];

    //constructores 
    //---------/ carga aleatoria /--------
    public Matrices(){
        matriz = new int[3][3];
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                matriz[i][j] = (int)Math.floor(Math.random()* (9)+1);
            }
        }
    }
    
    //---------/ Datos ingresados /----------
    public Matrices(int x[][]){
        matriz = x;
    }
    
    //--------/ multiplicar matrices /---------
    public Matrices(int m1[][], int m2[][]){ 
        matriz = new int[m1.length][m2[0].length];
        
        int aux[][] = new int[3][3];
        
        for(int i = 0; i < m1.length; i++){
            for(int j = 0; j < m2[0].length; j++){
                for(int k = 0; k < m1.length; k++){
                    aux[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        
        matriz = aux;
    }
    
    //metodo llenar matriz
    public static int[][] llenarMatriz(){
        int MAux[][] = new int[3][3];
        
        for(int i = 0; i < MAux.length; i++){
            for(int j = 0; j < MAux[0].length; j++){
                System.out.print("Ingrese numero:  ");
                MAux[i][j] = sca.nextInt();
            }
        }
        
        return MAux;
    }
    
    //metodo toString()
    @Override
    public String toString(){
        String mostrarMatriz = "";
        
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                mostrarMatriz += matriz[i][j] + "\t";
            }
            mostrarMatriz += "\n";
        }
        
        return mostrarMatriz;
    }
    
    //metodo get
    public int[][] getMatriz() {
        return matriz;
    }
    
    
    
    public static void main(String[] args) {
        
        Matrices m1 = new Matrices();
        
        Matrices m2 = new Matrices();
        
        System.out.println(m1);
        System.out.println(m2);
        
        Matrices m3 = new Matrices(m1.getMatriz(), m2.getMatriz());
        System.out.println(m3);
        
        int max[][] = Matrices.llenarMatriz();
        Matrices m4 = new Matrices(max);
        
        System.out.println(m4);
        
    }
}
