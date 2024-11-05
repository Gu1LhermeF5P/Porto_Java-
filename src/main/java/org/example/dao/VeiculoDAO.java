package org.example.dao;


import org.example.ConnectionFactory.CriarConexaoBD;
import org.example.model.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VeiculoDAO {

    Connection conn;

    public VeiculoDAO() {
        this.conn = CriarConexaoBD.pegarConexao();
    }

    private final String SQL_GET_ALL = "SELECT * FROM tbl_veiculos WHERE ROWNUM <= 10";
    private final String SQL_DELETE_WHERE = "DELETE FROM tbl_veiculos WHERE placa = ?";

    private final String SQL_SELECT_WHERE = "SELECT * FROM tbl_veiculos WHERE placa = ?";

    private final String SQL_UPDATE_WHERE = "UPDATE tbl_veiculos SET placa = ?, modelo = ?, marca = ?, ano = ? WHERE placa = ?";

    public List<Veiculo> buscarTodos() throws SQLException {
        List<Veiculo> lVeiculos = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL_GET_ALL);
        while (rs.next()) {
            Veiculo v = new Veiculo(
                    rs.getString("placa"),
                    rs.getString("modelo"),
                    rs.getString("marca"),
                    rs.getInt("ano")
            );
            lVeiculos.add(v);
        }
        return lVeiculos;
    }


    public void deletaVeiculo(String placa) throws SQLException {
        try(PreparedStatement ps = conn.prepareStatement(SQL_DELETE_WHERE)){
            ps.setString(1, placa);
            ps.executeUpdate();

        }
    }

    public Veiculo buscaVeiculo(String placa) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT_WHERE)){
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            Veiculo v = null;
            while (rs.next()){
                v = new Veiculo(rs.getString("placa"),
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getInt("ano")
                );
            }
            return v;
        }
    }

    public Integer editaVeiculo(String placa, Veiculo veiculo) throws SQLException{
        try(PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_WHERE)){
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getModelo());
            ps.setString(3, veiculo.getMarca());
            ps.setInt(4, veiculo.getAno());
            ps.setString(5, placa);
            ps.executeUpdate();
            return (ps.executeUpdate());
        }
    }

}


