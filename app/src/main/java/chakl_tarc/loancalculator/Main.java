package chakl_tarc.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends AppCompatActivity
{

    public static final String LOANSTATUS = "Reject";
    public static final String TOTALINTEREST = "";
    public static final String TOTALLOAN = "";
    public static final String MONTHLYPAYMENT = "";


    private EditText editTextPrice;
    private EditText editTextSalary;
    private EditText editTextInterestRate;
    private EditText editTextDownpayment;
    private EditText editTextRepayment;

    private float vehiclePrice;
    private float salary;
    private float interestRate;
    private float repayment;
    private float downpayment;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
        editTextInterestRate = (EditText) findViewById(R.id.editTextInterestRate);
        editTextDownpayment = (EditText) findViewById(R.id.editTextDownpayment);
        editTextRepayment = (EditText) findViewById(R.id.editTextRepayment);
    }

    public void calculateRepayment(View view)
    {

        vehiclePrice = Float.parseFloat(editTextPrice.getText().toString());
        salary = Float.parseFloat(editTextSalary.getText().toString());
        interestRate = Float.parseFloat(editTextInterestRate.getText().toString());
        repayment = Float.parseFloat(editTextRepayment.getText().toString());
        downpayment = Float.parseFloat(editTextDownpayment.getText().toString());


        float totalInterest = (vehiclePrice - downpayment) * interestRate * (repayment/12);
        float totalLoan = (vehiclePrice - downpayment) + totalInterest;
        float monthlyPayment = totalLoan / repayment;

        Intent intent = new Intent(this, Result.class);

        if(monthlyPayment <= (salary*0.3))
        {
            intent.putExtra(LOANSTATUS, "Approve");
            intent.putExtra(TOTALINTEREST,totalInterest);
            intent.putExtra(TOTALLOAN,totalLoan);
            intent.putExtra(MONTHLYPAYMENT,monthlyPayment);

        }
        else
        {
            intent.putExtra(LOANSTATUS, "Reject");
        }

        startActivity(intent);
    }

}
