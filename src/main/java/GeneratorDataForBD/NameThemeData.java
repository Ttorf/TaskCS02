package GeneratorDataForBD;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NameThemeData {
    String[] listNames = new String[]{"Олег", "Иван", "Александр", "Артём", "Павел"};
    String[] listThemes = new String[]{"Зарплата", "Отгул", "Отпуск", "Штрафы", "Премия"};

    public java.sql.Date dataNowGenerationString() {

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = java.sql.Date.valueOf(formatForDateNow.format(dateNow));
        return sqlDate;

    }

    public String randomName() {

        int a = (int) (Math.random() * 4);
        return listNames[a];

    }

    public String randomTheme() {
        int a = (int) (Math.random() * 4);
        return listThemes[a];

    }

}
