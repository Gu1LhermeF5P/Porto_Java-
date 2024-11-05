package org.example.service;

import org.example.dao.UsuarioDAO;
import org.example.model.Usuario;

import java.sql.SQLException;

public class UsuarioServices {
    static UsuarioDAO usuarioDAO = new UsuarioDAO();


    public static void cadastrarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.inserirUsuario(usuario);
    }
}

