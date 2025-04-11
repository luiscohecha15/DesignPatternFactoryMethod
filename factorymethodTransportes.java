// --- PASO 1: Definir la Interfaz del Producto ---
// Esto define qué tipo de objeto queremos crear.
interface Envio {
    String enviar(); // Todos los saludos deben poder decir "hola" de alguna forma.
}

// --- PASO 2: Crear Productos Concretos ---
// Estas son las implementaciones específicas de Saludo.
class EnvioTerrestre implements Envio {
    @Override
    public String enviar() {
        return "Se ha enviado de forma terrestre";
    }
}

class EnvioMaritimo implements Envio {
    @Override
    public String enviar() {
        return "Se ha enviado de forma maritima";
    }
}

class EnvioAereo implements Envio {
    @Override
    public String enviar() {
        return "Se ha enviado de forma aerea";
    }
}

// --- PASO 3: Definir la Fábrica Abstracta (Creator) ---
// Contiene el "Factory Method" abstracto.
abstract class FabricaEnvios {

    // Este es el FACTORY METHOD. Es abstracto.
    // Obliga a las subclases a decidir qué Saludo concreto crear.
    public abstract Envio crearEnvio();

    // Un método que usa el producto creado por el factory method.
    public void Enviar() {
        Envio envio = crearEnvio(); // Llama al factory method para obtener el objeto.
        System.out.println("Mensaje obtenido de la fábrica: " + envio.enviar());
    }
}

// --- PASO 4: Crear Fábricas Concretas (Concrete Creators) ---
// Cada fábrica concreta implementa el factory method para crear un producto específico.
class FabricaEnviosTerrestres extends FabricaEnvios {
    @Override
    public Envio crearEnvio() {
        // Esta fábrica específica crea Saludos en Español.
        return new EnvioTerrestre();
    }
}

class FabricaEnviosMaritimos extends FabricaEnvios {
    @Override
    public Envio crearEnvio() {
        // Esta fábrica específica crea Saludos en Inglés.
        return new EnvioMaritimo();
    }
}

class FabricaEnviosAereos extends FabricaEnvios {
    @Override
    public Envio crearEnvio() {
        // Esta fábrica específica crea Saludos en Inglés.
        return new EnvioAereo();
    }
}

// --- PASO 5: Usar las Fábricas (Código Cliente) ---
public class DemoSimpleFactory {

    public static void main(String[] args) {

        System.out.println("Probando la Fábrica de Envios de forma Terrestre");
        FabricaEnvios fabricaT = new FabricaEnviosTerrestres();
        fabricaT.Enviar();

        System.out.println("Probando la Fábrica de Envios de forma Marítima");
        FabricaEnvios fabricaM = new FabricaEnviosMaritimos();
        fabricaM.Enviar();

        System.out.println("Probando la Fábrica de Envios de forma Aerea");
        FabricaEnvios fabricaA = new FabricaEnviosAereos();
        fabricaA.Enviar();
    }
}
