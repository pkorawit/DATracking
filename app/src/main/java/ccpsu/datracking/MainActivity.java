package ccpsu.datracking;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ccpsu.datracking.databinding.ActivityMainBinding;
import ccpsu.datracking.model.ItemTracking;
import ccpsu.datracking.restapi.ItemTrackingAPI;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<ItemTracking> {

    String scannedCode;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scan();
            }
        });



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

    public void scan(){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            scannedCode = intent.getStringExtra("SCAN_RESULT");
            getDAItemDetail(scannedCode);
        }
        else{
            scannedCode = "";
        }
    }

    public void getDAItemDetail(String code){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://datracking.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        ItemTrackingAPI restAPI = retrofit.create(ItemTrackingAPI.class);

        Call<ItemTracking> call = restAPI.getTrackingInfo(code);

        //asynchronous call
        call.enqueue(this);

    }

    @Override
    public void onResponse(Response<ItemTracking> response, Retrofit retrofit)  {
        if(response.body() != null) {
            binding.setItem(response.body());
            Toast.makeText(MainActivity.this, response.body().getItemID(), Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Not found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

}
