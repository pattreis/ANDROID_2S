package nac04.fiap.com.br.leonardoejoao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Banco extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Banco";
    public static final int VERSION = 1;
    public static final String TB_CLIENTE = "cliente";

    public Banco(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE `" + TB_CLIENTE + "` ( " +
                "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "`nome` TEXT NOT NULL, " +
                "`email` TEXT NOT NULL, " +
                "`telefone` TEXT )";

        db.execSQL(sql);

        //
        // Dados Fictícios
        //
        db.execSQL("INSERT INTO " + TB_CLIENTE + " (nome, email, telefone) VALUES ('Maria Oliveira', 'maria@teste.com', '(11) 1111-1111')");
        db.execSQL("INSERT INTO " + TB_CLIENTE + " (nome, email, telefone) VALUES ('Lurdes da Silva', 'lurdes@teste.com', '(11) 2222-2222')");
        db.execSQL("INSERT INTO " + TB_CLIENTE + " (nome, email, telefone) VALUES ('Samuel de Souza', 'samuel@teste.com', '(11) 3333-3333')");
        db.execSQL("INSERT INTO " + TB_CLIENTE + " (nome, email, telefone) VALUES ('Sálvio da Costa', 'salvio@teste.com', '(11) 4444-4444')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public List<Cliente> getAll() {
        List<Cliente> clientes = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                TB_CLIENTE,
                new String[]{"id", "nome", "email", "telefone"},
                null,
                null,
                null,
                null,
                "nome ASC"
        );

        while ( cursor.moveToNext() ) {
            Cliente cliente = new Cliente();
            cliente.setId( cursor.getInt(0) );
            cliente.setNome( cursor.getString(1) );
            cliente.setEmail( cursor.getString(2) );
            cliente.setTelefone( cursor.getString(3) );

            clientes.add(cliente);
        }//while

        cursor.close();

        return clientes;
    }
}
