/*
 * NeuronAnimActivity.java
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


import android.preference.PreferenceManager;
import android.os.Bundle;

/**
 *
 * @author nbatfai
 */
public class NeuronGameActivity extends android.app.Activity {

    public static final String PREFERENCES = "NeuronGameSave";
    public static boolean restore = false;

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.content.SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);

        setContentView(R.layout.main);
        //NorbironSurfaceView.setData(settings);

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        android.content.SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        android.content.SharedPreferences.Editor editor = settings.edit();
        NorbironSurfaceView.saveData(editor);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        int i=0;
        for(NeuronBox nb : NorbironSurfaceView.nodeBoxes)
        {
            savedInstanceState.putInt("x"+i ,nb.x);
            savedInstanceState.putInt("y"+i ,nb.y);
            savedInstanceState.putInt("db"+i, nb.numberOfNeurons);
            savedInstanceState.putInt("type"+i, nb.covertype);
            savedInstanceState.putBoolean("selected"+i, nb.getSelected());
            savedInstanceState.putBoolean("open"+i, nb.getCover());
            i++;
        }
        savedInstanceState.putInt("size", NorbironSurfaceView.nodeBoxes.size());

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restore = true;

        NorbironSurfaceView.nodeBoxes.clear();
        for (int i=0; i<savedInstanceState.getInt("size"); i++)
        {
            int covertype = savedInstanceState.getInt("type"+i, 0);
            NeuronBox box = (NeuronBox)Nodes.get(covertype).clone();
            NorbironSurfaceView.nodeBoxes.add(box);
            box.setXY(savedInstanceState.getInt("x"+i, 0), savedInstanceState.getInt("y"+i, 0));
            box.numberOfNeurons = savedInstanceState.getInt("db"+i, 0);
            box.setSelected(savedInstanceState.getBoolean("selected"+i, false));
            box.setCover(savedInstanceState.getBoolean("open"+i, false));
        }
    }
}