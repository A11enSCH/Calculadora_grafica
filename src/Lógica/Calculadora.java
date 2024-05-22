package Lógica;

public class Calculadora {
    private double resultado;
    private String operacion;
    private boolean nuevaOperacion;

    public Calculadora() {
        resultado = 0;
        operacion = "";
        nuevaOperacion = true;
    }

    public double getResultado() {
        return resultado;
    }

    public boolean isNuevaOperacion() {
        return nuevaOperacion;
    }

    public void setNuevaOperacion(boolean nuevaOperacion) {
        this.nuevaOperacion = nuevaOperacion;
    }

    public void realizarOperacion(String comando, String pantallaTexto) {
        if (comando.equals("=")) {
            calcular(Double.parseDouble(pantallaTexto));
            operacion = "";
            nuevaOperacion = true;
        } else if ("0123456789.".contains(comando)) {
            if (nuevaOperacion) {
                nuevaOperacion = false;
            }
        } else {
            if (!operacion.isEmpty()) {
                calcular(Double.parseDouble(pantallaTexto));
            } else {
                resultado = Double.parseDouble(pantallaTexto);
            }
            operacion = comando;
            nuevaOperacion = true;
        }
    }

    private void calcular(double numero) {
    	if (operacion.equals("+")) {
            resultado += numero;
        } else if (operacion.equals("-")) {
            resultado -= numero;
        } else if (operacion.equals("*")) {
            resultado *= numero;
        } else if (operacion.equals("/")) {
            resultado /= numero;
        }
    }
}
