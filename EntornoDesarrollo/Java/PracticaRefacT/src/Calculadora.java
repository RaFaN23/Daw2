public class Calculadora {
    public double calculadora (double a,double b,String operation ){
        double resultado = 0.0;
        switch (operation) {
            case "suma" -> resultado = a + b;
            case "resta" -> resultado = a - b;
            case "mult" -> resultado = a * b;
            case "dividir" -> {
                if (b != 0) {
                    resultado = a / b;
                } else {
                    throw new IllegalArgumentException("El diviso no puede ser cero");
                }
            }
        }
        return resultado;
    }
}
