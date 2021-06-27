package com.henrry.authentication.validator;

import com.henrry.authentication.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {

    //1 Especifica que una instancia del modelo User puede ser validada con este validador personalizado.
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    //2 Crea nuestra validación personalizada. Podemos agregar errores vía.rejectValue
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if(!user.getPasswordConfirmation().equals((user.getPassword()))) {
            // El primer argumento es la variable de nuestro modelo que estamos validando. El segundo argumento es un código que podemos usar para establecer un mensajes de error.
            errors.rejectValue("passwordConfirmation", "Match");
        }
    }
}
