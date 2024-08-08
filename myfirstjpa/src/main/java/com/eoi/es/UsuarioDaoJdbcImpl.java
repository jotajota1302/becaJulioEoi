package com.eoi.es;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDaoJdbcImpl implements UsuarioDao {

	@Override
	public Usuario findById(int id) {

		try {

			Usuario usuario = null;

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/beca?serverTimezone=UTC",
					"root", "root");

			PreparedStatement statement = connection
					.prepareStatement("SELECT id,usuario,email FROM usuario WHERE id= ?");
			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("usuario"));
				usuario.setEmail(rs.getString("email"));
			}

			connection.close();

			return usuario;

		} catch (Exception e) {

			return null;
		}

	}

}
