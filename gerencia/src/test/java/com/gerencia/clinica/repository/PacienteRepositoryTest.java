package com.gerencia.clinica.repository;

import com.gerencia.clinica.model.Paciente;
import com.gerencia.clinica.service.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PacienteRepositoryTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveAndFind() {
        Paciente paciente = new Paciente(null, "John", "Doe", 'M', LocalDate.of(1990, 1, 1), (byte) 0, (short) 180, 80.0, "12345678909", 0.0);
        when(pacienteRepository.save(any(Paciente.class))).thenReturn(paciente);
        when(pacienteRepository.findById(anyLong())).thenReturn(Optional.of(paciente));

        Paciente savedPaciente = pacienteService.addPaciente(paciente);
        Paciente foundPaciente = pacienteService.getPacienteById(1L);

        assertEquals("John", savedPaciente.getNome());
        assertNotNull(foundPaciente);
        assertEquals("Doe", foundPaciente.getSobrenome());
    }

    @Test
    public void testUpdatePaciente() {
        Paciente paciente = new Paciente(1L, "John", "Doe", 'M', LocalDate.of(1990, 1, 1), (byte) 0, (short) 180, 80.0, "12345678909", 0.0);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));
        when(pacienteRepository.save(any(Paciente.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Paciente updatedInfo = new Paciente(1L, "Jane", "Doe", 'F', LocalDate.of(1990, 1, 1), (byte) 0, (short) 180, 75.0, "12345678909", 0.0);
        Paciente updatedPaciente = pacienteService.updatePaciente(1L, updatedInfo);

        assertNotNull(updatedPaciente);
        assertEquals("Jane", updatedPaciente.getNome());
    }

    @Test
    public void testDeletePaciente() {
        Paciente paciente = new Paciente(1L, "John", "Doe", 'M', LocalDate.of(1990, 1, 1), (byte) 0, (short) 180, 80.0, "12345678909", 0.0);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));
        doNothing().when(pacienteRepository).deleteById(1L);

        pacienteService.deletePaciente(1L);
        verify(pacienteRepository, times(1)).deleteById(1L);
    }
}
