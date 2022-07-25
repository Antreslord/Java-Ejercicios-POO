/*
  * Metodos getters y setters
  * Constructores
  * Metodos: acelerar(), desacelerar(), frenar()
  * Metodo para calcular el tiempo de llegada entre (distancia Km)/velocidadActual
  * Metodo para mostrar los valores del Automovil
  * con el metodo acelerar Modificar que cuando sobrepase el limite de velocidadMaxima se genere un multa
  * Crear un metodo para saber si el Automovil tiene multas.
*/

package POO;
public class Automovil {
    
    /*---------------------------/ Atributos /---------------------------*/
    private String marca;
    private int anioFabricacion;
    private float volumenLitros;
    //---------------------------
    private enum tipoCombustible {gasolina,bioetanol,diesel,biodiesel,gasnatural};
    private tipoCombustible combustible;
    //---------------------------
    private enum tipoVehiculo {ciudad, subcompacto, compacto, familiar, ejecutivo, SUV};
    private tipoVehiculo vehiculo;
    //---------------------------
    private int numeroPuertas;
    private int numeroAsientos;
    private int velocidadMaxima;
    //---------------------------
    private enum tipoColor {blanco, negro, rojo, naranja, amarillo, azul, violeta};
    private tipoColor color;
    //---------------------------
    private float velocidadActual;
    private boolean esAutomatico;
    private double multas;
    
    
    /*---------------------------/ Constructores /---------------------------*/
    public Automovil(String marca, int anioFabricacion, float volumenLitros, tipoCombustible combustible, tipoVehiculo vehiculo,
                     int numeroPuertas, int numeroAsientos, int velocidadMaxima, tipoColor color, float velocidadActual,
                     boolean esAutomatico)
    {
        this.marca = marca;
        this.anioFabricacion = anioFabricacion;
        this.volumenLitros = volumenLitros;
        this.combustible = combustible;
        this.vehiculo = vehiculo;
        this.numeroPuertas = numeroPuertas;
        this.numeroAsientos = numeroAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.color = color;
        this.velocidadActual = velocidadActual;
        this.esAutomatico = esAutomatico;
    }
    
    public Automovil(){}
    
    /*---------------------------/ Metodos Especiales /---------------------------*/
    //----------Metodo Acelerar----------
    public void acelerar(float aceleracion){
        if((velocidadActual+aceleracion) < velocidadMaxima){
            velocidadActual += aceleracion;
            System.out.println("Velocidad Actual: +"+velocidadActual+" Km/h");
        }
        else if((velocidadActual+aceleracion) > velocidadMaxima){
            System.out.println(reciboMulta(aceleracion));
            multas += 1000;
        }
    }
    public String reciboMulta(float aceleracion){
        return  "-------------------------------------------------------"+"\n"+
                "¡¡¡COBRO DE MULTA POR SOBREPASAR LA VELOCIDAD MAXIMA!!!"+"\n"+
                "-------------------------------------------------------"+"\n"+
                "\n"+
                "velocidad NO PERMITIDA  "+(velocidadActual+aceleracion)+" Km/h"+"\n"+
                "Por concepto de exceso de velocidad."+"\n"+
                "Por el valor de 1,000 $."+"\n"+
                "-------------------------------------------------------";
    }
    //----------Metodo Desacelerar----------
    public void desacelerar(float desaceleracion){
        if((velocidadActual > 0) && (velocidadActual < velocidadMaxima)){
            velocidadActual -= desaceleracion;
            System.out.println("Velocidad Actual: -"+velocidadActual+" Km/h");
        }else{
            System.out.println("¡¡¡Velocidad Mininma!!!");
        }
    }
    //----------Metodo Frenar----------
    public void frenar(){
        velocidadActual = 0;
        System.out.println("Has frenado. Velocidad Actual: "+velocidadActual+" Km/h");
    }
    //----------Metodo Calcular Tiempo----------
    public void tiempoEnLlegar(int recorrido){
        int tiempo = (int)((recorrido * 1000)/velocidadActual);
        if(tiempo > 60){
            int horas = tiempo/60;
            int minutos = tiempo % 60;
            System.out.println("Se estima que llegara a su destino en: "+horas+":"+minutos+" hrs");
        }else{
            System.out.println("Se estima que llegara a su destino en "+tiempo+" min");
        }
    };
    //----------Comprobar multas----------
    public void comprobarMultas(){
        if(multas > 0){
            System.out.println("Posee multas con un total de : "+multas);
        }else{
            System.out.println("El Automovil NO POSEE multas");
        }
    }
    //----------Metodo toString()----------
    public String toString(){
        return  "Marca de Automovil: "+marca+"\n"+
                "Año de Fabricacion: "+anioFabricacion+"\n"+
                "Cilindraje del Motor: "+volumenLitros+"\n"+
                "Tipo de Combustible: "+combustible+"\n"+
                "Tipo de Vehiculo: "+vehiculo+"\n"+
                "Numero de puertas: "+numeroPuertas+"\n"+
                "Numero de Asientos: "+numeroAsientos+"\n"+
                "Velocidad Maxima: "+velocidadMaxima+" Km/h"+"\n"+
                "Color: "+color+"\n"+
                "Velocidad Actual: "+velocidadActual+" Km/h"+"\n"+
                "Es automatico: "+esAutomatico;
    }
    /*---------------------------/ Metodos setter y getters /---------------------------*/
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    //----------------------------------------
    public int getAnioFabricacion() {
        return anioFabricacion;
    }
    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
    //----------------------------------------
    public float getVolumenLitros() {
        return volumenLitros;
    }
    public void setVolumenLitros(float volumenLitros) {
        this.volumenLitros = volumenLitros;
    }
    //----------------------------------------
    public tipoCombustible getCombustible() {
        return combustible;
    }
    public void setCombustible(tipoCombustible combustible) {
        this.combustible = combustible;
    }
    //----------------------------------------
    public tipoVehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(tipoVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    //----------------------------------------
    public int getNumeroPuertas() {
        return numeroPuertas;
    }
    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }
    //----------------------------------------
    public int getNumeroAsientos() {
        return numeroAsientos;
    }
    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }
    //----------------------------------------
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    //----------------------------------------
    public tipoColor getColor() {
        return color;
    }
    public void setColor(tipoColor color) {
        this.color = color;
    }
    //----------------------------------------
    public float getVelocidadAcutal() {
        return velocidadActual;
    }
    public void setVelocidadAcutal(float velocidadAcutal) {
        this.velocidadActual = velocidadAcutal;
    }
    //----------------------------------------
    public boolean getEsAutomatico(){
        return esAutomatico;
    }
    public void setEsAutomatico(boolean esAutomatico){
        this.esAutomatico = esAutomatico;
    }
    //----------------------------------------
    public double getMultas(){
        return multas;
    }
    //-----------------------------------------------------------------------------------------------------------
    public static void main(String args[]){
        
        Automovil auto = new Automovil("Renault", 2016, (float) 2.5, tipoCombustible.gasolina, tipoVehiculo.familiar, 5, 6, 80, tipoColor.negro, (float)40.5,false);
        
        System.out.println(auto);
        auto.acelerar(30);
        auto.acelerar(15);
        auto.comprobarMultas();
    }
}
