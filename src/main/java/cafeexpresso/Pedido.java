package cafeexpresso;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> itens;
    private StatusPedido status;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemPedido novoItem = new ItemPedido(produto, quantidade);
        this.itens.add(novoItem);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void pagar() {
        if (this.status == StatusPedido.PENDENTE) {
            this.status = StatusPedido.PAGO;
        }
    }

    public void enviarParaCozinha() {
        if (this.status == StatusPedido.PAGO) {
            this.status = StatusPedido.EM_PREPARO;
        } else {
            System.out.println("Erro: Pedido precisa estar PAGO para ir para a cozinha.");
        }
    }

    public void finalizarPedido() {
        if (this.status == StatusPedido.EM_PREPARO) {
            this.status = StatusPedido.FINALIZADO;
        }
    }

    public StatusPedido getStatus() { 
        return status; 
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}