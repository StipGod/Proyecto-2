import java.util.Random;
import java.util.Scanner;
public class Main
{
   static Bichos[][] tablero = new Bichos[2][2];


   public static void print()
   {
         System.out.println("  -------------"+"\n"
                        + ": "+tablero[0][0].getTipo()+"-"+tablero[0][0].getSalud()+" : "+tablero[1][0].getTipo()+"-"+tablero[1][0].getSalud()+" :"+"\n"
                        + "  -------------"+"\n"+
                        ": "+tablero[0][1].getTipo()+"-"+tablero[0][1].getSalud()+" : "+tablero[1][1].getTipo()+"-"+tablero[1][1].getSalud()+" :"+"\n"
                        + "  -------------");
   }
   public static void main(String[] args)
   {
       Scanner Scan = new Scanner(System.in);
       Random r = new Random();

       int valorInstanciar = r.nextInt(4)+1;
       //int valorInstanciar = 4;
       for(int i = 0; valorInstanciar<i; i++)
       {   
            int xd = r.nextInt(2)+1;
            if(xd == 1){
                Bichos BNi = new BichoNormal();
                if(i<2){
                    tablero[0][i] = BNi;
                }else if(i==3)
                {
                    tablero[1][0] = BNi;
                }else{
                    tablero[1][1] = BNi;
                }
            }else{
                Bichos BAi = new BichoAlien();
                if(i<2){
                    tablero[0][i] = BAi;
                }else if(i==3)
                {
                    tablero[1][0] = BAi;
                }else{
                    tablero[1][1] = BAi;
                }
            }
       }
       int caso = 1;
       while(caso>0  || (tablero[0][0].getSalud()<=0 && tablero[0][1].getSalud()<=0 && tablero[1][0].getSalud()<=0 && tablero[1][1].getSalud()<=0)){
            print();
            Scan.nextInt();
            switch(caso) {
                case 1 :
                tablero[0][0].setSalud((tablero[0][0].getSalud()-5));
                break;

                case 2 :
                tablero[1][0].setSalud((tablero[1][0].getSalud()-5));
                break;

                case 3 :
                tablero[0][1].setSalud((tablero[0][1].getSalud()-5));
                break;

                case 4 :
                tablero[1][1].setSalud((tablero[1][1].getSalud()-5));
                break;

                default :
                System.out.println("fin del programa");
            }
       }
   }
}