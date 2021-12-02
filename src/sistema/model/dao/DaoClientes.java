package sistema.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import sistema.model.dto.DtoClientes;
import sistema.model.interfaces.IDaoCliente;
import sistema.utils.conexion.ConexionDB;

public class DaoClientes implements IDaoCliente {

    private static final String SQL_READ = "SELECT * FROM consulta WHERE con_numero =?;";
    private static final ConexionDB conn = ConexionDB.saberConexion();

    @Override
    public boolean create(DtoClientes entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DtoClientes entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoClientes read(Integer id) {
        PreparedStatement ps;
        ResultSet res;
        DtoClientes clientes = null;
        try {
            ps = conn.getConn().prepareStatement(SQL_READ);
            ps.setInt(1, id);

            res = ps.executeQuery();

            while (res.next()) {
                clientes=  new DtoClientes(id, res.getInt(2),res.getString(3), res.getString(4),res.getString(5), res.getString(6) );
            }
            return clientes;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode()
                    + "\nError DaoClientes read:" + e.getMessage());
        } finally {
            conn.cerrarConexion();
        }

        return clientes;
    }

    @Override
    public List<DtoClientes> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
