#language:pt

Funcionalidade: Testes da API do JsonPlaceHolder método POST

  @getandpost
  Cenário: Criar um novo post com POST /posts
    Dado que a URL base é "http://jsonplaceholder.typicode.com"
    Quando fazemos uma solicitação POST para "/posts" com o corpo:
      """
      {
        "userId": 1,
        "title": "TesteAPIStrada",
        "body": "Conteúdo do novo post"
      }
      """
    Então o código de resposta do POST deve ser 201
    E o cabeçalho de resposta do POST deve conter "application/json; charset=utf-8"
