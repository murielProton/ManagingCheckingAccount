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

const selectElementForEvent1 = document.querySelector(".theme");
selectElementForEvent1.addEventListener("change", (event) =>{
    var themeValue = event.target.value;
    var divToShow = $(".display-if-theme-maches");
    if(doeseThemeValueMaches(themeValue)){
      divToShow.show();
    }else{
      divToShow.hide();
    }
});

const selectElementForEvent2 = document.querySelector(".type-of-payements");
selectElementForEvent2.addEventListener("change", (event) =>{
    var typeValue = event.target.value;
    var divToShow = $(".display-if-check");
    if(isTypeValueCheque(typeValue)){
      divToShow.show();
    }else{
      divToShow.hide();
    }
});


