import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class relatorios {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = lerArquivoFuncionarios("/home/luucasdinoo/Downloads/func");

        if (funcionarios != null) {
            // Listar os dados e o percentual de funcionários que recebem salários acima de R$ 1.320,00
            listarFuncionariosAcimaDe(funcionarios, 1320.00);

            // Listar os dados e o percentual de funcionários que recebem salários abaixo de R$ 1.320,00
            listarFuncionariosAbaixoDe(funcionarios, 1320.00);

            // Listar os dados e o percentual de funcionários que recebem salários iguais a R$ 1.320,00
            listarFuncionariosIguaisA(funcionarios, 1320.00);

            // Listar o número de funcionários que têm um determinado cargo
            listarNumeroFuncionariosPorCargo(funcionarios, "11"); // Substitua "Gerente" pelo cargo desejado
        }
    }

    public static List<Funcionario> lerArquivoFuncionarios(String nomeArquivo) {
        List<Funcionario> funcionarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                // Verifica se a linha contém todos os dados esperados
                if (dados.length == 4) {
                    int cod = Integer.parseInt(dados[0]);
                    String cargo = dados[1];
                    String nome = dados[2];
                    double salario = Double.parseDouble(dados[3]);

                    Funcionario funcionario = new Funcionario(cod, cargo, nome, salario);
                    funcionarios.add(funcionario);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }

        return funcionarios;
    }

    public static void listarFuncionariosAcimaDe(List<Funcionario> funcionarios, double salarioLimite) {
        int count = 0;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getSalario() > salarioLimite) {
                count++;
                // Aqui você pode exibir os dados do funcionário se necessário
            }
        }
        double percentual = (double) count / funcionarios.size() * 100;
        System.out.printf("Funcionários com salários acima de R$ %.2f: %d funcionário(s) (%.2f%%)\n", salarioLimite, count, percentual);
    }

    public static void listarFuncionariosAbaixoDe(List<Funcionario> funcionarios, double salarioLimite) {
        int count = 0;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getSalario() < salarioLimite) {
                count++;
                // Aqui você pode exibir os dados do funcionário se necessário
            }
        }
        double percentual = (double) count / funcionarios.size() * 100;
        System.out.printf("Funcionários com salários abaixo de R$ %.2f: %d funcionário(s) (%.2f%%)\n", salarioLimite, count, percentual);
    }

    public static void listarFuncionariosIguaisA(List<Funcionario> funcionarios, double salario) {
        int count = 0;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getSalario() == salario) {
                count++;
                // Aqui você pode exibir os dados do funcionário se necessário
            }
        }
        double percentual = (double) count / funcionarios.size() * 100;
        System.out.printf("Funcionários com salários iguais a R$ %.2f: %d funcionário(s) (%.2f%%)\n", salario, count, percentual);
    }

    public static void listarNumeroFuncionariosPorCargo(List<Funcionario> funcionarios, String cargo) {
        int count = 0;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCargo().equalsIgnoreCase(cargo)) {
                count++;
                // Aqui você pode exibir os dados do funcionário se necessário
            }
        }
        System.out.printf("Número de funcionários com cargo '%s' (Gerente de pessoal): %d\n", cargo, count);
    }
}