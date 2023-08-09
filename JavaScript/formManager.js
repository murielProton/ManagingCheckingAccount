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

const selectElementForEvent = document.querySelector(".theme");
console.log("je suis ici1 = "+selectElementForEvent);
selectElementForEvent.addEventListener("change", (event) =>{
    var themeValue = event.target.value;
    var divToShow = $(".display-if-theme-maches");
    if(doeseThemeValueMaches(themeValue)){
      divToShow.show();
    }else{
      divToShow.hide();
    }
});


