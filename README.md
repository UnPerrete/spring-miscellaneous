
# Conceptos

Definiciones y términos sobre Spring.




## Estructura de carpetas
La estructura de carpetas de un proyecto Spring suele ser la siguiente:
```bash
mi-proyecto-spring/  
├── src/  
│   ├── main/  
│   │   ├── java/  
│   │   │   └── com/  
│   │   │       └── ejemplo/  
│   │   │           ├── config/          # Configuraciones globales  
│   │   │           ├── controller/      # Controladores REST (@RestController)  
│   │   │           ├── dto/             # Objetos de transferencia de datos  
│   │   │           ├── exception/       # Manejo de excepciones globales  
│   │   │           ├── model/           # Entidades (@Entity)  
│   │   │           ├── repository/      # Interfaces de Spring Data JPA  
│   │   │           ├── service/         # Lógica de negocio (@Service)  
│   │   │           └── MiProyectoApplication.java  # Clase principal  
│   │   └── resources/  
│   │       ├── static/                  # Archivos estáticos (CSS, JS, imágenes)  
│   │       ├── templates/               # Plantillas (Thymeleaf, si usas frontend)  
│   │       ├── application.properties   # Configuración (o application.yml)  
│   │       └── data.sql                 # Datos iniciales (opcional)  
│   └── test/                            # Pruebas unitarias/integración  
│       └── java/com/ejemplo/...         # Test para servicios/controladores  
├── .gitignore                           # Archivos a ignorar en Git  
├── pom.xml (o build.gradle)             # Gestión de dependencias  
└── README.md                            # Documentación del proyecto  
```
## POST, GET Y PUT

Son un conjunto de métodos de petición para indicar la acción que se desea realizar para un recurso determinado. Aunque estos también pueden ser sustantivos, estos métodos de solicitud a veces son llamados **verbos HTTP**.

| Anotación | Verbo HTTP     | Propósito                |
| :-------- | :------- | :------------------------- |
| `@GetMapping` | `GET` | Obtener datos (sin modificar nada). |
| `@PostMapping` | `POST` | Crear un nuevo recurso (envía datos al servidor). |
| `@PutMapping` | `PUT` | Actualizar todos los atributos de un objeto existente (o crearlo si no existe). |

Es más facil de comprender si piensas que tú mismo eres el usuario, ¿quiero obtener información? **uso @GetMapping**, ¿quiero crear un recurso? **@PostMapping**, ¿quiero modificar un recurso existente? **@PutMapping**.

### ¿Cuando usar @PutMapping?
PUT se usa para reemplazar un recurso existente en el servidor.
Características clave:
- **Idempotente**: Ejecutarlo múltiples veces tiene el mismo efecto que hacerlo una vez (a diferencia de POST, que puede crear múltiples recursos).
- Requiere un identificador: Debes especificar qué recurso actualizar (ej: /api/tareas/1).

### Diferencias entre @PutMapping y @PatchMapping
@PutMapping es para reemplazar todo el objeto y modificar todos los atributos del mismo, mientras que @PatchMapping se usa para modificar atributos específicos.

## @RequestBody y @PathVariable 
| Anotación | Uso    | Ejemplo                |
| :-------- | :------- | :------------------------- |
| `@RequestBody` | Recibir datos estructurados (JSON, XML) en el cuerpo de la petición. | {"titulo": "Hacer ejercicio", "completada": true} |
| `@PathVariable` | /api/tareas/1 -> id = 1 | URL |

### @RequestBody
Se usa cuando el cliente (Postman, frontend) envía datos complejos (objetos JSON).

Por ejemplo:
Vamos a crear un objeto en un array con este método:
```bash
@PostMapping("/tareas")
public Tarea crearTarea(@RequestBody Tarea nuevaTarea) { // Recibe un JSON y lo convierte a objeto Java
    return tareaService.crearTarea(nuevaTarea);
}
```
El Body de la petición POST tiene que ser algo así dependiendo de los atributos de clase Tarea:
```bash
{
    "titulo": "Aprender Spring",
    "completada": false
}
```

### @PathVariable
Se usa cuando necesitas identificar un recurso específico en la URL, este recurso se especifíca entre { - }:

@GetMapping("/{b}/filtrar")

@PutMapping("/{id}/completar")

@PutMapping("/{id}")

Por ejemplo:
- Actualizar/Eliminar un recurso concreto.
- Obtener una tarea por ID

Un método que usa @PathVariable se ve de esta forma:
```bash
@PutMapping("/{id}/completar")
    public Tarea completarTarea(@PathVariable Long id){
        return tareaService.completar(id);
    }
```
Este método es para obtener la tarea con dicho ID y marcar el campo "completada" como true.

No se debe usar @PathVariable para datos complejos, hacer una ruta así ("/tareas/{titulo}/{completada}") está mal. **Se debe usar @RequestBody**