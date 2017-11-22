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

public class DateCaluActivity extends AppCompatActivity {

    EditText monthStart, monthEnd, dayStart, dayEnd, yearStart, yearEnd;
    Button calculate;
    TextView resultText;

    private String mS, mE;
    private int dS, dE, yS, yE, years_passed, days_passed;

    private String months[] = {"january", "february", "march", "april", "may", "june", "july","august", "september", "october", "november", "december"};
    private int monthKeys[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        monthStart = (EditText)findViewById(R.id.monthStart);
        dayStart = (EditText)findViewById(R.id.dayStart);
        yearStart = (EditText)findViewById(R.id.yearStart);

        monthEnd = (EditText)findViewById(R.id.monthEnd);
        dayEnd = (EditText)findViewById(R.id.dayEnd);
        yearEnd = (EditText)findViewById(R.id.yearEnd);

        calculate = (Button)findViewById(R.id.btnCalculate);
        resultText = (TextView)findViewById(R.id.txtResult);

    }

    public void calculateDate(View v){
        mS = monthStart.getText().toString().toLowerCase();
        mE = monthEnd.getText().toString().toLowerCase();

        dS = Integer.parseInt(dayStart.getText().toString());
        dE = Integer.parseInt(dayEnd.getText().toString());

        yS = Integer.parseInt(yearStart.getText().toString());
        yE = Integer.parseInt(yearEnd.getText().toString());

        int monthStart = findMonthKey(mS);
        int monthEnd = findMonthKey(mE);

        years_passed = calculateYears(monthStart, monthEnd);
        days_passed = calculateDays(monthStart, monthEnd, dS, dE);

        if (days_passed == 365)
        {
            years_passed++;
            days_passed = 0;
        }

        if (monthStart != 0 && monthEnd != 0 && (dS <= 31 && dS > 0) && (dE <= 31 && dE > 0) && (yE >= yS))
        {
            resultText.setText("" + years_passed + " years, " + days_passed + " days.");
        }
        else if (yE < yS)
        {
//            int years_ago = Math.abs(years_passed) - 1;
//            int days_ago = 365 - days_passed;
//
//            if (days_ago == 365)
//            {
//                years_ago++;
//                days_ago = 0;
//            }
//
//            resultText.setText("" + years_ago + " years, " + days_ago + " days ago.");

            resultText.setText("Can't calculate backwards!");
        }
        else if (monthStart == 0 || monthEnd == 0)
        {
            resultText.setText("Invalid entry in month!");
        }
        else if (dS > 31 || dE > 31)
        {
            resultText.setText("No more than 31 days!");
        }
        else if (dS <= 0 || dE <= 0)
        {
            resultText.setText("Date must be larger than 0!");
        }
    }


    public int calculateYears(int s, int e)
    {
        int y = 0;

        if (s < e)
        {
            y = yE - yS;
        }
        else if (s > e)
        {
            y = yE - yS - 1;
        }
        else if (s == e)
        {
            if (dE < dS)
            {
                y = yE - yS - 1;
            }
            else
            {
                y = yE - yS;
            }
        }

        return y;
    }

    public int calculateDays(int s, int e, int dS, int dE)
    {
        int d = 0;

        if (s < e)
        {
            for (int i = 0; i < monthDays.length; i++)
            {
                if (monthKeys[i] == s)
                {
                    d = d + (monthDays[i] - dS);
                }
                else if (monthKeys[i] > s && monthKeys[i] < e)
                {
                    d = d + monthDays[i];
                }
                else if (monthKeys[i] == e)
                {
                    d = d + dE;
                }
            }
        }
        else if (e < s)
        {
            int days_passed_A = 0;

            for (int i = 0; i < monthDays.length; i++)
            {
                if (monthKeys[i] == s)
                {
                    d = d + (monthDays[i] - dS);
                }
                else if (monthKeys[i] > s)
                {
                    d = d + (monthDays[i]);
                }
            }

            for (int i = 0; i < monthDays.length; i++)
            {
                if (monthKeys[i] == e)
                {
                    days_passed_A = days_passed_A + dE;
                }
                else if (monthKeys[i] < e)
                {
                    days_passed_A = days_passed_A + monthDays[i];
                }
            }

            d = d + days_passed_A;
        }
        else if (e == s)
        {
            if (dE >= dS)
            {
                d = d + (Math.abs(dE - dS));
            }
            else
            {
                d = d + (365 - Math.abs(dE - dS));
            }

        }

        return d;
    }

    public int findMonthKey(String m)
    {
        int key = 0;
        System.out.println(m);

        for (int i = 0; i < monthKeys.length; i++)
        {
            if (m.equals(months[i]))
            {
                key = monthKeys[i];
                return key;
            }
        }

        return 0;
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
                Intent intent=new Intent(DateCaluActivity.this,ScienceActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.Simple:
                Intent intent2=new Intent(DateCaluActivity.this,MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.Angle:
                Intent intent3=new Intent(DateCaluActivity.this,AnglechangeActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.Temperature:
                Intent intent4=new Intent(DateCaluActivity.this,TemperaturechangeActivity.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.Sys:
                Intent intent5=new Intent(DateCaluActivity.this,SyschangeActivity.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.Date:
                break;
            case R.id.Help:
                Intent intent7=new Intent(DateCaluActivity.this,HelpActivity.class);
                startActivity(intent7);
                finish();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

}
