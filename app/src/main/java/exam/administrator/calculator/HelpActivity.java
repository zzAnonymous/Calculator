package exam.administrator.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by Administrator on 2017/10/10.
 */

public class HelpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.Science:
                Intent intent=new Intent(HelpActivity.this,ScienceActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.Simple:
                Intent intent2=new Intent(HelpActivity.this,MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.Angle:
                Intent intent3=new Intent(HelpActivity.this,AnglechangeActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.Temperature:
                Intent intent4=new Intent(HelpActivity.this,TemperaturechangeActivity.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.Sys:
                Intent intent5=new Intent(HelpActivity.this,SyschangeActivity.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.Date:
                Intent intent6=new Intent(HelpActivity.this,DateCaluActivity.class);
                startActivity(intent6);
                finish();
                break;
            case R.id.Help:
                break;


        }
        return super.onOptionsItemSelected(item);
    }



}
