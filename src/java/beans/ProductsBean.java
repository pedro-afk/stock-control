package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import models.Products;

@ManagedBean(name = "products")
@SessionScoped

public class ProductsBean {

    private Products l;

    public ProductsBean() {
        l = new Products();

    }

    public Products getL() {
        return l;
    }

    public void setL(Products l) {
        this.l = l;
    }

    public String executaGravacao() {
        if (l.gravar()) {
            return "/mensagemSucesso";
        } else {
            return "/mensagemErro";
        }
    }

    public List<Products> buscarLivros() {
        return l.getProducts();
    }

}
