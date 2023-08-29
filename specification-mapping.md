# Mapping HTML -> java -> SQL
------------------------------------------------------------------------------------------------------
|               |                HTML                |         java          |        SQL         |
-------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------
| Name          |                                   |          id           |      java_id        |
| Type          |                                   | long                  | INT(10)             |
| Auto generated|                                   | YES                   | NO                  |
| Nullable      |                                   | NO                    | NO                  |
| Unique        |                                   | YES                   | YES                 |
| Required      |                                   | YES                   | YES                 |
| Name          |               Date                |   dateOfTransaction   | date_of_transaction |
| Label         | date                              |                       |                     |
| id            | date                              |                       |                     |
| div class     | horizontal-subcontainer-for-4     |                       |                     |
| Type          | date                              | Date                  | date                |
| Nullable      | NO                                | NO                    | NO                  |
| Unique        |                                   | NO                    | NO                  |
| Required      | YES                               | YES                   | YES                 |
| Name          |       type de transaction         |    typeTransaction    | type_of_transaction |
| Label         | type-of-transactions              |                       |                     |
| id            | type-of-transactions              |                       |                     |
| div class     | horizontal-subcontainer-for-4     |                       |                     |
| Type          | picklist <select> from <option>   | enum TypeOfTransaction| ENUM                |
| Label         | type-of-transactions              |                       |                     |
| id            | type-of-transactions              |                       |                     |
| div class     | horizontal-subcontainer-for-4     |                       |                     |
| Nullable      | NO                                | YES                   | NO                  |
| Unique        |                                   | NO                    | NO                  |
| Required      | YES                               | YES                   | YES                 |
| Name          |             N° de Chèque          |       checkNumber     |     check_number    |
| Label         | check-number                      |                       |                     |
| id            | check-number                      |                       |                     |
| div class     | horizontal-subcontainer-for-4     |                       |                     | 
|               | display-if-type-check             |                       |                     |
| Type          | text                              | String                | TEXT(50)            |
| Nullable      | YES                               | YES                   | YES                 |
| Unique        |                                   | YES                   | YES                 |
| Required      | NO                                | NO                    | NO                  |
| Name          |                 Nom               |          name         |         name        |
| Label         | name                              |                       |                     |
| id            | name                              |                       |                     |
| div class     | horizontal-subcontainer-for-4     |                       |                     |
| Type          | text                              | String                | TEXT(50)            |
| Nullable      | NO                                | NO                    | NO                  |
| Unique        |                                   | NO                    | NO                  |
| Required      | YES                               | YES                   | YES                 |
| Name          |            Montant                |         amount        |       amount        |
| Label         | amount                            |                       |                     |
| id            | amount                            |                       |                     |
| div class     | horizontal-subcontainer-for-4     |                       |                     |
| Type          | text                              | Float                 | FLOAT(10,dd)        |
|               | pattern="[0-9\.]+"                |                       |                     |
|               | maxlength="10"                    |                       |                     | 
|               | value="€"                         |                       |                     |
| Nullable      | NO                                | NO                    | NO                  |
| Unique        |                                   | NO                    | NO                  |
| Required      | YES                               | YES                   | YES                 |
| Name          |           Thème général           |      themeGeneral     |    theme_general    |
| Label         | theme-general                     |                       |                     |
| id            | theme-general                     |                       |                     |
| div class     | horizontal-subcontainer-for-2     |                       |                     |
|               | horizontal-subcontainer-for-3     |                       |                     |
| Type          | picklist <select> from <option>   | enum ThemeGeneral     | ENUM                |
| Nullable      | NO                                | YES                   | YES                 |
| Unique        |                                   | NO                    | NO                  |
| Required      | YES                               | YES                   | YES                 |
| Name          |            Destinataire           |      beneficiary      |     beneficiary     |
| Label         | beneficiary                       |                       |                     |
| id            | beneficiary                       |                       |                     |
| div class     | horizontal-subcontainer-for-2     |                       |                     |
|               | display-if-theme-present          |                       |                     |
| Type          | text                              | String                | TEXT(50)            |
| Nullable      | YES                               | YES                   | YES                 |
| Unique        |                                   | NO                    | NO                  |
| Required      | NO                                | NO                    | NO                  |
| Name          |             Sous thème            |       themeSub        |      theme_sub      |
| Label         | theme-sub                         |                       |                     |
| id            | theme-sub                         |                       |                     |
| div class     | horizontal-subcontainer-for-2     |                       |                     |
|               | horizontal-subcontainer-for-3     |                       |                     |
|               | display-if-theme-matches-themesub |                       |                     |
|               | theme-sub                         |                       |                     |
| Type          | picklist <select> from <option>   | enum ThemeSub         | ENUM                |
| Nullable      | YES                               | YES                   | YES                 |
| Unique        |                                   | NO                    | NO                  |
| Required      | NO                                | NO                    | NO                  |
| Name          |           Locataire               |        tenant         |        tenant       |
| Label         | tentant                           |                       |                     |
| id            | tentant                           |                       |                     |
| div class     | horizontal-subcontainer-for-3     |                       |                     |
|               | display-if-theme-rent             |                       |                     |
| Type          | text                              | String                | TEXT(50)            |
| Nullable      | YES                               | YES                   | YES                 |
| Unique        |                                   | NO                    | NO                  |
| Required      | NO                                | NO                    | NO                  |
| Name          |               Auteur              |        author         |       author        |
| Label         | author                            |                       |                     |
| id            | author                            |                       |                     |
| div class     | horizontal-subcontainer-for-3     |                       |                     | 
|               | display-if-theme-matches-author   |                       |                     |
| Type          | picklist <select> from <option>   | enum Author           | ENUM                |
| Nullable      | YES                               | YES                   | YES                 |
| Unique        |                                   | NO                    | NO                  |
| Required      | NO                                | NO                    | NO                  |
| Name          |                                   |                       |           id        |
| Type          |                                   |                       |                     |
| Auto generated|                                   |                       |                     |
| Nullable      |                                   |                       | NO                  |
| Unique        |                                   |                       | YES                 |
| Required      |                                   |                       | YES                 |
