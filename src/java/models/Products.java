/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Products {

    private int id;
    private String name;
    private String description;
    private double price;
    private int qtd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public boolean gravar() {
        try {
            java.sql.Connection conexao = new Conexao().conectar();
            if (conexao != null) {
                String sql = "insert into products(name, description, price, qtd) values(?,?,?,?)";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, description);
                ps.setDouble(3, price);
                ps.setInt(4, qtd);

                ps.execute();
                ps.close();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("An error ocurred " + e);
            return false;
        }
    }

    public ArrayList<Products> getProducts() {
        java.sql.Connection conexao = new Conexao().conectar();
        String sql = "SELECT * FROM products ORDER BY id DESC";

        try {
            if (conexao != null) {
                PreparedStatement ps = conexao.prepareStatement(sql);
                // executa query
                ResultSet result = ps.executeQuery();
                ArrayList<Products> list = new ArrayList<>();

                // enquanto tiver próximo
                while (result.next()) {
                    Products p = new Products();
                    p.setId(result.getInt("id"));
                    p.setName(result.getString("name"));
                    p.setDescription(result.getString("description"));
                    p.setPrice(result.getDouble("price"));
                    p.setQtd(result.getInt("qtd"));
                    list.add(p);
                }
                conexao.close();
                return list;

            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.print("Exceção gerada ao tentar buscar os dados: " + e.getMessage());

            return null;
        }
    }

    public boolean deletaProduto(int idProd) {
        try {
            java.sql.Connection conexao = new Conexao().conectar();
            String sql = "DELETE FROM products WHERE id = ?";
            System.out.print(sql);
            if (conexao != null) {
                PreparedStatement ps = conexao.prepareStatement(sql);
                System.out.print(getId());

                ps.setInt(1, idProd);
                ps.execute();
                conexao.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

    }

    public boolean alteraProduto(int idProd) {

        try {
            java.sql.Connection conexao = new Conexao().conectar();
            if(conexao != null){
                
            String sql = ("update products set name=?, description=?, price=?, qtd=? where id="+idProd);
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.setInt(4, qtd);
            //ps.setInt(5, idProd);

            ps.execute();
            ps.close();
            return true;
            }
            else{
                return false;
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    
}
