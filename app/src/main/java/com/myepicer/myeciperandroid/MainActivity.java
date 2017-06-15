package com.myepicer.myeciperandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.myepicer.myeciperandroid.Model.Recipe;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Recipe> recipeList = Recipe.getListInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView recipeListView = (ListView) findViewById(R.id.recipeListView);
        recipeListView.setAdapter(new RecipeAdapter());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private  class RecipeAdapter extends ArrayAdapter<Recipe>{

        public RecipeAdapter() {
            super(MainActivity.this, R.layout.listview_item_recipe,recipeList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView==null){
                convertView = getLayoutInflater().inflate(R.layout.listview_item_recipe,parent,false);
            }

            TextView txtRecipeTitle,txtLevel,txtTime,txtCost;
            ImageView imgRecipe ;
            Recipe recipe = recipeList.get(position);

            imgRecipe = (ImageView) convertView.findViewById(R.id.imgRecipe);
            txtRecipeTitle = (TextView) convertView.findViewById(R.id.txtRecipeTitle);
            txtLevel = (TextView) convertView.findViewById(R.id.txtLevel);
            txtTime = (TextView) convertView.findViewById(R.id.txtTime);
            txtCost = (TextView) convertView.findViewById(R.id.txtCost);

            imgRecipe.setImageResource(recipe.getPicture());
            txtRecipeTitle.setText(recipe.getName());
            txtLevel.setText(recipe.getLevel());
            txtTime.setText(recipe.getTime());
            txtCost.setText(String.valueOf(recipe.getCost()));

            return convertView;
        }
    }
}
