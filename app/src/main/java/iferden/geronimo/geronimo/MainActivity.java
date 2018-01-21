package iferden.geronimo.geronimo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import iferden.geronimo.geronimo.Model.Personnage;
import iferden.geronimo.geronimo.adapters.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<Personnage> personnagesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //remplir la ville
        ajouterPersonnages();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        //puis créer un MyAdapter, lui fournir notre liste de villes.
        //cet adapter servira à remplir notre recyclerview
        myAdapter = new MyAdapter(personnagesList);
        recyclerView.setAdapter(myAdapter);
    }

    private void ajouterPersonnages() {
        personnagesList.add(new Personnage("The king of the north","Game of thrones",R.drawable.game_of_thrones));
        personnagesList.add(new Personnage("The King Ragnar","Vikings",R.drawable.vikings));

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // User chose the "Settings" item, show the app settings UI...
                personnagesList.add(new Personnage("The king of the north","Game of thrones",R.drawable.game_of_thrones));
                if(personnagesList.size()>1)
                    myAdapter.notifyItemInserted(1);
                else
                    myAdapter.notifyItemInserted(0);
                return true;

            case R.id.action_remove:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                if(personnagesList.size()>0)
                {
                    personnagesList.remove(0);
                    myAdapter.notifyItemRemoved(0);
                }
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}