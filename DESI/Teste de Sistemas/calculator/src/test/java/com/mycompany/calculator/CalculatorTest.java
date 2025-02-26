package com.mycompany.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author julio_busarello
 */
public class CalculatorTest {
    
    public CalculatorTest() {
        
    }
    
    @Test
    void testSoma() {
        Calculator c = new Calculator();
        Assertions.assertEquals(5, c.soma(2, 3));
    }
    
    @Test
    void testSubtracao() {
        Calculator c = new Calculator();
        Assertions.assertEquals(-1, c.subtrair(2, 3));
    }
    
    @Test
    void testMultiplicar() {
        Calculator c = new Calculator();
        Assertions.assertEquals(4, c.multiplicar(2, 2));
    }
    
    @Test
    void testDividir() {
        Calculator c = new Calculator();
        Assertions.assertEquals(32, c.dividir(64, 2));
        //Assertions.assertEquals(0, c.dividir(64, 0));
    }
    
    @Test
    void testDividirPorZero() {
        Calculator c = new Calculator();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.dividir(3, 0);
        });
        Assertions.assertEquals("Não é possível dividir por zero!", exception.getMessage());
    }
    
    @Test
    void testPotencializar() {
        Calculator c = new Calculator();
        Assertions.assertEquals(256, c.potencializar(4, 4));
    }
    
}
