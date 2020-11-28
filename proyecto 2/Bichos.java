public class Bichos
{
    protected int salud;
    protected String tipo;
    public Bichos(int s, String tp)
    {
        this.salud = s;
        this.tipo = tp;
    }
    public int getSalud()
    {
        return this.salud;
    }
    public void setSalud(int s)
    {
        this.salud = s;
    }
    public String getTipo()
    {
        return this.tipo;
    }
}