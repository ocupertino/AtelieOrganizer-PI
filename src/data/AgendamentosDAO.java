package data;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentosDAO {

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
    
    public int salvar(Agendamentos agenda){
        int status;
        try {
            st = conn.prepareStatement("insert into agenda values(?,?,?,?,?,?)");
            
            st.setString(1, agenda.getId());
            st.setString(2, agenda.getNome());
            st.setString(3, agenda.getEndereco());
            st.setString(4, agenda.getTelefone());
            st.setString(5, agenda.getIdata());
            st.setString(6, agenda.getAnotacoes());
            status = st.executeUpdate();
            return status;
          
            
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return e.getErrorCode();
        }
    }
    
    
    public int atualizar(Agendamentos agen){
        int status;
        try{
            st = conn.prepareCall("update agenda set nomeCliente = ?, endereco = ?, telefone = ?, idata = ?, anotacoes = ?  where id = ?");
            
            st.setString(6, agen.getId());
            st.setString(1, agen.getNome());
            st.setString(2, agen.getEndereco());
            st.setString(3, agen.getTelefone());
            st.setString(4, agen.getIdata());
            st.setString(5, agen.getAnotacoes());
            
            status = st.executeUpdate();
            return status;
        }catch(SQLException ex){
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
     public Agendamentos consultar (String id){
        try {
            Agendamentos agendamentos = new Agendamentos();
            st = conn.prepareCall("select * from agenda where id = ?");
            st.setString(1, id);
            rs = st.executeQuery();
            
            if (rs.next()) {
                agendamentos.setId(rs.getString("id"));
                agendamentos.setNome(rs.getString("nome"));
                agendamentos.setEndereco(rs.getString("data"));
                agendamentos.setTelefone(rs.getString("endereço"));
                agendamentos.setIdata(rs.getString("celular"));
                
                return  agendamentos;
                
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }
    
    
    

    }
