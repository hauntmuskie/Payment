public class Order {
    String name, type, sugar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Order(String name, String type, String sugar, int qty) {
        this.name = name;
        this.type = type;
        this.sugar = sugar;
        this.qty = qty;
    }

    int qty;

}