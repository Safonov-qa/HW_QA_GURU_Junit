package ru.SafonovILL;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class LocaleWebTest {


    static Stream<Arguments> siteShouldContainsAllOfGivenButtonsForGivenLocale() {
        return Stream.of(
                Arguments.of("Частным клиентам" ,List.of(
                        "SberPay",
                        "СберПрайм+",
                        "Кредиты",
                        "Ипотека",
                        "Карты",
                        "Вклады",
                        "Премиум",
                        "Инвестиции",
                        "Платежи",
                        "Переводы",
                        "Страхование",
                        "Поддержка"

                        )),
                Arguments.of("Самозанятым", List.of(
                        "Своё дело",
                        "Бесплатно в СберБанк Онлайн",
                        "Сервисы партнёров за 0 ₽",
                        "Другие сервисы",
                        "Как платить налоги",
                        "Помощь"
                ))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Для локали {0} на сайте http://www.sberbank.ru/ru/credit_org должен отображаться список кнопок {1}")
    @Tag("REGRESSION")
    void siteShouldContainsAllOfGivenButtonsForGivenLocale(String locale, List <String> ExpectedButtons) {

        open("http://www.sberbank.ru/ru/");
        $(".kitt-header__sections").$(byText(locale)).click();
        $$(".kitt-top-menu__item.kitt-top-menu__item_first").shouldHave(texts(ExpectedButtons));









        sleep(800);

    }


}
