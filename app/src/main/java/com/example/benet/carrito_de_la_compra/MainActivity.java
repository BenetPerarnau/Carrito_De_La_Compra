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

    EditText unidades1, univalor1,unidades2,univalor2;
    TextView labelR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        unidades1=(EditText)findViewById(R.id.txtp1);
        univalor1=(EditText)findViewById(R.id.txtp2);
        unidades2=(EditText)findViewById(R.id.txtp3);
        univalor2=(EditText)findViewById(R.id.txtp4);
        labelR=(TextView)findViewById(R.id.txtResult);

    }

    public void ocultarTeclado(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void resetear(View vista){

        unidades1.setText("");
        univalor1.setText("");
        unidades2.setText("");
        univalor2.setText("");
        labelR.setText("");

        ocultarTeclado(vista);

    }
    public void calcular(View vista){
        try {
        if(unidades1.getText().toString().length()!=0 && univalor1.getText().toString().length()!=0 &&
           unidades2.getText().toString().length()!=0 &&univalor2.getText().toString().length()!=0){//todo esta relleno

                float a = (Integer.parseInt(unidades1.getText().toString()) * (Float.parseFloat(univalor1.getText().toString())));
                float b = (Integer.parseInt(unidades2.getText().toString()) * (Float.parseFloat(univalor2.getText().toString())));
                float suma = a + b;
                labelR.setText(suma + " €");
                Toast.makeText(this, R.string.txtIncrementTrue, Toast.LENGTH_LONG).show();


        }else if(unidades1.getText().toString().length()!=0 && univalor1.getText().toString().length()!=0){//se puede calcular el producto 1

            float r=(Integer.parseInt(unidades1.getText().toString())*(Float.parseFloat(univalor1.getText().toString())));
            labelR.setText(r+" €");
            Toast.makeText(this, R.string.txtIncrementTrue, Toast.LENGTH_LONG).show();

        }else if(unidades2.getText().toString().length()!=0 &&univalor2.getText().toString().length()!=0){//se puede calcular el producto 2

            float r=(Integer.parseInt(unidades2.getText().toString())*(Float.parseFloat(univalor2.getText().toString())));
            labelR.setText(r+" €");
            Toast.makeText(this, R.string.txtIncrementTrue, Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, R.string.txtIncrementFalse, Toast.LENGTH_LONG).show();
        }

        ocultarTeclado(vista);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
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
