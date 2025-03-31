Microserviço de E-mail
Este é um microsserviço Spring Boot para envio de e-mails em formato texto e HTML.

Funcionalidades
Envio de e-mails em texto simples via API REST

Envio de e-mails com template HTML via API REST

Endpoints simples para verificação de saúde do serviço

Suporte a container Docker

Endpoints da API
Endpoints de Health Check
GET /api/test/getstatusapp - Verifica se a API está rodando (retorna {"status":"up"})

POST /api/test/poststatusapp - Verifica se a API está rodando (retorna {"status":"up"})

Endpoints de E-mail
Enviar E-mail em Texto Puro
Copy
POST /email/send-txt
Parâmetros:
- recipient: Endereço de e-mail do destinatário
- subject: Assunto do e-mail
- message: Conteúdo da mensagem em texto puro

Exemplo:
http://localhost:8080/email/send-txt?recipient=usuario@exemplo.com&subject=Teste&message=Olá%20Mundo
Enviar E-mail HTML
Copy
POST /email/send-html
Parâmetros:
- recipient: Endereço de e-mail do destinatário
- subject: Assunto do e-mail
- message: Conteúdo da mensagem em HTML (será inserido no template)

Exemplo:
http://localhost:8080/email/send-html?recipient=usuario@exemplo.com&subject=Teste%20HTML&message=<p>Olá%20Mundo</p>
Configuração
O serviço requer a seguinte configuração no application.properties:

properties
Copy
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=seu-email@gmail.com
spring.mail.password=sua-senha-de-app
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
Observação: Para Gmail, você precisará gerar uma Senha de App se estiver usando 2FA.

Templates HTML
A funcionalidade de e-mail HTML usa um arquivo de template localizado em:
src/main/resources/template-email.html

O template deve conter os placeholders:

#{nome} - Será substituído pelo e-mail do destinatário

#{message} - Será substituído pelo conteúdo da mensagem

Suporte Docker
O projeto inclui um Dockerfile multi-estágio que:

Usa JDK 21 para construir a aplicação

Cria uma imagem leve de runtime com JRE 21

Para construir e executar:

bash
Copy
docker build -t email-service .
docker run -p 8080:8080 email-service
Dependências
Spring Boot

Spring Mail

JavaMail

Observações de Segurança
A API inclui anotações @CrossOrigin permitindo requisições de qualquer origem

Considere adicionar configuração CORS adequada para produção

Garanta que as credenciais de e-mail estejam adequadamente protegidas e não commitadas no versionamento
