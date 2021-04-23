package cloud.autotests.tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Story("Login tests")
public class LoginTests extends TestBase {

    @Test
    @DisplayName("Authorization with wrong data")
    void loginTest() {
        step("Open login page", () -> {
            open(TestData.getWebUrl());
            $(".body").shouldHave(text("личный кабинет"));
            $(byAttribute("data-tip", "Войти в личный кабинет")).click();
            $(".form__main").shouldHave(text("вход"));
        });
        step("Fill in login form", () -> {
            $(byAttribute("name", "login")).val(TestData.getUserLogin());
            $(byAttribute("name", "password")).val(TestData.getUserPassword());
            $(byText("Войти")).click();
        });
        step("Verify wrong data validating message", () ->
                $(".form__error-inner").shouldHave(text("Неправильный e-mail или пароль.")));
    }

    @Test
    @DisplayName("Authorization with no login")
    void LoginRequired() {
        step("Open login page", () -> {
            open(TestData.getWebUrl());
            $(".body").shouldHave(text("личный кабинет"));
            $(byAttribute("data-tip", "Войти в личный кабинет")).click();
            $(".form__main").shouldHave(text("вход"));
        });
        step("Fill in login form", () -> {
            $(byAttribute("name", "login")).val("");
            $(byAttribute("name", "password")).val(TestData.getUserPassword());
            $(byText("Войти")).click();
        });
        step("Verify missing login validating message", () ->
                $(byAttribute("name", "auth")).shouldHave(text("Обязательное поле")));
    }

    @Test
    @DisplayName("Authorization with no password")
    void PasswordRequired() {
        step("Open login page", () -> {
            open(TestData.getWebUrl());
            $(".body").shouldHave(text("личный кабинет"));
            $(byAttribute("data-tip", "Войти в личный кабинет")).click();
            $(".form__main").shouldHave(text("вход"));
        });
        step("Fill in login form", () -> {
            $(byAttribute("name", "login")).val(TestData.getUserLogin());
            $(byAttribute("name", "password")).val("");
            $(byText("Войти")).click();
        });
        step("Verify missing password validating message", () ->
                $(byAttribute("name", "auth")).shouldHave(text("Обязательное поле")));
    }
    @Test
    @DisplayName("RememberPassword")
    void RememberPassword() {
        step("Open login page", () -> {
            open(TestData.getWebUrl());
            $(".body").shouldHave(text("личный кабинет"));
            $(byAttribute("data-tip", "Войти в личный кабинет")).click();
            $(".form__main").shouldHave(text("вход"));
        });
        step("RememberPassword", () -> {
            $(byText("Напомнить пароль")).click();
            $(".inner").shouldHave(text("Восстановление пароля"));
        });
    }

    @Test
    @DisplayName("Registration")
    void Registration() {
        step("Open login page", () -> {
            open(TestData.getWebUrl());
            $(".body").shouldHave(text("личный кабинет"));
            $(byAttribute("data-tip", "Войти в личный кабинет")).click();
            $(".form__main").shouldHave(text("вход"));
        });
        step("Registration", () -> {
            $(byText("Зарегистрироваться")).click();
            $(".inner").shouldHave(text("Регистрация"));
        });
    }
}


