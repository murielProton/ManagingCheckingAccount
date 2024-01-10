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
- Locataire

## Formulaire HTML
Tous les labels sont en Français.\

### Liste des champs par ordre d'apparition
- Date pick date
- Type menu déroulant à choix multiple <select> with <option>  : Salaire, Virement ( dans le cas ou le montant est crédité sur mon compte ), TIP, Prélèvement Automatique, Retrait, Carte bancaire, Encaissement Chèque, Encaissement Espèces, Chèque, Espèces.\
- N° de Chèque number\
- Nom ( débiteur / magasin / créditeur) text libre 50 caractères maximum\
- Montant en € number \
- Thème général menu déroulant à choix multiple : Caluire et Cuire, Meyzieu, Santé, Alimentaire, Loisir, Voyages, TCL, Vêtements, Papeterie, Informatique, Montplat, Patrick, Muriel.\
- Sous thème : Loyer, Charges, Travaux, Eau, Gaz, Prêt Immobilier, Electricité, Bois de chauffe, Impôts Fonciers, Taxe d'Habitation, Assurance, Entretient Chaudière, Ramonage, Électroménager, Mobilier, Patrick, Muriel.\
- Auteur : Patrick, Muriel.\
- Locataire text.\
### Règles d'affichage très faciles à mettre en place grace joinfaces / primefaces
Le champ Auteur apparaît et est obligatoire que lorsqu'il s'agit d'un sous thème : Travaux, Charges, Impôts Fonciers, Eau, Gaz, Électricité, Prêt Immobilier, Bois de chauffe, Assurance, Entretient Chaudière, Ramonage, Électroménager, Mobilier.\
Le champ N° de chèque apparaît et est obligatoire si le type de payement est par Chèque.\
Si le Type de payement est Chèque un champs N° de Chèque apparaît. \
Si le sous Thème est Caluire et Cuire loyer champs Locataire apparaît. \
Si le thème général est l'un des suivants :
- santé
- TCL
- Vêtements
- Caluire et Cuire
- Meyzieu
Le champs sous thème apparaît.
Dans le cas où le thème général est santé, TCL ou Vêtements ; la liste de sous thème est limité à Muriel et Patrick. \
Dans le cas où le thème général est Caluire et Cuire ; la liste de sous thème est limité à :
- Travaux
- Loyer
- Charges
- Taxe Foncière \
Dans le cas où le thème général est Meyzieu ; la liste de sous thème est limité à :
- Eau
- Gaz
- Electricité
- bois de chauffe
- ramonage
- prêt immobilier
- Assurance
- Entretien Chaudière
- Electroménager
- Taxe Foncière
- Taxe d'Habitation
- Travaux \
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
#### Condition sub Theme Loyer
Dans le cas de Thème est Caluire et Cuire rent il est obligatoire d'indiqué le prénom et le nom du locataire.\
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
- Locataire String
#### TypeTransaction
- Salary
- Payment ( dans le cas ou le montant est crédité sur mon compte )
- TIP
- Automatic-drawdown
- Withdrawal
- Credit Card
- Check-cashing
- Cashing
- Check
- Cash
#### Author 
- Patrick
- Muriel
- Both
#### Theme = General Theme + Sub Theme
#### General Theme :
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


