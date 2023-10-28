import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final String FILENAME = "toys.csv";

    public static void main(String[] args){
        try{
            ToyShop shop = new ToyShop();
            File toyFile = new File(FILENAME);
            
            if(!toyFile.exists()){
                toyFile.createNewFile();
                shop.add(new Toy(1, "Pop it", 5, 20));
                shop.add(new Toy(2, "Кукла Барби", 6, 18));
                shop.add(new Toy(3, "Машинка Хот Вилс", 3, 15));
                shop.add(new Toy(4, "Мишка Teddy", 10, 10));
                shop.add(new Toy(5,"Трактор Синий", 12, 13));
                shop.saveToFile(FILENAME);
            } else {
                shop.loadFromFile(FILENAME);
            }
            shop.setWeight(2, 30); // изменить вес куклы на 30%
            ArrayList<String> toyList = shop.getToyList(); //получить список игруше в магазине
            for (String toy : toyList){
                System.out.println(toy);
            }

            ArrayList<Toy> winners = shop.playGame(4); // разыграть 4 игрушки
            System.out.println("Выиграли следующие игрушки: ");
            for(Toy t : winners) {
                System.out.println(t.getName());
            }

            shop.saveToFile(FILENAME); // сохранить данные об игрушках в файл

        } catch(IOException e) {
            System.out.println("Ошибка при работе с файлпми: " + e.getMessage());
        }
    }  
} 
