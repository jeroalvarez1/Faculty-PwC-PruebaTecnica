<h1 style="font-size:40px;">Prueba tecnica para Pwc.</h1>
Empresa: Pwc.  
Entrevistado: Jerónimo Alvarez Tablado.  

Consigna: Realizar un sistema que permita gestionar las personas que estudian y trabajan en una facultad.  
Se pretende realizar una aplicación para una facultad que gestione la información sobre las personas vinculadas con la misma y que se pueden clasificar en tres tipos: estudiantes, profesores y personal de servicio. A continuación, se detalla qué tipo de información debe gestionar esta aplicación:  

* Por cada persona, se debe conocer, al menos, su nombre y apellidos, su número de identificación y su estado civil.  
* Con respecto a los empleados, sean del tipo que sean, hay que saber su año de incorporación a la facultad y qué número de despacho tienen asignado.  
* Con respecto a los empleados, sean del tipo que sean, hay que saber su año de incorporación a la facultad y qué número de despacho tienen asignado.  
* Por lo que se refiere a los profesores, es necesario gestionar a qué departamento pertenecen (lenguajes, matemáticas, arquitectura, ...).  
* Sobre el personal de servicio, hay que conocer a qué sección están asignados (biblioteca, decanato, secretaría, ...).  

El ejercicio consiste, en primer lugar, en definir la jerarquía de clases de esta aplicación. A continuación, debe programar las clases definidas en las que, además de los constructores, hay que desarrollar los métodos correspondientes a las siguientes operaciones:  

* Cambio del estado civil de una persona.  
* Matriculación de un estudiante en un nuevo curso.  
* Cambio de departamento de un profesor.  
* Traslado de sección de un empleado del personal de servicio.  

Bonus:  

* Obtención de todos los profesores para algún departamento particular  
* Obtención de todos los estudiantes de un curso.  
* Realizar tests que prueben la funcionalidad realizada.  


# Requisitos para ejecutar el sistema:  

* Tener mysqserver instalado
* Tener java 11 o superior instalado
* Tener mvn instalado


# Pasos para ejecutar el sistema:  

* Crear la base de datos faculty    
* Una vez clonado el repositorio ir al archivo src/main/resources/application.properties y cambiar spring.datasource.username = username por el nombre de usuario de la base de datos y spring.datasource.password= password por la contraseña de dicho usuario  
* Ejecutar en comando mvn install en la carpeta raiz del sistema  
* Para fianlizar ejecutar el comando java -jar faculty-0.0.1-SNAPSHOT.jar en la carpeta target del proyecto para ejecutar el sistema  


# Las consultas que se le pueden realizar a la API desarrollada son:  

Civil Status  

    Agegar Civil Status  
    /api/civilstatus - POST  
        {  
            "name": "Soltero"  
        }  

        {  
            "name": "Casado"  
        }  

        {  
            "name": "Viudo"  
        }  

Course  

    Obtener un curso  
        /api/courses/{course_id} - GET  

    Obtener estudiantes de un curso  
        /api/courses/{course_id}/students - GET  


    Agregar un curso  
        /api/courses - POST  
            {  
                "name": "Primero A"  
            }  
            
            {  
                "name": "Segundo B"  
            }  

            {  
                "name": "Segundo A"  
            }  

    Agregar estudiante a curso  
        /api/courses/add/{course_id}/student/{student_id} - GET  
        
    Quitar todos los estudiantes de un curso  
        /api/courses/remove/{course_id} - GET  

    Quitar un estudiante de un curso  
        /api/courses/remove/{course_id}/student/{student_id} - GET  

Department  

    Agregar un departamento  
        /api/departments - POST  
            {  
                "name": "Lengua"  
            }  

            {  
                "name": "Matematica"  
            }  

            {  
                "name": "Ciencias Naturales"  
            }  

Person  

    Cambiar estado civil de una persona  
        /api/persons/{person_id}/changestatus/{status_id} - GET  

Section  

    Agregar nueva seccion  
        /api/sections - POST  
            {  
                "name": "Laboratorio"  
            }  

            {  
                "name": "Cocina"  
            }  

            {  
                "name": "Puerta"  
            }  

ServiceStaff  

    Cambiar empleado de servicio de seccion  
        /api/services/{serviceStaff_id}/changesection/{section_id} - GET  

    Agregar nuevo empleado de servicio  
        /api/services - POST  
            { 
                "firstName": "Piter",  
                "lastNames": "Alvarez",  
                "dni": "41786523", 
                "yearIncorporation": 2020, 
                "officeNumber": 25  
            }  

            {  
                "firstName": "Juan",  
                "lastNames": "Davis",  
                "dni": "41756423",  
                "yearIncorporation": 2015,  
                "officeNumber": 21  
            }  

            {  
                "firstName": "Andres", 
                "lastNames": "Perez", 
                "dni": "40386523",  
                "yearIncorporation": 2021,  
                "officeNumber": 5  
            }  


Student  

    Agregar nuevo estudiante  
        /api/students - POST  
            {  
                "firstName": "Pedro",  
                "lastNames": "Picapiedras", 
                "dni": "01276756"  
            }  

            {  
                "firstName": "Romina",  
                "lastNames": "Ramirez",  
                "dni": "25678967"  
            } 
            
            {  
                "firstName": "Andres",  
                "lastNames": "De los Angeles",  
                "dni": "41768967"  
            }  

Teacher  

    Cambiar profesor de departamento  
        /api/teachers/{teacher_id}/changedepartment/{department_id} - GET  

    Obtener profesores de un departamento  
        /api/teachers/department/{department_id} - GET  

    Agregar profesores  
        /api/teachers  
            {  
                "firstName": "Bruno",  
                "lastNames": "Galdamez",  
                "dni": "41786467",  
                "yearIncorporation": 2010,  
                "officeNumber": 2  
            }  

            {  
                "firstName": "Alejandra",  
                "lastNames": "Tablado",  
                "dni": "30675621",  
                "yearIncorporation": 2015,  
                "officeNumber": 1  
            }  

            {  
                "firstName": "Andres",  
                "lastNames": "Gomez",  
                "dni": "43346523",  
                "yearIncorporation": 2017,  
                "officeNumber": 9  
            }  
