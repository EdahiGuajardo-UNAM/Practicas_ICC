import java.util.Scanner;

public class BinarioInteractivo{
    public static void main(String[] args){
        //Se inicializa el objeto scanner
        Scanner scanner =new Scanner(System.in);
        char respuesta='s';

        do{
        
        
        
        //se inicializa el dato con una variable centinela para forzar el primer ciclo
        int numero_base_10=-1;
        //Etapa de validación
        while(numero_base_10<0){
            //prompt al usuario
            System.out.println("Ingresa un número entero igual o mayor a cero ");
            

            //se valida si es un entero
            if(!scanner.hasNextInt()){
                System.out.println("Error:Ingresa un número entero ");
                //obliga a que el valor del numero_base_10 se reinicie
                scanner.next();

            }else{
              //después de pasar las validaciones se le asigna el valor del prompt
              numero_base_10=scanner.nextInt();
                if(numero_base_10<0){
                    System.out.println("Error:Ingresa un número >= 0");

                }


            }
        }

        
            //Etapa de ejecución del algoritmo de conversión a binario
        
        //Inicialización del string de número binario
        String numero_binario="";

        //caso base
        if(numero_base_10==0){
            numero_binario="0";
            System.out.printf("Tu número es: %s %n", numero_binario);
            System.out.print("¿Deseas ingresar otro número? oprime s repetir ");
            respuesta = scanner.next().charAt(0);

        }else{
            //algoritmo de conversión
            int cociente = numero_base_10;
            String binario="";

            while(cociente>0){
                int nuevo_cociente= cociente/2;
                int residuo=cociente%2;
                binario=Integer.toString(residuo)+binario;
                cociente=nuevo_cociente;

            }

            System.out.printf("Tu número es: %s %n", binario);
            System.out.print("¿Deseas ingresar otro número? oprime s repetir ");
            respuesta = scanner.next().charAt(0);

        }
        
    }while(respuesta == 's' || respuesta=='S');

    System.out.print("Hasta luego! ");

        

        scanner.close();






  }
 }
