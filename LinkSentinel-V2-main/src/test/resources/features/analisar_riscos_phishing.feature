Feature: Analisar Riscos de Links (Phishing)
  Como um usuario logado no LinkSentinel
  Eu quero que o sistema analise os links para riscos de phishing durante a verificacao
  Para que eu possa ser alertado sobre URLs potencialmente perigosas

  Background:
    Given que existe um usuario registrado no sistema com e-mail "analista_risco@example.com" e senha "SenhaAnalise1"
    And eu realizei o login com o e-mail "analista_risco@example.com" e senha "SenhaAnalise1"
    And eu possuo uma colecao chamada "Links para Analise"
    And eu adicionei o link "http://sitepotencialmentesuspeito.com/login" com descricao "Site Suspeito" a colecao "Links para Analise"
    And o sistema esta configurado para consultar "blacklists conhecidas de phishing"
    And o sistema esta configurado para aplicar "heuristicas de URL para deteccao de phishing"

  Scenario: Analise automatica de phishing e visualizacao de score de risco alto para um link suspeito
    Given que a URL "http://sitepotencialmentesuspeito.com/login" "e reconhecida como de alto risco" pela analise de phishing
    When eu solicito uma "verificacao imediata" para o link "http://sitepotencialmentesuspeito.com/login"
    Then o sistema deve realizar a "analise de risco de phishing" para o link "http://sitepotencialmentesuspeito.com/login"
    And apos a conclusao da verificacao, ao visualizar os detalhes do link "http://sitepotencialmentesuspeito.com/login", eu devo ver o "Status HTTP" como "200 OK"
    And eu devo ver o "Score de Risco Phishing" como "Alto"
    And eu devo ver os "Motivos do Risco" como "Detectado em Blacklist X" # Ou "URL contem caracteres suspeitos", etc.

  Scenario: Analise automatica de phishing e visualizacao de score de risco baixo para um link confiavel
    Given que a URL "https://www.wikipedia.org" "e reconhecida como de baixo risco" pela analise de phishing
    And eu adicionei o link "https://www.wikipedia.org" com descricao "Wikipedia" a colecao "Links para Analise"
    When eu solicito uma "verificacao imediata" para o link "https://www.wikipedia.org"
    Then o sistema deve realizar a "analise de risco de phishing" para o link "https://www.wikipedia.org"
    And apos a conclusao da verificacao, ao visualizar os detalhes do link "https://www.wikipedia.org", eu devo ver o "Status HTTP" como "200 OK"
    And eu devo ver o "Score de Risco Phishing" como "Baixo"

  Scenario: Visualizacao de score de risco medio devido a heuristicas de URL
    Given que a URL "http://login-banco-seguro.info-account-update.com/signin" "aciona heuristicas de URL suspeita" mas "nao esta em blacklists conhecidas"
    And eu adicionei o link "http://login-banco-seguro.info-account-update.com/signin" com descricao "URL Heuristica" a colecao "Links para Analise"
    When eu solicito uma "verificacao imediata" para o link "http://login-banco-seguro.info-account-update.com/signin"
    Then o sistema deve realizar a "analise de risco de phishing" para o link "http://login-banco-seguro.info-account-update.com/signin"
    And apos a conclusao da verificacao, ao visualizar os detalhes do link "http://login-banco-seguro.info-account-update.com/signin", eu devo ver o "Status HTTP" como "200 OK"
    And eu devo ver o "Score de Risco Phishing" como "Medio"
    And eu devo ver os "Motivos do Risco" como "URL contem termos suspeitos" # Ou similar, baseado nas heuristicas