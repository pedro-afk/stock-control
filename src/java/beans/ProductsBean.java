package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import models.Products;

@ManagedBean(name = "products")
@SessionScoped

public class ProductsBean {

    private Products p;

    public ProductsBean() {
        p = new Products();
    }

    public Products getP() {
        return p;
    }

    public void setP(Products prod) {
        this.p = prod;
    }

    public void executaGravacao() {
        if (p.gravar()) {
            // return "/sucesso";
            System.out.println("Operação relaizada com êxito");
        } else {
            System.out.println("Operação relaizada com erro");
            // return "/erro";
        }
    }

    public List<Products> buscarProducts() {
        return p.getProducts();
    }

    public void deleteProd(int id) {

        if (p.deletaProduto(id)) {
            System.out.println(id + "parou aqui");
        } else {
            System.out.println("Error");
        }
    }

    public String alterar(int id) {
        
        if(p.alteraProduto(id)){
            return "/index";
            
        }
        else{
            return "/erro";
        }
    }


}
