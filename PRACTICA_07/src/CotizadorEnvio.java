/**
 * Clase de utileria o servicio que contiene las reglas de negocio para
 * cotizar costos de envio y determinar requerimientos de seguro.
 * 
 * Al no modelar un objeto con estado interno persistente, sus metodos se declaran
 * como estaticos (static) y operan sobre los objetos {@link Paquete} recibidos por parametro.
 * 
 * @author Cesar Edahi Guajardo
 * @version 1.0
 */
public class CotizadorEnvio {

    /**
     * Evalua si una referencia recibida corresponde a un paquete valido para operar.
     * 
     * @param p Objeto paquete a inspeccionar.
     * @return true si la referencia no es nula y cumple con las condiciones minimas
     *         para considerarse valido; false en caso contrario.
     */
    public static boolean esPaqueteValido(Paquete p) {
        // POR HACER: Implementa la validacion de referencia y propiedades del paquete
        if(p ==null){
            return false;

        } 

        if(p.getPesoFisico()<0.1){
            return false;
        }
        
        if(p.getAlto()<1 && p.getAncho()<1 && p.getAlto()<1){
            return false;

        }

        return true;
        
        

    }

    /**
     * Calcula la tarifa base de envio de acuerdo a los rangos de peso cobrable:
     * <ul>
     *   <li>Hasta 5 kg: cuota fija de $120.00.</li>
     *   <li>Mas de 5 kg y hasta 15 kg: $120.00 mas $18.00 por cada kg que exceda los 5 kg.</li>
     *   <li>Mas de 15 kg: $300.00 mas $25.00 por cada kg que exceda los 15 kg.</li>
     * </ul>
     * 
     * @param p El paquete cuya tarifa se calculara.
     * @return El importe total del envio en pesos, o -1.0 si el paquete no es valido.
     */
    public static double cotizarEnvio(Paquete p) {
        // POR HACER: Valida el paquete y calcula la tarifa escalonada segun los rangos
        if(!esPaqueteValido(p)){
            return -1.0;

        }

        double peso_cobrable=p.obtenerPesoCobrable();
        double tarifa;

        if(peso_cobrable<=5.0){
            tarifa=120.0;
        }else if(peso_cobrable>5.0 && peso_cobrable<=15.0){

            double indice_sobrepeso=peso_cobrable-5.0;

            tarifa=120.0+(indice_sobrepeso*18.0);


        }else{
            double indice_sobrepeso=peso_cobrable-15.0;
            tarifa=300.0 + (indice_sobrepeso*25);

        }

        return tarifa;
        
    }

    /**
     * Determina si el paquete requiere poliza de seguro obligatorio.
     * Esto ocurre si el paquete es valido y cumple al menos una de las siguientes condiciones:
     * <ul>
     *   <li>Su valor declarado supera $3,000.00 pesos.</li>
     *   <li>Es sobredimensionado: alguna de sus aristas excede los 60 cm o la suma
     *       de sus tres dimensiones supera los 150 cm.</li>
     * </ul>
     * 
     * @param p El paquete a evaluar.
     * @return true si el paquete amerita contratacion de seguro obligatorio; false en caso contrario.
     */
    public static boolean requiereSeguro(Paquete p) {
        // POR HACER: Evalua las condiciones de valor y dimensiones sobredimensionadas


        if(esPaqueteValido(p)){


        boolean altoSobreDimension = p.getAlto()>60;
        boolean anchoSobreDimension = p.getAncho()>60;
        boolean largoSobreDimension = p.getLargo()>60;
        boolean sumaSobreDimension = (p.getAlto()+p.getAncho()+p.getLargo())>150;

            if(p.getValorDeclarado()>3000.00|| altoSobreDimension || anchoSobreDimension || largoSobreDimension || sumaSobreDimension){
                return true;
            }
            return false;
        }
        return false;
        
    }
}
