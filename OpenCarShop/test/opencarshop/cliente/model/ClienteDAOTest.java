/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencarshop.cliente.model;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import opencarshop.Endereco;
import opencarshop.util.ConexaoMySQL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author keoma
 */
public class ClienteDAOTest {
   //  private Connection conn;
    //private final ConexaoMySQL c = new ConexaoMySQL();
  
   public ClienteDAOTest() {
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
     * Test of cadastraCliente method, of class ClienteDAO.
     */
    

   
     @Test //testa se o metodo cadastra objeto nulo
    public void testCadastraClienteCpfZero () throws Exception {
        System.out.println("Testando metodo cadastrarCliente com cpf igual a zero");
        Cliente cli = new Cliente();
        cli.setCpf("0");     //CPF Invalido
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate date = LocalDate.parse("2005-nov-12", formatter);
     cli.setNome("TesteCPF");
     cli.setDataNascimento(date);
     cli.setEmail("teste@gmail.com");
     cli.setTelefone1("22222");
     cli.setTelefone2("telefone2");
      cli.setAtivo(true);
      Endereco end = new Endereco();
      end.setBairro("Teste");
      end.setCEP("444444");
      end.setCidade("Aracaju");
      end.setEstado("SE");
      end.setNumero(10);
      end.setRua("Rua");
      end.setComplemento("complemento");
      end.setTipo(Character.MIN_VALUE);
        
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = false;
        boolean result = instance.cadastraCliente(cli, end);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
     @Test 
    public void testCadastraClienteNomeVazio () throws Exception {
        System.out.println("Testando cadastraCliente com nome vazio");
        Cliente cli = new Cliente();
        cli.setCpf("2222222");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate date = LocalDate.parse("2005-nov-12", formatter);
     cli.setNome("");       //Nome Vazio
     cli.setDataNascimento(date);
     cli.setEmail("teste@gmail.com");
     cli.setTelefone1("22222");
     cli.setTelefone2("telefone2");
      cli.setAtivo(true);
      Endereco end = new Endereco();
      end.setBairro("Teste");
      end.setCEP("444444");
      end.setCidade("Aracaju");
      end.setEstado("Se");
      end.setNumero(10);
      end.setRua("Rua");
      end.setComplemento("complemento");
      end.setTipo(Character.MIN_VALUE);
        
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = false;
        boolean result = instance.cadastraCliente(cli, end);
        assertEquals(expResult, result);
      
    }
    
    
    
     @Test //testa se o metodo cadastra objeto nulo
    public void testCadastraClienteEstadoVazio () throws Exception {
        System.out.println("Testando cadastraCliente com estado do endereço vazio");
        Cliente cli = new Cliente();
        cli.setCpf("3333333");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate date = LocalDate.parse("2005-nov-12", formatter);
     cli.setNome("testeEstadoVazio");
     cli.setDataNascimento(date);
     cli.setEmail("teste@gmail.com");
     cli.setTelefone1("22222");
     cli.setTelefone2("telefone2");
      cli.setAtivo(true);
      Endereco end = new Endereco();
      end.setBairro("Teste");
      end.setCEP("444444");
      end.setCidade("Aracaju");
      end.setEstado("");          //Estado vazio
      end.setNumero(10);
      end.setRua("Rua");
      end.setComplemento("complemento");
      end.setTipo(Character.MIN_VALUE);
        
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = false;
        boolean result = instance.cadastraCliente(cli, end);
        assertEquals(expResult, result);
      
    }
    
     @Test //testa se o metodo cadastra objeto nulo
    public void testCadastraClienteEmailNulo () throws Exception {
        System.out.println("Testando cadastraCliente com email vazio");
        Cliente cli = new Cliente();
        cli.setCpf("4444444");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate date = LocalDate.parse("2005-nov-12", formatter);
     cli.setNome("testeEmailNulo");
     cli.setDataNascimento(date);
     cli.setEmail("teste@@@");   ////emial nulo
     cli.setTelefone1("22222");
     cli.setTelefone2("telefone2");
      cli.setAtivo(true);
      Endereco end = new Endereco();
      end.setBairro("Teste");
      end.setCEP("444444");
      end.setCidade("Aracaju");
      end.setEstado("SE");
      end.setNumero(10);
      end.setRua("Rua");
      end.setComplemento("complemento");
      end.setTipo(Character.MIN_VALUE);
        
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = false;
        boolean result = instance.cadastraCliente(cli, end);
        assertEquals(expResult, result);
      
    }
     
    
    @Test //testa se o metodo cadastra objeto nulo
    public void testCadastraClienteTelefonelNulo () throws Exception {
        System.out.println("Testando cadastraCliente com telefone vazio");
        Cliente cli = new Cliente();
        cli.setCpf("555555");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate date = LocalDate.parse("2005-nov-12", formatter);
     cli.setNome("TesteTelefoneNulo");
     cli.setDataNascimento(date);
     cli.setEmail("teste@gmail.com");   
     cli.setTelefone1("");   //telefones nulos
     cli.setTelefone2("");
      cli.setAtivo(true);
      Endereco end = new Endereco();
      end.setBairro("Teste");
      end.setCEP("444444");
      end.setCidade("Aracaju");
      end.setEstado("SE");
      end.setNumero(10);
      end.setRua("Rua");
      end.setComplemento("complemento");
      end.setTipo(Character.MIN_VALUE);
        
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = false;
        boolean result = instance.cadastraCliente(cli, end);
        assertEquals(expResult, result);
      
    }
    
    
    
    
    
    
   
    
    
}
