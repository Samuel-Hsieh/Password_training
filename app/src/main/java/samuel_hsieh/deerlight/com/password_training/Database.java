package samuel_hsieh.deerlight.com.password_training;

/**
 * Created by samuel_hsieh on 15/9/19.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private final static int _DBVersion = 1; //版本
    private final static String _DBName = "data.db";  //資料庫名稱
    private final static String _Password = "password"; //資料表名稱(密碼)
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context, name, factory, version);
    }
    public Database(Context context) {
        this(context, _DBName, null, _DBVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        final String password = "CREATE TABLE IF NOT EXISTS "+ _Password + "( " +
                "_password VARCHAR(12) NOT NULL"+");";
        db.execSQL(password);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        final String password = "DROP TABLE " + _Password;
        db.execSQL(password);
    }
}
