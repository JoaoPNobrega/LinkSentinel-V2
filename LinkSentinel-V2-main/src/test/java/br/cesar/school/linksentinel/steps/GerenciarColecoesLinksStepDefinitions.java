package br.cesar.school.linksentinel.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class GerenciarColecoesLinksStepDefinitions {

    @Given("eu estou na {string}") // Este é um step genérico, pode ser reutilizado
    public void eu_estou_na(String pagina) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given eu estou na " + pagina);
        throw new io.cucumber.java.PendingException();
    }

    @When("eu tento criar uma nova colecao com o nome {string}")
    public void eu_tento_criar_uma_nova_colecao_com_o_nome(String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When eu tento criar uma nova colecao com o nome " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }

    @Then("a colecao {string} deve ser criada e listada para o usuario {string}")
    public void a_colecao_deve_ser_criada_e_listada_para_o_usuario(String nomeColecao, String emailUsuario) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then a colecao " + nomeColecao + " deve ser criada e listada para o usuario " + emailUsuario);
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo ver a mensagem {string}") // Genérico
    public void eu_devo_ver_a_mensagem(String mensagem) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo ver a mensagem " + mensagem);
        throw new io.cucumber.java.PendingException();
    }

    @Given("que a colecao {string} do usuario {string} existe")
    public void que_a_colecao_do_usuario_existe(String nomeColecao, String emailUsuario) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given que a colecao " + nomeColecao + " do usuario " + emailUsuario + " existe");
        throw new io.cucumber.java.PendingException();
    }

    @Given("a colecao {string} contem o link {string} com descricao {string}")
    public void a_colecao_contem_o_link_com_descricao(String nomeColecao, String url, String descricao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given a colecao " + nomeColecao + " contem o link " + url + " com descricao " + descricao);
        throw new io.cucumber.java.PendingException();
    }

    @When("eu seleciono a colecao {string} para visualizar seus links")
    public void eu_seleciono_a_colecao_para_visualizar_seus_links(String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When eu seleciono a colecao " + nomeColecao + " para visualizar seus links");
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo ver o link {string} com a descricao {string}")
    public void eu_devo_ver_o_link_com_a_descricao(String url, String descricao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo ver o link " + url + " com a descricao " + descricao);
        throw new io.cucumber.java.PendingException();
    }

    @Given("que o usuario {string} possui uma colecao chamada {string}")
    public void que_o_usuario_possui_uma_colecao_chamada(String emailUsuario, String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given que o usuario " + emailUsuario + " possui uma colecao chamada " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }

    @When("eu seleciono a colecao {string} para exclusao")
    public void eu_seleciono_a_colecao_para_exclusao(String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When eu seleciono a colecao " + nomeColecao + " para exclusao");
        throw new io.cucumber.java.PendingException();
    }

    @When("eu confirmo a acao de exclusao da colecao")
    public void eu_confirmo_a_acao_de_exclusao_da_colecao() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When eu confirmo a acao de exclusao da colecao");
        throw new io.cucumber.java.PendingException();
    }

    @Then("a colecao {string} e todos os seus links devem ser permanentemente removidos")
    public void a_colecao_e_todos_os_seus_links_devem_ser_permanentemente_removidos(String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then a colecao " + nomeColecao + " e todos os seus links devem ser permanentemente removidos");
        throw new io.cucumber.java.PendingException();
    }

    @Then("a colecao {string} {string} na lista de colecoes")
    public void a_colecao_na_lista_de_colecoes(String nomeColecao, String naoDeveMaisSerExibida) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then a colecao " + nomeColecao + " " + naoDeveMaisSerExibida + " na lista de colecoes");
        throw new io.cucumber.java.PendingException();
    }

    @Given("que eu ja possuo uma colecao chamada {string}")
    public void que_eu_ja_possuo_uma_colecao_chamada(String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given que eu ja possuo uma colecao chamada " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo ver a mensagem de erro {string}")
    public void eu_devo_ver_a_mensagem_de_erro(String mensagemErro) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo ver a mensagem de erro " + mensagemErro);
        throw new io.cucumber.java.PendingException();
    }

    @Then("a colecao {string} {string} duplicada na minha lista de colecoes")
    public void a_colecao_duplicada_na_minha_lista_de_colecoes(String nomeColecao, String naoDeveSer) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then a colecao " + nomeColecao + " " + naoDeveSer + " duplicada na minha lista de colecoes");
        throw new io.cucumber.java.PendingException();
    }
}