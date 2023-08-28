function doeseThemeGeneralValueMaches(themeGeneralValue){
  const arrayOfThemes =["meyzieu",
                        "caluire-et-cuire",
                        "health",
                        "tcl",
                        "clothing"
                      ];
  if(arrayOfThemes.includes(themeGeneralValue)){
    return true;
  } else {
    return false;
  }
}

function doeseThemeSubValueMaches(themeSubValue){
  const arrayOfThemes =["contstruction-work",
                        "costs",
                        "housing-taxe",
                        "property-taxe",
                        "water",
                        "gass",
                        "electricity",
                        "loan",
                        "fire-wood",
                        "insurance",
                        "boiler",
                        "cheminey-sweeping",
                        "home-appliance",
                        "furniture"
                      ];
  if(arrayOfThemes.includes(themeSubValue)){
    return true;
  } else {
    return false;
  }
}
function isThemeSubValueRent(themeSubValue){
  console.log("I Am in isThemeSubValueRent()"); 
  if(themeSubValue == "rent"){
    console.log("I Am in isThemeSubValueRent() TRUE");
    return true;
  } else {
    console.log("I Am in isThemeSubValueRent() FALSE");
    return false;
  }
}

function isTypeValueCheque(typeValue){

  if(typeValue == "check"){
    return true;
  } else {
    return false;
  }
}

function isThemeValuePresent(typeValue){

  if(typeValue == "present"){
    return true;
  } else {
    return false;
  }
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

const selectElementForEvent2 = document.querySelector(".type-of-payements");
selectElementForEvent2.addEventListener("change", (event) =>{
    var typeValue = event.target.value;
    var divToShow = $(".display-if-type-check");
    if(isTypeValueCheque(typeValue)){
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
