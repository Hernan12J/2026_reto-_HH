# Autor: hhern
# Fecha: 03/22/2026
# language: es

Característica: Registro de usuario en Demoblaze

  Como nuevo usuario
  Quiero registrarme en la plataforma
  Para poder iniciar sesión posteriormente

  @HH-4
  Escenario: Registro exitoso de usuario
    Dado que "Hernan" abre el sitio web
    Cuando el se registra con credenciales validas
    Entonces el deberia ver un mensaje de registro exitoso

    @HH-6
  Escenario: Registro fallido con campos vacíos
    Dado que "Hernan" abre el sitio web
    Cuando el intenta registrarse con campos vacios
    Entonces el deberia ver un mensaje de error de registro