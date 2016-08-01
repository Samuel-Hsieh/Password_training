package samuel_hsieh.deerlight.com.password_training;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button one_btn,two_btn,three_btn,four_btn,five_btn,six_btn,seven_btn,eight_btn,nine_btn,zero_btn
    ,clear_btn,back_btn;
    ImageView first_Image,second_Image,third_Image,four_Image;
    private Database DH = null;
    private String[] pwd = {"_password"};
    private String pwd_temp = "dirq";//預設dirq
    private String password="";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openDB();
        sharedPreferences = getSharedPreferences("Userdata",MODE_PRIVATE);
        if(isChecked()==false){ //確認是否有寫入密碼,有:true並且設定CheckBox為true
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Setting_activity.class);
            startActivity(intent);
            finish();
        }
        Declare();
        one_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.length()<4) {
                    password = password + "1";
                }
                changeIcon();
                isPwdＣorrect();
            }
        });
        two_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.length()<4) {
                    password = password + "2";
                }
                changeIcon();
                isPwdＣorrect();
            }
        });
        three_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.length()<4) {
                    password = password + "3";
                }
                changeIcon();
                isPwdＣorrect();
            }
        });
        four_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.length()<4) {
                    password = password + "4";
                }
                changeIcon();
                isPwdＣorrect();
            }
        });
        five_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.length()<4) {
                    password = password + "5";
                }
                changeIcon();
                isPwdＣorrect();
            }
        });
        six_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.length()<4) {
                    password = password + "6";
                }
                changeIcon();
                isPwdＣorrect();
            }
        });
        seven_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.length()<4) {
                    password = password + "7";
                }
                changeIcon();
                isPwdＣorrect();
            }
        });
        eight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.length()<4) {
                    password = password + "8";
                }
                changeIcon();
                isPwdＣorrect();
            }
        });
        nine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.length()<4) {
                    password = password + "9";
                }
                changeIcon();
                isPwdＣorrect();
            }
        });
        zero_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.length()<4) {
                    password = password + "0";
                }
                changeIcon();
                isPwdＣorrect();
            }
        });
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.length()>0) {
                    password = password.subSequence(0, password.length() - 1).toString();
                    switch (password.length()){
                        case 3:
                            four_Image.setBackgroundResource(R.mipmap.ic_launcher);
                            break;
                        case 2:
                            third_Image.setBackgroundResource(R.mipmap.ic_launcher);
                            break;
                        case 1:
                            second_Image.setBackgroundResource(R.mipmap.ic_launcher);
                            break;
                        case 0:
                            first_Image.setBackgroundResource(R.mipmap.ic_launcher);
                            break;
                    }
                }
            }
        });
    }
    //判斷密碼是否正確
    public void isPwdＣorrect(){
        if(password.equals(get_pwd())){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, Setting_activity.class);
            startActivity(intent);
            finish();
        }
        else{
            if(password.length() == 4) {
                Toast.makeText(MainActivity.this, "密碼錯誤", Toast.LENGTH_SHORT).show();
            }
        }
    }
    //改變密碼圖示
    private void changeIcon(){
        switch (password.length()){
            case 1:
                first_Image.setBackgroundResource(R.drawable.ic_test);
                break;
            case 2:
                second_Image.setBackgroundResource(R.drawable.ic_test);
                break;
            case 3:
                third_Image.setBackgroundResource(R.drawable.ic_test);
                break;
            case 4:
                four_Image.setBackgroundResource(R.drawable.ic_test);
                break;
        }
    }
    //清除資料
    private void clear(){
        password = "";
        first_Image.setBackgroundResource(R.mipmap.ic_launcher);
        second_Image.setBackgroundResource(R.mipmap.ic_launcher);
        third_Image.setBackgroundResource(R.mipmap.ic_launcher);
        four_Image.setBackgroundResource(R.mipmap.ic_launcher);
    }
    //取得資料庫的密碼
    private String get_pwd(){
        SQLiteDatabase db = DH.getReadableDatabase();
        Cursor cursor;
        cursor = db.query("password",pwd,null, null, null, null, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) { //資料表有東西(有建立密碼)
            pwd_temp= cursor.getString(0);
        }
        return pwd_temp;
    }
    private void Declare(){
        one_btn = (Button)findViewById(R.id.one_btn);
        two_btn = (Button)findViewById(R.id.two_btn);
        three_btn = (Button)findViewById(R.id.three_btn);
        four_btn = (Button)findViewById(R.id.four_btn);
        five_btn = (Button)findViewById(R.id.five_btn);
        six_btn = (Button)findViewById(R.id.six_btn);
        seven_btn = (Button)findViewById(R.id.seven_btn);
        eight_btn = (Button)findViewById(R.id.eight_btn);
        nine_btn = (Button)findViewById(R.id.nine_btn);
        zero_btn = (Button)findViewById(R.id.zero_btn);
        clear_btn = (Button)findViewById(R.id.clear_btn);
        back_btn = (Button)findViewById(R.id.back_btn);
        first_Image = (ImageView)findViewById(R.id.first_Image);
        second_Image = (ImageView)findViewById(R.id.second_Image);
        third_Image = (ImageView)findViewById(R.id.third_Image);
        four_Image = (ImageView)findViewById(R.id.four_Image);
    }
    //確認isChecked的狀態值
    private Boolean isChecked(){
        Boolean CheckBoxisChecked = sharedPreferences.getBoolean("isChecked",false);
        return CheckBoxisChecked;
    }
    //開啟資料庫(副程式)
    private void openDB() {
        Log.i("success", "openDB");
        DH = new Database(this);
    }
    //關閉資料庫(副程式)
    private void closeDB(){
        DH.close();
    }
    //OnDestory
    @Override
    protected void onDestroy() {
        closeDB();
        super.onDestroy();
    }
}
