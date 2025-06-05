package data;

import com.mysql.cj.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAO {

    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atelie_organizerdb", "root", "1234");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }
    
     public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {

        }
    }
    
    
    public Usuario consultar (String id){
        try {
          Usuario usuario = new Usuario();
          st = conn.prepareCall("SELECT * FROM usuario FROM id = ?");
          st.setString(1, id);
          rs = st.executeQuery();
          
            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setNivel(rs.getString("nivel"));
                return usuario;
                
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
        
    }
    
   public static Usuario validarUsuario(Usuario u) {
        return null;
    }
   
   public boolean existeUsuario (String user) throws SQLException{
       String sql = "select count(*) from usuario where nome = ?";
       st = conn.prepareStatement(sql);
       st.setString(1, user);
       rs = st.executeQuery();
       rs.next();
       int count = rs.getInt(1);
       return  count > 0;
              
   }
   
   public boolean validarLogin (String nome, String senha) throws SQLException{
       String sql = "select senha from usuario where nome = ?";
       st = conn.prepareStatement(sql);
       st.setString(1, nome);
       rs = st.executeQuery();
       if(rs.next()){
           String password = rs.getString("senha");
           return senha.equals(password);
       }else{
           return  false;
       }
       
   }

}
