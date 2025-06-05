
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesDAO {
    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atelie_organizerdb", "root", "1234");
            return true;
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return  false;
        }
    }
    
     public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {

        }
    }
    
    public int salvar(Clientes clientes){
        int status;
        try {
            st = conn.prepareStatement("insert into clientes values(?,?,?,?)");
            
            st.setString(1, clientes.getId());
            st.setString(2, clientes.getNome());
            st.setString(3, clientes.getEndereco());
            st.setString(4, clientes.getTelefone());
            
            status = st.executeUpdate();
            return status;
          
            
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return e.getErrorCode();
        }
    }
    
}
