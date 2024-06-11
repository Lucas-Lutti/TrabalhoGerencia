package com.gerencia.clinica.service;

import com.gerencia.clinica.model.Paciente;
import com.gerencia.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public List<Paciente> getAllPacientes() {
        return repository.findAll();
    }

    public Paciente getPacienteById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Paciente addPaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    public Paciente updatePaciente(Long id, Paciente paciente) {
        Paciente existingPaciente = repository.findById(id).orElse(null);
        if (existingPaciente != null) {
            existingPaciente.setNome(paciente.getNome());
            existingPaciente.setSobrenome(paciente.getSobrenome());
            existingPaciente.setSexo(paciente.getSexo());
            existingPaciente.setNascimento(paciente.getNascimento());
            existingPaciente.setIdade(paciente.getIdade());
            existingPaciente.setAltura(paciente.getAltura());
            existingPaciente.setPeso(paciente.getPeso());
            existingPaciente.setCpf(paciente.getCpf());
            existingPaciente.setImc(paciente.getImc());
            return repository.save(existingPaciente);
        }
        return null;
    }

    public void deletePaciente(Long id) {
        repository.deleteById(id);
    }
}
