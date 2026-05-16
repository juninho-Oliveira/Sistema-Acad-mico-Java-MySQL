// =========================
// IMPORTS DA INTERFACE
// =========================

// Importa janela principal
import javax.swing.JFrame;

// Importa menus
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

// Importa abas
import javax.swing.JTabbedPane;

// Importa painéis
import javax.swing.JPanel;

// Importa textos e área de texto
import javax.swing.JLabel;
import javax.swing.JTextArea;

// Importa campos de texto
import javax.swing.JTextField;

// Importa campos formatados
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

// Importa caixas de seleção
import javax.swing.JComboBox;

// Importa radio buttons
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

// Importa botões e mensagens
import javax.swing.JButton;
import javax.swing.JOptionPane;

// =========================
// IMPORTS MYSQL
// =========================

// Importa conexão e comandos SQL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TelaSistemaAcademico {

    public static void main(String[] args) {

        // =========================
        // JANELA PRINCIPAL
        // =========================

        JFrame tela = new JFrame();
        tela.setTitle("Sistema Acadêmico");
        tela.setSize(900, 600);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        // =========================
        // MENU SUPERIOR
        // =========================

        JMenuBar barraMenu = new JMenuBar();

        JMenu menuAluno = new JMenu("Aluno");
        JMenu menuNotas = new JMenu("Notas e Faltas");
        JMenu menuAjuda = new JMenu("Ajuda");

        JMenuItem itemSalvar = new JMenuItem("Salvar");
        JMenuItem itemAlterar = new JMenuItem("Alterar");
        JMenuItem itemConsultar = new JMenuItem("Consultar");
        JMenuItem itemExcluir = new JMenuItem("Excluir");
        JMenuItem itemSair = new JMenuItem("Sair");

        menuAluno.add(itemSalvar);
        menuAluno.add(itemAlterar);
        menuAluno.add(itemConsultar);
        menuAluno.add(itemExcluir);
        menuAluno.addSeparator();
        menuAluno.add(itemSair);

        barraMenu.add(menuAluno);
        barraMenu.add(menuNotas);
        barraMenu.add(menuAjuda);

        tela.setJMenuBar(barraMenu);

        // =========================
        // ABAS DO SISTEMA
        // =========================

        JTabbedPane abas = new JTabbedPane();

        JPanel painelDados = new JPanel();
        JPanel painelCurso = new JPanel();
        JPanel painelNotas = new JPanel();
        JPanel painelBoletim = new JPanel();

        // Layout null permite posicionar manualmente com setBounds
        painelDados.setLayout(null);
        painelCurso.setLayout(null);
        painelNotas.setLayout(null);
        painelBoletim.setLayout(null);

        // =====================================================
        // ABA DADOS PESSOAIS
        // =====================================================

        // RGM
        JLabel lblRgm = new JLabel("RGM");
        lblRgm.setBounds(30, 30, 100, 25);
        painelDados.add(lblRgm);

        JTextField txtRgm = new JTextField();
        txtRgm.setBounds(100, 30, 120, 25);
        painelDados.add(txtRgm);

        // Nome
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(250, 30, 100, 25);
        painelDados.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(310, 30, 250, 25);
        painelDados.add(txtNome);

        // Data de nascimento
        JLabel lblData = new JLabel("Data de Nascimento");
        lblData.setBounds(30, 70, 150, 25);
        painelDados.add(lblData);

        final JFormattedTextField txtData = criarCampoFormatado("##/##/####");
        txtData.setBounds(180, 70, 120, 25);
        painelDados.add(txtData);

        // CPF
        JLabel lblCpf = new JLabel("CPF");
        lblCpf.setBounds(330, 70, 50, 25);
        painelDados.add(lblCpf);

        final JFormattedTextField txtCpf = criarCampoFormatado("###.###.###-##");
        txtCpf.setBounds(380, 70, 150, 25);
        painelDados.add(txtCpf);

        // Email
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 110, 100, 25);
        painelDados.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(100, 110, 460, 25);
        painelDados.add(txtEmail);

        // Endereço
        JLabel lblEndereco = new JLabel("End.");
        lblEndereco.setBounds(30, 150, 100, 25);
        painelDados.add(lblEndereco);

        JTextField txtEndereco = new JTextField();
        txtEndereco.setBounds(100, 150, 460, 25);
        painelDados.add(txtEndereco);

        // Município
        JLabel lblMunicipio = new JLabel("Município");
        lblMunicipio.setBounds(30, 190, 100, 25);
        painelDados.add(lblMunicipio);

        JTextField txtMunicipio = new JTextField();
        txtMunicipio.setBounds(100, 190, 150, 25);
        painelDados.add(txtMunicipio);

        // UF
        JLabel lblUf = new JLabel("UF");
        lblUf.setBounds(270, 190, 30, 25);
        painelDados.add(lblUf);

        JComboBox<String> cbUf = new JComboBox<>(
                new String[]{"SP", "RJ", "MG", "BA", "PR"}
        );
        cbUf.setBounds(300, 190, 60, 25);
        painelDados.add(cbUf);

        // Celular
        JLabel lblCelular = new JLabel("Celular");
        lblCelular.setBounds(380, 190, 80, 25);
        painelDados.add(lblCelular);

        final JFormattedTextField txtCelular = criarCampoFormatado("(##)#####-####");
        txtCelular.setBounds(450, 190, 130, 25);
        painelDados.add(txtCelular);

        // =====================================================
        // ABA CURSO
        // =====================================================

        // Curso
        JLabel lblCurso = new JLabel("Curso");
        lblCurso.setBounds(30, 30, 100, 25);
        painelCurso.add(lblCurso);

        JComboBox<String> cbCurso = new JComboBox<>(
                new String[]{
                        "Análise e Desenvolvimento de Sistemas",
                        "Ciência da Computação",
                        "Engenharia de Software"
                }
        );
        cbCurso.setBounds(100, 30, 350, 25);
        painelCurso.add(cbCurso);

        // Campus
        JLabel lblCampus = new JLabel("Campus");
        lblCampus.setBounds(30, 70, 100, 25);
        painelCurso.add(lblCampus);

        JComboBox<String> cbCampus = new JComboBox<>(
                new String[]{
                        "Tatuapé",
                        "Paulista",
                        "Mooca",
                        "Santo André"
                }
        );
        cbCampus.setBounds(100, 70, 250, 25);
        painelCurso.add(cbCampus);

        // Período
        JLabel lblPeriodo = new JLabel("Período");
        lblPeriodo.setBounds(30, 120, 100, 25);
        painelCurso.add(lblPeriodo);

        JRadioButton rbMatutino = new JRadioButton("Matutino");
        rbMatutino.setBounds(100, 120, 100, 25);

        JRadioButton rbVespertino = new JRadioButton("Vespertino");
        rbVespertino.setBounds(220, 120, 100, 25);

        JRadioButton rbNoturno = new JRadioButton("Noturno");
        rbNoturno.setBounds(340, 120, 100, 25);

        ButtonGroup grupoPeriodo = new ButtonGroup();
        grupoPeriodo.add(rbMatutino);
        grupoPeriodo.add(rbVespertino);
        grupoPeriodo.add(rbNoturno);

        painelCurso.add(rbMatutino);
        painelCurso.add(rbVespertino);
        painelCurso.add(rbNoturno);

        // Botões da aba Curso
        JButton btnSalvarCurso = new JButton("Salvar");
        btnSalvarCurso.setBounds(40, 180, 100, 40);
        painelCurso.add(btnSalvarCurso);

        JButton btnConsultarCurso = new JButton("Consultar");
        btnConsultarCurso.setBounds(160, 180, 100, 40);
        painelCurso.add(btnConsultarCurso);

        JButton btnAlterarCurso = new JButton("Alterar");
        btnAlterarCurso.setBounds(280, 180, 100, 40);
        painelCurso.add(btnAlterarCurso);

        JButton btnExcluirCurso = new JButton("Excluir");
        btnExcluirCurso.setBounds(400, 180, 100, 40);
        painelCurso.add(btnExcluirCurso);

        // =========================
        // AÇÕES DO MENU SUPERIOR
        // =========================

        itemSalvar.addActionListener(e -> btnSalvarCurso.doClick());
        itemConsultar.addActionListener(e -> btnConsultarCurso.doClick());
        itemAlterar.addActionListener(e -> btnAlterarCurso.doClick());
        itemExcluir.addActionListener(e -> btnExcluirCurso.doClick());
        itemSair.addActionListener(e -> System.exit(0));

        // =====================================================
        // AÇÃO DO BOTÃO SALVAR ALUNO
        // =====================================================

        btnSalvarCurso.addActionListener(e -> {

            try {
            	
                // Abre conexão com banco
                Connection conn = Conexao.conectar();
            	
                // =========================
                // VALIDAÇÃO DOS CAMPOS OBRIGATÓRIOS
                // =========================
                

             if (txtRgm.getText().trim().isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Preencha o RGM.");
                 return;
             }

             if (txtNome.getText().trim().isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Preencha o nome.");
                 return;
             }

             if (txtData.getText().contains("_")) {
                 JOptionPane.showMessageDialog(null, "Preencha a data de nascimento.");
                 return;
             }

             if (txtCpf.getText().contains("_")) {
                 JOptionPane.showMessageDialog(null, "Preencha o CPF.");
                 return;
             }

             if (txtEmail.getText().trim().isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Preencha o email.");
                 return;
             }

             if (txtEndereco.getText().trim().isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Preencha o endereço.");
                 return;
             }

             if (txtMunicipio.getText().trim().isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Preencha o município.");
                 return;
             }

             if (txtCelular.getText().contains("_")) {
                 JOptionPane.showMessageDialog(null, "Preencha o celular.");
                 return;
             }

             if (!rbMatutino.isSelected() && !rbVespertino.isSelected() && !rbNoturno.isSelected()) {
                 JOptionPane.showMessageDialog(null, "Selecione o período.");
                 return;
             }
                
                

                // SQL INSERT para cadastrar aluno
                String sql =
                        "INSERT INTO alunos "
                      + "(rgm, nome, data_nascimento, cpf, email, endereco, municipio, uf, celular, curso, campus, periodo) "
                      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement stmt = conn.prepareStatement(sql);

                // Dados pessoais
                stmt.setString(1, txtRgm.getText());
                stmt.setString(2, txtNome.getText());
                stmt.setString(3, txtData.getText());
                stmt.setString(4, txtCpf.getText());
                stmt.setString(5, txtEmail.getText());
                stmt.setString(6, txtEndereco.getText());
                stmt.setString(7, txtMunicipio.getText());
                stmt.setString(8, cbUf.getSelectedItem().toString());
                stmt.setString(9, txtCelular.getText());

                // Dados do curso
                stmt.setString(10, cbCurso.getSelectedItem().toString());
                stmt.setString(11, cbCampus.getSelectedItem().toString());

                // Período selecionado
                String periodo = "";

                if (rbMatutino.isSelected()) {
                    periodo = "Matutino";
                } else if (rbVespertino.isSelected()) {
                    periodo = "Vespertino";
                } else if (rbNoturno.isSelected()) {
                    periodo = "Noturno";
                }

                stmt.setString(12, periodo);

                // Executa o cadastro
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!");

                // Limpa campos após salvar
                limparCamposAluno(
                        txtRgm, txtNome, txtData, txtCpf, txtEmail,
                        txtEndereco, txtMunicipio, txtCelular,
                        cbUf, cbCurso, cbCampus, grupoPeriodo
                );

                conn.close();

            } catch (Exception erro) {

                // Trata erro de RGM duplicado
                if (erro.getMessage().toLowerCase().contains("duplicate")) {
                    JOptionPane.showMessageDialog(null, "Esse RGM já está cadastrado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar: " + erro.getMessage());
                }
            }
        });

        // =====================================================
        // AÇÃO DO BOTÃO CONSULTAR ALUNO
        // =====================================================

        btnConsultarCurso.addActionListener(e -> {

            try {

                Connection conn = Conexao.conectar();

                String sql = "SELECT * FROM alunos WHERE rgm = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, txtRgm.getText());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {

                    txtNome.setText(rs.getString("nome"));
                    txtData.setText(rs.getString("data_nascimento"));
                    txtCpf.setText(rs.getString("cpf"));
                    txtEmail.setText(rs.getString("email"));
                    txtEndereco.setText(rs.getString("endereco"));
                    txtMunicipio.setText(rs.getString("municipio"));
                    cbUf.setSelectedItem(rs.getString("uf"));
                    txtCelular.setText(rs.getString("celular"));

                    cbCurso.setSelectedItem(rs.getString("curso"));
                    cbCampus.setSelectedItem(rs.getString("campus"));

                    String periodo = rs.getString("periodo");

                    if ("Matutino".equals(periodo)) {
                        rbMatutino.setSelected(true);
                    } else if ("Vespertino".equals(periodo)) {
                        rbVespertino.setSelected(true);
                    } else if ("Noturno".equals(periodo)) {
                        rbNoturno.setSelected(true);
                    }

                    JOptionPane.showMessageDialog(null, "Aluno encontrado!");

                } else {
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
                }

                conn.close();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + erro.getMessage());
            }
        });

        // =====================================================
        // AÇÃO DO BOTÃO ALTERAR ALUNO
        // =====================================================

        btnAlterarCurso.addActionListener(e -> {

            try {

                if (txtRgm.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o RGM para alterar.");
                    return;
                }

                Connection conn = Conexao.conectar();

                String sql =
                        "UPDATE alunos SET "
                      + "nome=?, "
                      + "data_nascimento=?, "
                      + "cpf=?, "
                      + "email=?, "
                      + "endereco=?, "
                      + "municipio=?, "
                      + "uf=?, "
                      + "celular=?, "
                      + "curso=?, "
                      + "campus=?, "
                      + "periodo=? "
                      + "WHERE rgm=?";

                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, txtNome.getText());
                stmt.setString(2, txtData.getText());
                stmt.setString(3, txtCpf.getText());
                stmt.setString(4, txtEmail.getText());
                stmt.setString(5, txtEndereco.getText());
                stmt.setString(6, txtMunicipio.getText());
                stmt.setString(7, cbUf.getSelectedItem().toString());
                stmt.setString(8, txtCelular.getText());
                stmt.setString(9, cbCurso.getSelectedItem().toString());
                stmt.setString(10, cbCampus.getSelectedItem().toString());

                String periodo = "";

                if (rbMatutino.isSelected()) {
                    periodo = "Matutino";
                } else if (rbVespertino.isSelected()) {
                    periodo = "Vespertino";
                } else if (rbNoturno.isSelected()) {
                    periodo = "Noturno";
                }

                stmt.setString(11, periodo);
                stmt.setString(12, txtRgm.getText());

                int linhas = stmt.executeUpdate();

                if (linhas > 0) {
                    JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado para alterar.");
                }

                conn.close();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar: " + erro.getMessage());
            }
        });

        // =====================================================
        // AÇÃO DO BOTÃO EXCLUIR ALUNO
        // =====================================================

        btnExcluirCurso.addActionListener(e -> {

            try {

                if (txtRgm.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o RGM para excluir.");
                    return;
                }

                Connection conn = Conexao.conectar();

                String sql = "DELETE FROM alunos WHERE rgm=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, txtRgm.getText());

                int linhas = stmt.executeUpdate();

                if (linhas > 0) {
                    JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");

                    limparCamposAluno(
                            txtRgm, txtNome, txtData, txtCpf, txtEmail,
                            txtEndereco, txtMunicipio, txtCelular,
                            cbUf, cbCurso, cbCampus, grupoPeriodo
                    );

                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado para excluir.");
                }

                conn.close();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir: " + erro.getMessage());
            }
        });

        // =====================================================
        // ABA NOTAS E FALTAS
        // =====================================================

        // RGM
        JLabel lblRgmNota = new JLabel("RGM");
        lblRgmNota.setBounds(30, 30, 100, 25);
        painelNotas.add(lblRgmNota);

        JTextField txtRgmNota = new JTextField();
        txtRgmNota.setBounds(100, 30, 120, 25);
        painelNotas.add(txtRgmNota);

        // Disciplina
        JLabel lblDisciplina = new JLabel("Disciplina");
        lblDisciplina.setBounds(30, 70, 100, 25);
        painelNotas.add(lblDisciplina);

        JComboBox<String> cbDisciplina = new JComboBox<>(
                new String[]{
                        "Programação Orientada a Objetos",
                        "Banco de Dados",
                        "Engenharia de Software",
                        "Estrutura de Dados"
                }
        );
        cbDisciplina.setBounds(120, 70, 300, 25);
        painelNotas.add(cbDisciplina);

        // Semestre
        JLabel lblSemestre = new JLabel("Semestre");
        lblSemestre.setBounds(30, 110, 100, 25);
        painelNotas.add(lblSemestre);

        JComboBox<String> cbSemestre = new JComboBox<>(
                new String[]{
                        "2025-1",
                        "2025-2",
                        "2026-1",
                        "2026-2"
                }
        );
        cbSemestre.setBounds(120, 110, 120, 25);
        painelNotas.add(cbSemestre);

        // Nota
        JLabel lblNota = new JLabel("Nota");
        lblNota.setBounds(270, 110, 50, 25);
        painelNotas.add(lblNota);

        JComboBox<String> cbNota = new JComboBox<>(
                new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}
        );
        cbNota.setBounds(320, 110, 80, 25);
        painelNotas.add(cbNota);

        // Faltas
        JLabel lblFaltas = new JLabel("Faltas");
        lblFaltas.setBounds(430, 110, 60, 25);
        painelNotas.add(lblFaltas);

        JTextField txtFaltas = new JTextField();
        txtFaltas.setBounds(490, 110, 80, 25);
        painelNotas.add(txtFaltas);

        // Botões da aba Notas
        JButton btnSalvarNota = new JButton("Salvar");
        btnSalvarNota.setBounds(40, 180, 100, 40);
        painelNotas.add(btnSalvarNota);

        JButton btnConsultarNota = new JButton("Consultar");
        btnConsultarNota.setBounds(160, 180, 100, 40);
        painelNotas.add(btnConsultarNota);

        JButton btnAlterarNota = new JButton("Alterar");
        btnAlterarNota.setBounds(280, 180, 100, 40);
        painelNotas.add(btnAlterarNota);

        JButton btnExcluirNota = new JButton("Excluir");
        btnExcluirNota.setBounds(400, 180, 100, 40);
        painelNotas.add(btnExcluirNota);

        // =====================================================
        // AÇÃO DO BOTÃO SALVAR NOTA
        // =====================================================

        btnSalvarNota.addActionListener(e -> {

            try {

                if (txtRgmNota.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o RGM da nota.");
                    return;
                }

                Connection conn = Conexao.conectar();

                String sql =
                        "INSERT INTO notas_faltas "
                      + "(rgm, disciplina, semestre, nota, faltas) "
                      + "VALUES (?, ?, ?, ?, ?)";

                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, txtRgmNota.getText());
                stmt.setString(2, cbDisciplina.getSelectedItem().toString());
                stmt.setString(3, cbSemestre.getSelectedItem().toString());
                stmt.setString(4, cbNota.getSelectedItem().toString());

                int faltas = 0;

                if (!txtFaltas.getText().trim().isEmpty()) {
                    faltas = Integer.parseInt(txtFaltas.getText());
                }

                stmt.setInt(5, faltas);

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Nota e faltas salvas com sucesso!");

                limparCamposNota(txtRgmNota, cbDisciplina, cbSemestre, cbNota, txtFaltas);

                conn.close();

            } catch (Exception erro) {

                if (erro.getMessage().toLowerCase().contains("foreign key")) {
                    JOptionPane.showMessageDialog(null, "Esse RGM não existe na tabela de alunos.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar nota: " + erro.getMessage());
                }
            }
        });

        // =====================================================
        // AÇÃO DO BOTÃO CONSULTAR NOTA
        // =====================================================

        btnConsultarNota.addActionListener(e -> {

            try {

                Connection conn = Conexao.conectar();
                
             // Verifica se o RGM da nota foi preenchido
                if (txtRgmNota.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha o RGM para consultar a nota.");
                    return;
                }

                String sql = "SELECT * FROM notas_faltas WHERE rgm = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, txtRgmNota.getText());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {

                    cbDisciplina.setSelectedItem(rs.getString("disciplina"));
                    cbSemestre.setSelectedItem(rs.getString("semestre"));
                    cbNota.setSelectedItem(rs.getString("nota"));
                    txtFaltas.setText(String.valueOf(rs.getInt("faltas")));

                    JOptionPane.showMessageDialog(null, "Nota encontrada!");

                } else {
                    JOptionPane.showMessageDialog(null, "Nota não encontrada!");
                }

                conn.close();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar nota: " + erro.getMessage());
            }
        });

        // =====================================================
        // AÇÃO DO BOTÃO ALTERAR NOTA
        // =====================================================

        btnAlterarNota.addActionListener(e -> {

            try {

                if (txtRgmNota.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o RGM para alterar a nota.");
                    return;
                }

                Connection conn = Conexao.conectar();

                String sql =
                        "UPDATE notas_faltas SET "
                      + "disciplina=?, "
                      + "semestre=?, "
                      + "nota=?, "
                      + "faltas=? "
                      + "WHERE rgm=?";

                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, cbDisciplina.getSelectedItem().toString());
                stmt.setString(2, cbSemestre.getSelectedItem().toString());
                stmt.setString(3, cbNota.getSelectedItem().toString());

                int faltas = 0;

                if (!txtFaltas.getText().trim().isEmpty()) {
                    faltas = Integer.parseInt(txtFaltas.getText());
                }

                stmt.setInt(4, faltas);
                stmt.setString(5, txtRgmNota.getText());

                int linhas = stmt.executeUpdate();

                if (linhas > 0) {
                    JOptionPane.showMessageDialog(null, "Nota alterada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma nota encontrada para alterar.");
                }

                conn.close();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar nota: " + erro.getMessage());
            }
        });

        // =====================================================
        // AÇÃO DO BOTÃO EXCLUIR NOTA
        // =====================================================

        btnExcluirNota.addActionListener(e -> {

            try {

                if (txtRgmNota.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o RGM para excluir a nota.");
                    return;
                }

                Connection conn = Conexao.conectar();

                String sql = "DELETE FROM notas_faltas WHERE rgm=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, txtRgmNota.getText());

                int linhas = stmt.executeUpdate();

                if (linhas > 0) {
                    JOptionPane.showMessageDialog(null, "Nota excluída com sucesso!");
                    limparCamposNota(txtRgmNota, cbDisciplina, cbSemestre, cbNota, txtFaltas);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma nota encontrada para excluir.");
                }

                conn.close();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir nota: " + erro.getMessage());
            }
        });

        // =====================================================
        // ABA BOLETIM
        // =====================================================

        JLabel lblRgmBoletim = new JLabel("RGM");
        lblRgmBoletim.setBounds(30, 30, 100, 25);
        painelBoletim.add(lblRgmBoletim);

        JTextField txtRgmBoletim = new JTextField();
        txtRgmBoletim.setBounds(100, 30, 120, 25);
        painelBoletim.add(txtRgmBoletim);

        JButton btnConsultarBoletim = new JButton("Consultar Boletim");
        btnConsultarBoletim.setBounds(240, 30, 180, 25);
        painelBoletim.add(btnConsultarBoletim);

        JTextArea areaBoletim = new JTextArea();
        areaBoletim.setBounds(30, 80, 800, 350);
        areaBoletim.setEditable(false);
        painelBoletim.add(areaBoletim);

        // =====================================================
        // AÇÃO DO BOTÃO CONSULTAR BOLETIM
        // =====================================================

        btnConsultarBoletim.addActionListener(e -> {

            try {

                Connection conn = Conexao.conectar();
                
             // Verifica se o RGM do boletim foi preenchido
                if (txtRgmBoletim.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha o RGM para consultar o boletim.");
                    return;
                }

                String sql =
                        "SELECT a.rgm, a.nome, a.curso, n.disciplina, n.semestre, n.nota, n.faltas "
                      + "FROM alunos a "
                      + "INNER JOIN notas_faltas n ON a.rgm = n.rgm "
                      + "WHERE a.rgm = ?";

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, txtRgmBoletim.getText());

                ResultSet rs = stmt.executeQuery();

                String boletim = "";
                boolean encontrou = false;

                while (rs.next()) {

                    encontrou = true;

                    boletim += "RGM: " + rs.getString("rgm") + "\n";
                    boletim += "Nome: " + rs.getString("nome") + "\n";
                    boletim += "Curso: " + rs.getString("curso") + "\n";
                    boletim += "Disciplina: " + rs.getString("disciplina") + "\n";
                    boletim += "Semestre: " + rs.getString("semestre") + "\n";
                    boletim += "Nota: " + rs.getString("nota") + "\n";
                    boletim += "Faltas: " + rs.getInt("faltas") + "\n";
                    boletim += "------------------------------\n";
                }

                if (encontrou) {
                    areaBoletim.setText(boletim);
                } else {
                    areaBoletim.setText("Nenhum boletim encontrado para esse RGM.");
                }

                conn.close();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar boletim: " + erro.getMessage());
            }
        });

        // =====================================================
        // ADICIONA AS ABAS NA TELA
        // =====================================================

        abas.addTab("Dados Pessoais", painelDados);
        abas.addTab("Curso", painelCurso);
        abas.addTab("Notas e Faltas", painelNotas);
        abas.addTab("Boletim", painelBoletim);

        tela.add(abas);

        // Mostra a tela
        tela.setVisible(true);
    }

    // =====================================================
    // MÉTODO AUXILIAR: CAMPO FORMATADO
    // =====================================================

    public static JFormattedTextField criarCampoFormatado(String mascara) {

        try {
            return new JFormattedTextField(new MaskFormatter(mascara));
        } catch (Exception erro) {
            erro.printStackTrace();
            return new JFormattedTextField();
        }
    }

    // =====================================================
    // MÉTODO AUXILIAR: LIMPAR CAMPOS DO ALUNO
    // =====================================================

    public static void limparCamposAluno(
            JTextField txtRgm,
            JTextField txtNome,
            JFormattedTextField txtData,
            JFormattedTextField txtCpf,
            JTextField txtEmail,
            JTextField txtEndereco,
            JTextField txtMunicipio,
            JFormattedTextField txtCelular,
            JComboBox<String> cbUf,
            JComboBox<String> cbCurso,
            JComboBox<String> cbCampus,
            ButtonGroup grupoPeriodo) {

        txtRgm.setText("");
        txtNome.setText("");
        txtData.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtMunicipio.setText("");
        txtCelular.setText("");

        cbUf.setSelectedIndex(0);
        cbCurso.setSelectedIndex(0);
        cbCampus.setSelectedIndex(0);

        grupoPeriodo.clearSelection();
    }

    // =====================================================
    // MÉTODO AUXILIAR: LIMPAR CAMPOS DA NOTA
    // =====================================================

    public static void limparCamposNota(
            JTextField txtRgmNota,
            JComboBox<String> cbDisciplina,
            JComboBox<String> cbSemestre,
            JComboBox<String> cbNota,
            JTextField txtFaltas) {

        txtRgmNota.setText("");
        cbDisciplina.setSelectedIndex(0);
        cbSemestre.setSelectedIndex(0);
        cbNota.setSelectedIndex(0);
        txtFaltas.setText("");
    }
}
