package programacion4_potencia;

import java.util.Scanner;

public class Programacion4_Potencia {
    
    //----------/ Atributos /----------
    private double base;
    private double exponente;
    private double resultado;
    
    
    //----------/ constructores /----------
    public Programacion4_Potencia(){}
    
    public Programacion4_Potencia(double base, double exponente){
        this.base = base;
        this.exponente = exponente;
    }
    
    //----------/ metodo de calcular potencia /----------
    public double calcular(double base, double exponente){
        double resultado = 1;
        if(exponente > 0){
            for(int i = 0; i < exponente; i++){
                resultado *= base;
            }
            //System.out.println("El resultado de la potencia es: "+resultado);
            return resultado;
        }
        else if(exponente == 0){
            //System.out.println("El resultado de la potencia es: "+resultado);
            return 1;
        }
        else{
            for(int i = 0; i > exponente; i--){
                resultado *= base;
            }
            
            resultado = (1/resultado);
            //System.out.println("El resultado de la potencia es: "+resultado);
            
            return resultado;
        }
    }
    
    //----------/ metodo toString() /----------
    public String toString(){
        resultado = calcular(base, exponente);
        return  "La Base = "+base+"\n"+
                "El Exponente = "+exponente+"\n"+
                "El Resultado = "+ resultado+"\n"+
                "------------------------------------------";
    }
    
    //----------/ metodo Mostrar Menu /----------
    public static void mostrarMenu(){
        System.out.println( "------------/ MENU /------------"+"\n"+
                            "ELIJA ENTRE LAS OPCIONES:   "+"\n"+
                            "1. Añadir Potencia"+"\n"+
                            "2. Imprimir las potencias"+"\n"+
                            "3. Salir ");
    }
    
    //----------/ Metodos getters y setters /----------
    public double getBase() {
        return base;
    }
    public void setBase(double base) {
        this.base = base;
    }

    public double getExponente() {
        return exponente;
    }
    public void setExponente(double exponente) {
        this.exponente = exponente;
    }
    
    public double getResultado(){
        return resultado;
    }
    
///////////////////////////////////////////////////////////////////////////////
     
    public static void main(String[] args) {
        //pedir por consola
        Scanner sca = new Scanner(System.in);
        
        //iterador
        int i = 0;
        
        //coleccion de objetos
        Programacion4_Potencia potencias[] = new Programacion4_Potencia[5];
        
        int eleccion = 0;
        
        do{
            if(eleccion == 2){
                System.out.println( "------------------------------"+"\n"+
                                    "    IMPRESION DE POTENCIAS"+"\n"+
                                    "------------------------------");
                for(int j = 0; j < potencias.length; j++){
                    System.out.println("    Potencia n°"+(j));
                    System.out.println(potencias[j]);
                }
            }
            if(i < 5){
                //Pedir base y exponente
                System.out.println("Ingrese la Base:  ");
                double bas = sca.nextDouble();
                System.out.println("Ingrese el Exponente:  ");
                double exp = sca.nextDouble();
            
                //agregar nuevo Objeto potencia
                potencias[i] = new Programacion4_Potencia(bas, exp);
            
                //Imprimir
                //System.out.println(potencias[i]);
            
                i++;
            }
            else{
                System.out.println( "##########  ERORR  ##########"+"\n"+
                                    "El Array de 5 posiciones esta lleno");
            }
            
            //Mostrar menu
            Programacion4_Potencia.mostrarMenu();
            
            //Pedir al usuarion indicaciones
            eleccion = sca.nextInt();
            
        }while(eleccion != 3);
        
        /*Programacion4_Potencia p1 = new Programacion4_Potencia(2, -2);
        
        p1.calcular(p1.getBase(), p1.getExponente());*/
        
    }
    
}
