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

import java.util.Stack;

import static java.lang.Math.cos;
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.tan;

/**
 * Created by Administrator on 2017/9/13.
 */

public class ScienceActivity extends AppCompatActivity  {

    private Stack<Double> stacknum=null;
    private Stack<Character> stackopt=null;


    private TextView tvScreen;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);


        tvScreen = (TextView) findViewById(R.id.tvscreenScience);

        Button btn0= (Button) findViewById(R.id.btn0s);
        Button btn1= (Button) findViewById(R.id.btn1s);
        Button btn2= (Button) findViewById(R.id.btn2s);
        Button btn3= (Button) findViewById(R.id.btn3s);
        Button btn4= (Button) findViewById(R.id.btn4s);
        Button btn5= (Button) findViewById(R.id.btn5s);
        Button btn6= (Button) findViewById(R.id.btn6s);
        Button btn7= (Button) findViewById(R.id.btn7s);
        Button btn8= (Button) findViewById(R.id.btn8s);
        Button btn9= (Button) findViewById(R.id.btn9s);
        Button btnadd= (Button) findViewById(R.id.btnadds);
        Button btnsub= (Button) findViewById(R.id.btnsubs);
        Button btnmul= (Button) findViewById(R.id.btnmuls);
        Button btndiv= (Button) findViewById(R.id.btndivs);
        Button btnpoint= (Button) findViewById(R.id.btnpoints);
        Button btnclear= (Button) findViewById(R.id.btnclears);
        Button btnresult= (Button) findViewById(R.id.btnresults);
        Button btnback= (Button) findViewById(R.id.btnbacks);
        Button btnLeftHalf= (Button) findViewById(R.id.btnLeftHalf);
        Button btnRightHalf= (Button) findViewById(R.id.btnRightHalf);
        Button btnpai = (Button) findViewById(R.id.btnpai);
        Button btne= (Button) findViewById(R.id.btne);
        Button btnsin= (Button) findViewById(R.id.btnsin);
        Button btncos= (Button) findViewById(R.id.btncos);
        Button btntan= (Button) findViewById(R.id.btntan);
        Button btnln= (Button) findViewById(R.id.btnln);
        Button btnlog= (Button) findViewById(R.id.btnlog);


        btn0.setOnClickListener(new ScienceListener());
        btn1.setOnClickListener(new ScienceListener());
        btn2.setOnClickListener(new ScienceListener());
        btn3.setOnClickListener(new ScienceListener());
        btn4.setOnClickListener(new ScienceListener());
        btn5.setOnClickListener(new ScienceListener());
        btn6.setOnClickListener(new ScienceListener());
        btn7.setOnClickListener(new ScienceListener());
        btn8.setOnClickListener(new ScienceListener());
        btn9.setOnClickListener(new ScienceListener());
        btnadd.setOnClickListener(new ScienceListener());
        btnsub.setOnClickListener(new ScienceListener());
        btnmul.setOnClickListener(new ScienceListener());
        btndiv.setOnClickListener(new ScienceListener());
        btnpoint.setOnClickListener(new ScienceListener());
        btnclear.setOnClickListener(new ScienceListener());
        btnresult.setOnClickListener(new ScienceListener());
        btnback.setOnClickListener(new ScienceListener());
        btnLeftHalf.setOnClickListener(new ScienceListener());
        btnRightHalf.setOnClickListener(new ScienceListener());
        btnpai.setOnClickListener(new ScienceListener());
        btne.setOnClickListener(new ScienceListener());
        btnsin.setOnClickListener(new ScienceListener());
        btncos.setOnClickListener(new ScienceListener());
        btntan.setOnClickListener(new ScienceListener());
        btnln.setOnClickListener(new ScienceListener());
        btnlog.setOnClickListener(new ScienceListener());


    }



    class ScienceListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn0s:
                    tvScreen.append("0");
                    break;
                case R.id.btn1s:
                    tvScreen.append("1");
                    break;
                case R.id.btn2s:
                    tvScreen.append("2");
                    break;
                case R.id.btn3s:
                    tvScreen.append("3");
                    break;
                case R.id.btn4s:
                    tvScreen.append("4");
                    break;
                case R.id.btn5s:
                    tvScreen.append("5");
                    break;
                case R.id.btn6s:
                    tvScreen.append("6");
                    break;
                case R.id.btn7s:
                    tvScreen.append("7");
                    break;
                case R.id.btn8s:
                    tvScreen.append("8");
                    break;
                case R.id.btn9s:
                    tvScreen.append("9");
                    break;
                case R.id.btnpoints:
                    tvScreen.append(".");
                    break;
                case R.id.btnbacks:
                    String str=tvScreen.getText().toString();
                    if(str.length()>=1)
                        tvScreen.setText(str.substring(0,str.length()-1));
                    break;
                case R.id.btnadds:
                    tvScreen.append("+");
                    break;
                case R.id.btnsubs:
                    tvScreen.append("-");
                    break;
                case R.id.btnmuls:
                    tvScreen.append("*");
                    break;
                case R.id.btndivs:
                    tvScreen.append("/");
                    break;
                case R.id.btnRightHalf:
                    tvScreen.append(")");
                    break;
                case R.id.btnLeftHalf:
                    tvScreen.append("(");
                    break;
                case R.id.btnpai:
                    tvScreen.append("pi");
                    break;
                case R.id.btne:
                    tvScreen.append("e");
                    break;
                case R.id.btnsin:
                    tvScreen.append("sin");
                    break;
                case R.id.btncos:
                    tvScreen.append("cos");
                    break;
                case R.id.btntan:
                    tvScreen.append("tan");
                    break;
                case R.id.btnlog:
                    tvScreen.append("log");
                    break;
                case R.id.btnln:
                    tvScreen.append("ln");
                    break;
                case R.id.btnclears:
                    tvScreen.setText("");
                    break;

                case R.id.btnresults:
                    tvScreen.append("=");
                    String str2=tvScreen.getText().toString();
                    double result=Calculator(str2);
                    tvScreen.setText(result+"");
                    break;


            }
        }
    }

    private double Calculator(String str){
//        if (str.length() > 1 && !"=".equals(str.charAt(str.length() - 1) + "")) {
//                         str += "=";
//        }
        double yuan1,yuan2;
        char sig;

        stacknum = new Stack<Double>();
        stackopt = new Stack<Character>();


        StringBuffer temp = new StringBuffer();

        for(int i=0;i<str.length();i++){
            char x=str.charAt(i);
            if((x>='0'&&x<='9')||x=='.'){
                //number in buffer
                temp.append(x);
            }else {
                String tempStr = temp.toString();
                if(!tempStr.isEmpty()){
                    double numtemp = Double.parseDouble(tempStr);
                    stacknum.push(numtemp);
                    temp = new StringBuffer();
                }

                //double number push
                if(x=='!'){
                    yuan1=stacknum.pop();
                    double num=1;
                    for(int k=1;k<=yuan1;k++)
                        num=num*k;
                    stacknum.push(num);

                }else if(x=='p'){
                    stacknum.push(3.1415);//change to jingquezhi
                    i++;
                }else if(x=='e'){
                    stacknum.push(2.71828);//change to jingquezhi
                }else if(x=='('){
                    stackopt.push(x);
                }else {
                    if (stackopt.empty()) {//empty pushopt
                    if (x == 'l' && str.charAt(i + 1) == 'o')
                        stackopt.push('l');
                    else if (x == 'l' && str.charAt(i + 1) == 'n')
                        stackopt.push('n');
                    else
                        stackopt.push(x);
                } else {//not empty
                    char temp1 = stackopt.peek();
                    char temp2;
                    if (x == 'l' && str.charAt(i + 1) == 'o')
                        temp2 = 'l';
                    else if (x == 'l' && str.charAt(i + 1) == 'n')
                        temp2 = 'n';
                    else temp2 = x;


                    //进行优先级比较
                    char p = Precede(temp1, temp2);
                    if (p == '<')
                        stackopt.push(temp2);
                    if (p == '>' || p == '=') {
                        char rep = p;
                        while ((rep == '>' || p == '=') && (!stackopt.empty())) {
                            sig = stackopt.pop();
                            yuan1 = stacknum.pop();
                            if (sig == '_' || sig == 's' || sig == 'c' || sig == 't' || sig == 'l' || sig == 'n') {
                                //若为前缀单目运算符
                                double tt;
                                tt = S_Operate(sig, yuan1);
                                stacknum.push(tt);
                                if(!stackopt.empty())
                                    temp1 = stackopt.peek();
                                rep = Precede(temp1, temp2);
                            } else {//双目运算符
                                yuan2 =stacknum.pop();
                                stacknum.push(D_Operate(yuan2, sig, yuan1));
                                if(!stackopt.empty())
                                    temp1 = stackopt.peek();
                                rep = Precede(temp1, temp2);
                            }
                        }

                        if (x == ')')//如果栈外符是右括号要把与之匹配的左括号弹出栈外
                            stackopt.pop();
                        else if (x == 'l' && str.charAt(i + 1) == 'o')
                            stackopt.push('l');
                        else if (x == 'l' && str.charAt(i + 1) == 'n')
                            stackopt.push('n');
                        else
                            stackopt.push(x);
                    }
                }
                if(x=='s'||x=='c'||x=='t'||(x=='l'&&str.charAt(i + 1)=='o'))
                    i=i+2;
                if(x=='l'&&str.charAt(i + 1)=='n')
                    i++;
            }
            }





        }
        return stacknum.pop();

    }

    private double D_Operate(double x, char op, double y) {
        double a = 0;
        switch(op){
            case'+': a=x+y;break;
            case'-': a=x-y;break;
            case'*': a=x*y;break;
            case'/': a=x/y;break;
            case'^': a=Math.pow(x,y);break;

        }
        return a;
    }

    private double S_Operate(char op, double x) {
        double a = 0;
        switch(op){
            case's': a=Math.sin(x);break;
            case'c': a=cos(x);break;
            case't': a=tan(x);break;
            case'l': a=log10(x);break;//以10为底的对数
            case'n': a=log(x);break;//以e（2.718281828）为底的对数
            case'_': a=-x;break;

        }
        return a;
    }

    private char Precede(char op1, char op2)    {
        if(((op1=='+'||op1=='-')&&(op2=='+'||op2=='-'||op2==')'||op2=='='))||
                ((op1=='*'||op1=='/')&&(op2=='+'||op2=='-'||op2=='*'||op2=='/'||op2==')'||op2=='='))
                ||(op1=='^'&&(op2=='+'||op2=='-'||op2=='*'||op2=='/'||op2==')'||op2=='='||op2=='s'||op2=='c'||op2=='t'||op2=='_'||op2=='l'||op2=='n'))
                ||((op1=='_'||op1=='s'||op1=='c'||op1=='t'||op1=='l'||op1=='n')&&(op2=='+'||op2=='-'||op2=='*'||op2=='/'||op2==')'||op2=='='||op2=='s'||op2=='c'||op2=='t'||op2=='_'||op2=='l'||op2=='n')))
        return '>';//上述情况下 栈顶运算符优先级高于待定运算符 需弹栈
        if((op1=='('&&op2==')')||(op1=='='&&op2=='='))
            return '=';
        else
            return '<';

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
                break;
            case R.id.Simple:
                Intent intent2=new Intent(ScienceActivity.this,MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.Angle:
                Intent intent3=new Intent(ScienceActivity.this,AnglechangeActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.Temperature:
                Intent intent4=new Intent(ScienceActivity.this,TemperaturechangeActivity.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.Sys:
                Intent intent5=new Intent(ScienceActivity.this,SyschangeActivity.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.Date:
                Intent intent6=new Intent(ScienceActivity.this,DateCaluActivity.class);
                startActivity(intent6);
                finish();
                break;
            case R.id.Help:
                Intent intent7=new Intent(ScienceActivity.this,HelpActivity.class);
                startActivity(intent7);
                finish();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

}
