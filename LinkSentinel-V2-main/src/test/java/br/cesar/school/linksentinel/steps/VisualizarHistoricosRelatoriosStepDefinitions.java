package br.cesar.school.linksentinel.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class VisualizarHistoricosRelatoriosStepDefinitions {

    @Given("que o link {string} na colecao {string} possui um registro de verificacao de {string} com {string} e {string}")
    public void que_o_link_na_colecao_possui_um_registro_de_verificacao_de_com_e(String url, String nomeColecao, String dataHora, String statusHttp, String scoreRisco) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given que o link " + url + " na colecao " + nomeColecao + " possui um registro de verificacao de " + dataHora + " com " + statusHttp + " e " + scoreRisco);
        throw new io.cucumber.java.PendingException();
    }

    @When("eu seleciono o link {string}")
    public void eu_seleciono_o_link(String url) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When eu seleciono o link " + url);
        throw new io.cucumber.java.PendingException();
    }

    @When("eu solicito o {string} desse link")
    public void eu_solicito_o_desse_link(String tipoInfo) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When eu solicito o " + tipoInfo + " desse link");
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo ver uma lista de verificacoes anteriores para {string} ordenada da mais recente para a mais antiga")
    public void eu_devo_ver_uma_lista_de_verificacoes_anteriores_para_ordenada_da_mais_recente_para_a_mais_antiga(String url) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo ver uma lista de verificacoes anteriores para " + url + " ordenada da mais recente para a mais antiga");
        throw new io.cucumber.java.PendingException();
    }

    @Then("a entrada do historico para {string} deve mostrar {string} e {string}")
    public void a_entrada_do_historico_para_deve_mostrar_e(String dataHora, String detalhe1, String detalhe2) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then a entrada do historico para " + dataHora + " deve mostrar " + detalhe1 + " e " + detalhe2);
        throw new io.cucumber.java.PendingException();
    }

    @Given("que a colecao {string} do usuario {string} contem o link {string} com descricao {string}, ultimo {string}, {string} e {string}")
    public void que_a_colecao_do_usuario_contem_o_link_com_descricao_ultimo_e(String nomeColecao, String emailUsuario, String url, String descricao, String statusHttp, String validadeSsl, String scoreRisco) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given que a colecao " + nomeColecao + " do usuario " + emailUsuario + " contem o link " + url + " com descricao " + descricao + ", ultimo " + statusHttp + ", " + validadeSsl + " e " + scoreRisco);
        throw new io.cucumber.java.PendingException();
    }
    // O Cucumber pode ter gerado o snippet acima duas vezes se o step Gherkin for idêntico. Verifique.

    @When("eu seleciono a colecao {string}")
    public void eu_seleciono_a_colecao(String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When eu seleciono a colecao " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }

    @When("eu solicito o {string} da colecao")
    public void eu_solicito_o_da_colecao(String tipoInfo) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When eu solicito o " + tipoInfo + " da colecao");
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo ver no relatorio para {string} a metrica {string} com valor {string}")
    public void eu_devo_ver_no_relatorio_para_a_metrica_com_valor(String nomeColecao, String metrica, String valor) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo ver no relatorio para " + nomeColecao + " a metrica " + metrica + " com valor " + valor);
        throw new io.cucumber.java.PendingException();
    }

    @Given("que eu possuo uma colecao chamada {string} que {string} links")
    public void que_eu_possuo_uma_colecao_chamada_que_links(String nomeColecao, String contemOuNao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given que eu possuo uma colecao chamada " + nomeColecao + " que " + contemOuNao + " links");
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo ver um relatorio para {string} indicando {string}")
    public void eu_devo_ver_um_relatorio_para_indicando(String nomeColecao, String mensagem) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo ver um relatorio para " + nomeColecao + " indicando " + mensagem);
        throw new io.cucumber.java.PendingException();
    }

    @Then("as estatisticas devem mostrar {string} para total de links")
    public void as_estatisticas_devem_mostrar_para_total_de_links(String valor) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then as estatisticas devem mostrar " + valor + " para total de links");
        throw new io.cucumber.java.PendingException();
    }
}