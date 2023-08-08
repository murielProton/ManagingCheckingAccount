# Spécification application gestion de compte
## Général
Data base SQL
serveur SQL local
1 table SQL
1 seul formulaire HTML avec JavaScript pour le rendre UIX et dynamique.
Rendus Tableau 3 tableaux Open office.
3 rendus : Salaire, Dépense par Thème, Bilan mensuel
## Table SQL
Plusieurs colonnes : 
Date Mandatory
Type Mandatory
Nom du débiteur / magasin / nom du créditeur
Montant en € Mandatory
Thème Mandatory
Auteur 

## Formulaire HTML
Tous les labels sont en Français.
Le champ Auteur apparaît et est obligatoire que lorsqu'il s'agit d'un sous thème : Travaux, Charges, Impôts Fonciers, Eau, Gaz, Électricité, Prêt Immobilier, Bois de chauffe, Assurance, Entretient Chaudière, Ramonage, Électroménager, Mobilier.
Le champ N° de chèque apparaît et est obligatoire si le type de payement est par Chèque.
Date pick date
Type menu déroulant à choix multiple <select> with <option>  : 
- Salaire
- Virement ( dans le cas ou le montant est crédité sur mon compte )
- TIP
- Prélèvement Automatique
- Retrait
- Carte bancaire
- Encaissement Chèque
- Encaissement Espèces
- Chèque
- Espèces
Si le Type de payement est Chèque un champs N° de Chèque apparaît. number
Nom ( débiteur / magasin / créditeur) text libre 50 caractères maximum
Montant en € number 
Thème menu déroulant à choix multiple <select> with <optgroup> tags 
- Caluire et Cuire Travaux
- Caluire et Cuire Loyer
- Caluire et Cuire Charges
- Caluire et Cuire Impôts Fonciers
- Meyzieu Travaux
- Meyzieu Eau
- Meyzieu Gaz
- Meyzieu Prêt Immobilier
- Meyzieu Electricité
- Meyzieu Bois de chauffe
- Meyzieu Impôts Fonciers
- Meyzieu Assurance
- Meyzieu Entretient Chaudière
- Meyzieu Ramonage
- Meyzieu Électroménager ( four, machine à laver le linge, mixeur, aspirateur … )
- Meyzieu Mobilier
- Santé Patrick
- Santé Muriel
- Alimentaire
- Loisir
- Voyages
- TCL Muriel
- TCL Patrick
- Vêtements Patrick
- Vêtements Muriel
- Papeterie
- Informatique
Auteur :
- Patrick
- Muriel
## Backend Java
### Conditions 
#### Condition Rendu Salaire
Si le Type est Salaire ou Virement, et que Virement est suivi du nom CAF, PE, alors ces montants vont dans les bonnes colonnes du rendu Salaire. Tous les autres types sont à exclure de ce rendu.
#### Condition Rendu Bilan Mensuel
Condition 00 : Si le Type est Espèce alors il n'entre pas en compte dans le rendu Bilan Mensuel.
Tous les autres types en font parti.
Condition 01 : Pour le rendu du Bilan Mensuel, si le Type est Salaire ou Virement il est positif et donc dans la colonne crédit. Dans tous les autres cas il est négatif.
#### Condition Rendu Dépense par Thème
Tous les montants sont positifs. Salaire et Virement n'y figurent pas. Il classe toutes les sortie d'argent par thème est sous thèmes.
#### Condition Qui a payer
Dans le cas de Thème Construciton Work, Costs, Porperty Taxe, Water, Gaz, Electricity, Insurance, Boiler, Chimney Sweeping, Home Appliance et Furniture, loan il est obligatoire d'indiqué qui à payer : Patrick ou Muriel.
#### Condition Chèque
Si c'est un payement par chèque le N° du chèque est obligatoire.

