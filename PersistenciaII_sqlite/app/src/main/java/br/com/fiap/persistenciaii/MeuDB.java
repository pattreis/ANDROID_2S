package br.com.fiap.persistenciaii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MeuDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MeuDB";
    public static final int VERSION = 1;
    public static final String TB_CLIENTE = "cliente";

    public MeuDB(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TB_CLIENTE + " (" +
                "`id`INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "`nome`TEXT NOT NULL" +
                ")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertCliente(Cliente cliente) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", cliente.getNome());
        db.insert(TB_CLIENTE, null, cv);
    }

    public void updateCliente(Cliente cliente) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", cliente.getId());
        cv.put("nome", cliente.getNome());
        db.update(
                TB_CLIENTE,
                cv,
                "id = ?",
                new String[] {String.valueOf(cliente.getId())} );
    }

    public void deleteCliente(int id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        db.delete(
                TB_CLIENTE,
                "id = ?",
                new String[] {String.valueOf(id)}
                );
    }

    public List<Cliente> getAllClientes() {

        List<Cliente> clientes = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                TB_CLIENTE,
                new String[] {"id", "nome"},
                null,
                null,
                null,
                null,
                "nome ASC"
        );

        while (cursor.moveToNext()) {
            Cliente cliente = new Cliente();
            cliente.setId(cursor.getInt(0));
            cliente.setNome(cursor.getString(1));
            clientes.add(cliente);
        }

        cursor.close();
        return clientes;
    }

}
