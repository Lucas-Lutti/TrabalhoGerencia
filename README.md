# API de Gerenciamento de Pacientes e Aplicação Mobile

## Introdução
Este projeto consiste no desenvolvimento de uma API para gerenciar pacientes de uma clínica médica e uma aplicação mobile que interage com essa API. A API foi criada para otimizar os processos internos, simplificar a gestão de dados e aprimorar a qualidade do atendimento prestado pela clínica. A aplicação mobile, desenvolvida em Swift UIKit, demonstra algumas funcionalidades da API e oferece uma interface amigável para os usuários.

## Requisitos do Sistema
- Gerenciar informações de pacientes, incluindo nome, sobrenome, sexo, data de nascimento, idade, altura, peso, CPF e IMC.
- Calcular o peso ideal, IMC e idade dos pacientes.
- Oferecer endpoints para adicionar, atualizar, remover e listar pacientes.
- Validar o CPF dos pacientes.
- Retornar o CPF ofuscado dos pacientes.

## Arquitetura
A arquitetura do sistema é baseada em uma API RESTful, desenvolvida em Java utilizando Spring Boot. A API expõe endpoints para as operações CRUD de gerenciamento de pacientes, bem como para cálculos específicos relacionados aos dados dos pacientes. A aplicação mobile utiliza Swift UIKit para fornecer uma interface interativa que permite aos usuários visualizar e gerenciar informações dos pacientes.

## Endpoints da API

GET /api/v1/pacientes/all: Obtém uma lista de todos os pacientes.
GET /api/v1/pacientes/{id}: Obtém detalhes de um paciente específico.
POST /api/v1/pacientes: Adiciona um novo paciente.
PUT /api/v1/pacientes/{id}: Atualiza os detalhes de um paciente existente.
DELETE /api/v1/pacientes/{id}: Remove um paciente do sistema.


## Instruções de Uso

### Configuração do Ambiente
1. Certifique-se de ter o JDK 21+ instalado.
2. Instale o Maven.
3. Clone o repositório:

git clone <URL_DO_REPOSITORIO>
cd <DIRETORIO_DO_PROJETO>
mvn spring-boot


### Testes
mvn test


## Tecnologias Utilizadas
- Java
- Spring Boot
- Maven
- JUnit
- RestAssured
- Docker
- Swift UIKit (para a aplicação mobile)

## Testes
O projeto inclui testes unitários, de integração e de aceitação para garantir a qualidade do código. Os testes podem ser executados com o comando:

mvn test


## Implantação
Para implantar a API via Docker em um ambiente de produção, siga os passos:

1. Certifique-se de ter o Docker instalado.
2. Construa a imagem Docker:

docker build -t api-gerenciamento-pacientes.

3. Execute o contêiner:

docker run -p 8080:8080 api-gerenciamento-pacientes


## Aplicação Mobile

### Funcionalidades
A aplicação mobile foi desenvolvida em Swift UIKit e oferece as seguintes funcionalidades:
- Visualização da lista de pacientes.
- Detalhes de um paciente específico.
- Adição de novos pacientes.
- Atualização dos dados de pacientes existentes.
- Remoção de pacientes.

### Instalação e Configuração
1. Certifique-se de ter o Xcode instalado.
2. Clone o repositório:

git clone <URL_DO_REPOSITORIO>
cd <DIRETORIO_DO_PROJETO_MOBILE>

3. Abra o projeto no Xcode e execute-o em um simulador ou dispositivo físico.

## Contribuição
Contribuições são bem-vindas! Para contribuir, siga os passos:

1. Fork o repositório.
2. Crie uma nova branch:

git checkout -b minha-feature

3. Faça as alterações e commit:

git commit -m "Minha nova feature"

4. Envie para o repositório remoto:
git push origin minha-feature

5. Crie um Pull Request.

## Licença
Este projeto não possui um licenciamento específico. Para mais informações sobre os termos de uso e distribuição do software, por favor, entre em contato com o autor.

