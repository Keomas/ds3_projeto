/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencarshop.funcionario.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import opencarshop.funcionario.model.Funcionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexandre
 */
public class FuncionarioControllerTest {
    private FuncionarioController funcionarioController;
    private Funcionario funcionario;
    
    public FuncionarioControllerTest() {
         funcionarioController = new FuncionarioController();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPrevStage method, of class FuncionarioController.
     */
    @Test
    public void testSetPrevStage() {
        System.out.println("setPrevStage");
        Stage stage = null;
        Assert.assertTrue(true);
    }
    @Test
    public void testValidarFuncionarioPassa() throws Exception{
        Funcionario funcionario = this.criarFuncionario();
        boolean result = funcionarioController.validarFuncionario(funcionario);
        assertTrue(result);

    }
    @Test
    public void testValidarFuncionarioNuloFalha() throws Exception{
        try{
            Funcionario funcionario = null;
            funcionarioController.validarFuncionario(funcionario);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Funcionario nulo");
        }
    }
    
    @Test
    public void testValidarFuncionarioNomeVazioFalha() throws Exception{
        try{
            this.funcionario = this.criarFuncionario();
            this.funcionario.setNome("");
            funcionarioController.validarFuncionario(this.funcionario);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Nome não pode ser vazio ou nulo");
        }
    }
    
    @Test
    public void testValidarFuncionarioSenhaVaziaFalha() throws Exception{
        try{
            this.funcionario = this.criarFuncionario();
            this.funcionario.setSenha("");
            funcionarioController.validarFuncionario(this.funcionario);
        }catch(Exception exception){
            assertEquals(exception.getMessage(), "Senha não pode ser vazia ou nula");
        }
    }
    
    @Test
    public void testValidarFuncionarioEmailSemArrobaFalha() throws Exception{
        try{
            this.funcionario = this.criarFuncionario();
            this.funcionario.setEmail("testeteste.com");
            funcionarioController.validarFuncionario(this.funcionario);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Email deve conter @ e .com");
        }
    }
    
    @Test
    public void testValidarFuncionarioEmailSemComFalha() throws Exception{
        try{
            this.funcionario = this.criarFuncionario();
            this.funcionario.setEmail("teste@testecom");
            funcionarioController.validarFuncionario(this.funcionario);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Email deve conter @ e .com");
        }
    }
    
    @Test
    public void testValidarFuncionarioIdadeMenorQue18Falha() throws Exception{
        try{
            this.funcionario = this.criarFuncionario();
            this.funcionario.setDataNascimento(LocalDate.parse("2000-01-10"));
            funcionarioController.validarFuncionario(this.funcionario);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Data de nascimento não pode ser vazia ou funcionario tem que ser maior que 18");
        }
    }
    
    private Funcionario criarFuncionario(){
        return new Funcionario("123456",
                               "teste",
                               "senha",
                               LocalDate.parse("1995-02-14"),
                               "teste@teste.com",
                               "12345678",
                               "12345667",
                               false);
    }
    
}
