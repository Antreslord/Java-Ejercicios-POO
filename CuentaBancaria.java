/*
  Metodos:
  * Imprimir por pantalla los valores de los atributos de una cuenta bancaria.
  * Consultar el saldo de una cuenta bancaria.
  * Consignar un determinado valor en la cuenta bancaria, actualizando el saldo correspondiente.
  * Retirar un determinado valor de la cuenta bancaria, actualizando el saldo correspondiente. Es necesario tener en cuenta que no se puede realizar 
    el retiro si el valor solicitado supera el saldo actual de la cuenta.
  * Agregar a la clase CuentaBancaria, un atributo que represente el porcentaje de interés mensual aplicado a la cuenta.
  * Agregar un método que calcule un nuevo saldo aplicando la tasa de interés correspondiente.
*/

package POO;
public class CuentaBancaria {
    /*---------------------/ Atributos /---------------------*/
    private String nombres;
    private String apellidos;
    private int numeroCuenta;
    //------------------------
    private enum tipoCuenta {ahorros,corriente};
    private tipoCuenta cuenta;
    //------------------------
    private double saldo;
    private double intereses = 0.05;
    private boolean estado;
    
    /*---------------------/ Constructores /---------------------*/
    public CuentaBancaria(){}
    
    public CuentaBancaria(String nombres, String apellidos, int numeroCuenta, tipoCuenta cuenta){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroCuenta = numeroCuenta;
        this.cuenta = cuenta;
        this.saldo = 0; 
        this.estado = false;
    }
    /*---------------------/ Metodo compararCuentas() /---------------------*/
    public void compararCuentas(CuentaBancaria cuenta){
        if(saldo >= cuenta.saldo){
            System.out.println("El saldo de la cuenta actual es Mayor o Igual al saldo de la cuenta ingresada como parametro");
        }else{
            System.out.println("El Saldo de la cuenta actual es menor al saldo de la cuenta ingresada como paramatro");
        }
    }
    
    /*---------------------/ Metodo transferencia() /---------------------*/
    public void transferencia(CuentaBancaria cuenta, double valor){
        if(retirarDinero(valor)){ // depependiendo de true o false se puede realizar un retiro.
            cuenta.consignarDinero(valor);
        }
    }
    
    /*---------------------/ Metodos Especiales /---------------------*/
    //---/ Metodo retirarDinero() /---
    public boolean retirarDinero(double dinero){
    //Debe devolver un valor booleano ya que se necesita saber si la transaccion se puede realizar para siguientes METODOS;
        if((dinero+(intereses*dinero)) < saldo){
            saldo -= (dinero+(dinero*intereses));
            System.out.println("-----------------------------------");
            System.out.println("Transaccion de retiro Exitosa");
            System.out.println("Saldo Actualizado: "+saldo+ "$");
            System.out.println("Cobro por intereses: "+(dinero*intereses)+ "$");
            System.out.println("___________________________________");
            estado = (saldo > 0);
            return true;
        }else{
            System.out.println("Transaccion de retiro Fallida");
            System.out.println("El saldo de la cuenta es Insuficiente");
            return false;
        }
    }
    //---/ Metodo consignarDinero() /---
    public boolean consignarDinero(double dinero){ 
    //Debe devolver un valor booleano ya que se necesita saber si la transaccion se puede realizar para siguientes METODOS;
        if(dinero >0){
            saldo += dinero;
            System.out.println("-----------------------------------");
            System.out.println("Transaccion de consignacion Exitosa");
            System.out.println("Saldo Actualizado: "+saldo+ "$");
            System.out.println("___________________________________");
            estado = true;
            return true;
        }
        else{
            System.out.println("Valor ingresado Invalido");
            return false;
        }  
    }
    //---/ Metodo consultarValor() /---
    public void consultarSaldo(){
        String mostrarEstado = (estado == true)?"Activa":"Inactiva";
        System.out.println(  "------------- Banco Infravalor -------------"+"\n"+
                "____________________________________________"+"\n"+
                "\n"+
                "Numero de cuenta "+cuenta+": "+numeroCuenta+"\n"+
                "Estado de Cuenta: "+mostrarEstado+"\n"+
                "Saldo: "+saldo+"\n"+
                "____________________________________________");
    }
    //---/ Metodo toString() /---
    public String toString(){
        String mostrarEstado = (estado == true)?"Activa":"Inactiva";
        return  "------------- Banco Infravalor -------------"+"\n"+
                "____________________________________________"+"\n"+
                "\n"+
                "Nombre y Apellido del titular: "+nombres+" "+apellidos+"\n"+
                "Tipo de cuenta: "+cuenta+"\n"+
                "Numero de cuenta: "+numeroCuenta+"\n"+
                "Saldo en la cuenta: "+saldo+" $"+"\n"+
                "Estado de la cuenta: "+mostrarEstado+"\n"+
                "____________________________________________";
    }
    
    /*---------------------/ Metodos getters y setters /---------------------*/
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    //----------------------------
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    //----------------------------
    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    //----------------------------
    public tipoCuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(tipoCuenta cuenta) {
        this.cuenta = cuenta;
    }
    //----------------------------
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
    public static void main(String args[]){
        
        CuentaBancaria cuenta1 = new CuentaBancaria("Cristian", "Amaya Perez", 123456789, tipoCuenta.ahorros);
        
        CuentaBancaria cuenta2 = new CuentaBancaria("Julio", "Rodriguez", 987654321, tipoCuenta.ahorros);
        
        System.out.println(cuenta1);
        cuenta1.consignarDinero(20000);
        cuenta1.retirarDinero(15000);
        cuenta1.consultarSaldo();
        cuenta1.retirarDinero(5000);
        cuenta1.retirarDinero(1000);
        cuenta1.consultarSaldo();
        System.out.println("*******************************************************");
        cuenta1.transferencia(cuenta2, 1000);
        //---------------------------------------
        cuenta1.consultarSaldo();
        cuenta2.consultarSaldo();

    }
}
