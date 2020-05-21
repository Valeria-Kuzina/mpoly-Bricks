//package bricks;

import java.awt.Image;
import java.util.Enumeration;
import java.util.Vector;

/* Хранилище спрайтов */

class PuckSupply {
    /*
     * @_puck - массив шайб
     * @_count - кол-во оставшихся шайб
     */

    private Vector _pucks;
    private Enumeration<Puck> Puck;

    public PuckSupply(int N, PlayField pf, Image pic, Image pic1) {
        _pucks = new Vector();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0)
                _pucks.add(new Puck(pf, this, pic));
            else
                _pucks.add(new Puck(pf, this, pic1));
        }
        Puck = _pucks.elements();
    }

    public boolean hasMorePucks() {
        return Puck.hasMoreElements();
    }

    /* Взять следующую шайбу из хранилища */
    public Puck get() {
        return Puck.hasMoreElements() ? Puck.nextElement() : null;
    }
}

