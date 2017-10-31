package chakl_tarc.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Main extends AppCompatActivity
{

    public static final String LOANSTATUS = "Reject";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateRepayment(View view)
    {
        Intent intent = new Intent(this, Result.class);
        intent.putExtra(LOANSTATUS, "Approve");
        startActivity(intent);
    }

}
