package POO;
public class Planeta {
    /*----------/ Atributos /----------*/
    private String nombre = null;
    private int satelites = 0;
    private double masaKG = 0;
    private double volumenKM3 = 0;
    private int diametroKM = 0;
    private int distanciaAlSolKM = 0;
        //----------------------
    private enum tipoPlaneta {GASEOSO, TERRESTRE, ENANO};
    private tipoPlaneta tipo;
        //----------------------
    private boolean esObservable = false;
    
    /*---------/ Constructores /---------*/
    public Planeta(){
    }
    
    public Planeta(String nombre, int satelites, double masaKG, double volumenKM3, int diametroKM,
            int distanciaAlSolKM, tipoPlaneta tipo, boolean esObservable){
        this.nombre = nombre;
        this.satelites = satelites;
        this.masaKG = masaKG;
        this.volumenKM3 = volumenKM3;
        this.diametroKM = diametroKM;
        this.distanciaAlSolKM = distanciaAlSolKM;
        this.tipo = tipo;
        this.esObservable = esObservable;
    }
    
    /*----------/ Metodo Sring /----------*/
    public String toString(){
        return  "Nombre del planeta: "+getNombre()+"\n"+
                "N° de Satelites: "+getSatelites()+"\n"+
                "N° masa en Kilogramos: "+getMasaKG()+"\n"+
                "N° volumen en KM^3: "+getVolumenKM3()+"\n"+
                "N° diametro en KM: "+getDiametroKM()+"\n"+
                "N° KM de distancia al sol: "+getDistanciaAlSolKM()+"\n"+
                "Tipo de Planeta: "+getTipo()+"\n"+
                "¿Es observable?: "+getEsObservable();
    }
    
    /*----------/ Calcular la densidad de un planeta /----------*/
    public double calcularDensidad(){
        return getMasaKG()/getVolumenKM3();
    }
    
    /*----------/ Considerar si un planeta es del exterior /----------*/
    /*  Un planeta exterior está situado más allá del cinturón de asteroides. El cinturón de asteroides se encuentra 
        entre 2.1 y 3.4 UA. Una unidad astronómica (UA) es la distancia entre la Tierra y el Sol, UA = 149 597 870 Km.
            * 1(UA) = 149 597 870Km.
    */
    public String esPlanetaExterior(){
        boolean confirmacion;
        float limite = (float)(149597870 * 3.4);
        /*Un planeta exterior esta situado mas alla del cinturon de asteroides*/
        /*El cinturon se encuentra entre 2,1 y 3,4 UA. Donde (UA = 149'597.870 Km)*/
        confirmacion = distanciaAlSolKM > limite;
        
        if(confirmacion == true){
            return "Se considera un planeta exterior";
        }else{
            return "No se considera un planeta exterior";
        }
    }
    
    /*------------------/ Metodos setters /-----------------*/
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //-------------------------------------
    public int getSatelites() {
        return satelites;
    }
    public void setSatelites(int satelites) {
        this.satelites = satelites;
    }
    //-------------------------------------
    public double getMasaKG() {
        return masaKG;
    }
    public void setMasaKG(double masaKG) {
        this.masaKG = masaKG;
    }
    //-------------------------------------
    public double getVolumenKM3() {
        return volumenKM3;
    }
    public void setVolumenKM3(double volumenKM3) {
        this.volumenKM3 = volumenKM3;
    }
    //-------------------------------------
    public int getDiametroKM() {
        return diametroKM;
    }
    public void setDiametroKM(int diametroKM) {
        this.diametroKM = diametroKM;
    }
    //-------------------------------------
    public int getDistanciaAlSolKM() {
        return distanciaAlSolKM;
    }
    public void setDistanciaAlSolKM(int distanciaAlSolKM) {
        this.distanciaAlSolKM = distanciaAlSolKM;
    }
    //-------------------------------------
    public tipoPlaneta getTipo() {
        return tipo;
    }
    public void setTipo(tipoPlaneta tipo) {
        this.tipo = tipo;
    }
    //-------------------------------------
    public boolean getEsObservable() {
        return esObservable;
    }
    public void setEsObservable(boolean esObservable) {
        this.esObservable = esObservable;
    }
    
    
    public static void main(String args[]){
        Planeta planeta1 = new Planeta("ARGS-1504", 5, 9.5487E24, 3.0214E14, 45246, 850000000, tipoPlaneta.GASEOSO, true);
        
        Planeta tierra = new Planeta("Tierra", 1, 5.9736E24, 1.08321E12, 12742, 150000000, tipoPlaneta.TERRESTRE, true);

        System.out.println(tierra.toString());
        System.out.println("------------------------------------");
        System.out.println("La densidad del planeta es: "+tierra.calcularDensidad());
        System.out.println("------------------------------------");
        System.out.println("¿Es un planeta exterior?: "+tierra.esPlanetaExterior());
        System.out.println("");
        System.out.println();
        System.out.println();
        
        System.out.println(planeta1.toString());
        System.out.println("------------------------------------");
        System.out.println("La densidad del planeta es: "+planeta1.calcularDensidad());
        System.out.println("------------------------------------");
        System.out.println("¿Es un planeta exterior?: "+planeta1.esPlanetaExterior());
    }   
}
