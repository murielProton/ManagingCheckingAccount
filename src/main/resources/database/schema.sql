DROP TABLE if exists account_records;
CREATE TABLE account_records
(
    ID_SQL int not null AUTO_INCREMENT,
    id_Java int not null,
    date_of_transaction DATE not null,
    type_of_transaction ENUM("Salary", 
                            "Payment", 
                            "TIP", 
                            "Automatic Drawdown", 
                            "Withdrawal",
                            "CB", 
                            "Check Cashing", 
                            "Cashing", 
                            "Check", 
                            "Cash") not null,
    check_number CHAR(10),
    name_of_record CHAR(100) not null,
    amount DECIMAL(10, 2) not null,
    theme_general ENUM("Caluire et Cuire", 
                        "Meyzieu", 
                        "Montplat", 
                        "Health", 
                        "Food",
                        "Leisure",
                        "TCL Patrick",
                        "Travel",
                        "TCL",
                        "Clothing",
                        "Stationary",
                        "Other",
                        "Income Taxe") not null,
    beneficiary CHAR(50),
    theme_sub ENUM("Rent",
                    "Construction Work",
                    "Costs",
                    "Property Taxes",
                    "Water",
                    "Gass",
                    "Electricity",
                    "Loan",
                    "Fire Wood",
                    "Insurance",
                    "Boiler",
                    "Chimney Sweeping",
                    "Home Appliance",
                    "Furniture",
                    "Patrick",
                    "Muriel"),
    tenant CHAR(50),
    bank_account ENUM("Muriel's current account",
                      "Muriel's saving account",
                      "Patrick's current account", 
                      "Joint account"),
    PRIMARY KEY (ID_SQL)
);