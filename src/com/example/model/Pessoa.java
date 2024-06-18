package com.example.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
	private String nome;
	private LocalDate dataDeNascimento;

	public Pessoa(String nome, LocalDate dataDeNascimento) {
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public LocalDate getDataNascimento() {
		return dataDeNascimento;
	}
	
	public String getDataNascimentoFormatada() {
        return dataDeNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
