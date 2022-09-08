package com.mycompany.conversion;

import java.util.Scanner;

public class Conversion {
    
    //atributos
    private int numero;
    private int base;
    private String resultado;
    
    //Constructores
    public Conversion(){}
    
    public Conversion(int numero, int base){
        this.numero = numero;
        this.base = base;
        
    }
    
    //metodo conversion
    public String conversion(int numero, int base){
        String cadena = "";
        String reverso = "";
        int aux;
        if((base > 1) && (base < 10))
        {
            while(numero > base){
                aux = numero % base;
                cadena += String.valueOf(aux);
                numero /= base;
            }
            cadena += String.valueOf(numero);
        }
        else if((base > 9) && (base < 17))
        {
            while(numero > base)
            {
                aux = numero % base;
                switch(aux)
                {
                    case 10 -> cadena += "A";
                    case 11 -> cadena += "B";
                    case 12 -> cadena += "C";
                    case 13 -> cadena += "D";
                    case 14 -> cadena += "E";
                    case 15 -> cadena += "F";
                    default -> cadena+= String.valueOf(aux);
                }
                numero /= base;
            }
            if(numero > 9)
            {
                switch(numero)
                    {
                        case 10 -> cadena += "A";
                        case 11 -> cadena += "B";
                        case 12 -> cadena += "C";
                        case 13 -> cadena += "D";
                        case 14 -> cadena += "E";
                        case 15 -> cadena += "F";
                    }
            }
            else
            {
            cadena += String.valueOf(numero);
            }
        }
        
        for(int i = cadena.length()-1; i >= 0; i--)
        {
            reverso += cadena.charAt(i);
        }
        
        return reverso;
    }
    
    //metodo toString
    @Override
    public String toString(){
        resultado = conversion(numero, base);
        return  "Numero ingresado = "+numero+"\n"+
                "Base Ingresada = "+base+"\n"+
                "Resultado = "+resultado;
    }
    
    //Metodos getters y setters
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getBase() {
        return base;
    }
    public void setBase(int base) {
        this.base = base;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        
        System.out.println("Ingrese numero");
        int numero = sca.nextInt();
        
        System.out.println("Ingrese base");
        int base = sca.nextInt();
        
        Conversion c1 = new Conversion(numero, base);
        
        System.out.println(c1);
    }
}
