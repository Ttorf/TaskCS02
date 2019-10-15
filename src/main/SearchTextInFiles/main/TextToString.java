package main;

public class TextToString {
    static public String getTextString() {

        byte bKbd[] = new byte[256];
        int iCnt = 0;
        String szStr = "";
        try {
            iCnt = System.in.read(bKbd);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        szStr = new String(bKbd, 0, iCnt);
        szStr = szStr.trim();
        return szStr;
    }
}