/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PCMSI
 */
public class Cart {
    private List<Item> items;

    public Cart() {
        items=new ArrayList<>();
    }
    public Cart(List<Item> items){
        this.items=items;
    }
    private Item getItemById(int id){
        for(Item i:items){
            if(i.getProduct().getId()==id){
                return i;
            }           
        }
        return null;
    } 
    public int getQuantityById(int id){
        return getItemById(id).getQuantity();
    }
    //them vao gio
    public void addItem(Item t){
        //co r
        if(getItemById(t.getProduct().getId())!=null){
            Item i=getItemById(t.getProduct().getId());
            i.setQuantity(i.getQuantity()+t.getQuantity());
        }else{
            items.add(t);
        }
    }
    
        public void minusItem(Item t){
        //co r
        if(getItemById(t.getProduct().getId())!=null){
            Item i=getItemById(t.getProduct().getId());
            i.setQuantity(i.getQuantity()-t.getQuantity());
        }
    }
    public void removeItem(int id){
        if(getItemById(id)!=null){
            items.remove(getItemById(id));
        }
    }
    public double getTotalMoney(){
        double t=0;
        for(Item i:items)
            t+=i.getQuantity()*i.getPrice();
        return t;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
