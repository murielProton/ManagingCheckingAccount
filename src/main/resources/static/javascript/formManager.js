

function isTypeOfTransactionSalary(typeOfTransaction){
  
  if(typeOfTransaction == "SALARY"){
    return true;
  } 
  return false;
}

function doeseThemeGeneralValueMaches(themeGeneralValue){
  const arrayOfThemes =["MEYZIEU",
                        "CALUIRE_ET_CUIRE",
                        "HEALTH",
                        "TCL",
                        "CLOTHING",
                        "TRAVEL",
                        "LEISURE",
                        "INCOME_TAXE",
                        "COMPUTER"
                      ];
  if(arrayOfThemes.includes(themeGeneralValue)){
    return true;
  } else {
    return false;
  }
}
function doeseThemeGeneralValueMachesWhenTOTSalary(themeGeneralValue){
  const arrayOfThemes =["MEYZIEU",
                        "CALUIRE_ET_CUIRE",
                        "MONTPLAT",
                        "HEALTH",
                        "FOOD",
                        "TCL",
                        "CLOTHING",
                        "TRAVEL",
                        "LEISURE",
                        "STATIONARY",
                        "INCOME_TAXE",
                        "PRESENT",
                        "COMPUTER"
                      ];
  return(arrayOfThemes.includes(themeGeneralValue));
}

function doeseThemeGeneralValueMachesListToDefThemeSub(themeGeneralValue){
  const arrayOfThemes =["HEALTH",
                        "TCL",
                        "CLOTHING",
                        "TRAVEL",
                        "LEISURE",
                        "INCOME_TAXE",
                        "COMPUTER"
                      ];
  console.log("theme general value " + themeGeneralValue);
  console.log("boolean " + arrayOfThemes.includes(themeGeneralValue));
  return(arrayOfThemes.includes(themeGeneralValue));
}

function isThemeGeneralMeyzieu(themeGeneral){
  return (themeGeneral == "MEYZIEU");
}
function isThemeGeneralCaluireEtCuire(themeGeneral){
  return (themeGeneral == "CALUIRE_ET_CUIRE");
}
function doeseThemeSubValueMachesMeyzieu(themeSubValue){
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
  return (arrayOfThemes.includes(themeSubValue));
}

function doeseThemeSubValueMachesListForCaluireEtCuire(themeSubValue){
  const arrayOfThemes =["CONSTRUCTION_WORK",
                        "COSTS",
                        "PROPERTY_TAXE",
                        "INSURANCE",
                        "BOILER",
                        "CHIMNEY_SWEEPING",
                        "HOME_APPLIANCE",
                        "RENT"
                      ];
  return(arrayOfThemes.includes(themeSubValue));
}
function doeseThemeSubValueMachesPersonae(themeSubValue){
  const arrayOfThemes =["BOTH",
                        "HOUSEHOLD",
                        "PATRICK",
                        "MURIEL"
                      ];
  return(arrayOfThemes.includes(themeSubValue))
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

function clearChildren(currentParent){
  currentParent.children().find("input,select").each(function(){
    $(this).val('');
 });
 currentParent.find('input,select').each(function(){
  $(this).val('');
});
}

const selectElementForEvent1 = document.querySelector(".theme-general");
selectElementForEvent1.addEventListener("change", (event) =>{
    var themeGeneralValue = event.target.value;
    var divBeneficiary = $("#div-beneficiary");
    var divThemeSub =$("#div-theme-sub");
    var divAuthor =$("#div-author");
    var divTenant =$("#div-tenant")

    //Hide div and clear it's value, this is the second master branch of decision. It needs to clear and hide all selects depending on it.
    divThemeSub.hide();
    clearChildren(divThemeSub);
    divAuthor.hide();
    clearChildren(divAuthor);
    divBeneficiary.hide();
    clearChildren(divBeneficiary);
    divTenant.hide();
    clearChildren(divTenant);
    //

    $('.enum-sub-theme').each(function() {
      $( this ).prop('disabled', false);
    });

    if(isThemeValuePresent(themeGeneralValue)){
      divBeneficiary.show();
    }else if(doeseThemeGeneralValueMaches(themeGeneralValue)) {
      divThemeSub.show();
      console.log("theme générale "+themeGeneralValue);
      if(doeseThemeGeneralValueMachesListToDefThemeSub(themeGeneralValue)){
        console.log("selectElementForEvent1 + themeGeneralValue "+themeGeneralValue);
        $('.enum-sub-theme').each(function() {
          if(!doeseThemeSubValueMachesPersonae($( this ).val())){
            $( this ).prop('disabled', true);
          }else{
           /* console.log("We ignore.");*/
          }
        });
      }else if(isThemeGeneralCaluireEtCuire(themeGeneralValue)){
        $('.enum-sub-theme').each(function(){
          if(!doeseThemeSubValueMachesListForCaluireEtCuire($(this).val())){
            $( this ).prop('disabled', true);
          }else{
           /* console.log("We ignore.");*/
          }
        })
      }else if(isThemeGeneralMeyzieu(themeGeneralValue)){
        divAuthor.show();
        divThemeSub.show();

        $('.enum-sub-theme').each(function(){
          if(!doeseThemeSubValueMachesMeyzieu($(this).val())){
            $( this ).prop('disabled', true);
          }else{
           /* console.log("We ignore.");*/
          }
        })
      }
    }
});

const selectElementForEvent2 = document.querySelector(".type-of-transactions");
selectElementForEvent2.addEventListener("change", (event) =>{
    var selectOptionsToHide =[] ;
    var typeValue = event.target.value;
    var divCheckNumber = $("#div-check-number");
    var divBeneficiary = $("#div-beneficiary");
    var divThemeSub =$("#div-theme-sub");
    var divAuthor =$("#div-author");
    var divTenant =$("#div-tenant");
    var divThemeGeneral =$("#div-theme-general");

    //Hide div and clear it's value
    //Clear all divs because this is the first branch of seclection process. Each time its value changes all the underlings must be cleared.
    divCheckNumber.hide();
    clearChildren(divCheckNumber);
    divBeneficiary.hide();
    clearChildren(divBeneficiary);
    divThemeSub.hide();
    clearChildren(divThemeSub);
    divAuthor.hide();
    clearChildren(divAuthor);
    divTenant.hide();
    clearChildren(divTenant);
    //WARNING MUST NOT HIDE THEME GENERAL AS IT IS ALWAYS REQUIRED.
    clearChildren(divThemeGeneral);

    
    if(isTypeValueCheck(typeValue)){
      divCheckNumber.show();
    }

    $('.enum-theme-general').each(function() {
      $( this ).prop('disabled', false);
    });

    if(isTypeOfTransactionSalary(typeValue)){
      $('.enum-theme-general').each(function() {
        if(doeseThemeGeneralValueMachesWhenTOTSalary($( this ).val())){
          $( this ).prop('disabled', true);
        }else{
          /*console.log("On ignore.");*/
        }
      });
    }
});

const selectElementForEvent3 = document.querySelector("#theme-sub");
selectElementForEvent3.addEventListener("change", (event) =>{
  console.log("I Am in selectElementForEvent3()");
    var themeSubValue = event.target.value;
    var divTenant =$("#div-tenant")

    //Hide div and clear it's value
    divTenant.hide();
    clearChildren(divTenant);
    
    if (isThemeSubValueRent(themeSubValue)){
      console.log("I Am in selectElementForEvent3() display div Tenant");

      divTenant.show();
    }

});
