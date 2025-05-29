package br.cesar.school.linksentinel.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AdicionarVerificarLinksStepDefinitions {

    // Snippets baseados nos steps do adicionar_verificar_links_ondemand.feature
    // Muitos podem ser reutilizados se já definidos em outras classes
    // (como os @Given de usuário logado, coleção existente).

    // When eu adiciono o link com URL {string} e descricao {string} a colecao {string}
    // --> já existe em AnalisarRiscosPhishingStepDefinitions.java

    // When eu solicito uma {string} para o link {string}
    // --> já existe em AnalisarRiscosPhishingStepDefinitions.java

    // Then o link {string} com descricao {string} deve aparecer na colecao {string}
    @Then("o link {string} com descricao {string} deve aparecer na colecao {string}")
    public void o_link_com_descricao_deve_aparecer_na_colecao(String url, String descricao, String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then o link " + url + " com descricao " + descricao + " deve aparecer na colecao " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }

    // Then o sistema deve iniciar o processo de {string} para {string}
    // --> já existe em AnalisarRiscosPhishingStepDefinitions.java

    // Then apos a conclusao da verificacao do link {string}, eu devo poder visualizar o {string} como {string}
    // --> já existe em AnalisarRiscosPhishingStepDefinitions.java

    // Then eu devo poder visualizar a {string} como {string}
    // --> já existe em AnalisarRiscosPhishingStepDefinitions.java

    // Then eu devo poder visualizar o {string} contendo {string}
    // --> já existe em AnalisarRiscosPhishingStepDefinitions.java

    // Then eu devo poder visualizar o {string} como um valor {string}
    // --> já existe em AnalisarRiscosPhishingStepDefinitions.java

    // Then eu devo poder visualizar o {string} como {string}
    // --> já existe em AnalisarRiscosPhishingStepDefinitions.java (cuidado com duplicidade de assinatura)


    // Scenario: Tentativa de adicionar um link com URL em formato invalido
    // When eu tento adicionar o link com URL {string} e descricao {string} a colecao {string}
    @When("eu tento adicionar o link com URL {string} e descricao {string} a colecao {string}")
    public void eu_tento_adicionar_o_link_com_url_e_descricao_a_colecao(String url, String descricao, String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When eu tento adicionar o link com URL " + url + " e descricao " + descricao + " a colecao " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }
    // Then eu devo ver a mensagem de erro {string}
    // --> já existe em GerenciarColecoesLinksStepDefinitions.java

    // And o link {string} "nao deve ser" adicionado a colecao {string}
    @Then("o link {string} {string} adicionado a colecao {string}")
    public void o_link_adicionado_a_colecao(String url, String naoDeveSer, String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then o link " + url + " " + naoDeveSer + " adicionado a colecao " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: Tentativa de adicionar um link que ja existe na mesma colecao
    // Given que o link {string} com descricao {string} ja existe na colecao {string}
    @Given("que o link {string} com descricao {string} ja existe na colecao {string}")
    public void que_o_link_com_descricao_ja_existe_na_colecao(String url, String descricao, String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given que o link " + url + " com descricao " + descricao + " ja existe na colecao " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }
    // When eu tento adicionar o link com URL {string} e descricao {string} a colecao {string}
    // --> já definido acima
    // Then eu devo ver a mensagem de erro {string}
    // --> já definido
    // And o link {string} "nao deve ser" adicionado novamente
    // Este step é muito similar ao "o link {string} {string} adicionado a colecao {string}"
    // Você pode precisar de um step mais específico ou reutilizar com cuidado.
    // Exemplo:
    @Then("o link {string} {string} adicionado novamente")
    public void o_link_adicionado_novamente(String url, String naoDeveSer) {
        System.out.println(">>> STEP: Then o link " + url + " " + naoDeveSer + " adicionado novamente");
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: Solicitar verificacao imediata para um link existente que esta quebrado
    // Given que a colecao {string} contem o link {string} com descricao {string}
    // --> já existe em GerenciarColecoesLinksStepDefinitions.java

    // And o link {string} foi verificado anteriormente como {string}
    @Given("o link {string} foi verificado anteriormente como {string}")
    public void o_link_foi_verificado_anteriormente_como(String url, String statusAnterior) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: And o link " + url + " foi verificado anteriormente como " + statusAnterior);
        throw new io.cucumber.java.PendingException();
    }
    // When eu solicito uma {string} para o link {string}
    // --> já existe
    // Then o sistema deve iniciar o processo de {string} para {string}
    // --> já existe
    // And apos a conclusao da verificacao do link {string}, eu devo poder visualizar o "Status HTTP" como "Erro (ex: 404, Host Nao Encontrado)"
    // Este pode ser coberto pelo @Then("apos a conclusao da verificacao do link {string}, eu devo poder visualizar o {string} como {string}")
    // Se for exatamente essa a string, senão um novo snippet seria gerado e você o adicionaria.
}