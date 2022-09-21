# Author: Jesus David Zaraza Toro
Feature: Como Automatizador de pruebas
  Requiero consultar una provincia y municipio
  Para verificar los datos asociados a este

  @TEST-01
  Scenario: Obtener un municipio y los datos asociados
    Given que el automatizador ingresa una provincia y municipio
    When el automatizador ejecuta el servicio
    Then el servicio Obtener Municipios arroja los datos asociados al municipio

