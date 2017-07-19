package tech.hyperdev.scorekeeper.activities;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;
import tech.hyperdev.scorekeeper.utils.Utils;

public class MainActivity extends AppCompatActivity {

    private ScoreFragment scoreFragment;
    private ConstraintLayout constraintLayout;
    int color[] = {R.color.day, R.color.night};
    int count = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraint1);
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.frame1, new ScoreFragment().newInstance("Team 1")).commit();

        fragmentManager.beginTransaction().replace(R.id.frame2, new ScoreFragment().newInstance("Team 2")).commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Utils.changeToTheme(MainActivity.this,0);
                return true;
            case R.id.daymode:
                Utils.changeToTheme(MainActivity.this,1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
