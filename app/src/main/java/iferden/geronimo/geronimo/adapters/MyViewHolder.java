package iferden.geronimo.geronimo.adapters;

import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import iferden.geronimo.geronimo.Model.Personnage;
import iferden.geronimo.geronimo.R;

/**
 * Created by abdelaliiferden on 21/01/2018.
 */

public class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView textItemTitle;
    private TextView textItemDesciotion;
    private ImageView imageView;
    private AppCompatButton detailsButton;
    private AppCompatButton shareButton;

    //itemView est la vue correspondante à 1 cellule
    public MyViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView

        textItemTitle = (TextView) itemView.findViewById(R.id.item_title);
        textItemDesciotion = (TextView) itemView.findViewById(R.id.item_description);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        detailsButton = (AppCompatButton) itemView.findViewById(R.id.item_detail_btn);
        shareButton = (AppCompatButton) itemView.findViewById(R.id.item_share_btn);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(final Personnage myPersonnage){
        textItemTitle.setText(myPersonnage.getName());
        textItemDesciotion.setText(myPersonnage.getSerie());
        imageView.setBackgroundResource(myPersonnage.getImage());
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "DETAILS : "+myPersonnage.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", "Hello : " + myPersonnage.getName());
                intent.setType("text/plain");
                view.getContext().startActivity(intent);
            }
        });
    }
}