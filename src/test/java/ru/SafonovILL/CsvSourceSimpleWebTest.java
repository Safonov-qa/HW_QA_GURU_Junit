package ru.SafonovILL;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class CsvSourceSimpleWebTest {


    @CsvFileSource(resources = "/testdata/searchResultShouldContainExpectedText.csv", delimiter = '|')
    @ParameterizedTest(name = "В первом результате выдачи Сбербанка для {0} должен отобразится текст {1} ")
    @Tag("REGRESSION")
    void searchResultShouldContainExpectedText(String testData, String expectedText ) {
        open("http://www.sberbank.ru/ru/person");
        $("a.kitt-header-search").click();
        $(".kitt-header-search__search").setValue(testData).pressEnter();
        $$("yass-li.b-serp-item").first().shouldHave(text((expectedText)));


    }
}
