import java.util.Scanner;

public class CabanaDelMisterio{
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        boolean exit = false;
            do{

            //variables principales
            System.out.println("Ingresa el nombre completo del cliente: ");
            String nombre_estudiante = scanner.nextLine();

            System.out.println("Ingresa el tipo de cliente: P,E o R : ");
            char clasificación = scanner.next().charAt(0);

            while(clasificación!='P'&& clasificación!='E'&& clasificación!='R'){
                System.out.println("Error:Ingresa una opción correcta ");
                System.out.println("Ingresa el tipo de cliente: P,E o R : ");
                clasificación = scanner.next().charAt(0);

            }
            
            int capital = -1;

            while (capital <= 0) {
                System.out.print("Ingresa la cantidad de capital: ");
            
                if (!scanner.hasNextInt()) {
                    System.out.println("Error: Ingresa un número entero.");
                    scanner.next(); // Limpia la entrada de texto
                } else {
                    capital = scanner.nextInt(); // Única lectura del entero
  
            
                    if (capital <= 0) { // Evalúa si es menor o IGUAL a cero
                        System.out.println("Error: El capital tiene que ser un número mayor a cero.");
                    }
                }
            }


             double tasa_interes=0.15;
                          
             if(clasificación=='P'){
                tasa_interes=0.13;
            }else if(clasificación=='R'){
                tasa_interes=0.18;
            }
               
                  
                

            int meses=-1;
            while(meses<=0){
              System.out.println("Ingresa la cantidad de meses: ");

                  if(!scanner.hasNextInt()){
                      System.out.println("Error:Ingresa un número entero: ");
                      scanner.next();


                  }else{
                      meses=scanner.nextInt();
                      if(meses<0){
                          System.out.println("Error: los meses tienen que ser un número mayor a cero");

                      }


                  }
                  
              }

              //Menu
              String menu = """
                ##### Sistema de prestamos de la Cabaña del misterio #####
                > Las operaciones disponibles son
                1) Cotizar con interes simple.
                2) Cotizar con interes compuesto.
                3) Comparar interes simple y compuesto.
                4) Cambiar el capital del prestamo.
                0) Salir.
                """;

              


                               
                //se calcula el interes anual
                double interes_simple = (capital * tasa_interes)*meses/12;
                //se calcula el interes mensual
                double interes_mensual =interes_simple/12;

                // cuanto debe de pagar en total
                double pago_total_simple = capital + interes_simple;
                // el pago mensual simple
                double mensualidad_simple = pago_total_simple/12; 
                //tasa mensual
                double tasa_mensual= tasa_interes/12;
                //se inicializa el valor de la deuda con la del capital inicial
                double  deuda = capital;

                //variable de saldo_final_compuesto
                double saldo_final=capital * Math.pow(1+tasa_mensual, meses);
                //cálculo de interés compuesto
                double interes_compuesto= saldo_final-capital;
                double dif= interes_compuesto-interes_simple;
                //RESUMEN
                String resumen = """
                    ##### RESUMEN #####
                    Interés simple = %.2f
                    Total con interés simple = %.2f
                    Interés compuesto = %.2f
                    Total con interés compuesto = %.2f
                    Diferencia = %.2f
                    """.formatted(interes_simple, pago_total_simple, interes_compuesto, saldo_final, dif);
                    //Inicialización de variables que dictan comportamiento de los ciclos
                    int opcion = -1;
                    int conteo_errores=0;
                    int conteo_ciclos=0;
                    //se fuerza el primer ciclo
                    do{
                        //se imprime menu
                        System.out.println(menu);
                        System.out.print("Elige una opción: ");
                        //validación que sea un entero
                        if(scanner.hasNextInt()){
                            //pasa prueba y se asigna el valor del propmt
                            opcion = scanner.nextInt();
                            //segunda validación: si es un enter0 válido entre las opciones
                            if(opcion >= 0 && opcion <= 4){
                                                               
                                switch(opcion){
                                    case 1:
                                        System.out.println("Nombre:"+ nombre_estudiante);
                                        System.out.println("Capital:"+ capital);
                                        System.out.println("Tasa de interés:"+ tasa_interes);
                                        System.out.println("Meses:"+ meses);
                                        System.out.println("Interés simple:"+ interes_simple);
                                        System.out.println("Pago:"+ pago_total_simple);
                                        System.out.println("\n");
                                        conteo_ciclos++;
                                         
                                        break;
                
                                    case 2:
                                        System.out.println("Nombre:"+ nombre_estudiante);
                                        System.out.println("Capital:"+ capital);
                                        System.out.println("Tasa de interés:"+ tasa_interes);
                                        System.out.println("Meses:"+ meses);
                                        //número de ciclos igual a meses, empieza en 1 y va aumentando en 1  
                                         for(int i=1; i<=meses; i++){
                                             //actualización de deuda
                                             deuda=deuda*(1+tasa_mensual);
                                             System.out.printf("En el mes %d se tiene un saldo de %.2f %n", i, deuda);
                                         }
                                        System.out.println("Interés compuesto:"+ interes_compuesto);
                                        System.out.println("Pago:"+ saldo_final);
                                        System.out.println("\n");
                                        conteo_ciclos++;

                                    
                                        break;  
                                    case 3:
                                        System.out.println("Interés simple:"+ interes_simple);
                                        System.out.println("Interés compuesto:"+ interes_compuesto);
                                        if(interes_simple>interes_compuesto){
                                            System.out.println("Interés simple es mayor");
                                                System.out.println("Diferencia: $" + dif );
            
                                        }else{
                                            System.out.println("Interés compuesto es mayor");
                                            
                                            System.out.println("Diferencia: $"+ dif );
                                           
                                        }
            
                                        System.out.println("\n");
                                        conteo_ciclos++;
                                         
                                        break;                    
                                    case 4:
                                    //Se reinicia el valor del capital
            
                                    capital=-1;
            
            
                                        //mismas validaciones que al principio
                                        while (capital <= 0) {
                                            System.out.print("Ingresa la cantidad de capital: ");
                                        
                                            if (!scanner.hasNextInt()) {
                                                System.out.println("Error: Ingresa un número entero.");
                                                scanner.next(); // Limpia la entrada de texto
                                            } else {
                                                capital = scanner.nextInt(); // Única lectura del entero
                              
                                        
                                                if (capital <= 0) { // Evalúa si es menor o IGUAL a cero
                                                    System.out.println("Error: El capital tiene que ser un número mayor a cero.");
                                                }
                                            }
                                            System.out.println("\n");
                                            conteo_ciclos++;

                                          
                                        }
            
            
                                        break;                    
                                    case 0:
                                        //salida manual
                                        System.out.println("Saliendo del sistema...");
                                        break;                    
                                                                        
                
                                }
                            }else{
                               // Error por opción fuera de rango 
                                conteo_errores++;
                                System.out.printf("Error: Opción fuera de rango (%d/3 errores).%n", conteo_errores);
                            }
                            
                            

                        }else{
                            // Error por opción inválida
                            System.out.println("Error: Favor de ingresar una opción válida del menú.");
                            // Limpia la entrada no válida
                            scanner.next(); 
                            opcion = -1;
                            conteo_errores++;
                            System.out.printf("Errores acumulados: %d/3%n", conteo_errores);

                        }

                        // Verificar si se alcanzó el límite de 3 errores
                        if (conteo_errores >= 3) {
                            System.out.println("\nLímite de errores alcanzado, te muestro tu resumen y me despido:");
                            opcion = 0; 

                        }else if (conteo_ciclos >= 5) {
                             System.out.println("\nHas alcanzado el límite máximo de 5 operaciones permitidas.");
                             // Fuerza la salida del ciclo
                             opcion = 0; 
                            }


                        
                    }while(opcion!=0);
                    System.out.println(resumen);
     
  

        }while(exit);


    


        }



}