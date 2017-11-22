package exam.administrator.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/10/7.
 */

public class TemperaturechangeActivity extends AppCompatActivity {

    private EditText etn;
    private TextView txt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        etn=(EditText)findViewById(R.id.et_temperature);
        txt=(TextView)findViewById(R.id.tv_temperature);
        Button btn=(Button)findViewById(R.id.button_temperaturechange);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=etn.getText().toString();
                double b= (Double.valueOf(a))* 33.8;
                txt.setText(String.valueOf(b));
            }
        });

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
                Intent intent=new Intent(TemperaturechangeActivity.this,ScienceActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.Simple:
                Intent intent2=new Intent(TemperaturechangeActivity.this,MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.Angle:
                Intent intent3=new Intent(TemperaturechangeActivity.this,AnglechangeActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.Temperature:
                break;
            case R.id.Sys:
                Intent intent5=new Intent(TemperaturechangeActivity.this,SyschangeActivity.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.Date:
                Intent intent6=new Intent(TemperaturechangeActivity.this,DateCaluActivity.class);
                startActivity(intent6);
                finish();
                break;
            case R.id.Help:
                Intent intent7=new Intent(TemperaturechangeActivity.this,HelpActivity.class);
                startActivity(intent7);
                finish();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

}
