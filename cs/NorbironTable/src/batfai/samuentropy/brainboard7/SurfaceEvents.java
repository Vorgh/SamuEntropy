/*
 * SurfaceEvents.java
 * This is a case study for creating sprites for SamuEntropy/Brainboard.
 *
 * Copyright (C) 2016, Dr. B�tfai Norbert
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Ez a program szabad szoftver; terjeszthet� illetve m�dos�that� a
 * Free Software Foundation �ltal kiadott GNU General Public License
 * dokumentum�ban le�rtak; ak�r a licenc 3-as, ak�r (tetsz�leges) k�s�bbi
 * v�ltozata szerint.
 *
 * Ez a program abban a rem�nyben ker�l k�zread�sra, hogy hasznos lesz,
 * de minden egy�b GARANCIA N�LK�L, az ELADHAT�S�GRA vagy VALAMELY C�LRA
 * VAL� ALKALMAZHAT�S�GRA val� sz�rmaztatott garanci�t is bele�rtve.
 * Tov�bbi r�szleteket a GNU General Public License tartalmaz.
 *
 * A felhaszn�l�nak a programmal egy�tt meg kell kapnia a GNU General
 * Public License egy p�ld�ny�t; ha m�gsem kapta meg, akkor
 * tekintse meg a <http://www.gnu.org/licenses/> oldalon.
 *
 * Version history:
 *
 * 0.0.1, 2013.szept.29.
 */
package batfai.samuentropy.brainboard7;

/**
 *
 * @author nbatfai
 */
public class SurfaceEvents implements android.view.SurfaceHolder.Callback {

    private NorbironSurfaceView surfaceView;
    Thread thread;

    public SurfaceEvents(NorbironSurfaceView surfaceView) {

        this.surfaceView = surfaceView;
    }

    @Override
    public void surfaceDestroyed(android.view.SurfaceHolder holder) {

        surfaceView.stop();
        thread = null;
    }

    @Override
    public void surfaceCreated(android.view.SurfaceHolder holder) {

        thread = new Thread(surfaceView);
        thread.start();
        surfaceView.repaint();

    }

    @Override
    public void surfaceChanged(android.view.SurfaceHolder holder, int format,
            int width, int height) {

        surfaceView.repaint();

    }

}
