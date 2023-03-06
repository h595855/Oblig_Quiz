package no.hvl.dat153.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import no.hvl.dat153.Classes.Animal;
import no.hvl.dat153.Adapters.ListAdapter;
import no.hvl.dat153.DAO.AnimalDao;
import no.hvl.dat153.Database.AnimalDatabase;
import no.hvl.dat153.R;

public class DatabaseActivity extends AppCompatActivity {

    Set<Animal> images = new HashSet<Animal>();
    private ListView listView;
    private ListAdapter listAdapter;
    private List<Animal> animalList;
    private AnimalDatabase animalDatabase;
    private AnimalDao animalDao;

    private ActivityResultLauncher<Intent> AddPictureActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    Bundle extras = data.getExtras();
                    Animal newAnimal = extras.getParcelable("animal", Animal.class);
                    animalList.add(newAnimal);
                    //updating the list
                    listAdapter = new ListAdapter(this, R.layout.animalitem, animalList);
                    listView.setAdapter(listAdapter);
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databasectivity);

        //getting listview
        listView = findViewById(R.id.list_view);

        // Initialize the AnimalDatabase and AnimalDao
        animalDatabase = AnimalDatabase.getDatabase(this);
        animalDao = animalDatabase.animalDao();

        Animal a1 = new Animal("Cat", BitmapFactory.decodeResource(this.getResources(), R.drawable.cat));
        Animal a2 = new Animal("dog", BitmapFactory.decodeResource(this.getResources(), R.drawable.dog));
        Animal a3 = new Animal("among", BitmapFactory.decodeResource(this.getResources(), R.drawable.among));

        animalDao.insert(a1);
        animalDao.insert(a2);
        animalDao.insert(a3);

        animalList = animalDao.getAllAnimals();

        //adding to list
        animalList.add(a1);
        animalList.add(a2);
        animalList.add(a3);

        //creating listview of images
        listAdapter = new ListAdapter(this, R.layout.animalitem, animalList);
        listView.setAdapter(listAdapter);


        FloatingActionButton floatAdd = (FloatingActionButton) findViewById(R.id.addPicture);

        floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //making second activity to get update add to list
                Intent intent = new Intent(DatabaseActivity.this, AddPictureActivity.class);
                AddPictureActivity.launch(intent);

            }
        });
    }

    @Override
    public void onBackPressed(){
        finish();
        return;
    }
}