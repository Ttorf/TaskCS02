package main;

public class MainClass {
    private static String Text;

    public static void main(String[] args) {
        SearchAllLocalDisc searchAllLocalDisc = new SearchAllLocalDisc();
        System.out.println("Введите текст для поиска: ");
        Text = TextToString.getTextString();
        searchAllLocalDisc.search();
    }

    public static String getText() {
        return Text;
    }
}


