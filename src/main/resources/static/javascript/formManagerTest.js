/*Afin de tster du JavaScrip il faut :
- ouvrir le html associé dans le navigateur WEB (F12)
- copier les fonction que je veux tester dans la console du navigateur WEB
- les lancer pour que le navigateur web les enregistre
- copier ces fonctions de test au même endroit
- les lancer pour voir si elle renvoient 'success !'
*/
function testDoeseThemeValueMachesTrue(){
  var themeValue = "meyzieu-water"
  if (doeseThemeValueMaches(themeValue)){
    console.log("success !")
    return true;
  }
  console.log("failure");
  return false;
}
function testDoeseThemeValueMachesFalse(){
  var themeValue = "basilique"
  if (doeseThemeValueMaches(themeValue)){
    console.log("failure");
    return false;
  }
  console.log("success !")
  return true;
}
function testIsTypeValueChequeTrue(){
  var themeValue = "check"
  if (isTypeValueCheque(themeValue)){
    console.log("success !")
    return true;
  }
  console.log("failure");
  return false;
}
function testIsTypeValueChequeFalse(){
  var themeValue = "basilique"
  if (isTypeValueCheque(themeValue)){
    console.log("failure");
    return false;
  }
  console.log("success !")
  return true;
}

function testIsTypeValuePresentTrue(){
  var themeValue = "present"
  if (isTypeValuePresent(themeValue)){
    console.log("success !")
    return true;
  }
  console.log("failure");
  return false;
}
function testIsTypeValuePresentFalse(){
  var themeValue = "basilique"
  if (isTypeValuePresent(themeValue)){
    console.log("failure");
    return false;
  }
  console.log("success !")
  return true;
}