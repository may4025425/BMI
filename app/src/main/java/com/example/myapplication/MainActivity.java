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
    TextView(為顯示文字內容：程式輸出）EditText（為輸入文字內容：程式輸入）

* 1.拉元件、調整大小置中...等設定
* 2.取得元件，提升為屬性，抽取方法->設定id
* 3.按鈕事件處理（匿名類別）：
*            ->1.取得畫面中的按鈕物件（使用findViewById），然後將他ID做更改，利用他的ID名字將它這個物件轉成屬性，最後取得這個元件的幾行程式碼，將它們抽取成為findViews方法）
*             －>2.為按鈕物件註冊事件傾聽器(使用浮動： Toast類別； 使用對話眶：AlertDialog類別）
*              －>3.在傾聽器的方法中實作程式碼
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

      /*  AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(bmi+"");//設定顯示文字//setMessage()記得選字串，然後(bmi+"")的語法是：能將bmi轉成string，因為Java的特性（當左右是字串時，會將整數轉成字串）
                builder.show();//顯示對話眶
      */

        new AlertDialog.Builder(this)

        .setMessage(bmi+"")//設定顯示文字
        .setPositiveButton("ok",null)
        .show();//顯示對話眶


    }

    public void help(View view){

        System.out.println("抱歉");


    }


}
