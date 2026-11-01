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


             double tasa_interes=-1.0;
             while(tasa_interes<=0.0){
               System.out.println("Ingresa la tasa anual base : ");   
                   if(!scanner.hasNextDouble()){
                       System.out.println("Error:Ingresa un número con decimales: ");
                       scanner.next();   
                   }else{
                       tasa_interes=scanner.nextDouble()/100;
                       if(capital<0.0){
                           System.out.println("Error: La tasa anual debe ser mayor a cero");   
                       }   
                   }
                   
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
              
                 
            

        
            
            

            //Validación de datos para el cálculo
            if(capital >0 && tasa_interes > 0 && meses>0){

                if(clasificación=='P'){
                    tasa_interes=0.13;
                }else if(clasificación=='R'){
                    tasa_interes=0.18;
                }
                //Validación de clasificación correcta
                if(clasificación=='E' || clasificación=='P'|| clasificación=='R'){
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
                //número de ciclos igual a meses, empieza en 1 y va aumentando en 1  
                    for(int i=1; i<=meses; i++){
                        //actualización de deuda
                        deuda=deuda*(1+tasa_mensual);
                        System.out.printf("En el mes %d se tiene un saldo de %.2f %n", i, deuda);
                    }

                //variable de saldo_final_compuesto
                double saldo_final=capital * Math.pow(1+tasa_mensual, meses);
                //cálculo de interés compuesto
                double interes_compuesto= saldo_final-capital;
                //se imprimen resultados
                System.out.printf("Tasa aplicada = %.2f %n", tasa_interes);
                System.out.printf("Préstamo= %d %n", capital);
                System.out.printf("Meses de pago = %d %n", meses);
                System.out.printf("Interés simple = $%.2f %n", interes_simple);
                System.out.printf("Total con interés simple = $%.2f %n", pago_total_simple);
                System.out.printf("Interés compuesto = $%.2f %n", interes_compuesto);
                System.out.printf("Total con inter ́es compuesto: %2f ", saldo_final);
                
                }else{
                    System.out.printf("Clasificación no válida");
                
                }


            //Si el dato esta mal informa al usuario que dato
            }else{
                
                if(capital<0){
                    System.out.println("El dato del capital es erroneo");
                }
                if(tasa_interes<0) {
                    System.out.println("El dato de la tasa de interés esta mal");
                }
                if(meses<0){
                    System.out.println("El dato de meses de interés esta mal");
                }

            }

        }while(exit);


    


        }



}