import java.util.Scanner;

public class Wallet {
    public static void prompt(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "\n===================================WALLET=====================================\n" +
                            "                        SUIVI DE SOLDE\n" +
                            "                                1. consulter votre solde\n" +
                            "                        GESTION DE DEPENSE\n" +
                            "                                2. Ajouter de l'argent\n" +
                            "                                3. Retirer de l'argent\n" +
                            "                        PLANIFICATION BUDGETAIRE\n" +
                            "                                4. Voir toutes les catégories\n" +
                            "                                5. Ajouter une nouvelle catégorie\n" +
                            "                                6. Supprimer une catégorie\n" +
                            "                                7. QUITTER\n" +
                            "================================================================================");
            System.out.print("Que souhaitez-vous faire? (réponse : un nombre de 1 à 7) : ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    CategoriesManager.checkBalance();
                    break;
                case 2:
                    CostManager.handleMoney(true);
                    break;
                case 3:
                    CostManager.handleMoney(false);
                    break;
                case 4:
                    CategoriesManager.displayCategories();
                    break;
                case 5:
                    CategoriesManager.addCategory();
                    break;
                case 6:
                    CategoriesManager.deleteCategory();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Veuillez choisir un nombre entre 1 et 7.");
                    break;
            }
        }
    }
    public Wallet() {
    }

}
