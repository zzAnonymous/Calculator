package exam.administrator.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private TextView tvScreen;
    private List<Item> items = new ArrayList<Item>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScreen = (TextView) findViewById(R.id.tvscreen);
        
        Button btn0= (Button) findViewById(R.id.btn0);
        Button btn1= (Button) findViewById(R.id.btn1);
        Button btn2= (Button) findViewById(R.id.btn2);
        Button btn3= (Button) findViewById(R.id.btn3);
        Button btn4= (Button) findViewById(R.id.btn4);
        Button btn5= (Button) findViewById(R.id.btn5);
        Button btn6= (Button) findViewById(R.id.btn6);
        Button btn7= (Button) findViewById(R.id.btn7);
        Button btn8= (Button) findViewById(R.id.btn8);
        Button btn9= (Button) findViewById(R.id.btn9);
        Button btnadd= (Button) findViewById(R.id.btnadd);
        Button btnsub= (Button) findViewById(R.id.btnsub);
        Button btnmul= (Button) findViewById(R.id.btnmul);
        Button btndiv= (Button) findViewById(R.id.btndiv);
        Button btnpoint= (Button) findViewById(R.id.btnpoint);
        Button btnclear= (Button) findViewById(R.id.btnclear);
        Button btnresult= (Button) findViewById(R.id.btnresult);
        Button btnback= (Button) findViewById(R.id.btnback);

        btn0.setOnClickListener(new MainListener());
        btn1.setOnClickListener(new MainListener());
        btn2.setOnClickListener(new MainListener());
        btn3.setOnClickListener(new MainListener());
        btn4.setOnClickListener(new MainListener());
        btn5.setOnClickListener(new MainListener());
        btn6.setOnClickListener(new MainListener());
        btn7.setOnClickListener(new MainListener());
        btn8.setOnClickListener(new MainListener());
        btn9.setOnClickListener(new MainListener());
        btnadd.setOnClickListener(new MainListener());
        btnsub.setOnClickListener(new MainListener());
        btnmul.setOnClickListener(new MainListener());
        btndiv.setOnClickListener(new MainListener());
        btnpoint.setOnClickListener(new MainListener());
        btnclear.setOnClickListener(new MainListener());
        btnresult.setOnClickListener(new MainListener());
        btnback.setOnClickListener(new MainListener());





    }


    class MainListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {


            switch (v.getId()) {
                case R.id.btn0:
                    tvScreen.append("0");
                    break;
                case R.id.btn1:
                    tvScreen.append("1");
                    break;
                case R.id.btn2:
                    tvScreen.append("2");
                    break;
                case R.id.btn3:
                    tvScreen.append("3");
                    break;
                case R.id.btn4:
                    tvScreen.append("4");
                    break;
                case R.id.btn5:
                    tvScreen.append("5");
                    break;
                case R.id.btn6:
                    tvScreen.append("6");
                    break;
                case R.id.btn7:
                    tvScreen.append("7");
                    break;
                case R.id.btn8:
                    tvScreen.append("8");
                    break;
                case R.id.btn9:
                    tvScreen.append("9");
                    break;
                case R.id.btnpoint:
                    tvScreen.append(".");
                    break;
                case R.id.btnadd:
                    double x = Double.parseDouble(tvScreen.getText().toString());
                    items.add(new Item(x, Types.num));
                    CheckTAndComputer1();
                    items.add(new Item(0, Types.add));
                    tvScreen.setText("");
                    break;
                case R.id.btnsub:
                    items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Types.num));
                    CheckTAndComputer1();
                    items.add(new Item(0, Types.sub));
                    tvScreen.setText("");
                    break;
                case R.id.btnmul:
                    items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Types.num));
                    CheckTAndComputer1();
                    items.add(new Item(0, Types.mul));
                    tvScreen.setText("");
                    break;
                case R.id.btndiv:
                    items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Types.num));
                    CheckTAndComputer1();
                    items.add(new Item(0, Types.div));
                    tvScreen.setText("");
                    break;
                case R.id.btnresult:
                    items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Types.num));
                    CheckTAndComputer1();
                    tvScreen.setText(items.get(0).value + "");
                    items.clear();
                    break;
                case R.id.btnclear:
                    tvScreen.setText("");
                    items.clear();
                    break;
                case R.id.btnback:

                    String str=tvScreen.getText().toString();
                    if(str.length()>=1){
                        tvScreen.setText(str.substring(0,str.length()-1));
                    }
                    break;

            }

        }

    }

    public void CheckTAndComputer1(){
        if(items.size()>=3){
            double a=items.get(0).value;
            double b=items.get(2).value;
            int opt=items.get(1).type;

            items.clear();
            switch (opt){
                case Types.add:
                    items.add(new Item(a+b,Types.num));
                    break;
                case Types.sub:
                    items.add(new Item(a-b,Types.num));
                    break;
                case Types.mul:
                    items.add(new Item(a*b,Types.num));
                    break;
                case Types.div:
                    items.add(new Item(a/b,Types.num));
                    break;
            }
        }
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
                Intent intent=new Intent(MainActivity.this,ScienceActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.Simple:
                break;
            case R.id.Angle:
                Intent intent3=new Intent(MainActivity.this,AnglechangeActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.Temperature:
                Intent intent4=new Intent(MainActivity.this,TemperaturechangeActivity.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.Sys:
                Intent intent5=new Intent(MainActivity.this,SyschangeActivity.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.Date:
                Intent intent6=new Intent(MainActivity.this,DateCaluActivity.class);
                startActivity(intent6);
                finish();
                break;
            case R.id.Help:
                Intent intent7=new Intent(MainActivity.this,HelpActivity.class);
                startActivity(intent7);
                finish();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

}