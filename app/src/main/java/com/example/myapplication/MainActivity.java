package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



/*筆記區（check重點）
* 1.拉元件、調整大小置中...等設定
* 2.取得元件，提升為屬性，抽取方法->設定id
* 3.
* 4.
*
* */

public class MainActivity extends AppCompatActivity {
    //區域變數轉成類別屬性時，利用快捷鍵他會自動幫你建成屬性在此
   private EditText edWeight;
   private EditText edHeight;
   private Button bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

         //EditText edWeight = findViewById(R.id.edit_weight); 這樣仍是oncreate方法中的區域變數
        //edWeight = findViewById(R.id.edit_weight);這樣才算是類別的屬性（field)

        findViews();


    }

    //本來得在oncreate取得多個元件會造成有點雜亂，所以可以利用快捷鍵直接將它變成一種（也就是抽取程式碼成為方法）
    // 方法如下：
    private void findViews() {
        edWeight = findViewById(R.id.edit_weight);
        edHeight = findViewById(R.id.edit_height);
        bHelp = findViewById(R.id.b_Help);
    }

    public void bmi(View v){
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight/(height*height);
        Log.d("bmi",String.valueOf(bmi));
        //Log.d("MainActivity","BMI"+bmi);也可以
        Toast.makeText(this,String.valueOf(bmi),Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(this)

                .setMessage(bmi+"");


    }

    public void help(View view){

        System.out.println("抱歉");


    }


}
