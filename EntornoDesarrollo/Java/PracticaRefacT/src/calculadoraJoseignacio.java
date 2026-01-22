import java.util.Map;

interface Operacion {
    double calcular(double a, double b);
}


class Suma implements Operacion {
    public double calcular(double a, double b) {
        return a + b;
    }
}

class Resta implements Operacion {
    public double calcular(double a, double b) {
        return a - b;
    }
}

class Multiplicacion implements Operacion {
    public double calcular(double a, double b) {
        return a * b;
    }
}

class Division implements Operacion {
    public double calcular(double a, double b) {
        if (b == 0) throw new IllegalArgumentException("El divisor no puede ser cero.");
        return a / b;
    }
}


public class calculadoraJoseignacio {
    public double calcular(double a, double b, String operacion) {
        Map<String, Operacion> operaciones = Map.of(
                "sumar", new Suma(),
                "restar", new Resta(),
                "multiplicar", new Multiplicacion(),
                "dividir", new Division()
        );

        Operacion op = operaciones.get(operacion);
        if (op == null) {
            throw new IllegalArgumentException("Operación no válida: " + operacion);
        }
        return op.calcular(a, b);
    }
}