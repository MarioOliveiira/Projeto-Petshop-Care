import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConectaPostgres banco = new ConectaPostgres();
        String user = "postgres";
        String password = "postgres";
        String url = "jdbc:postgresql://localhost:5432/petshop";
        banco.Conectar(url, user, password);
        int escolha;
        do {
            System.out.println("==================");
            System.out.println("   Petshop care   ");
            System.out.println("==================");
            System.out.println("Escolha uma das opções abaixo: ");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Relatorios");
            System.out.println();
            System.out.println("0 - Sair");
            escolha = sc.nextInt();
            switch (escolha) {
                case 1: menuCadastrar(sc, banco); break;
                case 2: menuBuscar(sc, banco); break;
                case 3: menuAtualizar(sc, banco); break;
                case 4: menuExcluir(sc, banco); break;
                case 5: menuRelatorios(sc, banco); break;
            }
        } while (escolha != 0);
    }

    public static void menuCadastrar(Scanner sc, ConectaPostgres banco) {
        System.out.println("O que voce quer cadastrar? ");
        System.out.println("1 - Animal");
        System.out.println("2 - Cliente");
        System.out.println("3 - Pet");
        System.out.println("4 - Produto");
        int escolha2 = sc.nextInt();
        switch (escolha2) {
            case 1: cadastrarAnimal(sc, banco); break;
            case 2: cadastrarCliente(sc, banco); break;
            case 3: cadastrarPet(sc, banco); break;
            case 4: cadastrarProduto(sc, banco); break;
        }
    }

    public static void cadastrarAnimal(Scanner sc, ConectaPostgres banco) {
        AnimalDAO animalDAO = new AnimalDAO(banco);
        System.out.println("Digite o nome do tipo de animal: ");
        sc.nextLine();
        String nome = sc.nextLine();
        animalDAO.inserir(new Animal(nome));
        System.out.println("Animal incluido com sucesso!");
    }

    public static void cadastrarCliente(Scanner sc, ConectaPostgres banco) {
        ClienteDAO clienteDAO = new ClienteDAO(banco);
        System.out.println("Digite o nome: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.println("Digite o CPF: ");
        String cpf = sc.nextLine();
        System.out.println("Digite o email: ");
        String email = sc.nextLine();
        System.out.println("Digite a data de cadastro (AAAA-MM-DD): ");
        LocalDate data = LocalDate.parse(sc.nextLine());
        clienteDAO.inserir(new Cliente(nome, cpf, email, data));
        System.out.println("Cliente incluido com sucesso!");
    }

    public static void cadastrarPet(Scanner sc, ConectaPostgres banco) {
        PetDAO petDAO = new PetDAO(banco);
        AnimalDAO animalDAO = new AnimalDAO(banco);
        ClienteDAO clienteDAO = new ClienteDAO(banco);
        System.out.println("Digite o nome: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.println("Digite o porte do pet: ");
        String porte = sc.nextLine();
        System.out.println("Digite o tipo do pelo do pet:");
        String tipo_pelo = sc.nextLine();
        System.out.println("Digite o peso do pet: ");
        double peso = sc.nextDouble();
        ArrayList<Animal> animais = animalDAO.buscar();
        for (Animal a : animais) System.out.println(a.getCod_animal() + " - " + a.getNome());
        System.out.println("Digite o codigo do animal: ");
        int cod_animal = sc.nextInt();
        ArrayList<Cliente> clientes = clienteDAO.buscar();
        for (Cliente c : clientes) System.out.println(c.getCod_cliente() + " - " + c.getNome_cliente());
        System.out.println("Digite o codigo do cliente: ");
        int cod_cliente = sc.nextInt();
        petDAO.inserir(new Pet(nome, porte, tipo_pelo, peso, cod_animal, cod_cliente));
        System.out.println("Pet cadastrado com sucesso!");
    }

    public static void cadastrarProduto(Scanner sc, ConectaPostgres banco) {
        ProdutoDAO produtoDAO = new ProdutoDAO(banco);
        System.out.println("Digite o nome do produto: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.println("Digite o EAN do produto(cod barra): ");
        String ean = sc.nextLine();
        System.out.println("Digite o DUN do produto (cod barra caixa): ");
        String dun = sc.nextLine();
        System.out.println("Digite a descrição do produto: ");
        String descricao = sc.nextLine();
        System.out.println("Digite a marca do produto: ");
        String marca = sc.nextLine();
        System.out.println("Digite a categoria do produto: ");
        String categoria = sc.nextLine();
        produtoDAO.inserir(new Produto(nome, ean, dun, descricao, marca, categoria));
        System.out.println("Produto cadastrado com sucesso!");
    }
    public static void menuBuscar(Scanner sc, ConectaPostgres banco) {
        System.out.println("O que voce quer buscar? ");
        System.out.println("1 - Animal");
        System.out.println("2 - Cliente");
        System.out.println("3 - Pet");
        System.out.println("4 - Produto");
        int escolha2 = sc.nextInt();
        switch (escolha2) {
            case 1: buscarAnimal(sc, banco); break;
            case 2: buscarCliente(sc, banco); break;
            case 3: buscarPet(sc, banco); break;
            case 4: buscarProduto(sc, banco); break;
        }
    }

    public static void buscarAnimal(Scanner sc, ConectaPostgres banco) {
        AnimalDAO animalDAO = new AnimalDAO(banco);
        for (Animal a : animalDAO.buscar())
            System.out.println(a.getCod_animal() + " - " + a.getNome());
    }

    public static void buscarCliente(Scanner sc, ConectaPostgres banco) {
        ClienteDAO clienteDAO = new ClienteDAO(banco);
        for (Cliente c : clienteDAO.buscar())
            System.out.println(
                            c.getCod_cliente() + " - " +
                            c.getNome_cliente() + " - " +
                            c.getCpf() + " - " +
                            c.getEmail() + " - " +
                            c.getData_cadastro());
    }

    public static void buscarPet(Scanner sc, ConectaPostgres banco) {
        PetDAO petDAO = new PetDAO(banco);
        for (Pet p : petDAO.buscar())
            System.out.println(
                    p.getCod_pet() + " - " +
                    p.getNome_pet() + " - " +
                    p.getPorte() + " - " +
                    p.getTipo_pelo() + " - " +
                    p.getPeso());
    }

    public static void buscarProduto(Scanner sc, ConectaPostgres banco) {
        ProdutoDAO produtoDAO = new ProdutoDAO(banco);
        for (Produto pd : produtoDAO.buscar())
            System.out.println(
                    pd.getCod_produto() + " - " +
                    pd.getNome_produto() + " - " +
                    pd.getEan() + " - " +
                    pd.getDun() + " - " +
                    pd.getDescricao() + " - " +
                    pd.getMarca() + " - " +
                    pd.getCategoria());
    }

    public static void menuAtualizar(Scanner sc, ConectaPostgres banco) {
        System.out.println("O que voce quer atualizar? ");
        System.out.println("1 - Animal");
        System.out.println("2 - Cliente");
        System.out.println("3 - Pet");
        System.out.println("4 - Produto");
        int escolha2 = sc.nextInt();
        switch (escolha2) {
            case 1: atualizarAnimal(sc, banco); break;
            case 2: atualizarCliente(sc, banco); break;
            case 3: atualizarPet(sc, banco); break;
            case 4: atualizarProduto(sc, banco); break;
        }
    }

    public static void atualizarAnimal(Scanner sc, ConectaPostgres banco) {
        AnimalDAO animalDAO = new AnimalDAO(banco);
        buscarAnimal(sc, banco);
        System.out.println("Digite o codigo do animal a ser alterado: ");
        int cod = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o nome atualizado do animal:");
        String nome = sc.nextLine();
        Animal animal = new Animal(nome);
        animal.setCod_animal(cod);
        animalDAO.atualizar(animal);
        System.out.println("Animal atualizado com sucesso!");
    }

    public static void atualizarCliente(Scanner sc, ConectaPostgres banco) {
        ClienteDAO clienteDAO = new ClienteDAO(banco);
        buscarCliente(sc, banco);
        System.out.println("Digite o cod do cliente a ser alterado: ");
        int cod = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o nome atualizado: ");
        String nome = sc.nextLine();
        System.out.println("Digite o CPF atualizado: ");
        String cpf = sc.nextLine();
        System.out.println("Digite o email atualizado: ");
        String email = sc.nextLine();
        System.out.println("Digite a data (AAAA-MM-DD) atualizada: ");
        LocalDate data = LocalDate.parse(sc.nextLine());
        Cliente cliente = new Cliente(nome, cpf, email, data);
        cliente.setCod_cliente(cod);
        clienteDAO.atualizar(cliente);
        System.out.println("Cliente atualizado com sucesso!");
    }

    public static void atualizarPet(Scanner sc, ConectaPostgres banco) {
        PetDAO petDAO = new PetDAO(banco);
        AnimalDAO animalDAO = new AnimalDAO(banco);
        ClienteDAO clienteDAO = new ClienteDAO(banco);
        buscarPet(sc, banco);
        System.out.println("Digite o cod do pet a ser alterado: ");
        int cod = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o nome do pet atualizado: ");
        String nome_pet = sc.nextLine();
        System.out.println("Digite o porte do pet atualizado: ");
        String porte = sc.nextLine();
        System.out.println("Digite o tipo do pelo do pet atualizado:");
        String tipo_pelo = sc.nextLine();
        System.out.println("Digite o peso do pet atualizado: ");
        double peso = sc.nextDouble();
        for (Animal a : animalDAO.buscar()) System.out.println(a.getCod_animal() + " - " + a.getNome());
        System.out.println("Digite o codigo do animal: ");
        int cod_animal = sc.nextInt();
        for (Cliente c : clienteDAO.buscar()) System.out.println(c.getCod_cliente() + " - " + c.getNome_cliente());
        System.out.println("Digite o codigo do cliente: ");
        int cod_cliente = sc.nextInt();
        Pet pet = new Pet(nome_pet, porte, tipo_pelo, peso, cod_animal, cod_cliente);
        pet.setCod_pet(cod);
        petDAO.atualizar(pet);
        System.out.println("Pet atualizado com sucesso!");
    }

    public static void atualizarProduto(Scanner sc, ConectaPostgres banco) {
        ProdutoDAO produtoDAO = new ProdutoDAO(banco);
        buscarProduto(sc, banco);
        System.out.println("Digite o cod do produto a ser alterado:");
        int cod = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o nome do produto atualizado: ");
        String nome = sc.nextLine();
        System.out.println("Digite o EAN atualizado: ");
        String ean = sc.nextLine();
        System.out.println("Digite o DUN atualizado: ");
        String dun = sc.nextLine();
        System.out.println("Digite a descrição atualizada: ");
        String descricao = sc.nextLine();
        System.out.println("Digite a marca atualizada: ");
        String marca = sc.nextLine();
        System.out.println("Digite a categoria atualizada: ");
        String categoria = sc.nextLine();
        Produto produto = new Produto(nome, ean, dun, descricao, marca, categoria);
        produto.setCod_produto(cod);
        produtoDAO.atualizar(produto);
        System.out.println("Produto atualizado com sucesso!");
    }
    public static void menuExcluir(Scanner sc, ConectaPostgres banco) {
        System.out.println("O que voce quer excluir? ");
        System.out.println("1 - Animal");
        System.out.println("2 - Cliente");
        System.out.println("3 - Pet");
        System.out.println("4 - Produto");
        int escolha2 = sc.nextInt();
        switch (escolha2) {
            case 1: excluirAnimal(sc, banco); break;
            case 2: excluirCliente(sc, banco); break;
            case 3: excluirPet(sc, banco); break;
            case 4: excluirProduto(sc, banco); break;
        }
    }

    public static void excluirAnimal(Scanner sc, ConectaPostgres banco) {
        buscarAnimal(sc, banco);
        System.out.println("Digite o codigo do animal a ser excluido: ");
        int cod = sc.nextInt();
        Animal animal = new Animal("");
        animal.setCod_animal(cod);
        new AnimalDAO(banco).deletar(animal);
        System.out.println("Animal excluido com sucesso!");
    }

    public static void excluirCliente(Scanner sc, ConectaPostgres banco) {
        buscarCliente(sc, banco);
        System.out.println("Digite o cod do cliente a ser excluido: ");
        int cod = sc.nextInt();
        Cliente cliente = new Cliente("", "", "", LocalDate.now());
        cliente.setCod_cliente(cod);
        new ClienteDAO(banco).deletar(cliente);
        System.out.println("Cliente excluido com sucesso!");
    }

    public static void excluirPet(Scanner sc, ConectaPostgres banco) {
        buscarPet(sc, banco);
        System.out.println("Digite o cod do pet a ser excluido: ");
        int cod = sc.nextInt();
        Pet pet = new Pet("", "", "", 0, 0, 0);
        pet.setCod_pet(cod);
        new PetDAO(banco).deletar(pet);
        System.out.println("Pet excluido com sucesso!");
    }

    public static void excluirProduto(Scanner sc, ConectaPostgres banco) {
        buscarProduto(sc, banco);
        System.out.println("Digite o cod do produto a ser excluido: ");
        int cod = sc.nextInt();
        Produto produto = new Produto("", "", "", "", "", "");
        produto.setCod_produto(cod);
        new ProdutoDAO(banco).deletar(produto);
        System.out.println("Produto excluido com sucesso!");
    }
    public static void menuRelatorios(Scanner sc, ConectaPostgres banco) {
        System.out.println("1 - Atendimentos");
        System.out.println("2 - Pedidos");
        int escolha2 = sc.nextInt();
        switch (escolha2) {
            case 1: relatorioAtendimentos(sc, banco); break;
            case 2: relatorioPedidos(sc, banco); break;
        }
    }

    public static void relatorioAtendimentos(Scanner sc, ConectaPostgres banco) {
        VwAtendimentoDAO vwDAO = new VwAtendimentoDAO(banco);
        for (VwAtendimento a : vwDAO.buscar())
            System.out.println(
                    a.getNome_cliente() + " - " +
                    a.getNome_pet() + " - " +
                    a.getNome_servico() + " - " +
                    a.getValor_servico());
    }

    public static void relatorioPedidos(Scanner sc, ConectaPostgres banco) {
        RelatorioPedidoDAO relDAO = new RelatorioPedidoDAO(banco);
        for (RelatorioPedido rp : relDAO.buscar())
            System.out.println(
                    rp.getNome_produto() + " - " +
                    rp.getNome_cliente() + " - " +
                    rp.getValor_total());
    }
}