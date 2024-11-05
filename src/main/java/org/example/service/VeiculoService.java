package org.example.service;


import org.example.dao.VeiculoDAO;
import org.example.model.Veiculo;

import java.sql.SQLException;
import java.util.List;

public class VeiculoService {

    VeiculoDAO vd = new VeiculoDAO();

    public List<Veiculo> buscarTodos() throws SQLException {
        return vd.buscarTodos();
    }

    public void deletaVeiculo(String placa) throws SQLException{
        vd.deletaVeiculo(placa);
    }

    public Veiculo buscaVeiculo(String placa) throws SQLException {
        return vd.buscaVeiculo(placa);
    }

    public Integer editaVeiculo(String placa, Veiculo veiculo) throws SQLException {
        return vd.editaVeiculo(placa, veiculo);
    }
}
