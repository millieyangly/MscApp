package hk.hku.cs.mscapp;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import hk.hku.cs.mscapp.Fragment.AdmissionFragment;
import hk.hku.cs.mscapp.Fragment.ApplicationFragment;
import hk.hku.cs.mscapp.Fragment.FacultyFragment;
import hk.hku.cs.mscapp.Fragment.HKUFragment;
import hk.hku.cs.mscapp.Fragment.MainFragment;
import hk.hku.cs.mscapp.Fragment.ProgramFragment;
import hk.hku.cs.mscapp.Fragment.TableFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;
    private Fragment fragment_main, fragment_program, fragment_faculty, fragment_admission, fragment_hku;


    private Toolbar mActionBarToolbar;

    private int pagenum = 0;//the name of fragment
    private String textspeech;
    private TextToSpeech textToSpeech;
    private TextView input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();
        fragment_main = new MainFragment();
        fragment_program = new ProgramFragment();
        fragment_faculty = new FacultyFragment();
        fragment_admission = new AdmissionFragment();
        fragment_hku = new HKUFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.content_fragment, fragment_main).commit();

        //speech function
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == textToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.US);
                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE
                            && result != TextToSpeech.LANG_AVAILABLE) {
                        Toast.makeText(MainActivity.this, "TTS暂时不支持这种语音的朗读！",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        //  fragmentManager.beginTransaction()
        //        .replace(R.id.content_fragment, fragment_main).commit();


        //  浮动点 返回首页
        FloatingActionButton home = (FloatingActionButton) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //   .setAction("Action", null).show();

                fragmentManager.beginTransaction()
                        .replace(R.id.content_fragment, fragment_main).commit();
                pagenum = 0;
                mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
                getSupportActionBar().setTitle("MCS(CS)");
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            switch (pagenum) {
                case 0:

                    break;
                case 1:
                    input = (TextView) findViewById(R.id.text_program_overview1);
                    textspeech = input.getText().toString();
                    textToSpeech.speak(textspeech, TextToSpeech.QUEUE_ADD, null, null);
                    break;
                case 2:
                    input = (TextView) findViewById(R.id.text00);
                    textspeech = input.getText().toString();
                    input = (TextView) findViewById(R.id.text01);
                    textspeech = textspeech + input.getText().toString();
                    textToSpeech.speak(textspeech, TextToSpeech.QUEUE_ADD, null, null);
                    break;
                case 3:
//                    input = (TextView) findViewById(R.id.text2);
//                    textspeech = input.getText().toString();
//                    input = (TextView) findViewById(R.id.text7);
//                    textspeech = textspeech + input.getText().toString();
//                    textToSpeech.speak(textspeech, TextToSpeech.QUEUE_ADD, null, null);
                    break;
                case 4:
                    input = (TextView) findViewById(R.id.text_hku_detail);
                    textToSpeech.speak(input.getText().toString(),
                            TextToSpeech.QUEUE_ADD, null, null);
                    break;
                default:
                    break;

            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        if (textToSpeech != null)
            textToSpeech.shutdown();
        super.onDestroy();
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        System.out.print(id);

        if (id == R.id.program) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_fragment, fragment_program).commit();
            pagenum = 1;
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
            getSupportActionBar().setTitle("PROGRAM");

        } else if (id == R.id.faculy) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_fragment, fragment_faculty).commit();
            pagenum = 2;
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
            getSupportActionBar().setTitle("FACULTY");

        } else if (id == R.id.admission) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_fragment, fragment_admission).commit();
            pagenum = 3;
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
            getSupportActionBar().setTitle("ADMISSION");

        } else if (id == R.id.hku) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_fragment, fragment_hku).commit();
            pagenum = 4;
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
            getSupportActionBar().setTitle("ABOUT HKU");

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
