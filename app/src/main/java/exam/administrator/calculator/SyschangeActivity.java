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

public class SyschangeActivity extends AppCompatActivity {

    EditText et1,et2,et3;
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sys);

        tv= (TextView) findViewById(R.id.tv_sys_show);
        et1= (EditText) findViewById(R.id.et_sys1);
        et2= (EditText) findViewById(R.id.et_sys2);
        et3= (EditText) findViewById(R.id.et_sys_num);

        Button btn= (Button) findViewById(R.id.button_syschange);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=et1.getText().toString();
                String b=et2.getText().toString();
                String c=et3.getText().toString();
                if(a.equals("10")){
                }else if(a.equals("2")){
                    c=Integer.valueOf(c,2).toString();
                }else if(a.equals("16")){
                    c=Integer.valueOf(c,16).toString();
                }else if(a.equals("8")){
                    c=Integer.valueOf(c,8).toString();

                }
                Integer temp=new Integer(c);

                if(b.equals("2")){
                    String binstr=Integer.toBinaryString(temp);
                    tv.setText(binstr);
                }else if(b.equals("16")){
                    String hexstr=Integer.toHexString(temp);
                    tv.setText(hexstr);
                }else if(b.equals("8")){
                    String otcstr=Integer.toOctalString(temp);
                    tv.setText(otcstr);
                }else{
                    tv.setText(temp.toString());
                }


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
                Intent intent=new Intent(SyschangeActivity.this,ScienceActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.Simple:
                Intent intent2=new Intent(SyschangeActivity.this,MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.Angle:
                Intent intent3=new Intent(SyschangeActivity.this,AnglechangeActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.Temperature:
                Intent intent4=new Intent(SyschangeActivity.this,TemperaturechangeActivity.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.Sys:
                break;
            case R.id.Date:
                Intent intent6=new Intent(SyschangeActivity.this,DateCaluActivity.class);
                startActivity(intent6);
                finish();
                break;
            case R.id.Help:
                Intent intent7=new Intent(SyschangeActivity.this,HelpActivity.class);
                startActivity(intent7);
                finish();
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
