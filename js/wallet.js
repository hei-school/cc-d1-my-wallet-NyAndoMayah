import promptSync from 'prompt-sync';
const prompt = promptSync({});

const categories = [
    { balance: 0, name: 'Principale'}
];

const getCategories = () => {
    for (const category of categories) {
        console.log(`       ${categories.indexOf(category) + 1}. ${category.name}`)
    }
}
const checkBalance = () => {
    getCategories()
    const categoryIndex = +prompt('Vous souhaiteriez connaître le solde de quelle catégorie? (réponse: un nombre) : ')
    console.log(`La solde de la catégorie ${categories[categoryIndex - 1].name} est ${categories[categoryIndex - 1].balance} Ariary`)
}
const manageCost = (willAdd) => {
    getCategories()
    if(willAdd){
        const categoryIndex = +prompt("A quelle catégorie allez-vous ajouter de l'argent? (réponse: un nombre) : ")
        if(categoryIndex <= categories.length){
            const value = +prompt('Saisissez la valeur à ajouter : ')
            categories[categoryIndex -1].balance += value
            console.log('Argent ajoutée avec succès.')
        }else{
            console.log("La catégorie n'existe pas")
        }
    }else{
        const categoryIndex = +prompt("A quelle catégorie allez-vous retirer de l'argent? (réponse: un nombre) : ")
        if(categoryIndex <= categories.length){
            const value = +prompt('Saisissez la valeur à retirer : ')
            categories[categoryIndex - 1].balance -= value
            console.log('Argent retirée avec succès.')
        }else{
            console.log("La catégorie n'existe pas")
        }
    }
}
const budgetPlanning = (willAddCategory) => {
    if(willAddCategory){
        const newCategoryName = prompt('Veuillez saisir le nom de la catégorie : ')
        categories.push({balance: 0, name: newCategoryName})
        console.log('Catégorie ajoutée avec succès.')
    }else{
        getCategories()
        const categoryIndex = +prompt('Quelle catégorie allez-vous supprimmer? (réponse : un nombre) : ')
        if(categoryIndex <= categories.length){
            categories.splice(categoryIndex - 1, 1)
            console.log('Catégorie retirée avec succès.')
        }else{
            console.log("La catégorie n'existe pas")
        }
    }
}
const wallet = () => {
    const quitOption = 7
    while(true){
        console.log(`
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
        ===============================================================================`);
        let option = +prompt('Que souhaitez-vous faire? (réponse : un nombre de 1 à 7) : ');
        switch (option){
            case 1 :
                checkBalance()
                break;
            case 2 :
                manageCost(true)
                break;
            case 3 :
                manageCost(false)
                break;
            case 4 :
                getCategories()
                break;
            case 5 :
                budgetPlanning(true)
                break;
            case 6 :
                budgetPlanning(false)
                break;
            case 7 :
                return;
            default:
                console.log('Veuillez choisir un nombre entre 1 et 7.');
                break;
        }
    }
}
wallet()