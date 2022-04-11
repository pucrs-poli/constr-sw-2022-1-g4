# Trabalho 1
API REST de backend desenvolvida implementada sobre a API REST do Keycloak, executando em um cluster EKS na AWS, implementando, no mínimo, as seguintes rotas

Rotas padrão para autenticação OAUTH2 conforme implementação do Keycloak (login e geração do token OAUTH2)

POST /users: criação de um usuário

GET /users: recuperação dos dados de todos os usuários

GET /users/{id}: recuperação de um usuário

PUT /users/{id}: atualização de um usuário

PATCH /users/{id}: atualização da senha de um usuário

DELETE /users/{id}: exclusão lógica de um usuário