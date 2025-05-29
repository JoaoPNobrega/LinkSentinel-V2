package br.cesar.school.linksentinel.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n; // Importe LoginI18n
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("login")
@PageTitle("Login | LinkSentinel")
@AnonymousAllowed
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private final LoginForm loginForm = new LoginForm();

    public LoginView() {
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        // Configurar internacionalização para o formulário de login
        LoginI18n i18n = LoginI18n.createDefault();
        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("Login");
        i18nForm.setUsername("E-mail"); // <<<< ALTERAÇÃO AQUI
        i18nForm.setPassword("Senha");
        i18nForm.setSubmit("Entrar");
        i18nForm.setForgotPassword("Esqueci minha senha");
        i18n.setForm(i18nForm);

        LoginI18n.ErrorMessage i18nErrorMessage = i18n.getErrorMessage();
        i18nErrorMessage.setTitle("E-mail ou senha incorretos");
        i18nErrorMessage.setMessage("Verifique suas credenciais e tente novamente.");
        i18n.setErrorMessage(i18nErrorMessage);

        loginForm.setI18n(i18n); // Aplica as configurações de internacionalização/texto

        loginForm.setAction("login");
        loginForm.setForgotPasswordButtonVisible(true); // Tornar o botão "Esqueci minha senha" visível

        add(new H1("LinkSentinel Login"), loginForm);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (event.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            loginForm.setError(true);
        }
    }
}