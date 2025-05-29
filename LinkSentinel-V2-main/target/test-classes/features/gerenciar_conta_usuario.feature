Feature: Gerenciar Conta de Usuario
  Como um usuario do LinkSentinel
  Eu quero poder registrar, autenticar e gerenciar minha conta de forma segura
  Para utilizar as funcionalidades do sistema

  Background:
    Given que o sistema LinkSentinel esta operacional

  Scenario: Registro bem-sucedido de um novo usuario
    Given que eu sou um "novo visitante" na pagina de "registro"
    When eu preencho o campo "E-mail" com "usuario_valido@example.com"
    And eu preencho o campo "Senha" com "SenhaSegura123@"
    And eu preencho o campo "Confirmacao de Senha" com "SenhaSegura123@"
    And eu clico no botao "Registrar"
    Then eu devo ser redirecionado para a "pagina principal do usuario logado"
    And o usuario "usuario_valido@example.com" deve existir no sistema

  Scenario: Login bem-sucedido de um usuario existente
    Given que existe um usuario registrado no sistema com e-mail "usuario_existente@example.com" e senha "SenhaCorreta123"
    And eu estou na pagina de "login"
    When eu preencho o campo "E-mail" com "usuario_existente@example.com"
    And eu preencho o campo "Senha" com "SenhaCorreta123"
    And eu clico no botao "Entrar"
    Then eu devo ser redirecionado para a "pagina principal do usuario logado"
    And minha sessao de usuario deve ser estabelecida

  Scenario: Solicitacao e redefinicao de senha com token valido
    Given que existe um usuario registrado no sistema com e-mail "esquecido@example.com"
    And eu estou na pagina de "solicitacao de redefinicao de senha"
    When eu informo o e-mail "esquecido@example.com" para redefinicao
    And eu sigo o link de redefinicao recebido por e-mail com o token "TOKEN_XYZ123"
    And eu defino a "Nova Senha" como "NovaSenhaSuper#456"
    And eu confirmo a "Nova Senha" como "NovaSenhaSuper#456"
    And eu clico no botao "Redefinir Senha Agora"
    Then a senha do usuario "esquecido@example.com" deve ser atualizada para a nova senha
    And o token "TOKEN_XYZ123" deve ser invalidado
    And eu devo ser redirecionado para a "pagina de login" com a mensagem "Senha redefinida com sucesso!"

  Scenario: Tentativa de registro com e-mail que ja esta em uso
    Given que o e-mail "email_em_uso@example.com" ja esta cadastrado no sistema
    And eu sou um "novo visitante" na pagina de "registro"
    When eu tento me registrar com o e-mail "email_em_uso@example.com" e senha "QualquerSenhaValida"
    Then eu devo permanecer na pagina de "registro"
    And eu devo ver a mensagem de erro "Este e-mail ja esta cadastrado."