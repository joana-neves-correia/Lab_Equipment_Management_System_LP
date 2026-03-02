package ProjetoLP;

import java.time.LocalDate;

abstract class Equipamento {

    private int ID;
    private String nome;
    private Estados estado;
    private LocalDate data;
    private Utilizador utilizador;

    private static int IDseguinte = 0;

    public Equipamento(String nome){
        setNome(nome);
        this.ID = IDseguinte++;
        this.estado = Estados.ATIVO;
        this.utilizador = null;
        this.data = LocalDate.now();
    }

    public int getID(){return ID;}

    public String getNome(){return nome;}

    public Estados getEstado(){return estado;}

    public LocalDate getData(){return LocalDate.now();}

    public Utilizador getUtilizador(){return utilizador;}

    public boolean setNome(String nome){
        if(nome.length() <= 20){
            this.nome = nome;
            return true;
        }
        System.out.println("Erro: Limite de 20 caracteres.");
        return false;
    }

    public void setEstado(Estados estado){
        this.estado = estado;
    }

    public void setUtilizador(Utilizador utilizador){
        this.utilizador = utilizador;
    }

    public boolean mudarEstado(Estados e){
        switch (e){
            case ATIVO -> {
                if(estado == Estados.MANUTENCAO){
                    estado = Estados.ATIVO;
                    return true;
                } else {
                    System.out.println("Equipamento só pode passar a Ativo após Manutenção.");
                    return false;
                }
            }
            case MANUTENCAO -> {
                if(estado == Estados.ATIVO || estado == Estados.INATIVO){
                    estado = Estados.MANUTENCAO;
                    return true;
                } else {
                    System.out.println("Equipamento só pode ir para manutenção se o estado atual for Ativo ou Inativo.");
                    return false;
                }
            }
            case INATIVO -> {
                estado = Estados.INATIVO;
                return true;
            }
        }
        System.out.println("Mudança de estado inválida.");
        return false;
    }

    @Override
    public String toString() {
        return  "\n ID: " + ID +
                "\n Nome: " + nome +
                "\n Estado: " + estado +
                "\n Data: " + data +
                "\n Utilizador: " + (utilizador != null? utilizador.getNomeUtilizador(): "Nenhum");
    }
}
