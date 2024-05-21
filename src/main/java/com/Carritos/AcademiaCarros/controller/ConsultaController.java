package com.Carritos.AcademiaCarros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    @Qualifier("mysqlDatasource")
    DataSource mysqlDS;
    
    @Autowired
    @Qualifier("mysql2Datasource")
    DataSource mysqlDS2;

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/consulta1")
    public String obtenerEstudiantesEnCategoria() throws SQLException {
        List<Map<String, Object>> resultados = new ArrayList<>();
        String query = "SELECT cea2.matriculados.ID_matriculado, cea2.matriculados.ID_cliente, cea2.categoria.nombre_categoria " +
                "FROM cea2.matriculados " +
                "JOIN cea2.categoria ON cea2.matriculados.ID_categoria = cea2.categoria.ID_categoria " +
                "WHERE cea2.categoria.nombre_categoria = 'A1'";
        try (Connection connection = mysqlDS2.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Obtener los nombres de las columnas
            List<String> columnNames = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                Map<String, Object> fila = new LinkedHashMap<>();
                for (String columnName : columnNames) {
                    fila.put(columnName, resultSet.getObject(columnName));
                }
                resultados.add(fila);
            }
            // Crear un mapa que contenga tanto los nombres de las columnas como los datos
            Map<String, Object> dataMap = new LinkedHashMap<>();
            dataMap.put("columnNames", columnNames);
            dataMap.put("data", resultados);
            // Convertir el mapa a JSON
            return objectMapper.writeValueAsString(dataMap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // Implementar métodos similares para las otras consultas
}
