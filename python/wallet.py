categories = [
    {"balance": 0, "name": "Principale"}
]

def get_categories():
    for index, category in enumerate(categories, start=1):
        print(f"       {index}. {category['name']}")

def check_balance():
    get_categories()
    category_index = int(input("Vous souhaiteriez connaître le solde de quelle catégorie? (réponse: un nombre) : "))
    print(f"La solde de la catégorie {categories[category_index - 1]['name']} est {categories[category_index - 1]['balance']} Ariary")

def manage_cost(will_add):
    get_categories()
    if will_add:
        category_index = int(input("A quelle catégorie allez-vous ajouter de l'argent? (réponse: un nombre) : "))
        if category_index <= len(categories):
            value = int(input("Saisissez la valeur à ajouter : "))
            categories[category_index - 1]["balance"] += value
            print('Argent ajoutée avec succès.')
        else:
            print("La catégorie n'existe pas")
    else:
        category_index = int(input("A quelle catégorie allez-vous retirer de l'argent? (réponse: un nombre) : "))
        if category_index <= len(categories):
            value = int(input("Saisissez la valeur à retirer : "))
            categories[category_index - 1]["balance"] -= value
            print('Argent retirée avec succès.')
        else:
            print("La catégorie n'existe pas")

def budget_planning(will_add_category):
    if will_add_category:
        new_category_name = input("Veuillez saisir le nom de la catégorie : ")
        categories.append({"balance": 0, "name": new_category_name})
        print('Catégorie ajoutée avec succès.')
    else:
        get_categories()
        category_index = int(input("Quelle catégorie allez-vous supprimmer? (réponse : un nombre) : "))
        if category_index <= len(categories):
            categories.pop(category_index - 1)
            print('Catégorie retirée avec succès.')
        else:
            print("La catégorie n'existe pas")

def wallet():
    quit_option = 7
    while True:
        print('''
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
        ===============================================================================''')
        try:
            option = int(input('Que souhaitez-vous faire? (réponse : un nombre de 1 à 7) : '))
            if option == 1:
                check_balance()
            elif option == 2:
                manage_cost(True)
            elif option == 3:
                manage_cost(False)
            elif option == 4:
                get_categories()
            elif option == 5:
                budget_planning(True)
            elif option == 6:
                budget_planning(False)
            elif option == 7:
                return
            else:
                print('Veuillez choisir un nombre entre 1 et 7.')
        except ValueError:
            print('Veuillez saisir un nombre valide.')

wallet()
