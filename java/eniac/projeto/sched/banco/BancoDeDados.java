package eniac.projeto.sched.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import eniac.projeto.sched.model.Usuario;

public class BancoDeDados extends SQLiteOpenHelper {

    private static final String dbName = "db_sched";
    private static final int dbVersao = 1;
    private static final String tbName = "usuarios";
    private static final String coluna_codigo = "codigo";
    private static final String coluna_nome = "nome";
    private static final String coluna_senha = "senha";
    private static final String coluna_usuario = "usuario";

    public BancoDeDados(Context context) {
        super(context, dbName, null, dbVersao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qr_coluna  = "CREATE TABLE " + tbName + "(" + coluna_codigo + " INTEGER PRIMARY KEY, " +
                coluna_nome + " TEXT, " + coluna_senha +  " TEXT, " + coluna_usuario +  " TEXT)";
        db.execSQL(qr_coluna);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

     public void adicionarUsuario(Usuario usr){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues vr = new ContentValues();
        vr.put(coluna_nome, usr.getNome());
        vr.put(coluna_senha, usr.getSenha());
        vr.put(coluna_usuario, usr.getUsuario());
        db.insert(tbName,null, vr);
        db.close();
    }
    public Usuario selecionar(Usuario usr){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.query(tbName, new String[] {coluna_codigo, coluna_nome}, coluna_usuario +" = ?" + " AND "+ coluna_senha + " = ?",
                new String[] {String.valueOf(usr.getUsuario()), String.valueOf(usr.getSenha())}, null, null, null, null);
        if (cr != null){
            cr.moveToFirst();
        }
        Usuario usuario = new Usuario(Integer.parseInt(cr.getString(0)), cr.getString(1));
        return usuario;
    }
}