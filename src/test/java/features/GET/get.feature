#language:pt
Funcionalidade: Testes da API do JsonPlaceHolder método GET

@getandpost
Cenário: Verificar o código de resposta, o cabeçalho e o corpo da resposta de GET /posts
  Dado que a API JsonPlaceHolder está disponível
  Quando eu faço uma solicitação GET para "/posts"
  Então o código de resposta do GET deve ser 200
  E o cabeçalho de resposta do GET deve conter "application/json; charset=utf-8"
  E o corpo da resposta deve conter pelo menos 1 post