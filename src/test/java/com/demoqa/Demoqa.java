package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Demoqa {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Islam");
        $("#lastName").setValue("Kaziev");
        $("#userEmail").setValue("Kaziev@mail.com");
        $(withText("Male")).click();
        $("#userNumber").setValue("9111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();
        $("label[for=hobbies-checkbox-1]").shouldHave(text("Sport")).click();
        File fileToUpload = new File("src/test/resources/images/мтс.png");
        $("#uploadPicture").uploadFile(fileToUpload);
        $("#currentAddress").setValue("Pupkina, 214");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Islam Kaziev"));
        $(".modal-body").shouldHave(text("Kaziev@mail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9111111111"));
        $(".modal-body").shouldHave(text("14 September,1994"));
        $(".modal-body").shouldHave(text("Chemistry"));
        $(".modal-body").shouldHave(text("Sport"));
        $(".modal-body").shouldHave(text("мтс.png"));
        $(".modal-body").shouldHave(text("Pupkina, 214"));
        $(".modal-body").shouldHave(text("NCR Delhi"));

    }
}
