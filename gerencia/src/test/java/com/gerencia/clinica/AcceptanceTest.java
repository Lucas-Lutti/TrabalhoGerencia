package com.gerencia.clinica;

import com.gerencia.clinica.model.Paciente;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcceptanceTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void testAddAndGetPaciente() {
        // Adiciona um novo paciente
        Paciente paciente = new Paciente();
        paciente.setNome("John");
        paciente.setSobrenome("Doe");
        paciente.setSexo('M'); // Supondo que 'M' representa Masculino
        paciente.setIdade(30);
        paciente.setPeso(75.0);
        paciente.setCpf("12345678901");
        paciente.setImc(23.15);

        Response response = given()
                .contentType("application/json")
                .body(paciente)
                .when()
                .post("/api/v1/pacientes")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .response();

        Long pacienteId = response.jsonPath().getLong("id");

        // Verifica se o paciente foi adicionado corretamente
        given()
                .when()
                .get("/api/v1/pacientes/" + pacienteId)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("nome", equalTo("John"));

        // Testa a obtenção de todos os pacientes
        given()
                .when()
                .get("/api/v1/pacientes/all")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("size()", greaterThanOrEqualTo(1)); // Verifica se há pelo menos um paciente na lista
    }
}
