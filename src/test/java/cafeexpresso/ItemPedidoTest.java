package cafeexpresso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ItemPedidoTest {

    @Test
    public void testCalculoSubtotal() {
        Produto cafe = new Produto("Café Expresso", 5.00);
        ItemPedido item = new ItemPedido(cafe, 3);
        
        // Testa se o subtotal está correto (5.00 * 3 = 15.00)
        assertEquals(15.00, item.calcularSubtotal());
        assertEquals("Café Expresso", item.getProduto().getNome());
        assertEquals(3, item.getQuantidade());
        
    }
    
}