package com.gerencia.clinica.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private char sexo;
    private LocalDate nascimento;
    private int idade;
    private short altura; // altura em centímetros
    private double peso;
    private String cpf;
    private double imc;

    // Construtor padrão
    public Paciente() {}

    // Construtor com todos os atributos
    public Paciente(Long id, String nome, String sobrenome, char sexo, LocalDate nascimento, int idade, short altura, double peso, String cpf, double imc) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.cpf = cpf;
        this.imc = imc;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public short getAltura() {
        return altura;
    }

    public void setAltura(short altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    // Método para calcular o IMC
    public double calcularIMC() {
        double alturaMetros = this.altura / 100.0;
        this.imc = this.peso / (alturaMetros * alturaMetros);
        return this.imc;
    }

    // Método para calcular a idade
    public int calcularIdade() {
        this.idade = Period.between(this.nascimento, LocalDate.now()).getYears();
        return this.idade;
    }

    // Método para obter o peso ideal
    public double obterPesoIdeal() {
        double alturaMetros = this.altura / 100.0;
        if (this.sexo == 'M' || this.sexo == 'm') {
            return (72.7 * alturaMetros) - 58;
        } else {
            return (62.1 * alturaMetros) - 44.7;
        }
    }

    // Método para obter a situação do IMC
    public String obterSituacaoIMC() {
        if (this.imc < 17) {
            return "Muito abaixo do peso";
        } else if (this.imc >= 17 && this.imc < 18.49) {
            return "Abaixo do peso";
        } else if (this.imc >= 18.50 && this.imc < 24.99) {
            return "Peso normal";
        } else if (this.imc >= 25 && this.imc < 29.99) {
            return "Acima do peso";
        } else if (this.imc >= 30 && this.imc < 34.99) {
            return "Obesidade I";
        } else if (this.imc >= 35 && this.imc < 39.99) {
            return "Obesidade II (severa)";
        } else {
            return "Obesidade III (mórbida)";
        }
    }

    // Método para obter CPF ofuscado
    public String obterCpfOfuscado() {
        if (this.cpf != null && this.cpf.length() == 11) {
            return "***." + this.cpf.substring(3, 6) + ".***-**";
        }
        return null;
    }

    // Método para validar CPF
    public boolean validarCPF() {
        if (this.cpf == null || this.cpf.length() != 11 || this.cpf.chars().distinct().count() == 1) {
            return false;
        }

        try {
            int[] cpf = new int[11];
            for (int i = 0; i < 11; i++) {
                cpf[i] = Integer.parseInt(this.cpf.substring(i, i + 1));
            }

            int v1 = 0, v2 = 0;
            for (int i = 0; i < 9; i++) {
                v1 += cpf[i] * (10 - i);
                v2 += cpf[i] * (11 - i);
            }
            v1 = (v1 % 11) < 2 ? 0 : 11 - (v1 % 11);
            v2 += v1 * 2;
            v2 = (v2 % 11) < 2 ? 0 : 11 - (v2 % 11);

            return cpf[9] == v1 && cpf[10] == v2;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
