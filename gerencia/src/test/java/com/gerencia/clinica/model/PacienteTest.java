package com.gerencia.clinica.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    @Test
    public void testCalcularIMC() {
        Paciente paciente = new Paciente(null, "John", "Doe", 'M', LocalDate.of(1990, 1, 1), (byte) 0, (short) 180, 80.0, "12345678909", 0.0);
        double imc = paciente.calcularIMC();
        assertEquals(24.69, imc, 0.01);
    }

    @Test
    public void testCalcularIdade() {
        Paciente paciente = new Paciente(null, "John", "Doe", 'M', LocalDate.of(1990, 1, 1), (byte) 0, (short) 180, 80.0, "12345678909", 0.0);
        byte idade = (byte) paciente.calcularIdade();
        assertEquals(34, idade); // Atualize este valor de acordo com a data atual
    }

    @Test
    public void testObterPesoIdeal() {
        Paciente paciente = new Paciente(null, "John", "Doe", 'M', LocalDate.of(1990, 1, 1), (byte) 0, (short) 180, 80.0, "12345678909", 0.0);
        double pesoIdeal = paciente.obterPesoIdeal();
        assertEquals(72.7 * 1.80 - 58, pesoIdeal, 0.01);
    }

    @Test
    public void testObterSituacaoIMC() {
        Paciente paciente = new Paciente(null, "John", "Doe", 'M', LocalDate.of(1990, 1, 1), (byte) 0, (short) 180, 80.0, "12345678909", 0.0);
        paciente.calcularIMC();
        String situacaoIMC = paciente.obterSituacaoIMC();
        assertEquals("Peso normal", situacaoIMC);
    }

    @Test
    public void testObterCpfOfuscado() {
        Paciente paciente = new Paciente(null, "John", "Doe", 'M', LocalDate.of(1990, 1, 1), (byte) 0, (short) 180, 80.0, "12345678909", 0.0);
        String cpfOfuscado = paciente.obterCpfOfuscado();
        assertEquals("***.456.***-**", cpfOfuscado);
    }

    @Test
    public void testValidarCPF() {
        Paciente paciente = new Paciente(null, "John", "Doe", 'M', LocalDate.of(1990, 1, 1), (byte) 0, (short) 180, 80.0, "12345678909", 0.0);
        assertTrue(paciente.validarCPF());
    }

    @Test
    public void testInvalidarCPF() {
        Paciente paciente = new Paciente(null, "John", "Doe", 'M', LocalDate.of(1990, 1, 1), (byte) 0, (short) 180, 80.0, "12345678900", 0.0);
        assertFalse(paciente.validarCPF());
    }
}
