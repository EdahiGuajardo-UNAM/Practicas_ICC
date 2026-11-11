/**
 * Clase que modela un paquete para una empresa de envios postales y paqueteria.
 * Permite registrar sus dimensiones espaciales, peso fisico y valor declarado,
 * asi como calcular su peso volumetrico y determinar el peso cobrable final.
 * 
 * @author Cesar Edahi Guajardo Barreto
 * @version 1.0
 */
public class Paquete {

    // *** ATRIBUTOS ***
    // POR HACER: Declara los atributos necesarios de acuerdo a tu diseno y a la documentacion.
    // Recuerda aplicar el principio de encapsulamiento (declararlos privados).

    private String id;
    private double pesoFisico;
    private int alto;
    private int ancho;
    private int largo;
    private double valorDeclarado;


    // *** CONSTRUCTORES ***
    // Constructor con parámetros

    public Paquete(String id, double pesoFisico,int alto,int ancho,int largo,double valorDeclarado){
        if(alto<1){
            throw new IllegalArgumentException("La altura del objeto debe ser mayor a 0 cm");
        }

        if(ancho<1){
            throw new IllegalArgumentException("El ancho debe ser mayor a 0 cm");
        }

        if(largo<1){
            throw new IllegalArgumentException("El largo debe ser mayor a 0 cm");
            
        }

        if(pesoFisico<0.1){
            throw new IllegalArgumentException("El peso debe ser mayor a 0.0 kg");

        }

        if(valorDeclarado<1.0){
            throw new IllegalArgumentException("El valor declarado debe ser mayor a 0.0 MXN");
        }
        this.id=id;
        this.pesoFisico=pesoFisico;
        this.alto=alto;
        this.ancho=ancho;
        this.largo=largo;
        this.valorDeclarado=valorDeclarado;

    }

    //Constructor sin parámetros

    public Paquete(){
        this.id="0";
        this.pesoFisico=0.1;
        this.alto=1;
        this.ancho=1;
        this.largo=1;
        this.valorDeclarado=1.0;
    }


    // *** METODOS DE ACCESO Y ASIGNACION ***
    // POR HACER: Agrega los metodos de consulta (getters) y de modificacion (setters) necesarios.

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id=id;
        
    }

    public double getPesoFisico(){
        return this.pesoFisico;
    }

    public void setPesoFisico(double pesoFisico){
        this.pesoFisico=pesoFisico;
    }

    public int getAlto(){
        return this.alto;
    }

    public void setAlto(int alto){
        this.alto=alto;
    }

    public int getAncho(){
        return this.ancho;
    }

    public void setAncho(int ancho){
        this.ancho=ancho;
    }
    public int getLargo(){
        return this.largo;
    }

    public void setLargo(int alto){
        this.largo=largo;
    }

    public double getValorDeclarado(){
        return this.valorDeclarado;
    }

    public void setValorDeclarado(double valorDeclarado){
        this.valorDeclarado=valorDeclarado;
    }    


    // *** METODOS CALCULADORES BASE ***

    /**
     * Calcula el peso volumetrico del paquete segun el estandar comercial (IATA):
     * (largo * ancho * alto) / 5000.
     * 
     * @return El peso volumetrico equivalente en kilogramos.
     * 
     */
    public double calculaPesoVolumetrico() {
        double peso_vol=(getLargo()*getAncho()*getAlto())/5000.0;
        return peso_vol;
    }

    /**
     * Determina el peso cobrable final para efectos de tarificacion postal,
     * el cual corresponde al valor maximo entre el peso fisico y el volumetrico.
     * 
     * @return El mayor entre el peso real y el peso volumetrico.
     */
    public double obtenerPesoCobrable() {
        // POR HACER: Implementa la comparacion entre peso real y peso volumetrico

        double peso_cobrable=Math.max(getPesoFisico(), calculaPesoVolumetrico());
        return peso_cobrable;
    }


    // *** PROPUESTA PERSONAL ***
    // POR HACER: Agrega aqui al menos un nuevo metodo calculador util para la empresa
    // (ejemplo: recargo por envio express, costo por material fragil, descuento local, etc.)
    // Incluye sus comentarios Javadoc y los atributos necesarios.


        /**
     * Determina el valor de la prima del seguro de aproximadamente 0.5%
     *      * 
     * @return EL Producto del valor declarada * el 0.5%
     */
    public double calculoSeguro(){
        if(valorDeclarado>500.0){
            return valorDeclarado*0.05;

        }
        
        return valorDeclarado*0.03;
    }

    

}
