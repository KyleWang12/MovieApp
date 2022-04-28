package movieApp.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movieApp.model.AnnualGross;

public class AnnualGrossDao {
	protected ConnectionManager connectionManager;
	private static AnnualGrossDao instance = null;

	protected AnnualGrossDao() {
		connectionManager = new ConnectionManager();
	}

	public static AnnualGrossDao getInstance() {
		if (instance == null) {
			instance = new AnnualGrossDao();
		}
		return instance;
	}

	public AnnualGross create(AnnualGross gross) throws SQLException {
		String insertGross = "INSERT INTO AnnualGross(Year,FilmName,Gross,TotalGross,Theaters,DistributorName) VALUES(?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertGross);

			insertStmt.setInt(1, gross.getYear());
			insertStmt.setString(2, gross.getFilmName());
			insertStmt.setInt(3, gross.getGross());
			insertStmt.setInt(4, gross.getTotalGross());
			insertStmt.setInt(5, gross.getTheaters());
			insertStmt.setString(6, gross.getDistributorName());

			insertStmt.executeUpdate();

			return gross;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (insertStmt != null) {
				insertStmt.close();
			}
		}
	}

	public AnnualGross getAnnualGrossByYear(int Year) throws SQLException {
		String selectRes = "SELECT AnnualGrossId,Year,FilmName,Gross,TotalGross,Theaters,DistributorName FROM AnnualGross WHERE Year=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setInt(1, Year);

			results = selectStmt.executeQuery();

			if (results.next()) {
				int id = results.getInt("AnnualGrossId");
				int y = results.getInt("Year");
				String fn = results.getString("Filmname");
				int g = results.getInt("Gross");
				int tg = results.getInt("TotalGross");
				int t = results.getInt("Theaters");
				String dn = results.getString("DistributorName");

				AnnualGross ag = new AnnualGross(id, y, fn, g, tg, t, dn);
				return ag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return null;
	}

	public List<AnnualGross> getAnnualGrossByFilmName(String FilmName) throws SQLException {
		List<AnnualGross> ag = new ArrayList<>();
		String selectRes = "SELECT AnnualGrossId,Year,FilmName,Gross,TotalGross,Theaters,DistributorName FROM AnnualGross WHERE FilmName like ?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setString(1, "%"+FilmName+"%");

			results = selectStmt.executeQuery();

			while (results.next()) {
				int id = results.getInt("AnnualGrossId");
				int y = results.getInt("Year");
				String fn = results.getString("Filmname");
				int g = results.getInt("Gross");
				int tg = results.getInt("TotalGross");
				int t = results.getInt("Theaters");
				String dn = results.getString("DistributorName");

				AnnualGross annualGross = new AnnualGross(id, y, fn, g, tg, t, dn);
				ag.add(annualGross);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return ag;

	}

	public AnnualGross getAnnualGrossByGross(int Gross) throws SQLException {
		String selectRes = "SELECT AnnualGrossId,Year,FilmName,Gross,TotalGross,Theaters,DistributorName FROM AnnualGross WHERE Gross=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setInt(1, Gross);

			results = selectStmt.executeQuery();

			if (results.next()) {
				int id = results.getInt("AnnualGrossId");
				int y = results.getInt("Year");
				String fn = results.getString("Filmname");
				int g = results.getInt("Gross");
				int tg = results.getInt("TotalGross");
				int t = results.getInt("Theaters");
				String dn = results.getString("DistributorName");

				AnnualGross ag = new AnnualGross(id, y, fn, g, tg, t, dn);
				return ag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return null;

	}

	public AnnualGross getAnnualGrossByTotalGross(int TotalGross) throws SQLException {
		String selectRes = "SELECT AnnualGrossId,Year,FilmName,Gross,TotalGross,Theaters,DistributorName FROM AnnualGross WHERE TotalGross=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setInt(1, TotalGross);

			results = selectStmt.executeQuery();

			if (results.next()) {
				int id = results.getInt("AnnualGrossId");
				int y = results.getInt("Year");
				String fn = results.getString("Filmname");
				int g = results.getInt("Gross");
				int tg = results.getInt("TotalGross");
				int t = results.getInt("Theaters");
				String dn = results.getString("DistributorName");

				AnnualGross ag = new AnnualGross(id, y, fn, g, tg, t, dn);
				return ag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return null;

	}

	public AnnualGross getAnnualGrossByTheaters(int Theaters) throws SQLException {
		String selectRes = "SELECT AnnualGrossId,Year,FilmName,Gross,TotalGross,Theaters,DistributorName FROM AnnualGross WHERE Theaters=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setInt(1, Theaters);

			results = selectStmt.executeQuery();

			if (results.next()) {
				int id = results.getInt("AnnualGrossId");
				int y = results.getInt("Year");
				String fn = results.getString("Filmname");
				int g = results.getInt("Gross");
				int tg = results.getInt("TotalGross");
				int t = results.getInt("Theaters");
				String dn = results.getString("DistributorName");

				AnnualGross ag = new AnnualGross(id, y, fn, g, tg, t, dn);
				return ag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return null;
	}

	public AnnualGross getAnnualGrossByDistributorName(String DistributorName) throws SQLException {
		String selectRes = "SELECT AnnualGrossId,Year,FilmName,Gross,TotalGross,Theaters,DistributorName FROM AnnualGross WHERE DistributorName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setString(1, DistributorName);

			results = selectStmt.executeQuery();

			if (results.next()) {
				int id = results.getInt("AnnualGrossId");
				int y = results.getInt("Year");
				String fn = results.getString("Filmname");
				int g = results.getInt("Gross");
				int tg = results.getInt("TotalGross");
				int t = results.getInt("Theaters");
				String dn = results.getString("DistributorName");

				AnnualGross ag = new AnnualGross(id, y, fn, g, tg, t, dn);
				return ag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return null;
	}

	public AnnualGross delete(AnnualGross gross) throws SQLException {
		String deleteGross = "DELETE FROM AnnualGross WHERE AnnualGrossId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteGross);
			deleteStmt.setInt(1, gross.getAnnualGrossId());
			deleteStmt.executeUpdate();

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}
}
