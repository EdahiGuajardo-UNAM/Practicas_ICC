/**
 * Programa de pruebas y simulacion para las Guias de Envios
 * Ejecuta pruebas automatizadas.
 * 
 * @author Tu Nombre / Tu Numero de Cuenta
 * @version 1.0
 */
public class PruebaEnvio {

    /*
    * - Incluye las secciones guiadas para que agregues las pruebas de tu diseno
    *   de Persona (Parte 2), Envio y generacion de folios consecutivos (Parte 3),
    *   asi como la simulacion integral de envios, clones y devolucion (Parte 4).
    */

    private static int pruebasExitosas = 0;
    private static int totalPruebas = 0;

    /**
     * Metodo principal de verificacion y simulacion no interactiva.
     * 
     * @param args Argumentos de linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("  ICC 2027-1 | PRACTICA 9: AGREGACION, CLONACION Y GUIAS DE ENVIO");
        System.out.println("================================================================================\n");

        // ---------------------------------------------------------------------
        // PARTE 1: PAQUETES ESTANDARIZADOS (CONSTRUCTOR POR COPIA Y TOSTRING)
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 1: REPRESENTACION TEXTUAL Y CLONACION DE PAQUETE");
        Paquete kitBase = new Paquete("KIT-101", 4.0, 20.0, 20.0, 20.0, 500.0, false);
        Paquete otroPaquete = new Paquete("PKG-202", 12.0, 40.0, 30.0, 30.0, 1500.0, false);

        String txtKit = kitBase.toString();
        verificar("Paquete.toString() incluye el codigo de rastreo",
                  txtKit != null && txtKit.contains("KIT-101") && !txtKit.contains("Paquete@"));

        Paquete kitClon = new Paquete(kitBase);
        double pesoOriginal = kitBase.getPeso();
        kitBase.setPeso(99.0);
        verificar("Constructor por copia de Paquete crea instancia independiente en memoria",
                  kitClon != kitBase && Math.abs(kitClon.getPeso() - pesoOriginal) < 1e-6);
        kitBase.setPeso(pesoOriginal);

        kitClon.setCodigoRastreo("KIT-102"); // Nuevo codigo para envio en serie
        verificar("Modificar el codigo del paquete clonado no altera el paquete plantilla original",
                  "KIT-101".equals(kitBase.getCodigoRastreo()) && "KIT-102".equals(kitClon.getCodigoRastreo()));

        Paquete clonNulo = new Paquete(null);
        verificar("Constructor por copia con null asigna valores predeterminados validos",
                  clonNulo.getCodigoRastreo() != null && clonNulo.getPeso() > 0.0);
        System.out.println();

        // ---------------------------------------------------------------------
        // PARTE 2: PRUEBAS DE TU DISENO DE LA CLASE PERSONA
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 2: VERIFICACION DE LA CLASE PERSONA");
        // POR HACER (Parte 2):
        // Instancia al menos 3 objetos Persona con los constructores que disenaste:
        // - Dos personas en la misma ciudad/codigo postal (ej. personaX y personaY).
        // - Una persona en otra ciudad/codigo postal (ej. personaZ) y una copia con el mismo ID que personaX.
        Persona maria = new Persona("1", "Maria", "01832");
        Persona juan = new Persona("2", "Juan", "01832");
        Persona ana = new Persona("30", "Ana", "07353");
        Persona maria_2 = maria;

        // Agrega llamadas a verificar(...) para comprobar:
        // 1. Que mismaUbicacionQue(...) devuelve true entre personaX y personaY, y false con personaZ.
        System.out.println("¿Maria tiene la misma ubicación que Juan? expected:true " + "value: "+ maria.mismaUbicacionQue(juan));
        System.out.println("¿Maria tiene la misma ubicación que Ana? expected:false " + "value: "+ maria.mismaUbicacionQue(ana));
        // 2. Que esLaMismaPersona(...) devuelve true para el mismo identificador unico y false para distinto o null.
        System.out.println("¿Maria es la misma persona que Ana? expected:false " + "value: "+ maria.esLaMismaPersona(ana));
        System.out.println("¿Maria es la misma persona que Maria 2? expected: true " + "value: "+ maria.esLaMismaPersona(maria_2));
        System.out.println("¿Maria es la misma persona que null? expected:false " + "value: "+ maria.esLaMismaPersona(null));
        // 3. Que toString() devuelve una cadena legible con sus datos.
        System.out.println(maria.toString());
        System.out.println(juan.toString());
        System.out.println(ana.toString());

        // ---------------------------------------------------------------------
        // PARTE 3: PRUEBAS DE AGREGACION, FOLIOS CONSECUTIVOS Y OPERACIONES EN ENVIO
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 3: VERIFICACION DE ENVIO Y FOLIOS AUTOMATICOS");
        // POR HACER (Parte 3):
        // 1. Verifica con tu metodo de consulta que al inicio se han emitido 0 guias.
        System.out.println("Conteo de número de guías emitidas: "+ Envio.getConteoGuias());
        // 2. Crea una guia local (entre personaX y personaY con kitBase) y una foranea (hacia personaZ con kitClon).
        Envio envio1= new Envio(maria,juan,kitBase);
        Envio envio2= new Envio(maria,ana,kitClon);

        // 3. Verifica que ambas guias tienen folios no nulos, distintos y con numeracion consecutiva (1 y 2),
        System.out.println("Folio envio1: "+ envio1.getFolioGuia());
        System.out.println("Folio envio2: "+ envio2.getFolioGuia());

        //    y que el total de guias emitidas ahora es 2.
        // 4. Verifica esEnvioForaneo(), esAutoEnvio() y calcularCostoTotal() (confirmando el cargo foraneo).
        System.out.println("¿Es foráneo el envio1: "+ "expected: false " + "value: "+ envio1.esEnvioForaneo() );
        System.out.println("¿Es foráneo el envio2: "+ "expected: true " + "value: "+ envio1.esEnvioForaneo() );

        System.out.println("Costo de envio1: $" + envio1.calcularCostoTotal() );
        System.out.println("Costo de envio2: $" + envio2.calcularCostoTotal() );

        // 5. Verifica que cambiarDestinatario(...) rechaza null y acepta actualizar a otra persona (o a si misma).
        
        System.out.println("¿Se cambia destinatario si es null? "+ " expected: false "+ "value: " +  envio1.cambiarDestinatario(null));

        envio1.cambiarDestinatario(maria);

        System.out.println("Cambio válido de destinatario "+ "\n"+
         envio1.toString());


        // ---------------------------------------------------------------------
        // PARTE 4: SIMULACION INTEGRAL (CLONACION DE GUIA Y DEVOLUCION / RETORNO)
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 4: SIMULACION DE ENVIOS, CLONACION DE GUIA Y RETORNO");
        // POR HACER (Parte 4):
        // Modela e imprime en consola el siguiente escenario completo:
        // a) Persona X envia 'kitBase' a Persona Y (imprime la guia generada).
        
        System.out.println("Guia de envio paquete 3"+ "\n");
        Envio envio_3= new Envio(maria,juan,kitBase);

        System.out.println(envio_3.toString());
        // b) Persona X necesita enviar un segundo paquete ('otroPaquete') a la misma Persona Y
        //    clonando la guia anterior; verifica que conserva remitente y destinatario
        //    pero tiene el nuevo paquete y un nuevo folio consecutivo.
        Envio envio_4= new Envio(envio_3,otroPaquete);

        System.out.println("Guia de envio paquete 4"+ "\n");
        System.out.println(envio_4.toString());

        // c) Persona Y solicita devolver el primer paquete a Persona X generando una guia de retorno;
        //    verifica con verificar(...) que en la guia de retorno el remitente es Y, el destinatario es X,
        //    el paquete es una copia independiente con prefijo "RET-" y cuenta con un nuevo folio consecutivo.
        //    Imprime la guia de retorno y el total acumulado de guias emitidas en el sistema.
        System.out.println("Guia de  retorno del paquete 3"+ "\n");

        System.out.println(envio_3.generarGuiaRetorno());

        

        System.out.println("\n================================================================================");
        System.out.println("  RESUMEN DE PRUEBAS: " + pruebasExitosas + " / " + totalPruebas + " pruebas superadas con exito");
        System.out.println("================================================================================");
    }

    /**
     * Evalua una condicion booleana e imprime [OK] o [FALLO].
     * 
     * @param nombrePrueba Descripcion breve del caso evaluado.
     * @param condicion Resultado booleano esperado (true si paso).
     */
    private static void verificar(String nombrePrueba, boolean condicion) {
        totalPruebas++;
        if (condicion) {
            pruebasExitosas++;
            System.out.println("  [OK]    " + nombrePrueba);
        } else {
            System.out.println("  [FALLO] " + nombrePrueba);
        }
    }
}
