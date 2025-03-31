
# Microservice de Envio de E-mails

Este repositório contém uma API desenvolvida com Spring Boot que oferece funcionalidades para envio de e-mails em formatos de texto simples e HTML. A API também inclui um endpoint para realizar testes de integridade do serviço.

## Funcionalidades

- Envio de e-mails de texto simples.
- Envio de e-mails em formato HTML com templates.
- Teste de integridade da API com requisições GET e POST.

## Tecnologias

- **Spring Boot** - Framework para construção de APIs RESTful.
- **JavaMailSender** - Para envio de e-mails.
- **Swagger** - Para documentação da API.
- **Maven** - Gerenciador de dependências e construção do projeto.

## Endpoints

### 1. Enviar E-mail de Texto
Envie um e-mail simples em formato de texto.

- **URL:** `/email/send-txt`
- **Método:** `POST`
- **Parâmetros:**
  - `recipient`: E-mail do destinatário.
  - `subject`: Assunto do e-mail.
  - `message`: Conteúdo do e-mail.
  
- **Exemplo de Requisição:**
  
  ```http
  POST /email/send-txt?recipient=exemplo@dominio.com&subject=Assunto&message=Olá,%20mundo!
  ```

- **Respostas:**
  - **200 OK:** E-mail enviado com sucesso.
  - **500 Internal Server Error:** Erro ao enviar o e-mail.

### 2. Enviar E-mail HTML
Envie um e-mail em formato HTML utilizando um template.

- **URL:** `/email/send-html`
- **Método:** `POST`
- **Parâmetros:**
  - `recipient`: E-mail do destinatário.
  - `subject`: Assunto do e-mail.
  - `message`: Conteúdo da mensagem em HTML.

- **Exemplo de Requisição:**

  ```http
  POST /email/send-html?recipient=exemplo@dominio.com&subject=Teste%20HTML&message=Esta%20é%20uma%20mensagem%20de%20teste
  ```

- **Respostas:**
  - **200 OK:** E-mail HTML enviado com sucesso.
  - **500 Internal Server Error:** Erro ao enviar o e-mail.

### 3. Teste de Integridade da API (GET)
Verifica se a API está funcionando corretamente.

- **URL:** `/api/test/getstatusapp`
- **Método:** `GET`

- **Resposta:**
  ```json
  {
    "status": "up"
  }
  ```

### 4. Teste de Integridade da API (POST)
Verifica se a API está funcionando corretamente com uma requisição POST.

- **URL:** `/api/test/poststatusapp`
- **Método:** `POST`

- **Resposta:**
  ```json
  {
    "status": "up"
  }
  ```

## Configuração

### Configurações do E-mail
No arquivo `application.properties`, você precisa configurar as credenciais do e-mail e o servidor SMTP:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=seuemail@gmail.com
spring.mail.password=suasenha
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### Docker
Este projeto inclui um `Dockerfile` para facilitar a construção e o deployment do serviço em containers Docker.

Para construir a imagem Docker, use o seguinte comando:

```bash
docker build -t email-service .
```

E para rodar a aplicação em um container:

```bash
docker run -p 8080:8080 email-service
```

A aplicação estará disponível na porta `8080`.

## Como Rodar Localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/vengaa/Microservice-sendEmail.git
   cd Microservice-sendEmail
   ```

2. Compile o projeto:
   ```bash
   mvn clean install
   ```

3. Execute o aplicativo:
   ```bash
   mvn spring-boot:run
   ```

4. A API estará rodando em `http://localhost:8080`.

## Swagger

A documentação da API está disponível em Swagger, acessível através de `http://localhost:8080/swagger-ui.html`.

## Contribuições

Contribuições são bem-vindas! Se você deseja adicionar novas funcionalidades ou corrigir problemas, por favor, faça um fork do repositório, crie uma nova branch e envie um pull request.

## Licença

Distribuído sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
