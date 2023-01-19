# Desafio para a vaga de Dev Java na empresa RP Info Sistemas

Aplicação REST para registro de ordem de serviço utilizando Spring boot.

## Como rodar a Aplicação
- Passo 1: Clone o repositório
```
git clone https://github.com/lucassgoes/RPInfoDesafio.git
```
- Passo 2: Abra o projeto na sua IDE e rode a classe RpInfoDesafioApplication
- Passo 3: Acesse http://localhost:8080 no seu navegador.

## Documentação API Rest
### Métodos
Requisições para a API devem seguir os padrões:
| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais ordens de serviço. |
| `POST` | Utilizado para criar uma nova ordem de serviço. |
| `PUT` | Atualiza dados de uma ordem de serviço e alterar sua situação. |
| `DELETE` | Remove uma ordem de serviço do sistema. |

### Rotas
Requisições para a API devem seguir os padrões:
| Método | Rotas |
|---|---|
| `GET` | /api/workOrders |
| `POST` | /api/workOrders | 
| `PUT` | /api/workOrders/{id} |
| `DELETE` | /api/workOrders/{id} |