### Objets Java
#### Entry : 
Date LocalDate 
Type String
Name String
Amount in € float 
Theme String
Author (Patrick ou Muriel) String
#### Author 
Patrick
Muriel
#### Theme :
Caluire et Cuire 
Meyzieu
Montplat 
Health
Food
Leisure
Travel
TCL 
Clothing
Stationary
Computer
#### Sub Theme :
Construction Work
Rent 
Costs
Property Taxes
Water
Gass
Electricity
loan
Fire Wood
Inssurance
Boiler
Chimney Sweeping
Home Appliance
Furniture
Patrick
Muriel
## Rendu
Tous les rendus sont en Tableur Open Office.
### Salaire
Créer un document Tableur Open Office tous les 15 du mois dans le dossier D/Fianance/
Le nommer 'Salaire'AAAA-MM.
Tous les 15 du mois il reprendra toute la donnée enregistrer sur le mois précédent.
Un bouton dans l'application permet de le mettre à jour.
String 'Revenue de l'Année + Année concernée en chiffre'
String 'Mois'
String Salaire
String CAF
String Pole Emplois
String Total
String
Le nom du mois en toute lettre et classé dans l'ordre de Janvier à Décembre
Float + € uniquement du mois concerné
Si pas de donnée pour ce mois entrer 0€
Float + € 
Total de tous les payements de la CAF sur le mois concerné.
Si pas de donnée pour ce mois entrer 0€
Float + €
 Total de tous les payements de PE sur le mois concerné.
Si pas de donnée pour ce mois entrer 0€
Float 
Salaire + Payements CAF + Payement PD du mois
String
'Total + Année concernée en chiffre'
Float 
Somme de tous les salaires déjà payés cette année.
Float 
Somme de tous les payements de la CAF de cette année
Float 
Somme de tous les payements de PE déjà payés cette année.
Float 
Somme de l'ensemble des payements et salaires de cette année.
String
'Moyenne Mensuelle'
Float 
Total des Salaire de tous les mois divisé par le nombre de mois déjà finis dans l'année en cours.
Float 
Total des payements de tous les mois divisé par le nombre de mois déjà finis dans l'année en cours.
Float 
Total des payements de tous les mois divisé par le nombre de mois déjà finis dans l'année en cours.
Float 
Total de toutes les cellules de cette colonne divisé par le nombre de mois déjà écoulés dans l'année en cours.

### Dépense par Thème
Créer un document Tableur Open Office tous les ans dans le dossier D/Finance/
Le nommer 'DepensesParThèmes'AAAA.
Un bouton dans l'application permet de le mettre à jour.
Un bouton permet de le créer pendant l'année. Dans ce cas il s'agit de toutes les données de l'année en cours.
Un autre bouton permet de mettre à jour celui de l'année pas en cours mais, ce bouton nécessite de préciser l'année visée par l'utilisateur.
String 'Dépense par Thème sur l'Année + année concernée en chiffre'
String 'Mois'
String 'Thèmes', autant de colonnes qu'il y a de thèmes.
...
Total des dépenses mensuelles
String
Le nom du mois en toute lettre et classé dans l'ordre de Janvier à Décembre
Float
Total des montant sur ce thème du mois et de l'année concernée

Float
Total de l'ensemble des payement dans le mois.
String 'Total par Thème'
Float 
Total de l'ensemble des payements sur le thème visée sur l'année

Float 
Total de l'ensemble des payements du mois sur l'année
String 'Moyenne annuelle des payements par Thèmes'
Float
Total des dépenses annuelle sur le thème, divisé par le nombres de mois écoulés sur l'année en cours.

Float 
Total des dépenses annuelle divisé par nombre de mois écoulés sur l'année en cours.

### Bilan mensuel
Créer un document Tableur Open Office tous les 15 du mois dans le dossier D/Finance/
Le nommer 'CompteCourant'AAAA-MM.
Tous les 15 du mois il reprendra toute la donnée enregistrer sur le mois précédent.
Un bouton dans l'application permet de le mettre à jour.
String 'Bilan Mensuel'




String 'Date' 
String 'Titre'
String 'Montant'
String 'Total Banque avant exercice : '+ Float chiffre de la banque

Date Fromat jj/mm/yyyy
String 
'Type + (N° de chèque si existant) + Name'
Float
Ammount


String 'Total'

Float Somme des Montant de l'exercisse
String 'Total Banque après exercice : '+ Float chiffre de la banque

