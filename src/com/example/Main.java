package com.example;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.example.model.Funcionario;

public class Main {
	public static void main(String[] args) {
		List<Funcionario> funcionarios = new ArrayList<>();
		// Inserir todos os funcionários, na mesma ordem e informações do requisito
		funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.4"), "Operador"));
		funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
		funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.86"), "Diretor"));
		funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
		funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
		funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
		funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
		funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
	
		// Remover o funcionário “João” da lista
		funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
		
		// Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor
        BigDecimal percentualAumento = new BigDecimal("10");
        for (int i = 0; i < funcionarios.size(); i++) {
        	Funcionario func = funcionarios.get(i);
            func.aumentarSalario(percentualAumento);
        }
		
		// Imprimir todos os funcionários com todas suas informações, sendo que:
		// informação de data deve ser exibido no formato dd/mm/aaaa
		// informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula
        System.out.println("Funcionários:");
        for (int i = 0; i < funcionarios.size(); i++) {
        	Funcionario func = funcionarios.get(i);
            System.out.println("Nome: " + func.getNome());
            System.out.println("Data de Nascimento: " + func.getDataNascimentoFormatada());
            System.out.println("Salário: R$ " + func.getSalarioFormatado());
            System.out.println("Função: " + func.getFuncao());
            System.out.println("---------------------------------------------------------------------------");
            System.out.println();
        }
        
        
     // Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”
        Map<String, List<Funcionario>> funcionarioPorFuncao = new HashMap<>();

        // Iterar sobre a lista de funcionários para preencher o map de agrupamento por função
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario func = funcionarios.get(i);
            String funcao = func.getFuncao();
            if (!funcionarioPorFuncao.containsKey(funcao)) {
                funcionarioPorFuncao.put(funcao, new ArrayList<>());
            }
            funcionarioPorFuncao.get(funcao).add(func);
        }

        
        System.out.println("Funcionários agrupados por função:");
        for (Map.Entry<String, List<Funcionario>> entry : funcionarioPorFuncao.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Funcionario func : entry.getValue()) {
                System.out.println("\tNome: " + func.getNome());
                System.out.println("\tData de Nascimento: " + func.getDataNascimentoFormatada());
                System.out.println("\tSalário: R$ " + func.getSalarioFormatado());
                System.out.println("---------------------------------------------------------------------------");
                System.out.println();
            }
        }

        
        //  Imprimir os funcionários que fazem aniversário no mês 10 e 12
        System.out.println("Funcionários que fazem aniversário em outubro e dezembro:");
        for (int i = 0; i < funcionarios.size(); i++) {
        	Funcionario func = funcionarios.get(i);
            int mesAniversario = func.getDataNascimento().getMonthValue();
            if (mesAniversario == 10 || mesAniversario == 12) {
                System.out.println("Nome: " + func.getNome());
                System.out.println("Data de Nascimento: " + func.getDataNascimentoFormatada());
                System.out.println("---------------------------------------------------------------------------");
                System.out.println();
            }
        }
        
        // Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        System.out.println("Funcionário mais velho:");
        Funcionario maisVelho = null;
        for (int i = 0; i < funcionarios.size(); i++) {
        	Funcionario func = funcionarios.get(i);
            if (maisVelho == null || func.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = func;
            }
        }
        
        if (maisVelho != null) {
            LocalDate hoje = LocalDate.now();
            int idade = hoje.getYear() - maisVelho.getDataNascimento().getYear();
            System.out.println("Nome: " + maisVelho.getNome());
            System.out.println("Idade: " + idade + " anos");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println();
        }
        
        // Imprimir a lista de funcionários por ordem alfabética.
        System.out.println("Lista de funcionários por ordem alfabética:");
        List<Funcionario> funcionariosOrdenados = new ArrayList<>(funcionarios);
        funcionariosOrdenados.sort(Comparator.comparing(Funcionario::getNome));
        for (int i = 0; i < funcionariosOrdenados.size() ; i++) {
        	Funcionario func = funcionariosOrdenados.get(i);
        	System.out.println("Nome: " + func.getNome());
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println();
        
        // Imprimir o total dos salários dos funcionários.
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (int i = 0; i < funcionarios.size(); i++) {
        	Funcionario func = funcionarios.get(i);
        	totalSalarios = totalSalarios.add(func.getSalario());
        }
        
        @SuppressWarnings("deprecation")
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String totalSalariosFormatado = formatoMoeda.format(totalSalarios).replace("R$", "").trim();
        
        System.out.println("Total dos salários: R$:" + totalSalariosFormatado);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println();

        
        // Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("Quantos salários mínimos cada funcionário ganha:");
        for (int i = 0; i < funcionarios.size(); i++) {
        	Funcionario func = funcionarios.get(i);
            @SuppressWarnings("deprecation")
			BigDecimal salariosMinimos = func.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_DOWN);
            System.out.println("Nome: " + func.getNome());
            System.out.println("Salários Mínimos: " + salariosMinimos);
            System.out.println("---------------------------------------------------------------------------");
            System.out.println();
        }

	}
}
