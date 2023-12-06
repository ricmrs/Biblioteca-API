# REST API Application

Este projeto é uma aplicação REST APi feita em Java, utilizando Spring Boot, JPA e MySQL.

## Primeiros passos - MySql Banco de dados

Crie uma database 'biblioteca' com o comando em mysql:

```
msql> CREATE DATABASE biblioteca;
```

## Executando o aplicativo

No diretório raiz do aplicativo, utilize o comando:
```
./mvnw spring-boot:run "-Dspring-boot.run.arguments=--spring.datasource.username={username} --spring.datasource.password={password}"
```
Sendo {username} e {password} as variáveis de acesso ao banco de dados. Com isto, a aplicação estará sendo executada na porta 8080.

# REST API

Este projeto utiliza o Swagger UI para visualizar os endpoints da aplicação em [index.html](http://localhost:8080/swagger-ui/index.html#/). 

## Entities

### Editora

#### Criar uma editora

+ Request
  
  |Method|Endpoint|
  |-|-|
  |`POST`|/editoras|

  Body:
    
    ```
    {
     "nome": "editora"
    }
    ```

+ Response
  
  Status: `201`
  
  Body:
  
  ```
  {
   "id": 1,
   "nome": "editora"
  }
  ```

#### Detalhar uma editora

+ Request
  
  |Method|Endpoint|
  |:--|:--|
  |`GET`|/editoras/{id}|

+ Response
    
  Status: `200`
  
  Body:

  ```
  {
   "id": 1,
   "nome": "editora"
  }
  ```

#### Listar todas as editoras

+ Request
  
  |Method|Endpoint|
  |:--|:--|
  |`GET`|/editoras?page={page}&size={size}|

+ Response
  
  Status: `200`

  Body:
  
  ```
  {
   "content": [{"id": 1, "nome": "editora"}],
   "last": false,
   "first": true
  }
  ```

#### Atualizar editora

+ Request
  
  |Method|Endpoint|
  |:--|:--|
  |`PUT`|/editoras|

  Body:
  
  ```
  {
   "id": 1
   "nome": "novo nome"
  }
  ```

+ Response

  Status: `200`
  
  Body:
  
  ```
  {
   "id": 1
   "nome": "novo nome"
  }
  ```

#### Deletar editora

+ Request

  |Method|Endpoint|
  |:--|:--|
  |`DELETE`|/editoras/{id}|

+ Response

  Status: `204`

### Autor

#### Criar um autor

+ Request

  |Method|Endpoint|
  |:--|:--|
  |`POST`|/autores|

  Body:
  
   ```
  {
   "nome": "autor",
   "sobre": "sobre"
  }
  ```

+ Response

  Status: `201`
  
  Body:
  
  ```
  {
   "id": 1,
   "nome": "autor",
   "sobre": "sobre"
  }
  ```

#### Detalhar um autor

+ Request
  
  |Method|Endpoint|
  |:--|:--|
  |`GET`|/autores/{id}|

+ Response
 
  Status: `200`
  
  Body:
  
  ```
  {
   "id": 1,
   "nome": "autor",
   "sobre": "sobre",
   "livros": [
    	{
    	  "id": 1,
    	  "titulo": "titulo",
     	  "dataPublicacao": "2000-01-01"
    	}	
    ]
  }
  ```

#### Listar todos os autores

+ Request
  
  |Method|Endpoint|
  |:--|:--|
  |`GET`|/autores?page={page}&size={size}|

+ Response

  Status: `200`

  Body:
  
  ```
  {
   "content": [{"id": 1, "nome": "autor", "sobre": "sobre"}],
   "last": false,
   "first": true
  }
  ```

#### Atualizar autor

+ Request

  |Method|Endpoint|
  |:--|:--|
  |`PUT`|/autores|

  Body:
  
  ```
  {
   "id": 1,
   "nome": "novo nome",
   "sobre": "novo sobre"
  }
  ```

+ Response

  Status: `200`
  
  Body:
  
  ```
  {
   "id": 1,
   "nome": "novo nome",
   "sobre": "novo sobre",
   "livros": [
    	{
    	  "id": 1,
    	  "titulo": "titulo",
     	  "dataPublicacao": "2000-01-01"
    	}	
    ]
  }
  ```

#### Deletar autor

+ Request
  
  |Method|Endpoint|
  |:--|:--|
  |`DELETE`|/autores/{id}|

+ Response

  Status: `204`

### Livro

#### Criar um livro

+ Request

  |Method|Endpoint|
  |:--|:--|
  |`POST`|/livros|

  Body:
  
  ```
  {
   "titulo": "livro",
   "descricao": "descricao",
   "numeroPaginas": 100,
   "idioma": "idioma",
   "autorId": 1,
   "editoraId": 1,
   "dataPublicacao": "2000-01-01",
   "preco": 50
  }
  ```

+ Response

  Status: `201`
  
  Body:
  
  ```
  {
   "id": 1,
   "titulo": "livro",
   "descricao": "descricao",
   "numeroPaginas": 100,
   "idioma": "idioma",
   "autorId": {id: 1, "nome": "autor"},
   "editoraId": {id: 1, "nome": "editora"},
   "dataPublicacao": "2000-01-01",
   "preco": 50
  }
  ```

#### Detalhar um livro

+ Request
  
  |Method|Endpoint|
  |:--|:--|
  |`GET`|/livros/{id}|

+ Response

  Status: `200`
  
  Body:
  
  ```
  {
   "id": 1,
   "titulo": "livro",
   "descricao": "descricao",
   "numeroPaginas": 100,
   "idioma": "idioma",
   "autorId": {id: 1, "nome": "autor"},
   "editoraId": {id: 1, "nome": "editora"},
   "dataPublicacao": "2000-01-01",
   "preco": 50
  }
  ```

#### Listar todos os livros

+ Request

  |Method|Endpoint|
  |:--|:--|
  |`GET`|/livros?page={page}&size={size}|

+ Response

  Status: `200`
  
  Body:
  ```
  {
   "content": [{"id": 1, "titulo": "livro", "numeroPaginas": "100", "autorId": 1, "editoraId": 1, dataPublicacao: "2000-01-01", "preco": 50}],
   "last": false,
   "first": true
  }
  ```

#### Atualizar livro

+ Request
  
  |Method|Endpoint|
  |:--|:--|
  |`PUT`|/livros|

  Body:
  
  ```
  {
   "id": 1,
   "titulo": "novo titulo",
   "descricao": "nova descricao",
   "numeroPaginas": 80,
   "idioma": "novo idioma",
   "autorId": 2,
   "editoraId": 3,
   "dataPublicacao": "2000-01-02",
   "preco": 60
  }
  ```

+ Response

  Status: `200`
  
  Body:
  
  ```
  {
   "id": 1,
   "titulo": "novo titulo",
   "descricao": "nova descricao",
   "numeroPaginas": 80,
   "idioma": "novo idioma",
   "autorId": 2,
   "editoraId": 3,
   "dataPublicacao": "2000-01-02",
   "preco": 60
  }
  ```

#### Deletar livro

+ Request
  
  |Method|Endpoint|
  |:--|:--|
  |`DELETE`|/livros/{id}|

+ Response

  Status: `204`
