Feature: Gerenciar Colecoes de Links
  Como um usuario logado no LinkSentinel
  Eu quero poder criar, visualizar o conteudo e excluir minhas colecoes de links
  Para organizar minhas URLs de forma eficiente

  Background:
    Given que existe um usuario registrado no sistema com e-mail "colecionador_links@example.com" e senha "SenhaVal123"
    And eu realizei o login com o e-mail "colecionador_links@example.com" e senha "SenhaVal123"
    And eu estou na "pagina de gerenciamento de colecoes"

  Scenario: Criacao de uma nova colecao com nome valido e unico
    When eu tento criar uma nova colecao com o nome "Artigos de IA para Ler"
    Then a colecao "Artigos de IA para Ler" deve ser criada e listada para o usuario "colecionador_links@example.com"
    And eu devo ver a mensagem "Colecao 'Artigos de IA para Ler' criada com sucesso!"

  Scenario: Visualizar links dentro de uma colecao existente e populada
    Given que a colecao "Tutoriais de Desenvolvimento Web" do usuario "colecionador_links@example.com" existe
    And a colecao "Tutoriais de Desenvolvimento Web" contem o link "https://frontendmasters.com/" com descricao "Cursos de Frontend"
    And a colecao "Tutoriais de Desenvolvimento Web" contem o link "https://www.djangoproject.com/" com descricao "Documentacao oficial Django"
    And a colecao "Tutoriais de Desenvolvimento Web" contem o link "https://react.dev/" com descricao "Biblioteca React"
    When eu seleciono a colecao "Tutoriais de Desenvolvimento Web" para visualizar seus links
    Then eu devo ver o link "https://frontendmasters.com/" com a descricao "Cursos de Frontend"
    And eu devo ver o link "https://www.djangoproject.com/" com a descricao "Documentacao oficial Django"
    And eu devo ver o link "https://react.dev/" com a descricao "Biblioteca React"

  Scenario: Excluir uma colecao existente e seus links apos confirmacao
    Given que o usuario "colecionador_links@example.com" possui uma colecao chamada "Links Temporarios"
    And a colecao "Links Temporarios" contem o link "http://example.com/temp1" com descricao "Link temp 1"
    When eu seleciono a colecao "Links Temporarios" para exclusao
    And eu confirmo a acao de exclusao da colecao
    Then a colecao "Links Temporarios" e todos os seus links devem ser permanentemente removidos
    And a colecao "Links Temporarios" "nao deve mais ser exibida" na lista de colecoes
    And eu devo ver a mensagem "Colecao 'Links Temporarios' excluida com sucesso!"

  Scenario: Tentativa de criar colecao com nome que ja existe
    Given que eu ja possuo uma colecao chamada "Meus Favoritos"
    When eu tento criar uma nova colecao com o nome "Meus Favoritos"
    Then eu devo ver a mensagem de erro "Voce ja possui uma colecao com o nome 'Meus Favoritos'."
    And a colecao "Meus Favoritos" "nao deve ser" duplicada na minha lista de colecoes