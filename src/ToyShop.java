import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyShop(){
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addToy(Toy toy){
        toys.add(toy);
    }
    public void updateToyWeight(int toyId, double weight){
        for(Toy toy : toys){
            if (toy.getId() == toyId){
                toy.setWeight(weight);
                break;
            }
        }
    }

    public Toy selectPrizeToy(){
        double totalWeight = 0;
        for (Toy toy : toys){
            totalWeight += toy.getWeight();
        }
        Random random = new Random();
        double randomNumber = random.nextDouble() * totalWeight;

        double cumulativeWeight = 0;
        for (Toy toy : toys){
            cumulativeWeight += toy.getWeight();
            if (randomNumber <= cumulativeWeight){
                Toy prizeToy = new Toy(toy.getId(), toy.getName(),1, toy.getWeight());
                toys.remove(toy);
                prizeToys.add(prizeToy);
                return prizeToy;
            }
        }
        return null;
    }
    public void getPrizeToy(){
        if(!prizeToys.isEmpty()){
            Toy prizeToy = prizeToys.get(0);
            prizeToys.remove(0);

            try {
                FileWriter writer = new FileWriter("prize_toys.txt", true);
                writer.write(prizeToy.getId() + "," + prizeToy.getName() + "\n" );
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            prizeToy.setQuantity(prizeToy.getQuantity()-1);
        }

    }
}
