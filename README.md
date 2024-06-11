# API de Gerenciamento de Pacientes

## Introdução
Este projeto consiste no desenvolvimento de uma API para gerenciar pacientes de uma clínica médica. A API foi criada para otimizar os processos internos, simplificar a gestão de dados e aprimorar a qualidade do atendimento prestado pela clínica.

## Requisitos do Sistema
- Gerenciar informações de pacientes, incluindo nome, sobrenome, sexo, data de nascimento, idade, altura, peso, CPF e IMC.
- Calcular o peso ideal, IMC e idade dos pacientes.
- Oferecer endpoints para adicionar, atualizar, remover e listar pacientes.
- Validar o CPF dos pacientes.
- Retornar o CPF ofuscado dos pacientes.

## Arquitetura
A arquitetura do sistema é baseada em uma API RESTful, desenvolvida em Java utilizando Spring Boot. A API expõe endpoints para as operações CRUD de gerenciamento de pacientes, bem como para cálculos específicos relacionados aos dados dos pacientes.

## Endpoints da API
\```
- `GET /api/v1/pacientes/all`: Obtém uma lista de todos os pacientes.
- `GET /api/v1/pacientes/{id}`: Obtém detalhes de um paciente específico.
- `POST /api/v1/pacientes`: Adiciona um novo paciente.
- `PUT /api/v1/pacientes/{id}`: Atualiza os detalhes de um paciente existente.
- `DELETE /api/v1/pacientes/{id}`: Remove um paciente do sistema.
\```

## Instruções de Uso

### Configuração do Ambiente
1. Certifique-se de ter o JDK 21+ instalado.
2. Instale o Maven.
3. Clone o repositório:
\```
git clone <URL_DO_REPOSITORIO>
cd <DIRETORIO_DO_PROJETO>
mvn spring-boot:run
\```

### Testes
\```
mvn test
\```

### Documentação
Acesse a documentação da API em `http://localhost:8080/swagger-ui.html`.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Maven
- JUnit
- RestAssured
- Docker

## Código Fonte
O código fonte do projeto está disponível no GitHub. Para clonar o repositório:
\```
git clone <URL_DO_REPOSITORIO>
\```

## Testes
O projeto inclui testes unitários, de integração e de aceitação para garantir a qualidade do código. Os testes podem ser executados com o comando:
\```
mvn test
\```

## Implantação
Para implantar a API via Docker em um ambiente de produção, siga os passos:

1. Certifique-se de ter o Docker instalado.
2. Construa a imagem Docker:
\```
docker build -t api-gerenciamento-pacientes .
\```
3. Execute o contêiner:
\```
docker run -p 8080:8080 api-gerenciamento-pacientes
\```

## Contribuição
Contribuições são bem-vindas! Para contribuir, siga os passos:

1. Fork o repositório.
2. Crie uma nova branch:
\```
git checkout -b minha-feature
\```
3. Faça as alterações e commit:
\```
git commit -m "Minha nova feature"
\```
4. Envie para o repositório remoto:
\```
git push origin minha-feature
\```
5. Crie um Pull Request.


