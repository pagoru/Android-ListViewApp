package es.pagoru.listviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pablo on 10/1/17.
 */

public class Titular
{
    private String titulo;
    private String subtitulo;
    private int imageResource;

    public Titular(String tit, String sub, int imageResource){
        titulo = tit;
        subtitulo = sub;
        this.imageResource = imageResource;
    }

    public int getImageResource(){
        return imageResource;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }
}
class AdaptadorTitulares extends ArrayAdapter {

    public AdaptadorTitulares(Context context, Titular[] datos) {
        super(context, R.layout.activity_main, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        Titular tit = (Titular) getItem(position);
        View item = inflater.inflate(R.layout.activity_main, null);

        ImageView imageView = (ImageView)item.findViewById(R.id.imageView);
        imageView.setImageResource(tit.getImageResource());

        TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
        lblTitulo.setText(tit.getTitulo());

        TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
        lblSubtitulo.setText(tit.getSubtitulo());

        return(item);
    }
}