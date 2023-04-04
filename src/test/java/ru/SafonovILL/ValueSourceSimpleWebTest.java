package ru.SafonovILL;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Selenide.*;

public class ValueSourceSimpleWebTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void setup() {
        open("http://www.sberbank.ru/ru/person");
        $("a.kitt-header-search").click();
    }


    @ValueSource(strings = {
            "Вклады","Карты","Кредиты"
    })
    @Web
    @ParameterizedTest(name = "В поисковой выдаче Сбербанка должен должно отобразится не меньше 10 результатов по запросу {0}")
    void searchResultSizeGreaterThan10(String testData) {
        $(".kitt-header-search__search").setValue(testData).pressEnter();
        $$("yass-li.b-serp-item").shouldHave(CollectionCondition.sizeGreaterThanOrEqual(10));


    }
    @Disabled
    @DisplayName("В поисковой выдаче сбербанка должно отобразиться не меньше 10 результатов по запросу 'Ипотека' ")
    @Test
    void OpenMortgage() {
        $(".kitt-header-search__search").setValue("Ипотека").pressEnter();
        $$("yass-li.b-serp-item").shouldHave(CollectionCondition.sizeGreaterThanOrEqual(10));

    }

}
