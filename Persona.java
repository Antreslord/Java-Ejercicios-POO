# Persona
package POO;

public class Persona {
    
    /*Crear un programa de clase persona. Una persona posee: nombre, apellido, número de documento de identidad y año de
      nacimiento. 
      - La clase debe tener un constructor que inicialice los valores de sus respectivos atributos.
      - La clase debe incluir los siguientes métodos:
          * Definir un método que imprima en pantalla los valores de los atributos del objeto.
          * En un método main se deben crear dos personas y mostrar los valores de sus atributos en pantalla.
          * Agregar dos nuevos atributos a la clase Persona. Un atributo que represente el país de nacimiento de la persona (de tipo String) y otro que 
            identifique el género de la persona, el cual debe representarse como un char con valores 'H' o 'M'.
          * Modificar el constructor de la clase Persona para que inicialice estos dos nuevos atributos.
          * Modificar el método imprimir de la clase Persona para que muestre en pantalla los valores de los nuevos atributos.*/
    
    /*--------------/ Atributos /-------------*/
    private String nombre,apellido,DNI,paisNacimiento;
    private int anioNacimiento;
    private char genero;
    
    /*-------------/ Constructores /-------------*/
    public Persona(){
        
    }
    
    public Persona(String nombre, String apellido, String DNI, int anioNacimiento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.anioNacimiento = anioNacimiento;
    }
    
    public Persona(String nombre, String apellido, String DNI, int anioNacimiento,String paisNacimiento,char genero){
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.anioNacimiento = anioNacimiento;
        this.paisNacimiento = paisNacimiento;
        if(genero == 'F' || genero == 'f'){
            this.genero = 'F';
        }
        if(genero == 'M' || genero == 'm'){
            this.genero = 'M';
        }
    }
    /*---------------/ Metodo imprimir() /---------------*/
    public void imprimir(){
        System.out.println( "Nombre: "+getNombre()+"\n"
                           +"Apellido: "+getApellido()+"\n"
                           +"DNI: "+getDNI()+"\n"
                           +"Año de Nacimiento: "+getAnioNacimiento()+"\n"
                           +"Pais de nacimiento: "+getPaisNacimiento()+"\n"
                           +"Genero: "+definirGenero());
    }
    
    /*--------------/ Definir Genero /--------------*/
    public String definirGenero(){
        if(getGenero() == 'F'){
            return "Femenino";
        }else{
            return "Masculino";
        }
    }
    
    /*------------/ Metodos set /------------ */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setDNI(String DNI){
        this.DNI = DNI;
    }
    public void setAnioNacimiento(int anioNacimiento){
        this.anioNacimiento = anioNacimiento;
    }
    public void setPaisNacimiento(String paisNacimiento){
        this.paisNacimiento = paisNacimiento;
    }
    public void setGenero(char genero){
        if(genero == 'H' || genero == 'h'){
            this.genero = 'H';
        }
        if(genero == 'M' || genero == 'm'){
            this.genero = 'M';
        }
    }
    
    /*------------/ Metodos get /------------ */
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getDNI(){
        return DNI;
    }
    public int getAnioNacimiento(){
        return anioNacimiento;
    }
    public String getPaisNacimiento(){
        return paisNacimiento;
    }
    public char getGenero(){
        return genero;
    }
    
    /*-----------/ Metodo Estatico /----------*/
    public static void separar(){
        System.out.println("--------------------------");
    }
}

/*----------------------------------------------------------------------------------------------------------------------------------------------------*/

package POO_Test;
import POO.Persona; //<- importar del package Persona
public class Test_Persona {
    public static void main(String[] args) {
        
        Persona p1 = new Persona("sergio","bonilla","45103",1963);
        Persona p2 = new Persona();
        Persona p3 = new Persona("Felipe", "Villanueva", "789456123d", 1998, "Colombia", 'F');
        
        p2.setNombre("Camilo");
        p2.setApellido("Galvan");
        p2.setAnioNacimiento(1991);
        p2.setDNI("123456789");
        
        p1.imprimir();
        Persona.separar();
        p2.imprimir();
        Persona.separar();
        p3.imprimir();
        
    } 
}

