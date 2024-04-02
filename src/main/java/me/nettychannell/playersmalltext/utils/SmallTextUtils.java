package me.nettychannell.playersmalltext.utils;

public class SmallTextUtils {

    public static String getSmallText(String text) {
        String normalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String smallTextAlphabet = "ᴀʙᴄᴅᴇꜰɢʜɪᴊᴋʟᴍɴᴏᴘǫʀѕᴛᴜᴠᴡxʏᴢᴀʙᴄᴅᴇꜰɢʜɪᴊᴋʟᴍɴᴏᴘǫʀѕᴛᴜᴠᴡxʏᴢ";
        String normalNumbers = "0123456789";
        String smallTextNumbers = "₀₁₂₃₄₅₆₇₈₉";

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            int alphabetIndex = normalAlphabet.indexOf(character);
            int numberIndex = normalNumbers.indexOf(character);

            if (alphabetIndex != -1) {
                char smallChar = smallTextAlphabet.charAt(alphabetIndex);
                stringBuilder.append(smallChar);
            } else if (numberIndex != -1) {
                char smallNumber = smallTextNumbers.charAt(numberIndex);
                stringBuilder.append(smallNumber);
            } else {
                stringBuilder.append(character);
            }
        }

        return stringBuilder.toString();
    }


}
