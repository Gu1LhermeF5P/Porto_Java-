package org.example.dao;

import org.example.ConnectionFactory.CriarConexaoBD;
import org.example.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conn;

    //    private Endereco endereco;
    public UsuarioDAO() {
        this.conn = CriarConexaoBD.pegarConexao();
    }

    private final String SQL_INSERT_CADASTRO = "INSERT INTO tbl_usuarios (email, nome) VALUES (?, ?)";



    public void inserirUsuario(Usuario usuario) throws SQLException {
        System.out.println("Cadastrando usuário...");
        try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT_CADASTRO)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getNome());
            ps.executeUpdate();
        }
    }  
}


