/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencarshop.fornecedor.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import opencarshop.Endereco;
import opencarshop.fornecedor.model.Fornecedor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tharl
 */
public class FornecedorControllerTest {
    private Endereco endereco;
    private FornecedorController fornecedorController;
    private Fornecedor fornecedor;
    
    public FornecedorControllerTest() {
        fornecedorController = new FornecedorController();
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
    
    @Test
    public void testValidarFornecedorPassa() throws Exception{
        Fornecedor fornecedor = criarFornecedor();
        boolean result = fornecedorController.validarFornecedor(fornecedor);
        assertTrue(result);

    }
    @Test
    public void testValidarFornecedorNuloFalha() throws Exception{
        try{
            Fornecedor fornecedor = null;
            fornecedorController.validarFornecedor(fornecedor);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Fornecedor nulo");
        }
    }
    @Test
    public void testValidarFornecedorCnpjNulo() throws Exception{
        try{
            fornecedor = criarFornecedor();
            fornecedor.setCnpj(null);
            fornecedorController.validarFornecedor(fornecedor);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "CNPJ nao pode ser vazio ou nulo");
        }
    }
    @Test
    public void testValidarFornecedorRazaoSocialNulo() throws Exception{
        try{
            fornecedor = criarFornecedor();
            fornecedor.setRazaoSocial(null);
            fornecedorController.validarFornecedor(fornecedor);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "A razão social não pode ser vazia ou nula");
        }
    }
    @Test
    public void testValidarFornecedorEmailNulo() throws Exception{
        try{
            fornecedor = criarFornecedor();
            fornecedor.setEmail(null);
            fornecedorController.validarFornecedor(fornecedor);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Email nao pode ser vazio ou nulo");
        }
    }
    @Test
    public void testValidarFornecedorEmailIncompleto() throws Exception{
        try{
            fornecedor = criarFornecedor();
            fornecedor.setEmail("teste@ss");
            fornecedorController.validarFornecedor(fornecedor);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Email deve conter @ e .com");
        }
    }    
    @Test
    public void testValidarFornecedorTelefoneNulo() throws Exception{
        try{
            fornecedor = criarFornecedor();
            fornecedor.setTelefone1(null);
            fornecedorController.validarFornecedor(fornecedor);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "O telefone 1 não pode ser vazio");
        }
    }
    @Test
    public void testValidarFornecedorDescricaoNulo() throws Exception{
        try{
            fornecedor = criarFornecedor();
            fornecedor.setDescricao(null);
            fornecedorController.validarFornecedor(fornecedor);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "A descrição não pode ser vazia");
        }
    } 
    
    
    @Test
    public void testValidarEnderecoNulo() throws Exception{
        try{
            endereco = null;
            fornecedorController.validarEndereco(endereco);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Endereco nulo");
        }
    } 
    @Test
    public void testValidarEnderecoBairroNulo() throws Exception{
        try{
            endereco = criaEndereco();
            endereco.setBairro(null);
            fornecedorController.validarEndereco(endereco);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Bairro não pode ser vazio ou nulo");
        }
    } 
    
    @Test
    public void testValidarEnderecoCEPNulo() throws Exception{
        try{
            endereco = criaEndereco();
            endereco.setCEP(null);
            fornecedorController.validarEndereco(endereco);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "CEP não pode ser vazio ou nulo");
        }
    } 
    
    @Test
    public void testValidarEnderecoCidadeNulo() throws Exception{
        try{
            endereco = criaEndereco();
            endereco.setCidade(null);
            fornecedorController.validarEndereco(endereco);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Cidade não pode ser vazio ou nulo");
        }
    } 
    
    @Test
    public void testValidarEnderecoComplementoNulo() throws Exception{
        try{
            endereco = criaEndereco();
            endereco.setComplemento(null);
            fornecedorController.validarEndereco(endereco);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Complemento não pode ser vazio ou nulo");
        }
    } 
    
    
    @Test
    public void testValidarEnderecoEstadoNulo() throws Exception{
        try{
            endereco = criaEndereco();
            endereco.setEstado(null);
            fornecedorController.validarEndereco(endereco);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "Estado não pode ser vazio ou nulo");
        }
    } 
    
    @Test
    public void testValidarEnderecoRuaNulo() throws Exception{
        try{
            endereco = criaEndereco();
            endereco.setRua(null);
            fornecedorController.validarEndereco(endereco);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "A rua não pode ser vazio ou nulo");
        }
    } 
    
    @Test
    public void testValidarEnderecoTipoNulo() throws Exception{
        try{
            endereco = criaEndereco();
            endereco.setTipo(null);
            fornecedorController.validarEndereco(endereco);
        }
        catch(Exception exception){
            assertEquals(exception.getMessage(), "O tipo de endereço não pode ser vazio ou nulo");
        }
    } 
    
  
     private Fornecedor criarFornecedor(){
        return new Fornecedor("123456",
                               "teste",
                               "teste@teste.com",
                               "12345678",
                               "12345667",
                               "12345667",
                               false);
    }
     private Endereco criaEndereco()
     {
         return new Endereco("4545455",
                            "sergipe",
                            "aracaju",
                            "centro",
                            "dsdsa",
                            121,
                            "complemento",
                            's');
    
     }
}
