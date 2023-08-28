# Spécification application gestion de compte
## Général
Data base SQL\
serveur SQL local\
1 table SQL par année, afin de pouvoir faire des array moins grand lors des manipulation.\
1 seul formulaire HTML avec JavaScript pour le rendre UIX et dynamique.\
Rendus Tableau 3 tableaux Open office.\
3 rendus : Salaire, Dépense par Thème, Bilan mensuel\
## Table SQL
Plusieurs colonnes : 
- Date Mandatory
- Type Mandatory ( peut comprendre Type de payment et N° de chèque si existant )
- Nom du débiteur / magasin / nom du créditeur
- Montant en € Mandatory
- Thème Mandatory
- Auteur 

## Formulaire HTML
Tous les labels sont en Français.\
### Règles à mettre en place avec JavaScript
Le champ Auteur apparaît et est obligatoire que lorsqu'il s'agit d'un sous thème : Travaux, Charges, Impôts Fonciers, Eau, Gaz, Électricité, Prêt Immobilier, Bois de chauffe, Assurance, Entretient Chaudière, Ramonage, Électroménager, Mobilier.\
Le champ N° de chèque apparaît et est obligatoire si le type de payement est par Chèque.\
Si le Type de payement est Chèque un champs N° de Chèque apparaît. \
### Liste des champs par ordre d'apparition
- Date pick date
- Type menu déroulant à choix multiple <select> with <option>  : 
>- Salaire
>- Virement ( dans le cas ou le montant est crédité sur mon compte )
>- TIP
>- Prélèvement Automatique
>- Retrait
>- Carte bancaire
>- Encaissement Chèque
>- Encaissement Espèces
>- Chèque
>- Espèces
- N° de Chèque number
- Nom ( débiteur / magasin / créditeur) text libre 50 caractères maximum
- Montant en € number 
- Thème menu déroulant à choix multiple <select> with <optgroup> tags 
>- Caluire et Cuire Travaux
>- Caluire et Cuire Loyer
>- Caluire et Cuire Charges
>- Caluire et Cuire Taxe Foncière
>- Meyzieu Travaux
>- Meyzieu Eau
>- Meyzieu Gaz
>- Meyzieu Prêt Immobilier
>- Meyzieu Electricité
>- Meyzieu Bois de chauffe
>- Meyzieu Impôts Fonciers
>- Meyzieu Assurance
>- Meyzieu Entretient Chaudière
>- Meyzieu Ramonage
>- Meyzieu Électroménager ( four, machine à laver le linge, mixeur, aspirateur … )
>- Meyzieu Mobilier
>- Santé Patrick
>- Santé Muriel
>- Alimentaire
>- Loisir
>- Voyages
>- TCL Muriel
>- TCL Patrick
>- Vêtements Patrick
>- Vêtements Muriel
>- Papeterie
>- Informatique
- Auteur :
>- Patrick
>- Muriel
## Backend Java
### Conditions 
#### Condition Rendu Salaire
Si le Type est Salaire ou Virement, et que Virement est suivi du nom CAF, PE, alors ces montants vont dans les bonnes colonnes du rendu Salaire. Tous les autres types sont à exclure de ce rendu.\
#### Condition Rendu Bilan Mensuel
Condition 00 : Si le Type est Espèce alors il n'entre pas en compte dans le rendu Bilan Mensuel.
Tous les autres types en font parti.\
Condition 01 : Pour le rendu du Bilan Mensuel, si le Type est Salaire ou Virement il est positif et donc dans la colonne crédit. Dans tous les autres cas il est négatif.\
#### Condition Rendu Dépense par Thème
Tous les montants sont positifs. Salaire et Virement n'y figurent pas. Il classe toutes les sortie d'argent par thème est sous thèmes.\
#### Condition Qui a payer
Dans le cas de Thème Construciton Work, Costs, Porperty Taxe, Water, Gaz, Electricity, Insurance, Boiler, Chimney Sweeping, Home Appliance et Furniture, loan il est obligatoire d'indiqué qui à payer : Patrick ou Muriel.\
#### Condition Chèque
Si c'est un payement par chèque le N° du chèque est obligatoire.\
### Création de table SQL avec Java
Tous les ans création d'une nouvelle table SQL avec Java.
### Objets Java
#### Entry : 
- Date LocalDate 
- Type TypeOfTransaction (enum)
- Name String
- Amount in € float 
- Theme (enum)
- Author (Patrick ou Muriel) (enum)
#### TypeTransaction
- Salary
- Payment ( dans le cas ou le montant est crédité sur mon compte )
- TIP
- Automatic-drawdown
- Withdrawal
- Credit Card
- Cheque-cashing
- Cashing
- Cheque
- Cash
#### Author 
- Patrick
- Muriel
#### Theme :
- Caluire et Cuire 
- Meyzieu
- Montplat 
- Health
- Food
- Leisure
- Travel
- TCL 
- Clothing
- Stationary
- Computer
#### Sub Theme :
- Construction Work
- Rent 
- Costs
- Property Taxes
- Water
- Gass
- Electricity
- loan
- Fire Wood
- Inssurance
- Boiler
- Chimney Sweeping
- Home Appliance
- Furniture
- Patrick
- Muriel
## Rendu
Tous les rendus sont en Tableur Open Office.\
### Salaire
Créer ce document tous les 31 décembres de chaques année.\
Mettre à jour un document Tableur Open Office tous les 15 du mois dans le dossier approprié\
Le nommer 'Salaire'AAAA-MM.\
Tous les 15 du mois il reprendra toute la donnée enregistrer sur le mois précédent.\
Un bouton dans l'application permet de le mettre à jour.\
Titre du tableau :  String 'Revenue de l'Année + Année concernée en chiffre'\ 
| String 'Mois' | String Salaire | String CAF | String Pole Emplois |
|---------------|----------------|------------|---------------------|
| String | Float  + € |Float  + €|Float  + €|
| Le nom du mois ordre chronologique |Salaire du mois concerné; Si pas de donnée pour ce mois entrer 0€|total des payements CAF du mois. Si pas de donnée pour ce mois entrer 0€|total des payements PE du mois. Si pas de donnée pour ce mois entrer 0€|
| String | Float | Float | Float |
|Total + Année concernée en chiffre|Somme de tous les salaires déjà payés cette année.|Somme de tous les payements de la CAF de cette année|Somme de tous les payements de la PE de cette année|
| String | Float | Float | Float |
|'Moyenne Mensuelle'|Somme des Salaires / nombres de mois déjà écoulés|Somme des payements CAF / nombres de mois déjà écoulés| Somme des payements PE / nombres de mois déjà écoulés |
### Dépense par Thème
Créer un document Tableur Open Office tous les ans dans le dossier approprié\
Le nommer 'DepensesParThèmes'AAAA.\
Un bouton dans l'application permet de le mettre à jour.\
Un bouton permet de le créer pendant l'année. Dans ce cas il s'agit de toutes les données de l'année en cours.\
Un autre bouton permet de mettre à jour celui de l'année pas en cours mais, ce bouton nécessite de préciser l'année visée par l'utilisateur.\
Titre du tableau : String 'Dépense par Thème sur l'Année + année concernée en chiffre'\
|String 'Mois'|String 'Thèmes', autant de colonnes qu'il y a de thèmes.|...|Total des dépenses mensuelles|
|-------------|--------------------------------------------------------|---|-----------------------------|
|   String    |Float + €|---|Float + €|
|nom du mois classé dans l'ordre de Janvier à Décembre|Total des montants sur ce thème concernant ce moi de cette année|---|Total de l'ensemble des payements du mois.|
|String|Float + €|---|Float + €|
|'Total par Thème'|Total de l'ensemble des payements dans l'année, par thème.|---|Total Anuel des dépenses|
|String|Float|---|Float + €|
| 'Moyenne annuelle des payements par Thèmes'|Moyenne de l'ensemble des payements dans l'année, par thème.|---|Moyenne mensuelle des dépenses|

### Bilan mensuel
Créer un document Tableur Open Office tous les 15 du mois dans le dossier approprié.
Le nommer 'CompteCourant'AAAA-MM.
Tous les 15 du mois il reprendra toute la donnée enregistrer sur le mois précédent.
Un bouton dans l'application permet de le mettre à jour.
Titre du tableau : String 'Bilan Mensuel + MOIS + YYYY'
| String 'Date' | String 'Titre' | String 'Débit' | String 'Crédit' | String 'Total Banque avant exercice : '+ Float chiffre de la banque |
|---------------|---------------|--------------- | ---------------|---------------|
| Date Fromat jj/mm/yyyy | String 'Type + (N° de chèque si existant) + Name' | Float Ammount SI négatif +€. Nombres toujours négatifs | Float Amount Si positif +€ nombre toujours Positif |
| String 'Total' |  |Total de toutes les dépenses du mois, avec Foat +€ négatif|Total de toutes les entrées du mois, avec Foat +€ positif| Float Somme (Total Banque + Total des Crédits + Total débit) +€ | String 'Total Banque après exercice : '+ Float chiffre de la banque +€ | |


