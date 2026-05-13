package cafeexpresso;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    // Teste 1: Garante que a soma do carrinho está correta (Não apagamos!)
    @Test
    public void testSomaTotalPedido() {
        Produto cafe = new Produto("Café Expresso", 5.00);
        Produto paoDeQueijo = new Produto("Pão de Queijo", 4.00);
        
        Pedido pedido = new Pedido();
        pedido.adicionarItem(cafe, 2); // 2 cafés = 10.00
        pedido.adicionarItem(paoDeQueijo, 1); // 1 pão de queijo = 4.00
        
        assertEquals(14.00, pedido.calcularTotal());
        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
    }

    // Teste 2: Garante que as regras de status funcionam (Incremento novo!)
    @Test
    public void testFluxoDeStatus() {
        Pedido pedido = new Pedido();
        
        // Tenta enviar para a cozinha antes de pagar (Tem que falhar e continuar PENDENTE)
        pedido.enviarParaCozinha(); 
        assertEquals(StatusPedido.PENDENTE, pedido.getStatus()); 
        
        // Cliente paga o pedido
        pedido.pagar();
        assertEquals(StatusPedido.PAGO, pedido.getStatus());
        
        // Agora sim vai para a cozinha
        pedido.enviarParaCozinha();
        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());
        
        // Atendente entrega ao cliente
        pedido.finalizarPedido();
        assertEquals(StatusPedido.FINALIZADO, pedido.getStatus());
    }
}