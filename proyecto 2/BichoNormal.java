public class BichoNormal extends Bichos
{   
    public BichoNormal()
    {
        super(10,"BN");
    }
    @Override
    public int getSalud()
    {
        return this.salud;
    }
    @Override
    public void setSalud(int s)
    {
        this.salud = s;
    }
    @Override
    public String getTipo()
    {
        return this.tipo;
    }
}