package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

type Category struct {
	Balance int
	Name    string
}

var categories = []Category{
	{Balance: 0, Name: "Principale"},
}

func getCategories() {
	for i, category := range categories {
		fmt.Printf("       %d. %s\n", i+1, category.Name)
	}
}

func checkBalance() {
	getCategories()
	fmt.Print("Vous souhaiteriez connaître le solde de quelle catégorie? (réponse: un nombre) : ")
	var input string
	fmt.Scanln(&input)
	categoryIndex, err := strconv.Atoi(input)
	if err != nil || categoryIndex < 1 || categoryIndex > len(categories) {
		fmt.Println("Entrée invalide.")
		return
	}
	fmt.Printf("Le solde de la catégorie %s est %d Ariary\n", categories[categoryIndex-1].Name, categories[categoryIndex-1].Balance)
}

func manageCost(willAdd bool) {
	getCategories()
	var action string
	if willAdd {
		action = "ajouter de l'argent"
	} else {
		action = "retirer de l'argent"
	}
	fmt.Printf("À quelle catégorie allez-vous %s? (réponse: un nombre) : ", action)
	var input string
	fmt.Scanln(&input)
	categoryIndex, err := strconv.Atoi(input)
	if err != nil || categoryIndex < 1 || categoryIndex > len(categories) {
		fmt.Println("La catégorie n'existe pas")
		return
	}
	fmt.Print("Saisissez la valeur à ", action, " : ")
	var valueInput string
	fmt.Scanln(&valueInput)
	value, err := strconv.Atoi(valueInput)
	if err != nil {
		fmt.Println("Valeur invalide.")
		return
	}

	if willAdd {
		categories[categoryIndex-1].Balance += value
		fmt.Println("Argent ajouté avec succès.")
	} else {
		categories[categoryIndex-1].Balance -= value
		fmt.Println("Argent retiré avec succès.")
	}
}

func budgetPlanning(willAddCategory bool) {
	if willAddCategory {
		fmt.Print("Veuillez saisir le nom de la catégorie : ")
		var categoryName string
		fmt.Scanln(&categoryName)
		categories = append(categories, Category{Balance: 0, Name: categoryName})
		fmt.Println("Catégorie ajoutée avec succès.")
	} else {
		getCategories()
		fmt.Print("Quelle catégorie allez-vous supprimer? (réponse : un nombre) : ")
		var input string
		fmt.Scanln(&input)
		categoryIndex, err := strconv.Atoi(input)
		if err != nil || categoryIndex < 1 || categoryIndex > len(categories) {
			fmt.Println("La catégorie n'existe pas")
			return
		}
		categories = append(categories[:categoryIndex-1], categories[categoryIndex:]...)
		fmt.Println("Catégorie retirée avec succès.")
	}
}

func wallet() {
	for {
		fmt.Println(`
        ===================================WALLET=====================================
                            SUIVI DE SOLDE
                                1. consulter votre solde
                            GESTION DE DEPENSE
                                2. Ajouter de l'argent
                                3. Retirer de l'argent
                            PLANIFICATION BUDGETAIRE
                                4. Voir toutes les catégories
                                5. Ajouter une nouvelle catégorie
                                6. Supprimer une catégorie
                                7. QUITTER
        ===============================================================================`)
		fmt.Print("Que souhaitez-vous faire? (réponse : un nombre de 1 à 7) : ")
		var option string
		fmt.Scanln(&option)
		switch option {
		case "1":
			checkBalance()
		case "2":
			manageCost(true)
		case "3":
			manageCost(false)
		case "4":
			getCategories()
		case "5":
			budgetPlanning(true)
		case "6":
			budgetPlanning(false)
		case "7":
			return
		default:
			fmt.Println("Veuillez choisir un nombre entre 1 et 7.")
		}
	}
}

func main() {
	wallet()
}
