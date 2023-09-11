function doeseThemeGeneralValueMaches(themeGeneralValue){
  const arrayOfThemes =["MEYZIEU",
                        "CALUIRE_ET_CUIRE",
                        "HEALTH",
                        "TCL",
                        "CLOTHING"
                      ];
  if(arrayOfThemes.includes(themeGeneralValue)){
    return true;
  } else {
    return false;
  }
}

function doeseThemeSubValueMaches(themeSubValue){
  const arrayOfThemes =["CONSTRUCTION_WORK",
                        "COSTS",
                        "HOUSING_TAXE",
                        "PROPERTY_TAXE",
                        "WATER",
                        "GASS",
                        "ELECTRICITY",
                        "LOAN",
                        "FIRE_WOOD",
                        "INSURANCE",
                        "BOILER",
                        "CHIMNEY_SWEEPING",
                        "HOME_APPLIANCE",
                        "FURNITURE"
                      ];
  if(arrayOfThemes.includes(themeSubValue)){
    return true;
  } else {
    return false;
  }
}
function isThemeSubValueRent(themeSubValue){
  if(themeSubValue == "RENT"){
    return true;
  } else {
    return false;
  }
}

function isTypeValueCheck(typeValue){
  return "CHECK" == typeValue;
}

function isThemeValuePresent(typeValue){
    return (typeValue == "PRESENT");
}

const selectElementForEvent1 = document.querySelector(".theme-general");
selectElementForEvent1.addEventListener("change", (event) =>{
    var themeGeneralValue = event.target.value;
    var divBeneficiary = $(".display-if-theme-present");
    var divThemeSub =$(".display-if-theme-matches-themesub")
    if(isThemeValuePresent(themeGeneralValue)){
      divBeneficiary.show();
      divThemeSub.hide();
    }else if (doeseThemeGeneralValueMaches(themeGeneralValue)){
      divThemeSub.show();
      divBeneficiary.hide();
    }else{
      divThemeSub.hide();
      divBeneficiary.hide();
    }
});

const selectElementForEvent2 = document.querySelector(".type-of-transactions");
selectElementForEvent2.addEventListener("change", (event) =>{
    var typeValue = event.target.value;
    var divToShow = $(".display-if-type-check");
    if(isTypeValueCheck(typeValue)){
      divToShow.show();
    }else{
      divToShow.hide();
    }
});

const selectElementForEvent3 = document.querySelector("#theme-sub");
selectElementForEvent3.addEventListener("change", (event) =>{
  console.log("I Am in selectElementForEvent3()");
    var themeSubValue = event.target.value;
    var divAuthor = $(".display-if-theme-matches-author");
    var divTenant =$(".display-if-theme-rent")
    if(doeseThemeSubValueMaches(themeSubValue)){
  console.log("I Am in selectElementForEvent3() display div Author");

      divAuthor.show();
      divTenant.hide();
    }else if (isThemeSubValueRent(themeSubValue)){
  console.log("I Am in selectElementForEvent3() display div Tenant");

      divTenant.show();
      divAuthor.hide();
    }else{
  console.log("I Am in selectElementForEvent3() hide all");

      divTenant.hide();
      divAuthor.hide();
    }
});
