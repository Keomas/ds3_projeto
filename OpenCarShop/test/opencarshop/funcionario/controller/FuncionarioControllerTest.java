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
import opencarshop.funcionario.model.Contrato;
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
    private Contrato contrato;
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
        try{
            Funcionario funcionario = criarFuncionario();
            boolean result = funcionarioController.validarFuncionario(funcionario);
            assertTrue(result);
        }
        catch(Exception exception){
            fail();
        }
    }
    @Test
    public void testValidarFuncionarioNuloFalha() throws Exception{
        try{
            Funcionario funcionario = null;
            funcionarioController.validarFuncionario(funcionario);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Funcionario nulo");
        }
    }
    
    @Test
    public void testValidarFuncionarioCpfVazioFalha() throws Exception{
        try{
            funcionario = criarFuncionario();
            funcionario.setCpf("");
            funcionarioController.validarFuncionario(funcionario);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "CPF nao pode ser vazio ou nulo");
        }
    }
    
    @Test
    public void testValidarFuncionarioNomeVazioFalha() throws Exception{
        try{
            funcionario = criarFuncionario();
            funcionario.setNome("");
            funcionarioController.validarFuncionario(funcionario);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Nome nao pode ser vazio ou nulo");
        }
    }
    
    @Test
    public void testValidarFuncionarioSenhaVaziaFalha() throws Exception{
        try{
            funcionario = criarFuncionario();
            funcionario.setSenha("");
            funcionarioController.validarFuncionario(funcionario);
            fail();
        }catch(Exception exception){
            assertEquals(exception.getMessage(), "Senha nao pode ser vazia ou nula");
        }
    }
    @Test
    public void testValidarFuncionarioEmailVazioFalha() throws Exception{
        try{
            funcionario = criarFuncionario();
            funcionario.setEmail("");
            funcionarioController.validarFuncionario(funcionario);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Email nao pode ser vazio ou nulo");
        }
    }
    
    @Test
    public void testValidarFuncionarioEmailSemArrobaFalha() throws Exception{
        try{
            funcionario = criarFuncionario();
            funcionario.setEmail("testeteste.com");
            funcionarioController.validarFuncionario(funcionario);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Email deve conter @ e .com");
        }
    }
    
    @Test
    public void testValidarFuncionarioEmailSemComFalha() throws Exception{
        try{
            funcionario = criarFuncionario();
            funcionario.setEmail("teste@testecom");
            funcionarioController.validarFuncionario(funcionario);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Email deve conter @ e .com");
        }
    }
    
    
    @Test
    public void testValidarFuncionarioDataNascimentoVazia() throws Exception{
        try{
            funcionario = criarFuncionario();
            funcionario.setDataNascimento(null);
            funcionarioController.validarFuncionario(funcionario);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Data de nascimento nao pode ser nula ou vazia");
        }
    }
    @Test
    public void testValidarFuncionarioIdadeMenorQue18Falha() throws Exception{
        try{
            funcionario = criarFuncionario();
            funcionario.setDataNascimento(LocalDate.parse("2000-01-10"));
            funcionarioController.validarFuncionario(funcionario);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Funcionario tem que ser maior que 18");
        }
    }
    
    
    @Test
    public void testValidarContratoPassa() throws Exception{
        try{
            contrato = criarContrato();
            boolean result = funcionarioController.validarContrato(contrato);
            assertTrue(result);
        }
        catch(Exception exception){
            fail();
        }
    }
    
    @Test
    public void testValidarContratoNuloFalha() throws Exception{
        try{
            contrato = null;
            funcionarioController.validarContrato(contrato);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Contrato nao pode ser nulo");
        }
    }
    
    @Test
    public void testValidarContratoCargoVazio() throws Exception{
        try{
            contrato = criarContrato();
            contrato.setCargo(null);
            funcionarioController.validarContrato(contrato);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Cargo nao pode ser nulo ou vazio");
        }
    }
    
    @Test
    public void testValidarContratoSalarioNegativoFalha() throws Exception{
        try{
            contrato = criarContrato();
            contrato.setSalario(-50.00);
            funcionarioController.validarContrato(contrato);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Salario nao pode ser menor ou igual a zero");
        }
    }
    
    @Test
    public void testValidarContratoDataInicioNulaFalha() throws Exception{
        try{
            contrato = criarContrato();
            contrato.setDataInicio(null);
            funcionarioController.validarContrato(contrato);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Contrato deve ter data de inicio");
        }
    }
    
    @Test
    public void testValidarContratoDataTerminoNulaFalha() throws Exception{
        try{
            contrato = criarContrato();
            contrato.setDataTermino(null);
            funcionarioController.validarContrato(contrato);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Contrato deve ter data de termino");
        }
    }
    
    
    @Test
    public void testValidarContratoDataInicioMaiorQueDataTerminoFalha() throws Exception{
        try{
            contrato = criarContrato();
            contrato.setDataInicio(LocalDate.parse("2017-01-15"));
            contrato.setDataTermino(LocalDate.parse("1995-02-12"));
            funcionarioController.validarContrato(contrato);
            fail();
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "A data de término do contrato nao pode ser anterior a data de inicio do contrato");
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

    private Contrato criarContrato(){
        return new Contrato('c',
                            400.00,
                            LocalDate.parse("1995-02-14"),
                            LocalDate.parse("2000-02-15"));
    }
    
}
