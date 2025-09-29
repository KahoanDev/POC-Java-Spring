<h1 align="center" style="font-weight: bold;">POC-Java-Spring 💻</h1>

<p align="center">
 <a href="#tech">Tecnologias</a> • 
 <a href="#started">Getting Started</a> • 
 <a href="#routes">API Endpoints</a>
</p>

<p align="center">
    <b>CRUD simples de uma API REST de estoque de produtos.</b>
</p>

<h2 id="technologies">💻 Tecnologias</h2>

Lista de todas as tecnologias usadas
- Java
- Spring JPA
- Spring Validation
- Lombok
- MapStruct

<h2 id="started">🚀 Getting started</h2>

<h3>Pré-requisitos</h3>

Lista dos pré-requisitos para rodar o projeto:

- [Java](https://www.java.com/pt-BR/download)
- [Git](https://git-scm.com/downloads)

<h3>Clonagem</h3>

Como clonar o projeto:

```bash
git clone https://github.com/KahoanDev/POC-Java-Spring.git
```

<h3>Iniciando</h3>

#### Ambiente Local

1. Build the project:
   ```bash
   mvn clean package
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

<h2 id="routes">📍 API Endpoints</h2>

​
| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /produto/{id}</kbd>     | Pesquisa por Id [response details](#get-auth-detail)
| <kbd>GET /produto</kbd>     | Pesquisa todos [response details](#get2-auth-detail)
| <kbd>POST /produto</kbd>     | Salvar [request details](#post-auth-detail)
| <kbd>PUT /produto/{id}</kbd>     | Atualizar [request details](#put-auth-detail)
| <kbd>DELETE /produto/{id}</kbd>     | Deletar [details](#delete-auth-detail)

<h3 id="get-auth-detail">GET /produto/{id}</h3>

**RESPONSE**
```json
{
  "id": 1,
  "descricao": "Veja Limpa Tudo",
  "tipo": "LIMPEZA",
  "quantidade": 58
}
```

<h3 id="get2-auth-detail">GET /produto</h3>

**RESPONSE**
```json
[
  {
        "id": 1,
        "descricao": "Veja Limpa Tudo",
        "tipo": "LIMPEZA",
        "quantidade": 58
    },
    {
        "id": 2,
        "descricao": "Neve Papel Higienico",
        "tipo": "HIGIENE",
        "quantidade": 12
    }
]
```

<h3 id="post-auth-detail">POST /produto</h3>

**REQUEST**
```json
{
    "descricao": "Veja Limpa Tudo",
    "tipo": "LIMPEZA",
    "quantidade": 58
}
```

<h3 id="put-auth-detail">PUT /produto/{id}</h3>

**REQUEST**
```json
{
    "descricao": "Veja Limpa MAX",
    "tipo": "LIMPEZA",
    "quantidade": 120
}
```

<h3 id="delete-auth-detail">DELETE /produto/{id}</h3>
