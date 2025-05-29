Feature: Monitorar Links Agendados
  Como um usuario logado no LinkSentinel
  Eu quero poder configurar o monitoramento agendado para minhas colecoes de links
  Para ser notificado automaticamente sobre problemas como links quebrados ou riscos de phishing

  Background:
    Given que existe um usuario registrado no sistema com e-mail "monitorador@example.com" e senha "SenhaMonitor1"
    And eu realizei o login com o e-mail "monitorador@example.com" e senha "SenhaMonitor1"
    And eu possuo uma colecao chamada "Meus Blogs Favoritos"
    And a colecao "Meus Blogs Favoritos" contem o link "http://blogseguroefuncional.com" com descricao "Blog A"
    And a colecao "Meus Blogs Favoritos" contem o link "http://blogquevaifora.com" com descricao "Blog B"
    And a colecao "Meus Blogs Favoritos" contem o link "http://blogsuspeitoagora.com" com descricao "Blog C"
    And o sistema de agendamento de tarefas esta operacional

  Scenario: Ativar monitoramento diario para uma colecao e receber notificacao de link quebrado
    Given que o monitoramento para a colecao "Meus Blogs Favoritos" "nao esta ativo"
    When eu ativo o monitoramento "diario" para a colecao "Meus Blogs Favoritos"
    And o proximo ciclo de monitoramento agendado e executado para a colecao "Meus Blogs Favoritos"
    And durante o monitoramento, o link "http://blogquevaifora.com" e verificado como "inacessivel (erro 404)"
    And o link "http://blogseguroefuncional.com" e verificado como "OK"
    Then eu devo receber uma "notificacao na plataforma" informando que o link "http://blogquevaifora.com" da colecao "Meus Blogs Favoritos" esta "quebrado"
    And o status do link "http://blogquevaifora.com" deve ser atualizado para "inacessivel"

  Scenario: Ativar monitoramento semanal e receber notificacao de alto risco de phishing
    Given que o monitoramento para a colecao "Meus Blogs Favoritos" "nao esta ativo"
    When eu ativo o monitoramento "semanal" para a colecao "Meus Blogs Favoritos"
    And o proximo ciclo de monitoramento agendado e executado para a colecao "Meus Blogs Favoritos"
    And durante o monitoramento, o link "http://blogsuspeitoagora.com" e analisado com "score de risco de phishing alto" devido a "presenca em nova blacklist"
    And o link "http://blogseguroefuncional.com" e analisado com "score de risco de phishing baixo"
    Then eu devo receber uma "notificacao por e-mail" (se configurado) e "na plataforma" alertando sobre o "alto risco de phishing" para o link "http://blogsuspeitoagora.com" da colecao "Meus Blogs Favoritos"
    And o score de risco do link "http://blogsuspeitoagora.com" deve ser atualizado para "Alto"

  Scenario: Desativar monitoramento para uma colecao
    Given que o monitoramento "diario" para a colecao "Meus Blogs Favoritos" "esta ativo"
    When eu desativo o monitoramento para a colecao "Meus Blogs Favoritos"
    Then a colecao "Meus Blogs Favoritos" "nao deve mais ser" verificada automaticamente nos ciclos agendados
    And eu devo ver uma mensagem confirmando que "o monitoramento para 'Meus Blogs Favoritos' foi desativado"