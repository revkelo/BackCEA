package com.Carritos.AcademiaCarros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

    @GetMapping("/{id}")
	public String obtenerDatos(@PathVariable int id) throws SQLException {
		List<Map<String, Object>> resultados = new ArrayList<>();
		String query = "";
		switch (id) {
		case 1:
			query = "SELECT cea2.matriculados.ID_matriculado, cea2.matriculados.ID_cliente, cea2.categoria.nombre_categoria "
					+ "FROM cea2.matriculados "
					+ "JOIN cea2.categoria ON cea2.matriculados.ID_categoria = cea2.categoria.ID_categoria "
					+ "WHERE cea2.categoria.nombre_categoria = 'A1'";
			break;
		case 2:
			query = "SELECT cea2.examenteorico.ID_examenT, cea2.examenteorico.resultado " + "FROM cea2.examenteorico "
					+ "JOIN cea2.matriculados ON cea2.examenteorico.ID_matriculado = cea2.matriculados.ID_matriculado "
					+ "WHERE cea2.matriculados.ID_cliente = 5";
			break;
		case 3:
			query = "SELECT cea2.claseteorica.ID_claseT, cea2.claseteorica.descripcion, cea.instructor.Nombre, cea.instructor.Apellido\r\n"
					+ "FROM cea2.claseteorica\r\n"
					+ "JOIN cea2.matriculados ON cea2.claseteorica.ID_matriculado = cea2.matriculados.ID_matriculado\r\n"
					+ "JOIN cea.instructor  ON cea2.claseteorica.ID_instructor = cea.instructor.ID_instructor\r\n"
					+ "WHERE cea2.matriculados.ID_cliente = 1;";
			break;
		case 4:
			query = "SELECT cea.instructor.ID_instructor, cea.instructor.Nombre, cea.instructor.Apellido, cea.clasepractica.ID_claseP, cea.clasepractica.descripcion\r\n"
					+ "FROM cea.instructor\r\n"
					+ "JOIN cea.clasepractica ON cea.instructor.ID_instructor = cea.clasepractica.ID_instructor\r\n"
					+ "WHERE cea.instructor.ID_instructor = 1;";
			break;
		case 5:
			query = "SELECT cea.examenpractico.ID_examenP, cea.examenpractico.resultado, cea.examenpractico.ID_instructor, cea.examenpractico.ID_vehiculo\r\n"
					+ "FROM cea.examenpractico \r\n"
					+ "JOIN cea2.matriculados ON cea.examenpractico.ID_matriculado = cea2.matriculados.ID_matriculado\r\n"
					+ "WHERE cea2.matriculados.ID_cliente = 1;";
			break;
		case 6:
			query = "SELECT cea.clasepractica.ID_claseP, cea.clasepractica.descripcion, cea.instructor.Nombre, cea.instructor.Apellido "
					+ "FROM cea.clasepractica JOIN cea.instructor ON cea.clasepractica.ID_instructor = cea.instructor.ID_instructor WHERE "
					+ "cea.clasepractica.ID_vehiculo = 4;";
			break;
			
		case 7:
			query = "SELECT cea.examenpractico.ID_examenP,cea.examenpractico.ID_matriculado, cea.examenpractico.resultado, cea.vehiculos.Placa, "
					+ "cea.vehiculos.Modelo FROM cea.examenpractico JOIN cea.vehiculos ON cea.examenpractico.ID_vehiculo = cea.vehiculos.ID_vehiculo "
					+ "WHERE cea.examenpractico.ID_instructor = 3;";
			break;
		case 8:
			query = "SELECT cea2.matriculados.ID_matriculado, cea2.examenteorico.ID_examenT, cea2.examenteorico.resultado FROM cea2.examenteorico"
					+ " JOIN cea2.matriculados ON cea2.examenteorico.ID_matriculado = cea2.matriculados.ID_matriculado WHERE "
					+ "cea2.examenteorico.resultado = 'Aprobado';";
			break;
		case 9:
			query = "SELECT cea2.examenteorico.ID_examenT, cea2.examenteorico.resultado, cea2.matriculados.ID_matriculado\r\n"
					+ "FROM cea2.examenteorico\r\n"
					+ "JOIN cea2.matriculados ON cea2.examenteorico.ID_matriculado = cea2.matriculados.ID_matriculado;";
			break;
		case 10:
			query = "SELECT cea.examenpractico.ID_examenP, cea.examenpractico.resultado, cea.vehiculos.Placa, cea.vehiculos.Modelo, "
					+ "cea.vehiculos.Marca FROM cea.examenpractico JOIN cea.vehiculos ON cea.examenpractico.ID_vehiculo = cea.vehiculos.ID_vehiculo;";
			break;
		
		default:
			// Si el ID no coincide con ninguna consulta conocida, retorna un mensaje de
			// error o manejo según tu requerimiento
			return "ID no válido";
		}

		try (Connection connection = mysqlDS2.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {


			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				ResultSetMetaData metaData = resultSet.getMetaData();
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
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

    // Implementar métodos similares para las otras consultas
}
