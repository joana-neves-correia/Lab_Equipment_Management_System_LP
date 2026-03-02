package ProjetoLP;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoEquipamentos {

    public List<Equipamento> ListaEquipamentos = new ArrayList<>();
    public List<Utilizador> listaUtilizadores = new ArrayList<>();

    private Scanner scanner;

    public GestaoEquipamentos(Scanner scanner) {
        this.scanner = scanner;
    }

    public void adicionarEquipamentoEletronico() {

        Eletronico eletronico = new Eletronico("");

        String nome;
        do{
            System.out.print("\nNome: ");
            nome = scanner.nextLine();
        }while(!eletronico.setNome(nome));

        System.out.print("Potencia (W): ");
        float potencia = scanner.nextFloat();
        scanner.nextLine();
        eletronico.setPotencia(potencia);

        if(potencia > 0){
            float consumo;
            do {
                System.out.print("Consumo (kWh): ");
                consumo = scanner.nextFloat();
                scanner.nextLine();
            }while (!eletronico.setConsumoEnergetico(consumo));
        }

        ListaEquipamentos.add(eletronico);

        System.out.println("\n-> Equipamento " + nome + " adicionado!");
    }

    public void adicionarEquipamentoRecipiente() {

        Recipiente recipiente = new Recipiente("");

        String nome;
        do{
            System.out.print("\nNome: ");
            nome = scanner.nextLine();
        }while(!recipiente.setNome(nome));

        int volume;
        do {
            System.out.print("Volume (mL): ");
            volume = scanner.nextInt();
            scanner.nextLine();
        }while(!recipiente.setVolume(volume));

        System.out.println("\n1 : Vidro");
        System.out.println("2 : Plastico");
        System.out.println("3 : Metal");
        System.out.println("4 : Silicone ");
        System.out.print("\nEscolha o material: ");

        int tipoMaterial = scanner.nextInt();
        scanner.nextLine();
        Material material;

        switch (tipoMaterial) {
            case 1:
                material = Material.VIDRO;
                break;
            case 2:
                material = Material.PLASTICO;
                break;
            case 3:
                material = Material.METAL;
                break;
            case 4:
                material = Material.SILICONE;
                break;
            default:
                System.out.println("**Opção inválida**");
                return;
        }
        recipiente.setMaterial(material);

        System.out.print("\nO equipamento está esterilizado? \n1-Sim / 2-Não : ");

        int esterilizado = scanner.nextInt();
        scanner.nextLine();
        boolean esteril = (esterilizado == 1);
        recipiente.setEsteril(esteril);

        ListaEquipamentos.add(recipiente);
        System.out.println("\n-> Equipamento " + nome + " adicionado!");
    }

    public void adicionarEquipamentoMedicao() {

        Medicao medicao = new Medicao("");

        String nome;
        do{
            System.out.print("\nNome: ");
            nome = scanner.nextLine();
        }while (!medicao.setNome(nome));

        System.out.println("\n1 : Temperatura (ºC)");
        System.out.println("2 : Massa (g)");
        System.out.println("3 : Volume (mL)");
        System.out.println("4 : pH ");
        System.out.print("\nEscolha as unidades: ");

        int tipoUnidade = scanner.nextInt();
        scanner.nextLine();
        Unidades unidades;

        switch (tipoUnidade) {
            case 1:
                unidades = Unidades.TEMPERATURA;
                break;
            case 2:
                unidades = Unidades.MASSA;
                break;
            case 3:
                unidades = Unidades.VOLUME;
                break;
            case 4:
                unidades = Unidades.PH;
                break;
            default:
                System.out.println("\n**Opção inválida**");
                return;
        }

        medicao.setUnidade(unidades);

        float valor;
        do{
            System.out.print("\nValor: ");
            valor = scanner.nextFloat();
            scanner.nextLine();
        }while(!medicao.setValor(valor));

        ListaEquipamentos.add(medicao);

        System.out.println("\n-> Equipamento " + nome + " adicionado!");
    }

    public void listarEquipamentos() {
        if (ListaEquipamentos.isEmpty()) {
            System.out.println("Lista vazia!");
            System.out.println("\nPressione Enter para continuar.");
            scanner.nextLine();
            return;
        }
        for (int i = 0; i < ListaEquipamentos.size(); i++) {
            Equipamento e = (ListaEquipamentos.get(i));
            System.out.println("ID: " + e.getID() + " | Nome: " + e.getNome() + " | Registo: " + e.getData() + " | Estado: " + e.getEstado());
        }
        System.out.println("\nPressione Enter para voltar ao Menu inicial.");
        scanner.nextLine();
    }

    public Equipamento procurarID(int id) {
        for (Equipamento equip : ListaEquipamentos) {

            if (equip.getID() == id) {
                System.out.println(equip);
                return equip;
            }
        }
        System.out.println("**Equipamento não encontrado**");
        return null;
    }

    public Equipamento eliminarEquipamento(int id) {
        for (Equipamento equip : ListaEquipamentos) {

            if (equip.getID() == id) {
                ListaEquipamentos.remove(equip);
                System.out.println("\nEquipamento com ID:" + equip.getID() + " removido.");
                return equip;
            }
        }
        System.out.println("**Equipamento não encontrado**");
        return null;
    }

    public void listaDeUtilizadores(String ficheiro) {
        try {
            FileReader txt = new FileReader(ficheiro);
            Scanner scanner = new Scanner(txt);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] linhas = linha.split(";");

                String nomeUtilizador = linhas[0];
                LocalDate dataNascimento = LocalDate.parse(linhas[1]);
                String especializacao = linhas[2];

                Utilizador utilizador = new Utilizador(nomeUtilizador, dataNascimento, especializacao);
                listaUtilizadores.add(utilizador);

//                for (Utilizador u : listaUtilizadores) {
//                    System.out.println(u);
//                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Equipamento alugarEquipamento(int id) {

        for (Equipamento eq : ListaEquipamentos) {

            if (eq.getID() == id) {

                if (eq.getUtilizador() != null) {
                    System.out.println("**Equipamento não disponível**");
                    return eq;
                }

                while (true) {

                    System.out.print("\nInsira o nome do utilizador: ");
                    String nome = scanner.nextLine();

                    for (Utilizador util : listaUtilizadores) {
                        if (util.getNomeUtilizador().equalsIgnoreCase(nome)) {

                            eq.setUtilizador(util);
                            System.out.println("\n-> Equipamento " + eq.getNome() + " alugado por " + util.getNomeUtilizador() + ".");
                            return eq;
                        }
                    }
                    System.out.println("**Utilizador inválido**");
                }
            }
        } System.out.println("**Equipamento não encontrado**");
        return null;
    }

    public Equipamento devolverEquipamento(int e) {
        for (Equipamento x : ListaEquipamentos){
            if (x.getID() == e){
                x.setUtilizador(null);
                System.out.println("\n-> Equipamento devolvido!");
                break;
            }
            System.out.println("**Erro devolução**");
        }
        return null;
    }

    public void editarEquipamento(int id){

        for (Equipamento equip : ListaEquipamentos) {

            if (equip.getID() == id) {
                System.out.println(equip);
                int edicao;

                if(equip instanceof Eletronico) {
                    System.out.println("\n1 : Nome");
                    System.out.println("2 : Estado");
                    System.out.println("3 : Potência");
                    System.out.println("4 : Consumo Energético");
                    System.out.print("\nSelecione o parâmetro a editar: ");
                    edicao = scanner.nextInt();
                    scanner.nextLine();

                    switch (edicao) {
                        case 1:
                            String nome;
                            do {
                                System.out.print("\nInsira o novo nome do equipamento: ");
                                nome = scanner.nextLine();
                            }while(!equip.setNome(nome));
                            System.out.println("-> Nome alterado para " + equip.getNome());
                            break;

                        case 2:
                            System.out.println("\n1 - Ativo");
                            System.out.println("2 - Inactivo");
                            System.out.println("3 - Manutenção");
                            System.out.print("\nInsira o novo estado do equipamento: ");
                            int i = scanner.nextInt();
                            scanner.nextLine();

                            switch (i) {
                                case 1:
                                    equip.mudarEstado(Estados.ATIVO);
                                    break;
                                case 2:
                                    equip.mudarEstado(Estados.INATIVO);
                                    break;
                                case 3:
                                    equip.mudarEstado(Estados.MANUTENCAO);
                                    break;
                            }
                            System.out.println("-> Estado alterado para " + equip.getEstado());
                            break;

                        case 3:
                            System.out.print("\nInsira o novo valor de potência: ");
                            float pot = scanner.nextFloat();
                            scanner.nextLine();
                            ((Eletronico) equip).setPotencia(pot);
                            System.out.println("-> Potência alterado para " + ((Eletronico) equip).getPotencia());
                            break;

                        case 4:
                            float consenerg;
                            do {
                                System.out.print("\nInsira o novo valor de consumo energético: ");
                                consenerg = scanner.nextFloat();
                                scanner.nextLine();
                            }while(!((Eletronico) equip).setConsumoEnergetico(consenerg));
                            ((Eletronico) equip).setConsumoEnergetico(consenerg);
                            System.out.println("-> Consumo energético alterado para " + ((Eletronico) equip).getConsumoEnergetico());
                            break;
                    }
                }
                else if (equip instanceof Recipiente) {
                    System.out.println("\n1 : Nome");
                    System.out.println("2 : Estado");
                    System.out.println("3 : Volume");
                    System.out.println("4 : Material");
                    System.out.println("5 : Esterilizado");
                    System.out.print("\nSelecione o parâmetro a editar: ");
                    edicao = scanner.nextInt();

                    switch (edicao) {
                        case 1:
                            String nome;
                            do {
                                System.out.print("\nInsira o novo nome do equipamento: ");
                                nome = scanner.nextLine();
                            } while (!equip.setNome(nome));
                            System.out.println("-> Nome alterado para " + equip.getNome());
                            break;

                        case 2:
                            System.out.println("\n1 - Ativo");
                            System.out.println("2 - Inactivo");
                            System.out.println("3 - Manutenção");
                            System.out.print("\nInsira o novo estado do equipamento: ");
                            int i = scanner.nextInt();
                            scanner.nextLine();
                            switch (i) {
                                case 1:
                                    equip.mudarEstado(Estados.ATIVO);
                                    break;
                                case 2:
                                    equip.mudarEstado(Estados.INATIVO);
                                    break;
                                case 3:
                                    equip.mudarEstado(Estados.MANUTENCAO);
                                    break;
                            }
                            System.out.println("-> Estado alterado para " + equip.getEstado());
                            break;

                        case 3:
                            int vol;
                            do {
                                System.out.print("\nInsira o novo volume: ");
                                vol = scanner.nextInt();
                                scanner.nextLine();
                            }while(!((Recipiente) equip).setVolume(vol));
                            System.out.println("-> Volume alterado para " + ((Recipiente) equip).getVolume());
                            break;

                        case 4:
                            System.out.println("\n1 - Vidro");
                            System.out.println("2 - Plástico");
                            System.out.println("3 - Metal");
                            System.out.println("4 - Silicone");
                            System.out.print("\nInsira o novo material: ");
                            i = scanner.nextInt();
                            scanner.nextLine();

                            switch (i) {
                                case 1:
                                    ((Recipiente) equip).setMaterial(Material.VIDRO);
                                    break;
                                case 2:
                                    ((Recipiente) equip).setMaterial(Material.PLASTICO);
                                    break;
                                case 3:
                                    ((Recipiente) equip).setMaterial(Material.METAL);
                                    break;
                                case 4:
                                    ((Recipiente) equip).setMaterial(Material.SILICONE);
                                    break;
                            }
                            System.out.println("-> Material alterado para " + ((Recipiente) equip).getMaterial());
                            break;

                        case 5:
                            System.out.print("\nO equipamento está esterilizado? \n1-Sim / 2-Não : ");
                            int esterilizado = scanner.nextInt();
                            scanner.nextLine();
                            boolean esteril = (esterilizado == 1);
                            ((Recipiente) equip).setEsteril(esteril);
                            System.out.println("-> Equipamento esterilizado? " + (((Recipiente) equip).getEsteril() ? "Sim" : "Não"));
                            break;
                    }
                }
                else if (equip instanceof Medicao) {
                    System.out.println("\n1 : Nome");
                    System.out.println("2 : Estado");
                    System.out.println("3 : Valor atual");
                    System.out.print("\nSelecione o parâmetro a editar: ");
                    edicao = scanner.nextInt();

                    switch(edicao){
                    case 1:
                        String nome;
                        do {
                            System.out.print("\nInsira o novo nome do equipamento: ");
                            nome = scanner.nextLine();
                        } while (!equip.setNome(nome));
                        System.out.println("-> Nome alterado para " + equip.getNome());
                        break;

                    case 2:
                        System.out.println("\n1 - Ativo");
                        System.out.println("2 - Inactivo");
                        System.out.println("3 - Manutenção");
                        System.out.print("\nInsira o novo estado do equipamento: ");
                        int i = scanner.nextInt();
                        scanner.nextLine();
                        switch (i) {
                            case 1:
                                equip.mudarEstado(Estados.ATIVO);
                                break;
                            case 2:
                                equip.mudarEstado(Estados.INATIVO);
                                break;
                            case 3:
                                equip.mudarEstado(Estados.MANUTENCAO);
                                break;
                        }
                        System.out.println("-> Estado alterado para " + equip.getEstado());
                        break;

                    case 3:
                        float valor;
                        do{
                            if(((Medicao) equip).getUnidade() == Unidades.TEMPERATURA){
                                System.out.print("\nInsira o valor de temperatura (ºC): ");
                                valor = scanner.nextFloat();
                                scanner.nextLine();
                            }
                            else if (((Medicao) equip).getUnidade() == Unidades.MASSA) {
                                System.out.print("\nInsira o novo valor de massa (g): ");
                                valor = scanner.nextFloat();
                                scanner.nextLine();
                            }
                            else if (((Medicao) equip).getUnidade() == Unidades.VOLUME) {
                                System.out.print("\nInsira o novo volume (mL): ");
                                valor = scanner.nextFloat();
                                scanner.nextLine();
                            }
                            else {
                                System.out.print("\nInsira o novo valor de pH: ");
                                valor = scanner.nextFloat();
                                scanner.nextLine();
                            }
                        }while(!((Medicao) equip).setValor(valor));
                        System.out.println("-> Valor alterado para " + ((Medicao) equip).getValor());
                        break;
                    }

                }

            }

        }
    }

    public Equipamento gravarFicheiroDetalhado(String ficheiro){
        try{
            FileWriter fw = new FileWriter(ficheiro);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i< ListaEquipamentos.size(); i++) {
                bw.write(ListaEquipamentos.get(i).toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n-> Ficheiro " + ficheiro + " gravado!");
        return null;
    }

    public Equipamento gravarFicheiroSimples(String ficheiroSimples){
        try{
            FileWriter fw = new FileWriter(ficheiroSimples);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i< ListaEquipamentos.size(); i++) {
                bw.write("ID: " + ListaEquipamentos.get(i).getID());
                bw.write(" ; Nome: " + ListaEquipamentos.get(i).getNome().toString());
                bw.write(" ; Data de registo: " + ListaEquipamentos.get(i).getData().toString());
                bw.write(" ; Estado: " + ListaEquipamentos.get(i).getEstado().toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n-> Ficheiro " + ficheiroSimples + " gravado!");
        return null;
    }
}