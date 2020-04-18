package design.models.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JinYuwei
 * @Since: 2020/3/15
 */

class ChessPiece {//棋子
    private int id;
    private String text;
    private Color color;
    private int positionX;
    private int positionY;

    public ChessPiece(int id, String text, Color color, int positionX, int positionY) {
        this.id = id;
        this.text = text;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionX;
    }

    public static enum Color {
        RED, BLACK
    }

    // ...省略其他属性和getter/setter方法...
}

public class ChessBoard {//棋局
    private Map<Integer, ChessPiece> chessPieces = new HashMap<Integer, ChessPiece>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(1, "車", ChessPiece.Color.BLACK, 0, 0));
        chessPieces.put(2, new ChessPiece(2, "馬", ChessPiece.Color.BLACK, 0, 1));
        //...省略摆放其他棋子的代码...
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //...省略...
    }
}