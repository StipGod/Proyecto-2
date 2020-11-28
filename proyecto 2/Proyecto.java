import java.util.Scanner;
import java.util.*;
import java.io.*;



public class Proyecto {

    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        
        int tamaño=0;
        int capitalDisponible;
        System.out.print("¿Cuánto es el capital que se repartira?\n");
        capitalDisponible = scan.nextInt();
        System.out.print("¿A cuantos subgrupos quiere que se divida su capital?\n");
        tamaño = scan.nextInt();
        SubGrupo [] grupos = new SubGrupo[tamaño];
        System.out.print("A continuacion se le pedira la importancia que se le da a cada subgrupo\nen una medida porcentual,de formato decimal siendo 1 el 100%.\nLa suma de estos no podra exeder 1.\n");
        
        double total = 0;
        for(int i = 0; i<tamaño; i++)
        {
          System.out.print("Cual es el porcentage de importancia para el subgrupo "+ (i+1)+"?\n");
          double imp = scan.nextDouble();
          grupos[i] = new SubGrupo();
          grupos[i].setImportancia(imp);
          total = total+imp;
        }
        if(total!=1)
        {
          while(total!=1)
          { System.out.print("Los porcentages ingresados han sumado mas del 100%, vuelve a intentar:\n");
            total = 0;
            for(int i = 0; i<tamaño; i++)
            {
              System.out.print("Cual es el porcentage de importancia para el subgrupo "+ (i+1)+"?\n");
              double imp = scan.nextDouble();
              grupos[i] = new SubGrupo();
              grupos[i].setImportancia(imp);
              total = total+imp;
            }  
          }
        }

        for(int i = 0; i<tamaño;i++)
        {
          double capitalMandar = Math.round(grupos[i].getImportancia()*capitalDisponible);
          grupos[i].setCapitalRecibido(capitalMandar);

          System.out.print("La capital que recibio el subgrupo "+(i+1)+" fue de "+capitalMandar+"\n");
        }
        
            
        System.out.println("\nIngrese un numero del 0 al 3 para seguir:\n");
        System.out.println("Ingrese 1 para volver a imprimir los resultados\n");
        System.out.println("Ingrese 2 para imprimir el capital recibido por un subgrupo en especifico\n");
        System.out.println("Ingrese 3 para imprimir los resultados en un txt\n");
        System.out.println("Ingrese 0 para finalizar el programa");

        int i = 1;
        while(i!=0){
    
          int num = scan.nextInt();
          i=num;

          switch(num){
            case 0 :

            System.out.println("Fin del programa");

            break;
            case 1 :

             for(int x = 0; x<tamaño;x++)
            {
              System.out.print("La capital que recibio el subgrupo "+(x+1)+" fue de "+grupos[x].getCapitalRecibido()+"\n");
            }

            break;
            case 2 :

            System.out.println("Que subgrupo desea imprimir?");
            int xd = scan.nextInt();
            System.out.println("La capital que recibio el subgrupo "+(xd)+" fue de "+grupos[(xd-1)].getCapitalRecibido());

            break;
            case 3 :
            
            File file = new File("registro.txt");
            FileWriter fw = new FileWriter(file,true);
            PrintWriter salida = new PrintWriter(fw);
            
            System.out.println("A que semestre corresponde esta imformacion?");
            salida.write("Semestre "+scan.nextInt()+"\n");
            salida.write("Grupo|Capital Recibido\n");
            for(int x = 0; x<tamaño;x++)
            {
              salida.write((x+1)+"    |"+grupos[x].getCapitalRecibido()+"\n");
            }
            salida.close();
            System.out.println("Su archivo ha sido escrito en un txt exitosamente!");
            break;
            default:
            System.out.println("Comando Incorrecto"); 
            break;
          }
        }
        
    }
    
}