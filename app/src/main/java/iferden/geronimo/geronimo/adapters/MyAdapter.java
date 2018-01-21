package iferden.geronimo.geronimo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import iferden.geronimo.geronimo.Model.Personnage;
import iferden.geronimo.geronimo.R;

/**
 * Created by abdelaliiferden on 21/01/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<Personnage> list;

    //ajouter un constructeur prenant en entrée une liste
    public MyAdapter(List<Personnage> list) {
        this.list = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_card,viewGroup,false);
        return new MyViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le infos de notre personnage
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Personnage myObject = list.get(position);
        myViewHolder.bind(myObject);
    }

    //Le nombre de personnage
    @Override
    public int getItemCount() {
        return list.size();
    }

}
