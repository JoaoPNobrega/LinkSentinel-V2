package br.cesar.school.linksentinel.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AnalisarRiscosPhishingStepDefinitions {

    @Given("que existe um usuario registrado no sistema com e-mail {string} e senha {string}")
    public void que_existe_um_usuario_registrado_no_sistema_com_e_mail_e_senha(String email, String senha) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given que existe um usuario: " + email);
        throw new io.cucumber.java.PendingException();
    }

    @Given("eu realizei o login com o e-mail {string} e senha {string}")
    public void eu_realizei_o_login_com_o_e_mail_e_senha(String email, String senha) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given eu realizei login: " + email);
        throw new io.cucumber.java.PendingException();
    }

    @Given("eu possuo uma colecao chamada {string}")
    public void eu_possuo_uma_colecao_chamada(String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given eu possuo uma colecao: " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }

    @Given("eu adicionei o link {string} com descricao {string} a colecao {string}")
    public void eu_adicionei_o_link_com_descricao_a_colecao(String url, String descricao, String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given eu adicionei link " + url + " a " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }

    @Given("o sistema esta configurado para consultar {string}")
    public void o_sistema_esta_configurado_para_consultar(String configuracao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given sistema configurado para consultar " + configuracao);
        throw new io.cucumber.java.PendingException();
    }

    @Given("o sistema esta configurado para aplicar {string}")
    public void o_sistema_esta_configurado_para_aplicar(String configuracao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given sistema configurado para aplicar " + configuracao);
        throw new io.cucumber.java.PendingException();
    }

    @Given("que a URL {string} {string} mas {string}") // Este step parece um pouco diferente do feature original, ajuste se necessário.
    public void que_a_url_mas(String url, String condicao1, String condicao2) {
        // Write code here that turns the phrase above into concrete actions
         System.out.println(">>> STEP: Given que a URL " + url + " " + condicao1 + " mas " + condicao2);
        throw new io.cucumber.java.PendingException();
    }

    @When("eu solicito uma {string} para o link {string}")
    public void eu_solicito_uma_para_o_link(String acao, String url) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When eu solicito " + acao + " para " + url);
        throw new io.cucumber.java.PendingException();
    }

    @Then("o sistema deve realizar a {string} para o link {string}")
    public void o_sistema_deve_realizar_a_para_o_link(String acao, String url) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then o sistema deve realizar " + acao + " para " + url);
        throw new io.cucumber.java.PendingException();
    }

    @Then("apos a conclusao da verificacao, ao visualizar os detalhes do link {string}, eu devo ver o {string} como {string}")
    public void apos_a_conclusao_da_verificacao_ao_visualizar_os_detalhes_do_link_eu_devo_ver_o_como(String url, String campo, String valor) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then apos verificacao de " + url + ", ver " + campo + " como " + valor);
        throw new io.cucumber.java.PendingException();
    }

    // Este snippet foi gerado duas vezes no seu log com a mesma assinatura, então uma implementação é suficiente.
    // Se os steps Gherkin forem ligeiramente diferentes mas gerarem o mesmo snippet,
    // você pode precisar ajustar a expressão regular na anotação ou o texto no Gherkin.
    @Then("eu devo ver o {string} como {string}")
    public void eu_devo_ver_o_como(String campo, String valor) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo ver o " + campo + " como " + valor);
        throw new io.cucumber.java.PendingException();
    }

    // Este é para o step: "And eu devo ver os "Motivos do Risco" como "Detectado em Blacklist X"
    // O log gerou: @Then("eu devo ver os {string} como {string} # Ou similar, baseado nas heuristicas")
    // O comentário Gherkin não faz parte da expressão, então o snippet é o mesmo.
    // Se for distinto, o Cucumber teria gerado um snippet distinto.
    // Se for para "Motivos do Risco", o step Gherkin era:
    // And eu devo ver os "Motivos do Risco" como "Detectado em Blacklist X"
    // Vamos assumir que o snippet abaixo cobre isso.
    @Then("eu devo ver os {string} como {string}") // Este cobriria "Motivos do Risco"
    public void eu_devo_ver_os_como(String campo, String valor) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo ver os " + campo + " como " + valor);
        throw new io.cucumber.java.PendingException();
    }

    // Os snippets seguintes eram para outros parâmetros, mas o log mostrou
    // @Then("eu devo poder visualizar a {string} como {string}")
    // @Then("eu devo poder visualizar o {string} contendo {string}")
    // @Then("eu devo poder visualizar o {string} como um valor {string}")
    // @Then("eu devo poder visualizar o {string} como {string}") -> este é idêntico ao "eu devo ver o {string} como {string}"

    @Then("eu devo poder visualizar a {string} como {string}")
    public void eu_devo_poder_visualizar_a_como(String campo, String valor) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo poder visualizar a " + campo + " como " + valor);
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo poder visualizar o {string} contendo {string}")
    public void eu_devo_poder_visualizar_o_contendo(String campo, String valor) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo poder visualizar o " + campo + " contendo " + valor);
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo poder visualizar o {string} como um valor {string}")
    public void eu_devo_poder_visualizar_o_como_um_valor(String campo, String valor) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo poder visualizar o " + campo + " como um valor " + valor);
        throw new io.cucumber.java.PendingException();
    }
}