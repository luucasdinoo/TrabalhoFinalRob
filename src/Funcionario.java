public class Funcionario{
    private int cod;
    private String cargo;
    private String nome;
    private double salario;

    public Funcionario(int cod, String cargo, String nome, double salario) {
        this.cod = cod;
        this.cargo = cargo;
        this.nome = nome;
        this.salario = salario;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
