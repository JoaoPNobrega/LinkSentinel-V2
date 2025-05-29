package br.cesar.school.linksentinel.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class MonitorarLinksAgendadosStepDefinitions {

    @Given("o sistema de agendamento de tarefas esta operacional")
    public void o_sistema_de_agendamento_de_tarefas_esta_operacional() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given o sistema de agendamento de tarefas esta operacional");
        throw new io.cucumber.java.PendingException();
    }

    @Given("que o monitoramento para a colecao {string} {string}")
    public void que_o_monitoramento_para_a_colecao(String nomeColecao, String estadoMonitoramento) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given que o monitoramento para a colecao " + nomeColecao + " " + estadoMonitoramento);
        throw new io.cucumber.java.PendingException();
    }

    @When("eu ativo o monitoramento {string} para a colecao {string}")
    public void eu_ativo_o_monitoramento_para_a_colecao(String frequencia, String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When eu ativo o monitoramento " + frequencia + " para a colecao " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }

    @When("o proximo ciclo de monitoramento agendado e executado para a colecao {string}")
    public void o_proximo_ciclo_de_monitoramento_agendado_e_executado_para_a_colecao(String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When o proximo ciclo de monitoramento agendado e executado para a colecao " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }

    @When("durante o monitoramento, o link {string} e verificado como {string}")
    public void durante_o_monitoramento_o_link_e_verificado_como(String url, String status) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When durante o monitoramento, o link " + url + " e verificado como " + status);
        throw new io.cucumber.java.PendingException();
    }

    @When("o link {string} e verificado como {string}") // Já pode existir em outra classe, mas o log pode ter gerado de novo
    public void o_link_e_verificado_como(String url, String status) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When o link " + url + " e verificado como " + status);
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo receber uma {string} informando que o link {string} da colecao {string} esta {string}")
    public void eu_devo_receber_uma_informando_que_o_link_da_colecao_esta(String tipoNotificacao, String url, String nomeColecao, String estadoLink) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo receber uma " + tipoNotificacao + " informando que o link " + url + " da colecao " + nomeColecao + " esta " + estadoLink);
        throw new io.cucumber.java.PendingException();
    }

    @Then("o status do link {string} deve ser atualizado para {string}")
    public void o_status_do_link_deve_ser_atualizado_para(String url, String novoStatus) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then o status do link " + url + " deve ser atualizado para " + novoStatus);
        throw new io.cucumber.java.PendingException();
    }

    @When("durante o monitoramento, o link {string} e analisado com {string} devido a {string}")
    public void durante_o_monitoramento_o_link_e_analisado_com_devido_a(String url, String score, String motivo) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When durante o monitoramento, o link " + url + " e analisado com " + score + " devido a " + motivo);
        throw new io.cucumber.java.PendingException();
    }

    @When("o link {string} e analisado com {string}") // Similar ao anterior, pode ser reutilizável
    public void o_link_e_analisado_com(String url, String score) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When o link " + url + " e analisado com " + score);
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo receber uma {string} \\(se configurado) e {string} alertando sobre o {string} para o link {string} da colecao {string}")
    public void eu_devo_receber_uma_se_configurado_e_alertando_sobre_o_para_o_link_da_colecao(String notificacaoEmail, String notificacaoPlataforma, String tipoRisco, String url, String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo receber uma " + notificacaoEmail + " (se configurado) e " + notificacaoPlataforma + " alertando sobre o " + tipoRisco + " para o link " + url + " da colecao " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }

    @Then("o score de risco do link {string} deve ser atualizado para {string}")
    public void o_score_de_risco_do_link_deve_ser_atualizado_para(String url, String novoScore) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then o score de risco do link " + url + " deve ser atualizado para " + novoScore);
        throw new io.cucumber.java.PendingException();
    }

    @Given("que o monitoramento {string} para a colecao {string} {string}")
    public void que_o_monitoramento_para_a_colecao(String frequencia, String nomeColecao, String estado) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Given que o monitoramento " + frequencia + " para a colecao " + nomeColecao + " " + estado);
        throw new io.cucumber.java.PendingException();
    }

    @When("eu desativo o monitoramento para a colecao {string}")
    public void eu_desativo_o_monitoramento_para_a_colecao(String nomeColecao) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: When eu desativo o monitoramento para a colecao " + nomeColecao);
        throw new io.cucumber.java.PendingException();
    }

    @Then("a colecao {string} {string} verificada automaticamente nos ciclos agendados")
    public void a_colecao_verificada_automaticamente_nos_ciclos_agendados(String nomeColecao, String naoDeveMaisSer) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then a colecao " + nomeColecao + " " + naoDeveMaisSer + " verificada automaticamente nos ciclos agendados");
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo ver uma mensagem confirmando que {string}")
    public void eu_devo_ver_uma_mensagem_confirmando_que(String mensagem) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(">>> STEP: Then eu devo ver uma mensagem confirmando que " + mensagem);
        throw new io.cucumber.java.PendingException();
    }
}