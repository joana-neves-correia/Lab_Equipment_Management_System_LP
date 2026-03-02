package ProjetoLP;

public class Eletronico extends Equipamento{

    private float potencia;
    private float consumoEnergetico;

    public Eletronico(String nome) {
        super(nome);
    }

    public float getPotencia(){
        return potencia;
    }

    public float getConsumoEnergetico(){
        return consumoEnergetico;
    }

    public void setPotencia(float potencia){
        this.potencia = potencia;
        if (potencia <= 0.00){
            System.out.println("**Potencia < ou = a zero. Estado Inativo**");
            this.setEstado(Estados.INATIVO);
            }
    }

    public boolean setConsumoEnergetico(float consumo){
        float max = potencia / 1000f;
        if(consumo <= max && consumo > 0){
            this.consumoEnergetico = consumo;
            return true;
        } else {
            System.out.println("\n**Consumo inválido**");
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Potencia (W): " + potencia +
                "\n ConsumoEnergetico (kWh): " + consumoEnergetico;
    }
}
