/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gerenciadordeprovas.tests;

import gerenciadordeprovas.Alternativa;
import gerenciadordeprovas.Questao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristiano
 */
public class TestJunit {
    private Alternativa alternativaCerta;
    private Questao questao; 
    public TestJunit() {
    }
    
        
    @Before
    public void setUp() {
        System.out.println("Teste Iniciado");
        questao = new Questao();
        questao.setEnunciado("Qual idade final de Cristo?");
        alternativaCerta = new Alternativa("33");
        alternativaCerta.setQuestao(questao);
        questao.addAlternativaErrada(new Alternativa("25"));
        questao.addAlternativaErrada(new Alternativa("34"));
        questao.addAlternativaErrada(new Alternativa("45"));
        questao.addAlternativaErrada(new Alternativa("16"));
    }
    
    @After
    public void tearDown() {
        System.out.println("Teste Finalizado");
    }

    @Test
    public void test1(){
        assertEquals(new Alternativa("33"), alternativaCerta);
        assertEquals(questao, alternativaCerta.getQuestao());
        assertEquals(questao.getAlternativasErradas(), alternativaCerta.getQuestao().getAlternativasErradas());
    }
}
