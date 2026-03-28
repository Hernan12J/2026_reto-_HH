# Autor: hhern
# Fecha: 03/22/2026
# language: es
Característica: Login de usuario en Demoblaze

  @HH-1
Escenario: Login exitoso de usuario
  Dado que "Hernan" abre el sitio web
  Cuando el inicia sesion con credenciales validas
  Entonces el deberia ver su nombre de usuario en la pagina

  @HH-2
  Escenario: Login fallido con credenciales incorrectas
    Dado que "Hernan" abre el sitio web
    Cuando el inicia sesion con credenciales invalidas
    Entonces deberia ver un mensaje de error en el login