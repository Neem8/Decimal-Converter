import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite extends SQLiteOpenHelper {
    public sqlite(Context context) {
        super(context, "db.db", null, 1);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table registeration(username text,email text,password text)");
    }


    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists registeration");
    }
}
