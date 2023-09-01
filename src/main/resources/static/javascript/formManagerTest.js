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
function testIsTypeValueCheckTrue(){
  var themeValue = "check"
  if (isTypeValueCheck(themeValue)){
    console.log("success !")
    return true;
  }
  console.log("failure");
  return false;
}
function testIsTypeValueCheckFalse(){
  var themeValue = "basilique"
  if (isTypeValueCheck(themeValue)){
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