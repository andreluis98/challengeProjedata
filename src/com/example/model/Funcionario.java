package com.example.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {
	private BigDecimal salario;
	private String funcao;
	public Funcionario(String nome, LocalDate dataDeNascimento, BigDecimal salario, String funcao) {
		super(nome, dataDeNascimento);
        this.salario = salario;
        this.funcao = funcao;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public void aumentarSalario(BigDecimal percentual) {
		BigDecimal aumento = salario.multiply(percentual.divide(BigDecimal.valueOf(100)));
		salario = salario.add(aumento);
	}
	
	public String getSalarioFormatado() {
        @SuppressWarnings("deprecation")
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatoMoeda.format(salario).replace("R$", "").trim();
	}
	
	public String getFuncao() {
		return funcao;
	}

}
