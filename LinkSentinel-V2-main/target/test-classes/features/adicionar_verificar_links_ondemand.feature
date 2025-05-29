Feature: Adicionar e Verificar Links On-Demand
  Como um usuario logado no LinkSentinel
  Eu quero poder adicionar novos links as minhas colecoes e solicitar uma verificacao imediata do seu estado
  Para garantir que meus links sao validos e obter informacoes sobre eles

  Background:
    Given que existe um usuario registrado no sistema com e-mail "verificador@example.com" e senha "SenhaVerifica1"
    And eu realizei o login com o e-mail "verificador@example.com" e senha "SenhaVerifica1"
    And eu possuo uma colecao chamada "Minhas Ferramentas Online"
    And eu estou visualizando a colecao "Minhas Ferramentas Online"

  Scenario: Adicionar um novo link valido a uma colecao e solicitar verificacao imediata
    When eu adiciono o link com URL "https://www.google.com" e descricao "Motor de Busca Google" a colecao "Minhas Ferramentas Online"
    And eu solicito uma "verificacao imediata" para o link "https://www.google.com"
    Then o link "https://www.google.com" com descricao "Motor de Busca Google" deve aparecer na colecao "Minhas Ferramentas Online"
    And o sistema deve iniciar o processo de "verificacao" para "https://www.google.com"
    And apos a conclusao da verificacao do link "https://www.google.com", eu devo poder visualizar o "Status HTTP" como "200 OK"
    And eu devo poder visualizar a "Validade SSL" como "Valido"
    And eu devo poder visualizar o "Titulo da Pagina" contendo "Google"
    And eu devo poder visualizar o "Tempo de Resposta (ms)" como um valor "menor que 3000"
    And eu devo poder visualizar o "Score de Risco Phishing" como "Baixo"

  Scenario: Tentativa de adicionar um link com URL em formato invalido
    When eu tento adicionar o link com URL "url_formato_invalido" e descricao "Link com erro" a colecao "Minhas Ferramentas Online"
    Then eu devo ver a mensagem de erro "Formato de URL invalido."
    And o link "url_formato_invalido" "nao deve ser" adicionado a colecao "Minhas Ferramentas Online"

  Scenario: Tentativa de adicionar um link que ja existe na mesma colecao
    Given que o link "https://www.github.com" com descricao "Plataforma GitHub" ja existe na colecao "Minhas Ferramentas Online"
    When eu tento adicionar o link com URL "https://www.github.com" e descricao "Meu Repositorio GitHub" a colecao "Minhas Ferramentas Online"
    Then eu devo ver a mensagem de erro "Este link ja existe na colecao 'Minhas Ferramentas Online'."
    And o link "https://www.github.com" "nao deve ser" adicionado novamente

  Scenario: Solicitar verificacao imediata para um link existente que esta quebrado
    Given que a colecao "Minhas Ferramentas Online" contem o link "http://linkpropositalmentequerado123.com" com descricao "Link Quebrado para Teste"
    And o link "http://linkpropositalmentequerado123.com" foi verificado anteriormente como "inacessivel"
    When eu solicito uma "verificacao imediata" para o link "http://linkpropositalmentequerado123.com"
    Then o sistema deve iniciar o processo de "verificacao" para "http://linkpropositalmentequerado123.com"
    And apos a conclusao da verificacao do link "http://linkpropositalmentequerado123.com", eu devo poder visualizar o "Status HTTP" como "Erro (ex: 404, Host Nao Encontrado)"