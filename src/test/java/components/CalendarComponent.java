package components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        String selectorDay = "react-datepicker__day--0";
        selectorDay = "." + selectorDay + day + ":not(.react-datepicker__day--outside-month)";
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(selectorDay).click();
    }
}
