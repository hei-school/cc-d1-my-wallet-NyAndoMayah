import java.util.ArrayList;
import java.util.Scanner;

public class CostManager {
    public static void handleMoney(boolean addMoney){
        CategoriesManager.getCategories();
        Scanner scanner = new Scanner(System.in);
        String action = addMoney ? "ajouter de l'argent" : "retirer de l'argent";
        System.out.printf("À quelle catégorie allez-vous %s? (réponse: un nombre) : ", action);
        int categoryIndex = scanner.nextInt();
        ArrayList<Category> categories = CategoriesManager.getCategories();

        if (categoryIndex >= 1 && categoryIndex <= categories.size()) {
            System.out.printf("Saisissez la valeur à %s : ", action);
            int value = scanner.nextInt();
            Category category = categories.get(categoryIndex - 1);
            if (addMoney) {
                category.setBalance(category.getBalance() + value);
                System.out.println("Argent ajouté avec succès.");
            } else {
                category.setBalance(category.getBalance() - value);
                System.out.println("Argent retiré avec succès.");
            }
        } else {
            System.out.println("La catégorie n'existe pas");
        }
    }
}
