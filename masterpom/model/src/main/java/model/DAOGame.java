package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Game;

/**
 * The Class DAOHelloWorld.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */
class DAOGame extends DAOEntity<Game> {

	public DAOGame(final Connection connection) throws SQLException {
		super(connection);
	}

	/*

	 */
	@Override
	public boolean create(final Game entity) {
		// Not implemented
		return false;
	}

	/*
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	@Override
	public boolean delete(final Game entity) {
		// Not implemented
		return false;
	}

	/*
	 */
	@Override
	public boolean update(final Game entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	@Override
	public Game find(final int id) {
		//HelloWorld helloWorld = new HelloWorld();
		Game game = new Game();
		
		try {
			final String sql = "{call mapById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				game = new Game(id, resultSet.getString("Game"), resultSet.getInt("nbrDiamonds"));
			}
			return game;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
