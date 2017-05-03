package opencarshop.cliente.controller;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import opencarshop.Endereco;
import opencarshop.cliente.model.Cliente;
import opencarshop.cliente.model.ClienteDAO;
import opencarshop.util.Utilidades;

public class ClienteController implements Initializable {

    // TELA DE CADASTRO
    @FXML
    private TextField tf_cpfCadastro;
    @FXML
    private TextField tf_nomeCadastro;
    @FXML
    private DatePicker dp_dataNascimentoCadastro;
    @FXML
    private TextField tf_emailCadastro;
    @FXML
    private TextField tf_telefone1Cadastro;
    @FXML
    private TextField tf_telefone2Cadastro;

    @FXML
    private ComboBox<String> cb_tipoCadastro;
    @FXML
    private TextField tf_ruaCadastro;
    @FXML
    private TextField tf_cidadeCadastro;
    @FXML
    private TextField tf_estadoCadastro;
    @FXML
    private TextField tf_bairroCadastro;
    @FXML
    private TextField tf_cepCadastro;
    @FXML
    private TextField tf_numeroCadastro;
    @FXML
    private TextField tf_complementoCadastro;

    @FXML
    private Label resultadoCadastro;

    // TABELA CLIENTE
    @FXML
    private TableColumn<Cliente, String> col_nome;
    @FXML
    private TableColumn<Cliente, String> col_cpf;
    @FXML
    private TableColumn<Cliente, String> col_telefone1;
    @FXML
    private TableColumn<Cliente, String> col_telefone2;
    @FXML
    private TableColumn<Cliente, String> col_email;

    @FXML
    private TableView<Cliente> tbl_cliente;

    @FXML
    private CheckBox cb_ativo;

    @FXML
    private Label confirmaAlteracao;

    @FXML
    private void cadastrar(ActionEvent event) throws ParseException, Exception {
        //cb_cargoCadastro.setItems(cargos);
        Cliente cli = new Cliente();
        Endereco end = new Endereco();
        ClienteDAO c = new ClienteDAO();
        try{
            // OBJETO FUNCIONARIO
            cli.setCpf(tf_cpfCadastro.getText());
            cli.setNome(tf_nomeCadastro.getText());
            cli.setDataNascimento(dp_dataNascimentoCadastro.getValue());
            cli.setEmail(tf_emailCadastro.getText());
            cli.setTelefone1(tf_telefone1Cadastro.getText());
            cli.setTelefone2(tf_telefone2Cadastro.getText());
            cli.setAtivo(true);

            // OBJETO ENDERECO
            end.setCEP(tf_cepCadastro.getText());
            end.setEstado(tf_estadoCadastro.getText());
            end.setCidade(tf_cidadeCadastro.getText());
            end.setBairro(tf_bairroCadastro.getText());
            end.setRua(tf_ruaCadastro.getText());
            end.setNumero(Integer.parseInt(tf_numeroCadastro.getText()));
            end.setComplemento(tf_complementoCadastro.getText());
            end.setTipo(cb_tipoCadastro.getValue().charAt(0));
            c.cadastraCliente(cli, end);
            resultadoCadastro.setText("Cadastrado com sucesso");
        }
        catch(NumberFormatException exception1){
            resultadoCadastro.setText(exception1.getMessage());
        }
        catch(NullPointerException exception2){
            resultadoCadastro.setText(exception2.getMessage());
        }
        catch(Exception e ){
           resultadoCadastro.setText(e.getMessage());
        }      
    }

    @FXML
    private void alterarCadastro(ActionEvent event) throws Exception {
        Cliente cli = new Cliente();
        cli.setCpf(tf_cpfCadastro.getText());
        cli.setNome(tf_nomeCadastro.getText());
        cli.setDataNascimento(dp_dataNascimentoCadastro.getValue());
        cli.setEmail(tf_emailCadastro.getText());
        cli.setTelefone1(tf_telefone1Cadastro.getText());
        cli.setTelefone2(tf_telefone2Cadastro.getText());
        cli.setAtivo(cb_ativo.isSelected());

        ClienteDAO f = new ClienteDAO();
        if (f.alteraCliente(cli)) {
            confirmaAlteracao.setText("Alteração realizada com sucesso!!");
        } else {
            confirmaAlteracao.setText("Erro ao realizar a alteração!!");
        }
    }

    private void carregaTabelaCliente() throws Exception {
        col_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        col_cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        col_telefone1.setCellValueFactory(new PropertyValueFactory<>("telefone1"));
        col_telefone2.setCellValueFactory(new PropertyValueFactory<>("telefone2"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));

        ClienteDAO f = new ClienteDAO();
        List<Cliente> listaCliente = f.getAllCliente();
        ObservableList<Cliente> observableListFuncionatio;

        observableListFuncionatio = FXCollections.observableArrayList(listaCliente);
        tbl_cliente.setItems(observableListFuncionatio);
    }

    public void selecionarItemTablelaCliente(Cliente cliente) {
        if (cliente.getCpf() != null) {
            tf_cpfCadastro.setText(cliente.getCpf());
            tf_nomeCadastro.setText(cliente.getNome());
            tf_emailCadastro.setText(cliente.getEmail());
            tf_telefone1Cadastro.setText(cliente.getTelefone1());
            tf_telefone2Cadastro.setText(cliente.getTelefone2());
            dp_dataNascimentoCadastro.setValue(cliente.getDataNascimento());
            cb_ativo.setSelected(cliente.getAtivo());

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregaTabelaCliente();
            tbl_cliente.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> selecionarItemTablelaCliente(newValue));
        } catch (Exception ex) {
            //Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

}
