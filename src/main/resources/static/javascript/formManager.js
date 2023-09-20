

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
                        "LEISURE"
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
                        'MONTPLAT',
                        "HEALTH",
                        'FOOD',
                        "TCL",
                        "CLOTHING",
                        "TRAVEL",
                        "LEISURE",
                        'STATIONARY',
                        'INCOME_TAXE',
                        'PRESENT',
                        'COMPUTER'
                      ];
  return(arrayOfThemes.includes(themeGeneralValue));
}
function isThemeGeneralMeyzieu(themeGeneral){
  if(themeGeneral == 'MEYZIEU'){
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

function clearChildren(currentParent){
  currentParent.children().find('input,select').each(function(){
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

    if(isThemeValuePresent(themeGeneralValue)){
      divBeneficiary.show();
    }else if(isThemeGeneralMeyzieu(themeGeneralValue)){
      divAuthor.show();
      divThemeSub.show();
    }else if(doeseThemeGeneralValueMaches(themeGeneralValue)) {
      divThemeSub.show();
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
    if(isTypeOfTransactionSalary(typeValue)){
      $('.hideDisable').each(function() {
        if(doeseThemeGeneralValueMachesWhenTOTSalary($( this ).val())){
          $( this ).prop('disabled', true);
          console.log("On hide  " +$( this ));
        }else{
          console.log("On ignire  " +$( this ).val());
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
