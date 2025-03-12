import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerificadorTest {

    private Verificador verificador = new Verificador();

    @Test
    public void testValidarCpfComMenosDigitos() {
        String resultado = verificador.validarCpf("123456789");
        assertEquals("menosdigitos", resultado);
    }

    @Test
    public void testValidarCpfComMaisDigitos() {
        String resultado = verificador.validarCpf("123456789012");
        assertEquals("maisdigitos", resultado);
    }

    @Test
    public void testValidarCpfComDigitosIguais() {
        String resultado = verificador.validarCpf("111.111.111-11");
        assertEquals("digitosiguais", resultado);
    }

    @Test
    public void testValidarCpfComLetras() {
        String resultado = verificador.validarCpf("123a567b8911");
        assertEquals("contemletras", resultado);
    }

    @Test
    public void testValidarCpfValido() {
        // CPF válido fictício
        String resultado = verificador.validarCpf("105.549.779-07");
        assertEquals("valido", resultado);
    }

    @Test
    public void testValidarCpfInvalido() {
        // CPF inválido fictício
        String resultado = verificador.validarCpf("12345678900");
        assertEquals("invalido", resultado);
    }
}
