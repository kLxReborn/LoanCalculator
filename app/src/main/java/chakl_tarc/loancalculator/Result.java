package chakl_tarc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Result extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Get extra value
        //getIntent() method = asking "who called me?"
        Intent intent = getIntent();

        String status = intent.getStringExtra(Main.LOANSTATUS);

        //For numerical data, a default value must be provided
        //double repayment = intent.getDoubleExtra("repayment", 0);
    }

    public void closeActivity(View view)
    {
        finish();
    }

}
