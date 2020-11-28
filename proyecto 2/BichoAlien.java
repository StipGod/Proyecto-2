public class BichoAlien extends Bichos
{   
    public BichoAlien()
    {
        super(20,"BA");
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