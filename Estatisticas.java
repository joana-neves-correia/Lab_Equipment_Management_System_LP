package ProjetoLP;

import java.util.LinkedList;

public class Estatisticas {

    private GestaoEquipamentos gestaoEquipamentos;

    public Estatisticas(GestaoEquipamentos gestaoEquipamentos) {
        this.gestaoEquipamentos = gestaoEquipamentos;
    }


    public LinkedList<Eletronico> listaEqEletronicos() {

        LinkedList<Eletronico> listaEletronicos = new LinkedList<>();

        for (Equipamento i : gestaoEquipamentos.ListaEquipamentos) {
            if (i instanceof Eletronico) {
                listaEletronicos.add((Eletronico) i);
            }
        }
        return listaEletronicos;
    }

    public LinkedList<Medicao> listaEqMedicao() {

        LinkedList<Medicao> listaMedicao = new LinkedList<>();

        for (Equipamento i : gestaoEquipamentos.ListaEquipamentos) {
            if (i instanceof Medicao) {
                listaMedicao.add((Medicao) i);
            }
        }
        return listaMedicao;
    }

    public LinkedList<Recipiente> listaEqRecipiente() {

        LinkedList<Recipiente> listaRecipiente = new LinkedList<>();

        for (Equipamento i : gestaoEquipamentos.ListaEquipamentos) {
            if (i instanceof Recipiente) {
                listaRecipiente.add((Recipiente) i);
            }
        }
        return listaRecipiente;
    }

    public void numeroEletronico(){
        System.out.println(listaEqEletronicos().size());
    }

    public void numeroMedicao(){
        System.out.println(listaEqMedicao().size());
    }

    public void numeroRecipiente(){
        System.out.println(listaEqRecipiente().size());
    }

    public LinkedList<Equipamento> listaEqAtivos() {

        LinkedList<Equipamento> listaAtivos = new LinkedList<>();

        for (Equipamento i : gestaoEquipamentos.ListaEquipamentos) {
            if (i.getEstado() == Estados.ATIVO) {
                listaAtivos.add(i);
            }
        }
        return listaAtivos;
    }

    public LinkedList<Equipamento> listaEqInativos() {

        LinkedList<Equipamento> listaInativos = new LinkedList<>();

        for (Equipamento i : gestaoEquipamentos.ListaEquipamentos) {
            if (i.getEstado() == Estados.INATIVO) {
                listaInativos.add(i);
            }
        }
        return listaInativos;
    }

    public LinkedList<Equipamento> listaEqManutencao() {

        LinkedList<Equipamento> listaManutencao = new LinkedList<>();

        for (Equipamento i : gestaoEquipamentos.ListaEquipamentos) {
            if (i.getEstado() == Estados.MANUTENCAO) {
                listaManutencao.add(i);
            }
        }
        return listaManutencao;
    }

    public void numeroAtivos(){
        System.out.println(listaEqAtivos().size());
    }

    public void numeroInativos(){
        System.out.println(listaEqInativos().size());
    }

    public void numeroManutencao(){
        System.out.println(listaEqManutencao().size());
    }

    public float menorConsumo() {

        LinkedList<Eletronico> lista = listaEqEletronicos();

        float menor = lista.get(0).getConsumoEnergetico();

        for (Eletronico e : lista) {

            float valor = e.getConsumoEnergetico();

            if (valor < menor) {
                menor = valor;
            }
        }
        System.out.println("\n-> Menor consumo (kWh): " + menor);
        return menor;
    }

    public float maiorVolume() {

        LinkedList<Recipiente> lista = listaEqRecipiente();

        float maior = lista.get(0).getVolume();

        for (Recipiente e : lista) {

            float valor = e.getVolume();

            if (valor > maior) {
                maior = valor;
            }
        }
        System.out.println("\n-> Maior volume (mL): " + maior);
        return maior;
    }

    public float mediaTemperatura() {

        LinkedList<Medicao> lista = listaEqMedicao();

        float soma = 0;
        int contagem = 0;

        for (Medicao e : lista) {

            if (e.getUnidade() == Unidades.TEMPERATURA) {
                float valor = e.getValor();
                if (e.getValor() != 0) {
                    soma += valor;
                    contagem ++;
                }
            }
        }
        System.out.println("\n-> Média temperaturas (ºC): " + soma/contagem);
        return soma/contagem;
    }
}



