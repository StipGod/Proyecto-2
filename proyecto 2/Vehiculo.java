import java.time.LocalDateTime;
public class Vehiculo 
{
  public static Vehiculo[] vehiculos;
  public static int cantidad = 0;
  private String color;
  private String placa;
  private String marca;
  private int valorComercial;
  private LocalDateTime fecha;
  protected String tipo;

  public Vehiculo()
  {
      
  }
  
  public Vehiculo(int cant)
  {
      this.vehiculos = new Vehiculo[cant];
  }
  
  public Vehiculo(String tp,String p, String m,String c)
  {
    this.placa=p;
    this.marca=m;
    this.color=c;
    this.tipo = tp;
    this.valorComercial=30000000;
    cantidad++;
  }
  
  public Vehiculo(String tp,String p, String m, String c, int v)
  {
    this.placa=p;
    this.marca=m;
    this.color=c;
    this.valorComercial=v;
    this.tipo = tp;
    cantidad++;
  }

  public String getTipo()
  {
    return tipo;
  }

  public String toString()
  {
    String cadena = " ";
    cadena ="\nPlaca: " +placa + "\nMarca: " + marca + "\nColor: " + color + "\nValor Comercial: " + valorComercial+"\n" + fecha+"\n";
    return cadena;
  }

  public void actualizarFecha()
  {
    fecha = LocalDateTime.now();
  }
  
  public static String toStringVehiculos()
  { 
    String toSVanswer = "";
    for (int i = 0; i<vehiculos.length; i++)
    {
      if(vehiculos[i] != null)
      {
          toSVanswer += vehiculos[i].toString()+"\n";
      }
    }
    return toSVanswer;
  }
  
  public static int cantidadVehiculos()
  {
    return cantidad;
  }
  public static String Color(String color)
  {
     String elColor="";
     for(int c = 0; c < vehiculos.length;c++)
        {
            if(vehiculos[c] != null)
            {
            if(vehiculos[c].getColor().equalsIgnoreCase(color))
                {
                  elColor += vehiculos[c].toString();
                }
            }
      }  
      return elColor;
  }
  public static String ordenValor()
  {
    String ans = "";
    int contador = 0;
    Vehiculo[] aux = new Vehiculo[cantidad];
    Vehiculo[] temp = new Vehiculo[cantidad];
    for(int i = 0; i<vehiculos.length; i++){
      if(vehiculos[i] != null)
      { 
          //temp[contador] = vehiculos[i];
          aux[contador] = vehiculos[i];
          contador++;
      }   
    }
    for(int i = 1; i < cantidad ; i++)
      {           
       for(int j = 0; j < cantidad -1; j++)
         {
           if(aux[j].getValorComercial() > aux[j+1].getValorComercial()){
            temp[j] = aux[j];
                              
            aux[j] = aux[j+1]; 
                              
            aux[j+1] = temp[j];
                          
           }          
        }
      }
    for(int i = 0; i < cantidad; i++){
          ans = ans + aux[i].toString();
      }
    return ans;
  }
}