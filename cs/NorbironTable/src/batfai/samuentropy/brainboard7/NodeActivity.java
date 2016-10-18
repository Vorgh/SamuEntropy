/*
 * NodeActivity.java
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

class NodeAdapter extends android.widget.BaseAdapter {

    private android.content.Context context;
    private int[] nodeIds = {
        R.drawable.nandironproci, R.drawable.nandironproci2,
        R.drawable.matyironproci, R.drawable.matyironproci2,
        R.drawable.gretironproci, R.drawable.gretironproci2
    };

    public NodeAdapter(android.content.Context context) {

        cinit(context);
    }

    public NodeAdapter(android.content.Context context, android.util.AttributeSet attrs) {

        cinit(context);
    }

    public NodeAdapter(android.content.Context context,
            android.util.AttributeSet attrs, int defStyle) {

        cinit(context);
    }

    private void cinit(android.content.Context context) {

        this.context = context;
    }

    public int getCount() {
        return nodeIds.length;
    }

    public long getItemId(int position) {
        return nodeIds[position];
    }

    public Object getItem(int position) {
        return nodeIds[position];
    }

    public android.view.View getView(int position, android.view.View oldView, android.view.ViewGroup parent) {

        android.widget.ImageView imageView;

        if (oldView != null) {
            imageView = (android.widget.ImageView) oldView;
        } else {
            imageView = new android.widget.ImageView(context);
        }

        imageView.setImageResource(nodeIds[position]);
        return imageView;
    }

}

/**
 *
 * @author nbatfai
 */
public class NodeActivity extends android.app.Activity {

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nodes);

        android.widget.GridView gridView = (android.widget.GridView) findViewById(R.id.nodelist);
        gridView.setAdapter(new NodeAdapter(this));

        gridView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            public void onItemClick(android.widget.AdapterView<?> parent,
                    android.view.View view,
                    int position, long id) {

                android.content.Intent intent = new android.content.Intent();

                intent.setClass(NodeActivity.this, NeuronGameActivity.class);
                intent.setFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("selectedNode", position);
                startActivity(intent);

                NodeActivity.this.finish();

            }
        });

    }
}
