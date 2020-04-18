package design.models.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JinYuwei
 * @Since: 2020/3/15
 */

public class Editor {
    private List<Character> chars = new ArrayList<Character>();

    public void appendCharacter(char c, Font font, int size, int colorRGB) {
        Character character = new Character(c, font, size, colorRGB);
        chars.add(character);
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s == Character.s1);
    }
}

class Character {//文字
    public static String s1 = "abc";

    private char c;

    private Font font;
    private int size;
    private int colorRGB;

    public Character(char c, Font font, int size, int colorRGB) {
        this.c = c;
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }
}


class Font {
}




