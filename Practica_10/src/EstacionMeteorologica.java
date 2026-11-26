import java.util.Arrays;
/**
 * Modela una estacion meteorologica universitaria que almacena y procesa
 * las temperaturas diarias (en grados Celsius) de un periodo de monitoreo.
 *
 * @author [Tu Nombre Completo]
 * @version 1.0
 */
public class EstacionMeteorologica {

    // ATRIBUTOS 
    // POR HACER 

    private String nombreEstacion;
    private double[] temperaturas;


    // CONSTRUCTORES

    /**
     * Inicializa la estacion con el nombre predeterminado "Estacion UNAM"
     * y reserva espacio para una semana (7 dias), marcando cada posicion
     * inicialmente sin lectura registrada (-300.0).
     */
    public EstacionMeteorologica() {
        // POR HACER (1.1): Inicializa nombre, arreglo e inicializa todas las casillas con ciclo for.

        this.nombreEstacion="Estacion UNAM";
        this.temperaturas=new double[7];
        for(int i=0;i<this.temperaturas.length; i++){
            this.temperaturas[i]=-300.0;
        }

    }

    // POR HACER (Parte 5.3): Redacta la documentacion Javadoc para este constructor y los metodos restantes.
    public EstacionMeteorologica(String nombreEstacion, int numDias) {
        // POR HACER (1.2): Valida nombreEstacion y numDias; crea el arreglo e inicializa sus casillas en -300.0.
        if(nombreEstacion!=null ){
            this.nombreEstacion=nombreEstacion;
   
        }else{
            this.nombreEstacion="Estacion UNAM";

        }

        if(numDias>0){
            this.temperaturas=new double[numDias];
            for(int i=0;i<this.temperaturas.length; i++){
                this.temperaturas[i]=-300.0;
        }

        }else{
            this.temperaturas=new double[7];
            for(int i=0;i<this.temperaturas.length; i++){
                this.temperaturas[i]=-300.0;
            }

        }
    }

    // METODOS DE CONSULTA Y REGISTRO (PARTE 1)

    public String getNombreEstacion() {
        // POR HACER (1.3)
        return this.nombreEstacion;
    }

    public int getNumeroDias() {
        // POR HACER (1.3)
        return this.temperaturas.length;
    }

    /**
     * Registra la temperatura de un dia especifico en grados Celsius.
     * Solo modifica el arreglo si el indice es valido y la temperatura esta
     * dentro del rango fisico ambiental [-90.0, 60.0].
     *
     * @param indiceDia Posicion del dia a registrar (desde 0 hasta N - 1).
     * @param temp Temperatura ambiental registrada en grados Celsius.
     * @return true si el dato fue valido y se almaceno; false en caso contrario.
     */
    public boolean registrarTemperatura(int indiceDia, double temp) {
        if(this.temperaturas!=null&&
            indiceDia<temperaturas.length&&
            indiceDia>=0&&
            temp>=-90.0&&
            temp<=60.0){
            this.temperaturas[indiceDia]=temp;
            return true;
        }
        // POR HACER (1.4): Valida indiceDia y el rango fisico de temp.
        return false;
    }

    public double obtenerTemperatura(int indiceDia) {
        // POR HACER (1.5): Devuelve la lectura en indiceDia, o -300.0 si el indice es invalido.
        if(indiceDia<temperaturas.length&&indiceDia>0){
            return temperaturas[indiceDia];
        }else{
            return -300.0;

        }
       
    }

    // METODOS ESTADISTICOS (PARTE 2)

    public double calcularPromedio() {
        // POR HACER (2.1): Suma todas las temperaturas con un ciclo for y calcula el promedio.
        double suma=0.0;
        
        for(int i=0; i<this.temperaturas.length;i++){
            if(this.temperaturas[i] != -300.0){
                suma+=temperaturas[i];

            }

            
        }

        double promedio= suma/(temperaturas.length);
        return promedio;
    }

    public double obtenerMaxima() {
        double max = -300.0;
        // POR HACER (2.2): Recorre el arreglo y encuentra el valor maximo.
        for(int i=0; i<this.temperaturas.length;i++){
            if(temperaturas[i]>max){
                max=temperaturas[i];

            }
        }

        return max;
    }

    public int contarDiasCalurosos(double umbral) {
        if (this.temperaturas == null) {
            return 0;
        }
        int contador_dias_calurosos=0;
        // POR HACER (2.3): Cuenta cuantos dias superan estrictamente 'umbral'.
        for(int i=0;i<temperaturas.length;i++){
            if(umbral<temperaturas[i]){
                contador_dias_calurosos++;
            }

        }
    
        return contador_dias_calurosos;
    }

    @Override
    public String toString() {
        // POR HACER (2.4): Formato exacto:
        // "Estacion: <nombreEstacion> | Dias: <N> | Promedio: <prom> C | Maxima: <max> C"
      
        
        return "Estacion: "+ this.nombreEstacion+ " | " + "Dias: " + this.temperaturas.length + 
        " | " + "Promedio: " + calcularPromedio() + " C" + " | " + "Maxima: " + obtenerMaxima() + " C";
    }

    // CONVERSION DE ESCALAS (PARTE 3)

    public static double convertirAFahrenheit(double celsius) {
        // POR HACER (3.2): Decide si este metodo sera de instancia o static y realiza la conversion.

            double fahrenheit=(celsius*1.8)+32;
            return fahrenheit;

        
    }

    // POR HACER (3.3): Una vez creado Escala.java, descomenta y completa el metodo sobrecargado:
    
    public double calcularPromedio(Escala escala) {
        
        double promerdioCelsius=calcularPromedio();
        if(escala==escala.FAHRENHEIT){
            return convertirAFahrenheit(promerdioCelsius);
        }

        return promerdioCelsius;
    }


    // RETOS (PARTE 4)

    public int buscarPrimerDiaHelada() {
        // POR HACER (4.1): Devuelve el indice del primer dia con temp <= 0.0, o -1 si no hubo heladas.
        for(int i=0; i<this.temperaturas.length;i++){
            if(this.temperaturas[i] != -300.0 && this.temperaturas[i] <= 0.0){
                return i;
            }
            
        }

        return -1;
        
    }

    public double mayorCambioConsecutivo() {
        // POR HACER (4.2): Calcula la mayor variacion |t[i+1] - t[i]| entre dias seguidos.
 
        double maxVar = 0.0;

        for (int i = 0; i < this.temperaturas.length - 1; i++) {
            if(this.temperaturas[i] != -300.0){
                double actual = this.temperaturas[i];
                double siguiente = this.temperaturas[i + 1];
    
                    double variacion = Math.abs(siguiente - actual);
                    if (variacion > maxVar) {
                        maxVar = variacion;
                    }

            }

            
        }

        return maxVar;
    }
}
