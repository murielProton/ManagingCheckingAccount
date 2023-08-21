function doeseThemeValueMaches(themeValue){
  const arrayOfThemes =["meyzieu-water",
                        "meyzieu-gass", 
                        "meyzieu-electricity", 
                        "meyzieu-fire-wood", 
                        "meyzieu-loan", 
                        "meyzieu-insurance", 
                        "meyzieu-boiler", 
                        "Bois de chauffe", 
                        "meyzieu-chemeney-sweeping", 
                        "meyzieu-domestic-appliances", 
                        "meyzieu-furniture", 
                        "meyzieu-taxes", 
                        "meyzieu-construction-work",
                        "caluire-et-cuire-construction-work",
                        "caluire-et-cuire-costs",
                        "caluire-et-cuire-taxes"
                      ];
  if(arrayOfThemes.includes(themeValue)){
    return true;
  } else {
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

const selectElementForEvent1 = document.querySelector(".theme");
selectElementForEvent1.addEventListener("change", (event) =>{
    var themeValue = event.target.value;
    var divCheckNumber = $(".display-if-theme-matches");
    var divBeneficiary = $(".display-if-theme-present");
    if(doeseThemeValueMaches(themeValue)){
      divCheckNumber.show();
      divBeneficiary.hide();
    }else if (isThemeValuePresent(themeValue)){
      divBeneficiary.show();
      divCheckNumber.hide();
    }else{
      divCheckNumber.hide();
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


