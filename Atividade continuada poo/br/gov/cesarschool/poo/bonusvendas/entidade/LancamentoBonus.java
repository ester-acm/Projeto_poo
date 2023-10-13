package br.gov.cesarschool.poo.bonusvendas.entidade;
import java.time.LocalDateTime;
import java.util.Scanner;

/*  COMO FAZER O CÓDIGO:
* @todo scan num caixas de bonus e valor
*   Scanner sc = new Scanner(System.in);
*   long numeroCaixa Bonus = sc.nextLong();
* id.CaixaBonus = CPF+dataCadastral //Números do CPF e da data juntos ex.: CPF= 000.000.000-00 Data= 10/10/2023
*   ∴ id.CaixaBonus=00000000010102023
*
* Para o acumulo de pontosss: digita-se o id.CaixaBonus e o sistema deve conferir se essa caixa existe
* Caso exista esse id o sistema deve pedir o valor a ser colocado na Caixa, gerar um registro de entrada e atualizar o valor existente
* O registro de entrada consiste em gravar a hora, o valor e a caixa onde está  se colocando
* @question
*   Como conferir se a caixa já existe?
*   Como gerar o registro da hora da entrada em questão? Onde que esse registro será  guardado?
* @todo Acumular bônus
*
* Para fazer a consulta dos bônus pede-se o número da caixa de bônus do vendedor e tem acesso a:
*       1. Todos os resgates
*       2. Pontuação do vendedor
*       3. Saldo de bônus
* @todo Consultar bônus
*
* Para fazer o resgate digita o número da caixa de bônus, o valor a ser resgatado e o tipo de resgate
* O tipo de resgate pode ser:
*       1. Produto
*       2. Serviço
*       3. Cash
* É gerado o registro desse resgate, salvando a hora, o valor e a caixa de onde foi tirado
* @question
*   Pode-se usar switch case como em C ou JAVA não tem? Qual seria a função equivalente?
* @todo Resgatar bônus
*
*
*/

public class LancamentoBonus {
    private long numeroCaixaBonus;
    private double valor;
    private LocalDateTime dataHoraLancamento;

    public LancamentoBonus(long numeroCaixaBonus, double valor) {
        this.numeroCaixaBonus = numeroCaixaBonus;
        this.valor = valor;
        this.dataHoraLancamento = LocalDateTime.now();
        System.out.println("ID da Caixa de bônus do vendedor: " + numeroCaixaBonus + "\nValor a ser colocado na caixa: " + valor);
    }

    public long getNumeroCaixaBonus() {
        return numeroCaixaBonus;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHoraLancamento() {
        return dataHoraLancamento; 
    }

    public void adicionarValor(double valor) {
        this.valor += valor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o número de identificação da Caixa onde deseja adicionar o bônus? ");
        long numeroCaixaBonus = scanner.nextLong();
        double valor = 0;
        scanner.close();

        LancamentoBonus lancamento = null;

        if (lancamento != null && lancamento.getNumeroCaixaBonus() == numeroCaixaBonus) {
            System.out.println("Valor a ser adicionado: ");
            valor = scanner.nextDouble();
            lancamento.adicionarValor(valor);
        } else {
            lancamento = new LancamentoBonus(numeroCaixaBonus, valor);
        }
    }
}
