package chakl_tarc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity
{

    private String status;
    private double totalLoan = 0;
    private double monthlyRepayment = 0;
    private double interestRate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Get extra value
        //getIntent() method = asking "who called me?"
        Intent intent = getIntent();

        status = intent.getStringExtra(Main.LOANSTATUS);

        if(status.equals("Approve"))
        {


            //For numerical data, a default value must be provided
            totalLoan = intent.getDoubleExtra(Main.TOTALLOAN, 0);
            monthlyRepayment = intent.getDoubleExtra(Main.MONTHLYPAYMENT, 0);
            interestRate = intent.getDoubleExtra(Main.TOTALINTEREST, 0);
        }
    }

    public void closeActivity(View view)
    {
        finish();
    }

}
