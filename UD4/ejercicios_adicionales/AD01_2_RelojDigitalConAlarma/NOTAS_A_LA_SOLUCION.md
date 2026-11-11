# Notas a la solución – Reloj Digital con Alarma

## ¿Para qué sirven `getHora()` y `getAlarma()` si solo llaman a otro método?

Os puede llamar la atención que los métodos `getHora()` y `getAlarma()` de `RelojAlarma`
simplemente hagan una llamada al método correspondiente de cada instancia (`VisorReloj` y
`Alarma`):

```java
public String getHora() {
    return reloj.getHora();
}

public String getAlarma() {
    return alarma.getHoraAlarma();
}
```

A esto se le llama **delegar**: `RelojAlarma` no calcula la hora por sí misma, sino que le
encarga la tarea al objeto que sabe hacerla (`VisorReloj`) y devuelve lo que este le responde. Es
una palabra que ya habéis visto en el enunciado, cuando se pide que `ponerEnHora()` "delegue esta
tarea en la clase `VisorReloj`".

Parece redundante y repetición de código, pero no lo es. Es justo lo que hace que `RelojAlarma` sea
útil. Hay dos formas de verlo.

### 1. La metáfora del coche

Cuando conduces no hablas con el inyector, con el alternador ni con el sistema de frenos. Usas
el volante, los pedales y el cambio. Son la **cara pública** del coche: lo que el fabricante ha
decidido que puedes tocar. Lo que hay debajo está escondido.

Con `RelojAlarma` pasa lo mismo:

| Coche | Nuestro proyecto |
|---|---|
| Volante, pedales, cambio | Métodos `public` de `RelojAlarma` |
| Motor, frenos, inyección | `VisorReloj` y `Alarma` (atributos `private`) |
| Tú, que conduces | `TestReloj`, que usa el reloj |

Cuando giras el volante, el volante no mueve las ruedas por sí mismo: **delega** en la dirección,
que es la que sabe hacerlo. Tú solo ves el volante. Del mismo modo, `getHora()` delega en
`VisorReloj`.

Quien usa un `RelojAlarma` no necesita saber que dentro hay un `VisorReloj` y una `Alarma`.
Pide la hora y la obtiene. Si mañana cambiamos cómo está construido por dentro, quien lo usa no
se entera y su código sigue funcionando.

### 2. ¿Y si no existiera `RelojAlarma`?

Imaginad que no hubiéramos creado la clase `RelojAlarma`. Alguien tendría que **coordinar** el
reloj y la alarma, y ese alguien sería `TestReloj`, que es nuestro `main` de pruebas.
`TestReloj` tendría que:

1. crear por un lado un `VisorReloj`,
2. crear por otro lado una `Alarma`,
3. y **sincronizarlos él mismo**, es decir, hacer a mano lo que ahora hacen `emitirTic()` y
   `esHoraAlarma()`:

```java
VisorReloj reloj = new VisorReloj(18, 32);
Alarma alarma = new Alarma();
alarma.setHoraAlarma(18, 35);

reloj.emitirTic();
if (reloj.getHora().equals(alarma.getHoraAlarma())) {
    System.out.println("RIIIING");
}
// ...y repetir ese mismo bloque tras CADA tic, en CADA prueba
```

Esto tiene varios problemas:

- La clase de pruebas mezcla dos tareas: **probar** y **hacer funcionar el reloj con alarma**.
- Cualquier otra clase que quiera un reloj con alarma tendría que volver a escribir esa
  sincronización.
- Basta con olvidarse una vez de comprobar la alarma tras un tic para que no suene.

Con `RelojAlarma` toda esa lógica está en un único sitio, y `TestReloj` se limita a probarla:

```java
miReloj.emitirTic();   // avanza y comprueba la alarma; no hay que acordarse de nada más
```

## Cada clase, su trabajo

Fijaos en cómo se reparte el trabajo:

| Clase | Su trabajo |
|---|---|
| `VisorNumero` | Contar dando la vuelta al llegar al límite |
| `VisorReloj` | Llevar horas y minutos |
| `Alarma` | Guardar la hora de la alarma. |
| `RelojAlarma` | **Sincronizar** reloj y alarma, y ofrecer al exterior un único punto de uso o interfaz |
| `TestReloj` | Probar que todo lo anterior funciona |

Es una aplicación informal del principio de responsabilidad única: cada clase debería tener un
solo motivo para cambiar. Si queremos cambiar cómo se muestra la hora, tocamos `VisorReloj`. Si
queremos cambiar cuándo debe sonar la alarma, tocamos `RelojAlarma`. Si queremos añadir pruebas,
tocamos `TestReloj`. No se cumple a rajatabla (`RelojAlarma`, por ejemplo, también decide qué
se escribe cuando suena la alarma), pero sirve como brújula para decidir dónde poner cada cosa.

## Compruébalo tú mismo (opcional)

Haz una copia del proyecto y cambia en `RelojAlarma` el atributo a `public VisorReloj reloj;`.
Ahora, en `TestReloj.test1()`, sustituye `miReloj.emitirTic()` por `miReloj.reloj.emitirTic()`
y ejecuta.

- ¿Compila?
- ¿Avanza la hora?
- ¿Suena la alarma?

Con el atributo `private` esa trampa no se puede hacer, y esa es la razón por la que
`RelojAlarma` expone `emitirTic()` y no el reloj interno.
