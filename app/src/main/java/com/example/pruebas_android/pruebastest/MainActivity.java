package com.example.pruebas_android.pruebastest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText() != null && !editText.getText().toString().isEmpty()) {
                    request(editText.getText().toString());
                }
            }
        });
    }

    private void request(String key) {
        Api apiService =
                ApiClient.getClient().create(Api.class);
        Call<ModelDataResponse> call = apiService.getNews(key);
        call.enqueue(new Callback<ModelDataResponse>() {
            @Override
            public void onResponse(Call<ModelDataResponse> call, Response<ModelDataResponse> response) {
                if (response.isSuccessful()) {
                    Log.i("MainActivity", "Response: " + response.body().toString());
                    String location1 = response.body().getLstCordenadasServicio().get(0).getLatitud() + "," + response.body().getLstCordenadasServicio().get(0).getLongitud();
                    String location2 = response.body().getLstCordenadasServicio().get(1).getLatitud() + "," + response.body().getLstCordenadasServicio().get(1).getLongitud();
                    String center = TextUtils.join(", ",response.body().getRecorrido());
                    startSecondActivity(location1, center, location2);
                }
                Log.e("MainActivity", "ResponseCode: " + response.code());
            }

            @Override
            public void onFailure(Call<ModelDataResponse> call, Throwable t) {
                // Log error here since request failed
            }
        });
    }

    private void startSecondActivity(String location1, String center, String location2) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("location1", location1);
        intent.putExtra("recorrido", center);
        intent.putExtra("location2", location2);
        startActivity(intent);
    }

}
