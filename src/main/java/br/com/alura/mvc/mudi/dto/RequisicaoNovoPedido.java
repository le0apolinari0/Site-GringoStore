package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class RequisicaoNovoPedido {
    @NotBlank  @Size(min = 2, max = 100)
    private String nomeProduto;
    @NotBlank @Size(min = 2, max = 5000)
    private String urlProduto;
    @NotBlank  @Size(min = 2, max = 2000)
    private String urlImagem;
    private String descricao;


    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeproduto) {
        this.nomeProduto = nomeproduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlProduto(urlProduto);
        pedido.setUrlImagem(urlImagem);
        pedido.setDescricao(descricao);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setStatus(StatusPedido.APROVADO);
        pedido.setStatus(StatusPedido.ENTREGUE);
        return pedido;
    }
}
