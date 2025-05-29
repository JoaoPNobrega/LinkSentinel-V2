Feature: Visualizar Historicos e Relatorios de Links
  Como um usuario logado no LinkSentinel
  Eu quero poder visualizar o historico de verificacoes de um link especifico e relatorios consolidados de minhas colecoes
  Para acompanhar a evolucao do estado dos meus links e ter uma visao geral da saude das minhas colecoes

  Background:
    Given que existe um usuario registrado no sistema com e-mail "historiador@example.com" e senha "SenhaHist1"
    And eu realizei o login com o e-mail "historiador@example.com" e senha "SenhaHist1"
    And eu possuo uma colecao chamada "Minhas Pesquisas Academicas"
    And a colecao "Minhas Pesquisas Academicas" contem o link "http://paperinteressante.com/artigo1" com descricao "Artigo sobre IA"

  Scenario: Acessar historico de verificacoes de um link especifico
    Given que o link "http://paperinteressante.com/artigo1" na colecao "Minhas Pesquisas Academicas" possui um registro de verificacao de "2024-05-27 10:00:00" com "Status HTTP: 200 OK" e "Score Risco Phishing: Baixo"
    And que o link "http://paperinteressante.com/artigo1" na colecao "Minhas Pesquisas Academicas" possui um registro de verificacao de "2024-05-20 09:00:00" com "Status HTTP: 200 OK" e "Score Risco Phishing: Baixo"
    And que o link "http://paperinteressante.com/artigo1" na colecao "Minhas Pesquisas Academicas" possui um registro de verificacao de "2024-05-13 08:00:00" com "Status HTTP: 404 Not Found" e "Score Risco Phishing: Indeterminado"
    When eu seleciono o link "http://paperinteressante.com/artigo1"
    And eu solicito o "historico de verificacoes" desse link
    Then eu devo ver uma lista de verificacoes anteriores para "http://paperinteressante.com/artigo1" ordenada da mais recente para a mais antiga
    And a entrada do historico para "2024-05-27 10:00:00" deve mostrar "Status HTTP: 200 OK" e "Score Risco Phishing: Baixo"
    And a entrada do historico para "2024-05-13 08:00:00" deve mostrar "Status HTTP: 404 Not Found" e "Score Risco Phishing: Indeterminado"

  Scenario: Acessar relatorio consolidado de uma colecao com links em diferentes estados
    Given que a colecao "Minhas Pesquisas Academicas" do usuario "historiador@example.com" contem o link "http://paperinteressante.com/artigo1" com descricao "Artigo sobre IA", ultimo "Status HTTP: 200 OK", "Validade SSL: Valido" e "Score Risco Phishing: Baixo"
    And a colecao "Minhas Pesquisas Academicas" do usuario "historiador@example.com" contem o link "http://jornalcientifico.com/estudo2" com descricao "Estudo Cientifico", ultimo "Status HTTP: 200 OK", "Validade SSL: Valido" e "Score Risco Phishing: Baixo"
    And a colecao "Minhas Pesquisas Academicas" do usuario "historiador@example.com" contem o link "http://linkquebradoagora.net/page" com descricao "Link Quebrado", ultimo "Status HTTP: 500 Server Error", "Validade SSL: Invalido" e "Score Risco Phishing: Indeterminado"
    And a colecao "Minhas Pesquisas Academicas" do usuario "historiador@example.com" contem o link "http://sitephishingsimulado.com/login" com descricao "Site Perigoso", ultimo "Status HTTP: 200 OK", "Validade SSL: Valido" e "Score Risco Phishing: Alto"
    When eu seleciono a colecao "Minhas Pesquisas Academicas"
    And eu solicito o "relatorio consolidado" da colecao
    Then eu devo ver no relatorio para "Minhas Pesquisas Academicas" a metrica "Total de Links" com valor "4"
    And eu devo ver no relatorio para "Minhas Pesquisas Academicas" a metrica "Links Ativos (%)" com valor "75%"
    And eu devo ver no relatorio para "Minhas Pesquisas Academicas" a metrica "Links com SSL Valido (%)" com valor "75%"
    And eu devo ver no relatorio para "Minhas Pesquisas Academicas" a metrica "Links com Risco Alto (%)" com valor "25%"
    And eu devo ver no relatorio para "Minhas Pesquisas Academicas" a metrica "Links com Risco Medio (%)" com valor "0%"
    And eu devo ver no relatorio para "Minhas Pesquisas Academicas" a metrica "Links com Risco Baixo (%)" com valor "50%"

  Scenario: Acessar relatorio de uma colecao vazia
    Given que eu possuo uma colecao chamada "Nova Colecao Vazia" que "nao contem" links
    When eu seleciono a colecao "Nova Colecao Vazia"
    And eu solicito o "relatorio consolidado" da colecao
    Then eu devo ver um relatorio para "Nova Colecao Vazia" indicando "Nao ha links nesta colecao para gerar um relatorio."
    And as estatisticas devem mostrar "0" para total de links