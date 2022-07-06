# Java - Spring: Evaluacion Parte 1
Este programa fue diseñado con Java version 1.8.

## Objetivo
El programa Java-Spring tiene como objetivo utilizar Spring Data JPA para la realización de un API REST.

## Ejecución

1.  Mediante el programa de **eclipse** previamnete configurado para el uso de spring, se debera ejecutar el archivo [JavaSpringApplication](https://github.com/EMcoding17/EvaluacionJava/blob/main/src/main/java/com/evaluacion/parteuno/javaspring/JavaSpringApplication.java) como una Aplicacion Spring. Es importante dejar ejecutando el programa para poder acceder a los end-points.
2.  Abrir el programa de Postman y colocar la accion a realizar, la ruta o el end-point a utilizar y dar click en enviar.

# JSON
A continuación se muestran las rutas y el formato JSON para cada tabla

## **Employee**
**GET:** /Employee/getEmployee

**GET BY ID:**/Employee/getEmployee/{id}

**INSERT:** /Employee/createEmployee

**UPDATE:** /Employee/updateEmployee/{id}

**DELETE:** /Employee/deleteEmployee/{id}

**JSON:**

```json
{
    "id_employee": 1,
    "surname": "Dominguez",
    "firstname": "Lucho",
    "language": [
        {
            "id_language": 1,
            "code": "ESP",
            "name": "Español"
        }
    ],
    "airport": {
        "id_airport": 1,
        "name": "Aeropuerto Internacional de Toluca",
        "country": {
            "id_country": 1,
            "code": "MEX",
            "name": "Mexico"
        }
    }
}
```

## **Country**
**GET:** /Country/getCountry

**GET BY ID:**/Country/getCountry/{id}

**INSERT:** /Country/createCountry

**UPDATE:** /Country/updateCountry/{id}

**DELETE:** /Country/deleteCountry/{id}

**JSON:** 
```json
{
    "id_country": 1,
    "code": "MEX",
    "name": "Mexico"
}
```


## Airport
**GET:** /Airport/getAirport

**GET BY ID:**/Airport/getAirport/{id}

**INSERT:** /Airport/createAirport

**UPDATE:** /Airport/updateAirport/{id}

**DELETE:** /Airport/deleteAirport/{id}

**JSON:** 
```json
{
    "id_airport": 1,
    "name": "Aeropuerto Internacional de Toluca",
    "country": {
        "id_country": 1,
        "code": "MEX",
        "name": "Mexico"
    }
}
```

## Language
**GET:** /Airport/getAirport

**GET BY ID:**/Airport/getAirport/{id}

**INSERT:** /Airport/createAirport

**UPDATE:** /Airport/updateAirport/{id}

**DELETE:** /Airport/deleteAirport/{id}

**JSON:** 
```json
{
    "id_language": 1,
    "code": "ESP",
    "name": "Español"
}
```