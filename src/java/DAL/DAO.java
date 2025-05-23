/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.Acc;
import Entity.Cart;
import Entity.Category;
import Entity.Customer;
import Entity.Item;
import Entity.Order;
import Entity.Product;
import Entity.SQ;
import Entity.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PCMSI
 */
public class DAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE173276";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }
        public List<Acc> getAcc() {
        List<Acc> list = new ArrayList<>();
        String query = "select * from Account_HE173276";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Acc(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }
         public List<Order> getOrder() {
        List<Order> list = new ArrayList<>();
        String query = "select * from Orders_HE173276";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
           // ps.setString(1, cusid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Category> getCate() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Categories_HE173276";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {

        }
        return list;
    }
    public List<Supplier> getSup() {
        List<Supplier> list = new ArrayList<>();
        String query = "select * from Supplier_HE173276";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Supplier(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {

        }
        return list;
    }
    public List<SQ> getSQ() {
        List<SQ> list = new ArrayList<>();
        String query = "select * from ForgotPass_HE173276";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SQ(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> getProductByCateID(String cateid) {
        List<Product> list = new ArrayList<>();

        String query = "select * from Product_HE173276 where CategoryID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, cateid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }
    public List<Product> getProductBySupID(String supid) {
        List<Product> list = new ArrayList<>();

        String query = "select * from Product_HE173276 where SupplierID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, supid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Product getProductByID(String id) {
        String query = "select * from Product_HE173276 where ProductID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Product> getProductBySearch(String txtSearch) {
        List<Product> list = new ArrayList<>();

        String query = "select * from Product_HE173276 where ProductName like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Acc login(String user, String pass) {
        String query = "select * from Account_HE173276 where [user]=? and pass=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Acc(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
            }
        } catch (Exception e) {

        }
        return null;
    }
    

    public Acc checkUserValid(String user) {
        String query = "select * from Account_HE173276 where [user]=? ";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new Acc(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
            }
        } catch (Exception e) {

        }
        return null;
    }
    
     public Supplier checkSupValid(String sup) {
        String query = "select * from Supplier_HE173276 where SupplierName=? ";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, sup);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new Supplier(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {

        }
        return null;
    }
     
     public Category checkCateValid(String sup) {
        String query = "select * from Categories_HE173276 where CategoryName=? ";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, sup);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {

        }
        return null;
    }
     
    public void forgot( String user, String phone, String sq, String ans, String newpass) {
        String query = "update Account_HE173276 set pass=? where [user]=? and  phone=? and sqID=? and ans=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, newpass);
            ps.setString(2, user);
            ps.setString(3, phone);
            ps.setString(4, sq);
            ps.setString(5, ans);
           
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
    

    public void signup(String user, String pass,String name,String address,String phone,String sq,String ans) {
        String query = "insert into Account_HE173276 values((select MAX(uID) from Account_HE173276)+1,?,?,1,?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, name);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.setString(6, sq);
            ps.setString(7, ans);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void delete(String id) {
        String query = "delete from Product_HE173276 where ProductID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
    
    public void deletec(String id) {
        String query = "delete from Categories_HE173276 where CategoryID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
    
    public void deletes(String id) {
        String query = "delete from Supplier_HE173276 where SupplierID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
    
        public void deleteAcc(String id) {
        String query = "delete from Account_HE173276 where uID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void addP(String name, String img, String price, String des, String cateid,String supid) {
        String query = "insert into Product_HE173276(ProductID,ProductName,SupplierID,CategoryID,UnitPrice,img,des)\n"
                + "values((select MAX(ProductID) from Product_HE173276)+1,?,?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, supid);
            ps.setString(3, cateid);
            ps.setString(4, price);
            ps.setString(5, img);
            ps.setString(6, des);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
    
    public void addS(String name) {
        String query = "insert into Supplier_HE173276(SupplierID,SupplierName)\n"
                + "values((select MAX(SupplierID) from Supplier_HE173276)+1,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
    
    public void addC(String name) {
        String query = "insert into Categories_HE173276(CategoryID,CategoryName)\n"
                + "values((select MAX(CategoryID) from Categories_HE173276)+1,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void editP(String id, String name, String img, String price, String des, String cateid,String supid) {
        String query = "update Product_HE173276\n"
                + "set ProductName=?,\n"
                + "SupplierID=?,CategoryID=?,UnitPrice=?,img=?,\n"
                + "des=?\n"
                + "where ProductID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, supid);
            ps.setString(3, cateid);
            ps.setString(4, price);
            ps.setString(5, img);
            ps.setString(6, des);
            ps.setString(7, id);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void addOrder(Cart cart,Acc acc) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        LocalDate futureDate = curDate.plusDays(7);
        String fdate= futureDate.toString();
        String query = "insert into Orders_HE173276 values((select MAX(OrderID) from Orders_HE173276)+1,?,?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, acc.getUid());
            ps.setString(2, date);
            ps.setString(3, fdate);
            ps.setString(4, acc.getName());
            ps.setString(5, acc.getAddress());
            ps.setDouble(6, cart.getTotalMoney());
            ps.executeUpdate();
            //lay id cua order vua add
            String sql = "select MAX(OrderID) from Orders_HE173276";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            //add vao orderdetail
            if(rs.next()){
                int oid=rs.getInt(1);
                for(Item i:cart.getItems()){
                    String sql1="insert into OrderDetail_HE173276 values(?,?,?,?)";
                    PreparedStatement st1=con.prepareStatement(sql1);
                    st1.setInt(1, oid);
                    st1.setInt(2, i.getProduct().getId());
                    st1.setInt(3, i.getQuantity());
                    st1.setDouble(4, i.getPrice());
                    st1.executeUpdate();
                }
            }
            
        } catch  (Exception e){
            
        }
        }
    }
