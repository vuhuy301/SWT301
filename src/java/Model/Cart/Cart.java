package Model.Cart;

import Model.Product;
import java.util.ArrayList;
import java.util.List;

public final class Cart {

    List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getItemByProductID(int productID) {
        for (Item item : items) {
            if (item.getProduct().getId() == productID) {
                return item;
            }
        }
        return null;
    }

    public int getQuantityByProductID(int productID) {
        return getItemByProductID(productID).getQuantity();
    }

    public double getTotalMoney() {
        double total = 0;
        for (Item item : items) {
            total += item.getSubTotal();
        }
        return total;
    }

    public void addItem(Item item) {
        if (getItemByProductID(item.getProduct().getId()) != null) {
            Item addItem = getItemByProductID(item.getProduct().getId());
            addItem.setQuantity(addItem.getQuantity() + item.getQuantity());
        } else {
            items.add(item);
        }
    }

    public void removeItem(int productID) {
        if (getItemByProductID(productID) != null) {
            items.remove(getItemByProductID(productID));
        }
    }

    private Product getProductByProductID(int productID, List<Product> list) {
        for (Product item : list) {
            if (item.getId() == productID) {
                return item;
            }
        }
        return null;
    }

    public Cart(String txt, List<Product> list) {
        items = new ArrayList<>();
        try {

            if (txt != null && txt.length() != 0) {
                String[] itemLines = txt.split("-");

                for (String itemLine : itemLines) {
                    String[] itemDetails = itemLine.split("_");

                    int id = Integer.parseInt(itemDetails[0]);

                    String[] last = itemDetails[1].split("/");

                    int quantity = Integer.parseInt(last[0]);

                    String[] last_last = last[1].split(":");
//
                    for (String s : last_last) {
                        System.out.println(s);
                    }

                    String size = last_last[0];
                    String color = last_last[1];

                    Product product = getProductByProductID(id, list);

                    Item newItem = new Item(product, id, quantity, size, color);

                    if (getItemByProductID(newItem.getProduct().getId()) != null) {
                        Item oldItem = getItemByProductID(newItem.getProduct().getId());
                        oldItem.setQuantity(oldItem.getQuantity() + newItem.getQuantity());
                    } else {
                        items.add(newItem);
                    }
                }

            }

        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

}
