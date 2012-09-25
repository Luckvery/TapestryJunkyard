/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 2/1/12
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */

/*
 * A client-side validator that requires a string to contain letters only.
 */
Tapestry.Validator.letters = function(field, message) {

    field.addValidator(function(value) {
        if (value != null) {
            if (value.match('[A-Za-z]+') != value) {
                throw message;
            }
        }
    });

};

// Other validators can be added here...