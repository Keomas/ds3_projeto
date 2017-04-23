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
    public void testValidarFuncionario(){
        Funcionario funcionario = null;
        boolean result = funcionarioController.validarFuncionario(funcionario);
        assertFalse(result);
    }
    
    @Test
    public void testValidarFuncionarioNomeVazio(){
        Funcionario funcionario = null;
        funcionario = this.criarFuncionario();
        funcionario.setNome("");
        boolean result = funcionarioController.validarFuncionario(funcionario);
        assertFalse(result);
    }
    
    @Test
    public void testValidarFuncionarioSenhaVazia(){
        Funcionario funcionario = null;
        funcionario = this.criarFuncionario();
        funcionario.setSenha("");
        boolean result = funcionarioController.validarFuncionario(funcionario);
        assertFalse(result);
    }
    
    @Test
    public void testValidarFuncionarioEmailSem(){
        Funcionario funcionario = null;
        funcionario = this.criarFuncionario();
        funcionario.setEmail("testeteste.com");
        boolean result = funcionarioController.validarFuncionario(funcionario);
        assertFalse(result);
    }
    
    public void testValidarFuncionarioEmailSemCom(){
        Funcionario funcionario = null;
        funcionario = this.criarFuncionario();
        funcionario.setEmail("teste@teste.com");
        boolean result = funcionarioController.validarFuncionario(funcionario);
        assertFalse(result);
    }
    
    private Funcionario criarFuncionario(){
        return new Funcionario("123456",
                               "teste",
                               "senha",
                               LocalDate.parse("2016-02-14"),
                               "teste@teste.com",
                               "12345678",
                               "12345667",
                               false);
    }
    
}
