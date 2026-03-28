# Autor: hhern
# Fecha: 03/22/2026
# language: es
Característica: Login de usuario en Demoblaze

Escenario: Login exitoso de usuario
  Dado que "Hernan" abre el sitio web
  Cuando el inicia sesion con credenciales validas
  Entonces el deberia ver su nombre de usuario en la pagina