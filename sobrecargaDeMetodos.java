package POO;
public class Pedido {
    
    /*----------------------/ Metodos Sobrecargados /----------------------*/
    //-------/ Metodo 1 /-------
    public void calcularPedido(String primerPlato, double costoPrimerPlato, String bebida, double costoBebida){
        double total = costoPrimerPlato + costoBebida;
        System.out.println("El costo de "+primerPlato+" y "+bebida+" es: $"+total);
    }
    
    //-------/ Metodo 2 /-------
    public void calcularPedido(String primerPlato, double costoPrimerPlato, String segundoPlato, double costoSegundoPlato,
            String bebida, double costoBebida)
    {
        double total = costoPrimerPlato + costoBebida + costoSegundoPlato;
        System.out.println("El costo de "+primerPlato+", "+segundoPlato+" y "+bebida+" es: $"+total);
    }
    
    //-------/ Metodo 2 /-------
    public void calcularPedido(String primerPlato, double costoPrimerPlato, String segundoPlato, double costoSegundoPlato,
            String postre, double costoPostre, String bebida, double costoBebida)
    {
        double total = costoPrimerPlato + costoBebida + costoSegundoPlato+costoPostre;
        System.out.println("El costo de "+primerPlato+", "+segundoPlato+", "+postre+"y "+bebida+" es: $"+total);
    }
    
    public static void main(String args[]){
        Pedido pedido1 = new Pedido();
        pedido1.calcularPedido("Sancocho", 6000, "Pepsi", 2000);
        
        Pedido pedido2 = new Pedido();
        pedido2.calcularPedido("Crema de Verduras", 5000, "Churrasco",18000, "Gaseosa", 2000);
        
        Pedido pedido3 = new Pedido();
        pedido3.calcularPedido("Crema de Espinacas", 4000, "Mojarra", 20000, "Pastel", 8000, "Vino", 40000);
    }
}
