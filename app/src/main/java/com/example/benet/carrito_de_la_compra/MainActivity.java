package com.example.benet.carrito_de_la_compra;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    public void ocultarTeclado(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void resetear(View vista){

        EditText unidades1=(EditText)findViewById(R.id.txtp1);
        EditText univalor1=(EditText)findViewById(R.id.txtp2);

        EditText unidades2=(EditText)findViewById(R.id.txtp3);
        EditText univalor2=(EditText)findViewById(R.id.txtp4);

        TextView labelR=(TextView)findViewById(R.id.txtResult);

        unidades1.setText("");
        univalor1.setText("");
        unidades2.setText("");
        univalor2.setText("");
        labelR.setText("");

        ocultarTeclado(vista);

    }
    public void calcular(View vista){

        EditText unidades1=(EditText)findViewById(R.id.txtp1);
        EditText univalor1=(EditText)findViewById(R.id.txtp2);
        EditText unidades2=(EditText)findViewById(R.id.txtp3);
        EditText univalor2=(EditText)findViewById(R.id.txtp4);

        if(unidades1.getText().toString().length()!=0 && univalor1.getText().toString().length()!=0 &&
           unidades2.getText().toString().length()!=0 &&univalor2.getText().toString().length()!=0){
            float a=(Integer.parseInt(unidades1.getText().toString())*(Float.parseFloat(univalor1.getText().toString())));
            float b=(Integer.parseInt(unidades2.getText().toString())*(Float.parseFloat(univalor2.getText().toString())));
            float suma=a+b;
            TextView labelR=(TextView)findViewById(R.id.txtResult);
            labelR.setText(suma+" €");
            Toast.makeText(this, R.string.txtIncrementT, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, R.string.txtIncrementF, Toast.LENGTH_LONG).show();
        }

        ocultarTeclado(vista);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
