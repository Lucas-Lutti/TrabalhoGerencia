package com.gerencia.clinica;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.lessThan;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CapacityTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void testCapacity() throws InterruptedException {
        int numberOfRequests = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < numberOfRequests; i++) {
            executorService.execute(() -> {
                get("/api/v1/pacientes/all")
                    .then()
                    .statusCode(200)
                    .time(lessThan(2000L)); // Verifica se a resposta é retornada em menos de 2 segundos
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
