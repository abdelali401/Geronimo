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

        //remplir la liste des personnages
        ajouterPersonnages();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //cet adapter servira à remplir recyclerview
        myAdapter = new MyAdapter(personnagesList);
        recyclerView.setAdapter(myAdapter);
    }

    private void ajouterPersonnages() {
        personnagesList.add(new Personnage("The king of the north","Game of thrones",R.drawable.game_of_thrones));
        personnagesList.add(new Personnage("The King Ragnar","Vikings",R.drawable.vikings));
        personnagesList.add(new Personnage("Schofield","Prison break",R.drawable.prison_break));

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // Le button Add permet d'ajouter un personnage dans la liste
                personnagesList.add(new Personnage("The king of the north","Game of thrones",R.drawable.game_of_thrones));
                if(personnagesList.size()>1)
                    myAdapter.notifyItemInserted(1);
                else
                    myAdapter.notifyItemInserted(0);
                return true;

            case R.id.action_remove:
                // Le button Remove permet de retirer un personnage de la liste

                if(personnagesList.size()>0)
                {
                    personnagesList.remove(0);
                    myAdapter.notifyItemRemoved(0);
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

}