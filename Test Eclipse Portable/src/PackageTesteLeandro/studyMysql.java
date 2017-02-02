package PackageTesteLeandro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
import java.util.Random;

import org.jasypt.digest.StandardStringDigester;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class studyMysql {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Connection myConn = inicializaBanco();
			
			java.sql.Statement myStatement = executaSQLSimples(myConn);
			criaNomes(myStatement, 1000,1);
			//executaStoredProcedure(myConn);
			//CallableStatement myCallStatement;
			//executaStoreProcedureParametroRetorno(myConn);
			//executaStoredProcedureResultSetRetorno(myConn);
			//ResultSet myRS = executaPreparedStatement(myConn);
			//resultSetMetaDados(myRS);			
			//commitRollbakc(myConn, myStatement, myRS);
			//myConn.setAutoCommit(true);
			//dataBaseMetaDados(myConn);
			//updateBlob(myConn);
			//escreveArquivodoBLOB(myConn);
			//updateCLOB(myConn);
			//readCLOB(myConn);
			//setEncPass();
				} catch (SQLException e) {
			throw new RuntimeException(e);
		} /*catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

	private static Connection inicializaBanco() throws SQLException {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("testeleandro");
		EncryptableProperties props = new EncryptableProperties(encryptor);
		
		 try 
		 {
			props.load(new FileInputStream("/home/leandro/git/personal-study-projects/Test Eclipse Portable/Resources/teste.properties"));
		 } 
		 catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 } 
		 catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		Connection myConn = conectaBanco(props);
		return myConn;
	}

	private static void readCLOB(Connection myConn) throws SQLException,
		FileNotFoundException {
		Statement myCLOBWRITEStatement = (Statement) myConn.createStatement();
		String sql = "select livro from testeleandro where id = 601";
		File arquivoCLOB = new File("D:\\Pessoal\\testeInputJava Do DB.txt");
		FileOutputStream output = new FileOutputStream(arquivoCLOB);
		
		ResultSet myRSCLOB = myCLOBWRITEStatement.executeQuery(sql);
		int howMany=0;
		
		if (myRSCLOB.next())
		{
			
			Reader input = myRSCLOB.getCharacterStream("livro");
			System.out.println("Eu li do arquivo "+input.getClass());
			int myChar;
			try {
				while ((myChar=input.read())>0)
				{
					output.write(myChar);
					howMany++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		System.out.println("Feito!!" + howMany + " bytes");
	}

	private static void updateCLOB(Connection myConn) throws SQLException,
		FileNotFoundException {
		String sql = "update testeleandro set livro = ? where id=601";
		java.sql.PreparedStatement myCBLOBStatement = myConn.prepareStatement(sql);
		File arquivoLivro = new File("D:\\Pessoal\\testeInputJava.txt");
		System.out.println("Arquivo " + arquivoLivro.getName() + " de " + arquivoLivro.getPath());
		FileReader input = new FileReader(arquivoLivro);
		myCBLOBStatement.setCharacterStream(1, input);
		int linhas = myCBLOBStatement.executeUpdate();
		System.out.println("Atualizei quantas linhas: "+linhas);
	}

	private static void escreveArquivodoBLOB(Connection myConn)
			throws SQLException, FileNotFoundException {
		String sql = "select foto from testeleandro where id=601";
		java.sql.PreparedStatement readBLOBStatement = myConn.prepareStatement(sql);
		ResultSet myBLOBRS = readBLOBStatement.executeQuery();
		File arquivoFoto = new File("D:\\Pessoal\\foto_pessoal_java.jpg");
		FileOutputStream output = new FileOutputStream(arquivoFoto);
		if (myBLOBRS.next())
		{
			InputStream input = myBLOBRS.getBinaryStream("foto");
			byte[] buffer = new byte[1024];
			
			try {
				while (input.read(buffer)>0)
				{
					output.write(buffer);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("fiz o update!");
	}

	private static void updateBlob(Connection myConn) throws SQLException,
			FileNotFoundException {
		String sql = "update testeleandro set foto=? where id=601";
		java.sql.PreparedStatement myBLOBStatement = myConn.prepareStatement(sql);
		File arquivoFoto = new File("D:\\Pessoal\\foto_pessoal.jpg");
		FileInputStream input = new FileInputStream(arquivoFoto);
		myBLOBStatement.setBinaryStream(1, input);
		myBLOBStatement.executeUpdate();
	}

	private static void resultSetMetaDados(ResultSet myRS) throws SQLException {
		ResultSetMetaData myRSMetaData = (ResultSetMetaData) myRS.getMetaData();
		System.out.println(myRSMetaData.getColumnCount());
		System.out.println(myRSMetaData.getColumnName(1));
		System.out.println(myRSMetaData.getColumnName(2));
	}

	private static void dataBaseMetaDados(Connection myConn)
			throws SQLException {
		DatabaseMetaData dbMetaData = (DatabaseMetaData) myConn.getMetaData();
		System.out.println(dbMetaData.getDatabaseProductName());
		System.out.println(dbMetaData.getDatabaseProductVersion());
		System.out.println(dbMetaData.getDriverName());
		
		//l� tabelas
		ResultSet tabelas = dbMetaData.getTables(null, null, null, null);
		while (tabelas.next())
		{
			System.out.println(tabelas.getString("TABLE_NAME"));			
		}
		//l� colunas
		ResultSet colunas = dbMetaData.getColumns(null, null, "testeleandro", null);
		while (colunas.next())
		{
			System.out.println(colunas.getString("COLUMN_NAME"));			
		}
		
	}

	private static void commitRollbakc(Connection myConn,
			java.sql.Statement myStatement, ResultSet myRS) throws SQLException {
		myConn.setAutoCommit(false);
		criaNomes(myStatement, 100, 700);
		myConn.commit();

		while (myRS.next()) {

			System.out.println(myRS.getInt("ID") + "  ");
			System.out.println(myRS.getString("nome") + "  ");

		}
	}

	private static ResultSet executaPreparedStatement(Connection myConn)
			throws SQLException {
		java.sql.PreparedStatement myPrepStatement = myConn
				.prepareStatement("select * from testeleandro where id > ?");
		myPrepStatement.setInt(1, 300);
		ResultSet myRS = myPrepStatement.executeQuery();
		return myRS;
	}

	private static void executaStoredProcedureResultSetRetorno(Connection myConn)
			throws SQLException {
		CallableStatement myCallStatement;
		myCallStatement = myConn.prepareCall("{call retornaNomes(?)}");
		myCallStatement.setInt(1, 500);
		ResultSet myRSCall = myCallStatement.executeQuery();

		while (myRSCall.next()) {
			System.out.println(myRSCall.getInt("Id"));
		}
	}

	private static void executaStoredProcedure(Connection myConn)
			throws SQLException {
		// EXECU��O DE STORED PROCEDURE
		 CallableStatement myCallStatement =
		 myConn.prepareCall("{call crialinhaupdate(?,?)}");
		 myCallStatement.setInt(1, 511); myCallStatement.setString(2,"Criado JAVA PROC3 IS WE"); myCallStatement.execute();
	}

	private static void executaStoreProcedureParametroRetorno(Connection myConn)
			throws SQLException {
		CallableStatement myCallStatement = myConn
				.prepareCall("{call concatNome(?)}");
		myCallStatement.registerOutParameter(1, Types.VARCHAR);
		myCallStatement.setString(1, " Jabrungo ");
		myCallStatement.execute();
		String seuNome = myCallStatement.getString(1);
		System.out.println(seuNome);
	}

	private static java.sql.Statement executaSQLSimples(Connection myConn)
			throws SQLException {
		java.sql.Statement myStatement = myConn.createStatement();
		myStatement.executeUpdate("update testeleandro set nome='LeandroUpdate' where id=503");
		myStatement.executeUpdate("delete from testeleandro where id=502");
		return myStatement;
	}

	private static EncryptableProperties setEncPass()
	{
		
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("testeleandro");
		EncryptableProperties props = new EncryptableProperties(encryptor);
		String encPass = encryptor.encrypt("javauser"); 		 
		
		 try 
		 {
			props.load(new FileInputStream("/home/leandro/git/personal-study-projects/Test Eclipse Portable/Resources/teste.properties"));
			
		 } 
		 catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 } 
		 catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 System.out.println(encPass);
		 //props.put("pass",encPass );
		 try {
			conectaBanco(props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return props;
	}
	
	
	
	private static Connection conectaBanco(EncryptableProperties props) throws SQLException {
		
		String dbURL = props.getProperty("dbURL");
		String user = props.getProperty("user");
		String pass = props.getProperty("pass");
		

		Connection myConn = DriverManager.getConnection(dbURL, user, pass);
		return myConn;
	}

	private static void criaNomes(java.sql.Statement myStatement, int quantos,
			int inicio) throws SQLException {
		String insQuery = "";
		String name = "";
		Random randInt = new Random();
		int letter;
		for (int i = inicio; i < inicio + quantos; i++) {
			insQuery = "insert into testeleandro (id,nome) values ";
			for (int x = 0; x < 10; x++) {
				letter = randInt.nextInt(10);
				switch (letter) {
				case 0:
					name = name + "A";
					break;
				case 1:
					name = name + "E";
					break;
				case 2:
					name = name + "I";
					break;
				case 3:
					name = name + "O";
					break;
				case 4:
					name = name + "U";
					break;
				default:
					name = name + "X";
					break;
				}// fim switch }
			}// fim for monta nome

			insQuery = insQuery + "(" + i + ",'" + name + "')";
			System.out.println(insQuery);
			name = "";
			myStatement.executeUpdate(insQuery);

		}// fim for geral
	}

}
