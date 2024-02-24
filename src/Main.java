import java.util.List;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        Toy toy1 = new Toy(1, "Teddy Bear", 2, 0.5);
        Toy toy2 = new Toy(2, "Building Blocks", 5, 1.2);
        Toy toy3 = new Toy(3, "Doll", 3, 3.2);
        Toy toy4 = new Toy(4, "Car", 3, 1.2);


        toyShop.addToy(toy1);
        toyShop.addToy(toy2);
        toyShop.addToy(toy3);
        toyShop.addToy(toy4);
        toyShop.updateToyWeight(1, 0.7);

        Toy prizeToy = toyShop.selectPrizeToy();
        if (prizeToy != null) {
            System.out.println("Prize Toy:");
            System.out.println("ID: " + prizeToy.getId());
            System.out.println("Name: " + prizeToy.getName());
            System.out.println("Quantity: " + prizeToy.getQuantity());
            System.out.println("Weight: " + prizeToy.getWeight());
            System.out.println();
        }
        toyShop.getPrizeToy();
    }
}


