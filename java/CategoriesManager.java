import java.util.ArrayList;
import java.util.Scanner;

public class CategoriesManager {

    private static ArrayList<Category> categories = new ArrayList<Category>();

    static {
        categories.add(new Category(0, "Principale"));
    }

    public static void setCategories(ArrayList<Category> categories) {
        CategoriesManager.categories = categories;
    }

    public static ArrayList<Category> getCategories() {
        return categories;
    }

    public static void displayCategories() {

        for (int i = 0; i < categories.size(); i++) {
            int index = i+1;
            System.out.println(index + "-" + getCategories().get(i).getName());
        }
    }

    public static void addCategory(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir le nom de la catégorie : ");
        String newCategoryName = scanner.nextLine();
        ArrayList<Category> categories = getCategories();
        categories.add(new Category(0, newCategoryName));
        setCategories(categories);
        System.out.println("Catégorie ajoutée avec succès.");
    }

    public static void deleteCategory() {
        Scanner scanner = new Scanner(System.in);
        displayCategories();
        System.out.print("Quelle catégorie allez-vous supprimer? (réponse : un nombre) : ");
        int categoryIndex = scanner.nextInt();
        if (categoryIndex >= 1 && categoryIndex <= getCategories().size()) {
            ArrayList<Category> categories = getCategories();
            categories.remove(categoryIndex - 1);
            setCategories(categories);
            System.out.println("Catégorie retirée avec succès.");
        } else {
            System.out.println("La catégorie n'existe pas");
        }
    }
    public static void checkBalance() {
        displayCategories();
        System.out.print("Vous souhaiteriez connaître le solde de quelle catégorie? (réponse: un nombre) : ");
        Scanner scanner = new Scanner(System.in);
        int categoryIndex = scanner.nextInt();

        if (categoryIndex >= 1 && categoryIndex <= getCategories().size()) {
            System.out.printf("Le solde de la catégorie %s est %d Ariary%n",
                    getCategories().get(categoryIndex - 1).getName(), getCategories().get(categoryIndex - 1).getBalance());
        } else {
            System.out.println("Catégorie invalide.");
        }
    }

}