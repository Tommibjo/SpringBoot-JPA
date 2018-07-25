/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validateForm() {
    var name = document.forms["registration"]["name"].value;
    var surname = document.forms["registration"]["surname"].value;
    var age = document.forms["registration"]["age"].value;
    var gender = document.forms["registration"]["gender"].value;

    if (name == null || name == "") {
        alert("Name is mandatory");
        return false;
    }
    if (surname == null || surname == "") {
        alert("Surname is mandatory");
        return false;
    }
    if (age == null || age == "") {
        alert("Age is mandatory");
        return false;
    }
    if (gender == null || gender == "") {
        alert("Gender is mandatory");
        return false;
    }
}
