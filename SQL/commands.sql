sqlite3 --version

CREATE DATABASE IF NOT EXISTS accounting;

CREATE TABLE account2023
(
    a_date DATE,
    a_types ENUM("Salaire", 
                 "Virement", 
                 "TIP", 
                 "Prélèvement automatique", 
                 "Retrait",
                 "CB", 
                 "Encaissement chèque", 
                 "Encaissement d'espèces", 
                 "Chèque", 
                 "Espèce"),
    a_name CHAR(100),
    a_amount DECIMAL(10, 2),
    a_check_number INT(8),
    a_theme ENUM("Alimentaire", 
                 "Loisir", 
                 "Voyages", 
                 "Santé Muriel", 
                 "Santé Patrick",
                 "TCL Muriel",
                 "TCL Patrick",
                 "Vêtement Muriel",
                 "Vêtement Patrick",
                 "Meyzieu eau",
                 "Meyzieu gaz",
                 "Meyzieu éléctricité",
                 "Meyzieu bois de chauffe",
                 "Meyzieu prêt immobilier",
                 "Meyzieu assurance",
                 "Meyzieu entretien chaudière",
                 "Meyzieu ramonage",
                 "Meyzieu électroménager",
                 "Meyzieu mobilier",
                 "Meyzieu taxe foncière",
                 "Meyzieu travaux",
                 "Caluire et Cuire travaux",
                 "Caluire et Cuire loyer",
                 "Caluire et Cuire charges",
                 "Caluire et Cuire taxe foncière"),
    a_author ENUM("Muriel", 
                  "Patrick", 
                  "Les deux")
);
