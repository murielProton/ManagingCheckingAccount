set global sql_mode="NO_BACKSLASH_ESCAPES,STRICT_TRANS_TABLE,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION"


INSERT INTO account_records (dateOfTransaction) VALUES ('2023-08-31');
INSERT INTO account_records (typeOfTransaction) VALUES (TypeOfTransaction.CHECK);
INSERT INTO account_records (checkNumber) VALUES ('1234567890');
INSERT INTO account_records (name) VALUES ('Italy');
INSERT INTO account_records (amount) VALUES (0.00);
INSERT INTO account_records (themeGeneral) VALUES (ThemeGeneral.HEALTH);
INSERT INTO account_records (beneficiary) VALUES ('USA');
INSERT INTO account_records (themeSub) VALUES (ThemeSub.MURIEL);
INSERT INTO account_records (tenant) VALUES ('India');
INSERT INTO account_records (typeOfTransaction) VALUES ('Brazil');
INSERT INTO account_records (author) VALUES (Author.PATRICK);