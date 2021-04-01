package Lab04;

public class Order {

    public static final int MAX_NUMBER_ORDER = 10;
    private DVD[] item_ordered = new DVD[MAX_NUMBER_ORDER];
    private int qty_ordered = 0;

    public void addDVD(DVD disc){
        this.item_ordered[qty_ordered] = disc;
        this.qty_ordered ++;
    }

    public void removeDVD(DVD disc){
        DVD[] new_item_ordered = new DVD[MAX_NUMBER_ORDER];

        for (int i = 0; i<this.qty_ordered; i++){
            if (this.item_ordered[i] == disc){
                this.item_ordered[i].setDelete(true);
            }
        }

        int j = 0;
        for (int i = 0; i<this.qty_ordered; i++){
            if (!this.item_ordered[i].isDelete()){
                new_item_ordered[j++] = this.item_ordered[i];
            }
        }

        this.item_ordered = new_item_ordered;
        this.qty_ordered--;
    }

    public float totalCost(){
        float total = 0;
        for (int i = 0; i<this.qty_ordered; i++){
            total += this.item_ordered[i].getCost();
        }
        return total;
    }

    public void listDVDs() {
        System.out.println(this.qty_ordered);
        for (int i = 0; i < this.qty_ordered; i++) {
            System.out.println(i + " " + this.item_ordered[i].getTitle());
        }
    }
}
