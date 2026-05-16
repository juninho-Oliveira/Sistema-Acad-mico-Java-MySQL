// Importa a classe Connection
// Ela representa a conexão com o banco de dados
import java.sql.Connection;

// Importa o DriverManager
// Ele é responsável por criar a conexão com o MySQL
import java.sql.DriverManager;

// Nome da classe
public class Conexao {

    // Método estático que vai conectar no banco
    // Ele retorna uma Connection
    public static Connection conectar() {

        // TRY = tenta executar o código
        try {

            // Cria a conexão com o banco
            Connection conn = DriverManager.getConnection(

                // Endereço do banco
                // localhost = seu próprio computador
                // 3306 = porta padrão do MySQL
                // sistema_academico = nome do banco
                "jdbc:mysql://localhost:3306/sistema_academico",

                // Usuário do MySQL
                "root",

                // Senha do MySQL
                // Se estiver sem senha deixa ""
                "123456"
            );

            // Mostra mensagem no console se conectar
            System.out.println("Conectado com sucesso!");

            // Retorna a conexão
            return conn;

        // CATCH = captura erros
        } catch (Exception e) {

            // Mostra erro caso não conecte
            System.out.println("Erro ao conectar: " + e.getMessage());

            // Retorna null se der erro
            return null;
        }
    }
}