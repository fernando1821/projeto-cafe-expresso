import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    public void testCriacaoProduto() {
        // Testa se o produto é instanciado corretamente com os valores passados
        Produto produto = new Produto("Café Expresso", 5.50);
        
        assertEquals("Café Expresso", produto.getNome());
        assertEquals(5.50, produto.getPrecoUnitario());
    }
}