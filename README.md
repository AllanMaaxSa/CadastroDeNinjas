# CadastroDeNinjas

Descrição
---------
CadastroDeNinjas é uma API REST desenvolvida como projeto acadêmico para gerenciar um cadastro de "ninjas". O objetivo é praticar conceitos de backend com Spring Boot, persistência com JPA/H2, migrações com Flyway, documentação com Swagger e boas práticas de versionamento com Git.

Importante: este repositório é para fins de aprendizado e não se destina a produção.

Tecnologias usadas
------------------
- Linguagem / Framework: Java + Spring Boot (versão usada no projeto: 3.x)
- Persistência: Spring Data JPA
- Banco de dados: H2 (in-memory / runtime)
- Migrações: Flyway
- Documentação da API: Swagger / OpenAPI (Swagger UI)
- Auxiliares: Lombok
- Build / Execução: Maven (mvnw incluído)
- Testes: spring-boot-starter-test
- Controle de versão: Git

Requisitos
---------
- Java compatível com a versão definida no `pom.xml` (projeto usa `java.version` conforme POM; ajuste sua JDK para corresponder)
- Git
- Maven (opcional, você pode usar o wrapper `./mvnw` / `mvnw.cmd` presente no repositório)

Como rodar localmente
---------------------
1. Clone o repositório:
   git clone https://github.com/AllanMaaxSa/CadastroDeNinjas.git
   cd CadastroDeNinjas

2. Compilar e executar com o Maven Wrapper:
   - Linux / macOS:
     ./mvnw clean package
     ./mvnw spring-boot:run
   - Windows:
     mvnw.cmd clean package
     mvnw.cmd spring-boot:run

3. A aplicação ficará disponível por padrão em:
   http://localhost:8080

Build (jar)
-----------
- Gerar o artefato:
  ./mvnw clean package
- Executar o jar:
  java -jar target/*.jar

Testes
------
- Para executar testes automatizados:
  ./mvnw test

Banco de dados (H2) e migrações (Flyway)
----------------------------------------
- O projeto usa H2 como banco em tempo de execução (configuração por padrão no Spring Boot).
- Console H2 (se habilitado nas properties) costuma ficar em:
  http://localhost:8080/h2-console
  - URL JDBC típica (padrão Spring Boot): jdbc:h2:mem:testdb
  - Usuário: sa (por padrão)
- Migrações Flyway:
  - Coloque scripts de migração em: `src/main/resources/db/migration`
  - Nomeie os arquivos seguindo o padrão: `V1__descricao.sql`, `V2__descricao.sql`, etc.
  - As migrações são aplicadas automaticamente na inicialização.

Documentação da API (Swagger / OpenAPI)
--------------------------------------
- A documentação interativa (Swagger UI) estará disponível quando a dependência estiver configurada:
  - Endpoint comum: http://localhost:8080/swagger-ui/index.html (ou /swagger-ui.html)
- Caso a dependência de Swagger/OpenAPI não esteja presente no pom, adicione o Springdoc OpenAPI (ou equivalente) para gerar a UI automaticamente.

Estrutura do projeto
--------------------
- src/main/java — código-fonte Java (controllers, services, repositories, models)
- src/main/resources — arquivos de configuração (application.properties / application.yml)
- src/main/resources/db/migration — scripts Flyway
- src/test — testes automatizados

Configurações e variáveis de ambiente
------------------------------------
Documente aqui as propriedades necessárias no `application.properties` ou variáveis de ambiente:
- spring.datasource.url (se usar banco persistente)
- spring.datasource.username
- spring.datasource.password
- spring.jpa.hibernate.ddl-auto (quando aplicável)
- Qualquer outra variável sensível (tokens, chaves) coloque em `.env` ou variáveis do ambiente do servidor

Boas práticas e observações
--------------------------
- Mantenha as migrations versionadas em `src/main/resources/db/migration`.
- Utilize grupos de endpoints REST versionados, por exemplo `/api/v1/ninjas`.
- Configure profiles (ex.: `application-dev.yml`, `application-prod.yml`) se for evoluir para ambientes diferentes.
- Remova credenciais em texto claro e evite commitar arquivos com segredos.

Como contribuir
---------------
1. Faça fork deste repositório.
2. Crie uma branch: git checkout -b feature/nome-da-feature
3. Faça commits pequenos e significativos.
4. Abra um Pull Request descrevendo as mudanças.

Licença
-------
Este repositório é um projeto acadêmico — escolha uma licença se desejar compartilhar (ex.: MIT). Informe qual licença quer adicionar.

Contato
-------
Autor: AllanMaaxSa  
Repositório: https://github.com/AllanMaaxSa/CadastroDeNinjas

Notas finais
-----------
- Atualize este README com endpoints e exemplos de requisições (cURL / Postman) quando os modelos (campos de Ninja) estiverem definidos.
- Posso:
  - Atualizar automaticamente o README.md no repositório com este conteúdo,
  - Ou ajustar o README para incluir exemplos reais de endpoints se você colar a entidade `Ninja` (campos) ou o controller.
