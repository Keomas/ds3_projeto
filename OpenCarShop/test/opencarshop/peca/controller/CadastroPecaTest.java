/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencarshop.peca.controller;

import java.net.URL;
import java.util.ResourceBundle;
import opencarshop.peca.model.Peca;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexandre
 */
public class CadastroPecaTest {
    
    private Peca peca;
    private CadastroPeca cadastroPeca;
    public CadastroPecaTest() {
        cadastroPeca = new CadastroPeca();
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
     * Test of validaPeca method, of class CadastroPeca.
     */
    @Test
    public void testValidaPecaValidaPassa() throws Exception{
        try{
            peca = criarPeca();
            boolean result = cadastroPeca.validaPeca(peca);
            assertTrue(result);
        }catch(Exception exception){
            fail();
        }
    }
    
    @Test
    public void testValidaPecaNulaFalha() throws Exception{
        try{
            peca = null;
            cadastroPeca.validaPeca(peca);
            fail();
        }catch(Exception exception){
            assertEquals("Peca nula", exception.getMessage());
        }
    }
    
    @Test
    public void testValidaPecaNomeVazioFalha() throws Exception{
        try{
            peca = criarPeca();
            peca.setNome("");
            cadastroPeca.validaPeca(peca);
            fail();
        }catch(Exception exception){
            assertEquals("Nome nao pode ser nulo ou vazio", exception.getMessage());
        }
    }
    
    @Test
    public void testValidaPecaQuantidadeNegativaFalha() throws Exception{
        try{
            peca = criarPeca();
            peca.setQuantidade(-1);
            cadastroPeca.validaPeca(peca);
            fail();
        }catch(Exception exception){
            assertEquals("Quantidade nao pode ser negativa", exception.getMessage());
        }
    }
    
    @Test
    public void testValidaPecaValorNegativoFalha() throws Exception{
        try{
            peca = criarPeca();
            peca.setValor(-1.00);
            cadastroPeca.validaPeca(peca);
            fail();
        }catch(Exception exception){
            assertEquals("Valor nao pode ser negativo", exception.getMessage());
        }
    }
    
    private Peca criarPeca(){
        return new Peca(1, "teste", 10.0, 1, true);
    }
    
}
