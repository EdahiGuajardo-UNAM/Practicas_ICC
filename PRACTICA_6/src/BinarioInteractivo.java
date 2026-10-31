import java.util.Scanner;

public class BinarioInteractivo{
    public static void main(String[] args){
        //Se inicializa el objeto scanner
        Scanner scanner =new Scanner(System.in);
        //prompt al usuario
        System.out.print("Ingresa un número entero igual o mayor a cero ");
        //se inicializa el dato con una variable centinela para forzar el primer ciclo
        int numero_base_10=-1;
        //Etapa de validación
        while(numero_base_10<0){
            //se valida si es un entero
            if(!scanner.hasNextInt()){
                System.out.print("Ingresa un número entero igual o mayor a cero ");
                //obliga a que el valor del numero_base_10 se reinicie
                scanner.next();

            }else{

                //mensaje para el caso de que ingrese un negativo
                if(numero_base_10<0){
                    System.out.print("Ingresa un número entero igual o mayor a cero ");

                }

                //después de pasar las validaciones se le asigna el valor del prompt
                numero_base_10=scanner.nextInt();
            }
        }

        //Etapa de ejecución del algoritmo de conversión a binario
    
       //Inicialización del string de número binario
        String numero_binario="";

        //caso base
        if(numero_base_10==0){
            numero_binario="0";
            System.out.println(numero_binario);

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

            System.out.print(binario);
            
        }









    }
}