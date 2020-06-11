package Factory;

public class FactoryConexionDB {

    public static final int MySql = 1;
    public static String[] confMySQL = {"bd_inventario", "root", ""};

    public static ConexionDB open(int tipoDB) {
        switch (tipoDB) {
            case FactoryConexionDB.MySql:
                return new MysqlConexionFactory(confMySQL);
            default:
                return null;
        }

    }

}
