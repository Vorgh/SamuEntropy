/*
 * SplashActivity.java
 *
 * Norbiron Game
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

class Splash extends Thread {

    SplashActivity act;
    android.graphics.drawable.AnimationDrawable anim;

    public Splash(android.graphics.drawable.AnimationDrawable anim, SplashActivity act) {
        this.anim = anim;
        this.act = act;
    }

    public void st() {
        android.content.Intent intent = new android.content.Intent();
        intent.setClass(act, NeuronGameActivity.class);
        act.startActivity(intent);
        anim.stop();
    }

    @Override
    public void run() {
        anim.start();
    }
}

/**
 *
 * @author nbatfai
 */
public class SplashActivity extends android.app.Activity {

    private Splash splash;

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        android.widget.ImageView iv = (android.widget.ImageView) findViewById(R.id.neuronanimation);

        iv.setBackgroundResource(R.drawable.neuron_animation);

        final android.graphics.drawable.AnimationDrawable anim = (android.graphics.drawable.AnimationDrawable) iv.getBackground();

        splash = new Splash(anim, this);
        runOnUiThread(splash);

    }

    @Override
    public boolean onTouchEvent(android.view.MotionEvent evt) {
        if (evt.getAction() == android.view.MotionEvent.ACTION_DOWN) {
            splash.st();
        }
        return true;
    }
}
