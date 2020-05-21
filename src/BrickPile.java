//package bricks;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

public class BrickPile {
    private PlayField _pf;
    private Vector _bricks;
    private final int _rows = 4;
    private final int _cols = 10;
    private Enumeration<Brick> Brick;

    public BrickPile(PlayField pf, Image img, Image img1) {
        _pf = pf;
        _bricks = new Vector();
        int startx = 80;
        int x = startx, y = 10;
        Random random = new Random();

        // генерация кирпичей -> массив кирпичей
        for (int r = 0; r < _rows; r++) {
            for (int c = 0; c < _cols; c++) {
                Rectangle pos = new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
                if (random.nextInt(2) == 1)
                    _bricks.addElement(new Brick(_pf, this, img, pos));
                else
                    _bricks.addElement(new HardBrick(_pf, this, pos, img1, img));

                x += img.getWidth(null);
            }
            y += img.getHeight(null) + 2;
            x = startx;
        }

        // добавляем кирпичи
        Brick = _bricks.elements();
        while (Brick.hasMoreElements()) {
            pf.addSprite(Brick.nextElement());
        }
    }

    public int unbrokenCount() {
        int result = 0;

        for (int i = 0; i < _bricks.size(); i++) {
            if (!((Brick) _bricks.elementAt(i)).isDead())
                result++;
        }

        return result;
    }

    public int brokenCount() {
        return _bricks.size() - unbrokenCount();
    }
}
