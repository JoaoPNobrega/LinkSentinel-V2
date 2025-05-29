package br.cesar.school.linksentinel.ui; // Ou br.cesar.school.linksentinel.views

import br.cesar.school.linksentinel.service.EmailJaCadastradoException;
import br.cesar.school.linksentinel.service.UsuarioService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed; // Import para acesso anônimo
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Registrar Novo Usuário | LinkSentinel")
@Route("registrar")
@AnonymousAllowed // Permite acesso a esta view sem login
public class RegistroView extends VerticalLayout {

    private final UsuarioService usuarioService; // Para injetar o serviço

    private EmailField emailField;
    private PasswordField senhaField;
    private PasswordField confirmarSenhaField;
    private Button registrarButton;

    @Autowired // Spring injetará a instância do UsuarioService aqui
    public RegistroView(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        H1 titulo = new H1("Registrar no LinkSentinel");

        emailField = new EmailField("E-mail");
        emailField.setErrorMessage("Por favor, insira um e-mail válido");
        emailField.setRequiredIndicatorVisible(true);
        emailField.setClearButtonVisible(true);

        senhaField = new PasswordField("Senha");
        senhaField.setHelperText("Mínimo de 8 caracteres.");
        senhaField.setRequiredIndicatorVisible(true);
        senhaField.setClearButtonVisible(true);

        confirmarSenhaField = new PasswordField("Confirmar Senha");
        confirmarSenhaField.setRequiredIndicatorVisible(true);
        confirmarSenhaField.setClearButtonVisible(true);

        registrarButton = new Button("Registrar");
        registrarButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        FormLayout formLayout = new FormLayout();
        formLayout.add(emailField, senhaField, confirmarSenhaField, registrarButton);
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("30em", 2) // Ajuste para responsividade
        );
        formLayout.setMaxWidth("500px");

        // Adicionar lógica ao botão
        registrarButton.addClickListener(event -> registrar());

        add(titulo, formLayout);
    }

    private void registrar() {
        String email = emailField.getValue();
        String senha = senhaField.getValue();
        String confirmarSenha = confirmarSenhaField.getValue();

        // Validações básicas no frontend (podem ser mais robustas com o Binder do Vaadin depois)
        if (email == null || email.isBlank()) {
            emailField.setInvalid(true);
            emailField.setErrorMessage("E-mail é obrigatório.");
            // Notification.show("E-mail é obrigatório.", 3000, Notification.Position.MIDDLE).addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        } else {
            emailField.setInvalid(false); // Limpa erro anterior
        }

        if (senha == null || senha.isBlank()) {
            senhaField.setInvalid(true);
            senhaField.setErrorMessage("Senha é obrigatória.");
            return;
        } else {
            senhaField.setInvalid(false);
        }
         if (confirmarSenha == null || confirmarSenha.isBlank()) {
            confirmarSenhaField.setInvalid(true);
            confirmarSenhaField.setErrorMessage("Confirmar senha é obrigatório.");
            return;
        } else {
            confirmarSenhaField.setInvalid(false);
        }


        if (!senha.equals(confirmarSenha)) {
            confirmarSenhaField.setInvalid(true);
            confirmarSenhaField.setErrorMessage("As senhas não conferem.");
            senhaField.setInvalid(true); // Pode marcar ambos os campos
             // Notification.show("As senhas não conferem.", 3000, Notification.Position.MIDDLE).addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        } else {
            senhaField.setInvalid(false);
            confirmarSenhaField.setInvalid(false);
        }

        if (senha.length() < 8) {
             senhaField.setInvalid(true);
             senhaField.setErrorMessage("A senha deve ter no mínimo 8 caracteres.");
             // Notification.show("A senha deve ter no mínimo 8 caracteres.", 3000, Notification.Position.MIDDLE).addThemeVariants(NotificationVariant.LUMO_ERROR);
            return;
        } else {
            senhaField.setInvalid(false);
        }

        try {
            usuarioService.registrarNovoUsuario(email, senha);
            Notification notification = Notification.show("Usuário registrado com sucesso! Você será redirecionado para o login.", 5000, Notification.Position.MIDDLE);
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);

            // Limpar os campos após o sucesso
            emailField.clear();
            senhaField.clear();
            confirmarSenhaField.clear();

            // Redirecionar para a tela de login após um pequeno delay
            notification.addOpenedChangeListener(openedChangeEvent -> {
                if (!openedChangeEvent.isOpened()) { // Quando a notificação fechar
                     // UI.getCurrent().navigate("login"); // Descomente quando a LoginView existir e estiver mapeada para "login"
                }
            });

        } catch (EmailJaCadastradoException e) {
            emailField.setInvalid(true);
            emailField.setErrorMessage(e.getMessage());
            // Notification.show(e.getMessage(), 3000, Notification.Position.MIDDLE).addThemeVariants(NotificationVariant.LUMO_ERROR);
        } catch (Exception e) { // Captura outras exceções genéricas do backend
            Notification.show("Ocorreu um erro inesperado ao tentar registrar.", 5000, Notification.Position.MIDDLE)
                        .addThemeVariants(NotificationVariant.LUMO_ERROR);
            e.printStackTrace(); // Para depuração no console do servidor
        }
    }
}