package calculadora;

/*
 * Librerías para construir la interfaz gráfica (Swing)
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase Calculadora
 *
 * Crea una interfaz gráfica que permite al usuario ingresar dos números y
 * seleccionar una operación aritmética para calcular el resultado.
 */
public class Calculadora extends JFrame {

    // Campo de texto para el primer número
    private JTextField campoNumero1;

    // Campo de texto para el segundo número
    private JTextField campoNumero2;

    // Etiqueta para mostrar el resultado
    private JLabel etiquetaResultado;

    /**
     * Constructor de la clase Calculadora.
     *
     * Crea y organiza los componentes de la interfaz gráfica.
     */
    public Calculadora() {
        // Define el título de la ventana
        super("Calculadora básica");

        // Establece el layout de la ventana como una grilla de 4x2
        setLayout(new GridLayout(5, 2));

        // Inicializa los campos de texto
        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();

        // Inicializa la etiqueta de resultado
        etiquetaResultado = new JLabel("Resultado: ");

        // Crea los botones de operaciones
        JButton botonSumar = new JButton("Sumar");
        JButton botonRestar = new JButton("Restar");
        JButton botonMultiplicar = new JButton("Multiplicar");
        JButton botonDividir = new JButton("Dividir");
        JButton botonPotencia = new JButton("Potenciar");

        // Asocia una acción a cada botón
        botonSumar.addActionListener(new Operacion("+"));
        botonRestar.addActionListener(new Operacion("-"));
        botonMultiplicar.addActionListener(new Operacion("*"));
        botonDividir.addActionListener(new Operacion("/"));
        botonPotencia.addActionListener(new Operacion("^"));

        // Agrega los componentes a la ventana
        add(new JLabel("Número 1:"));
        add(campoNumero1);
        add(new JLabel("Número 2:"));
        add(campoNumero2);
        add(botonSumar);
        add(botonRestar);
        add(botonMultiplicar);
        add(botonDividir);
        add(botonPotencia);
        add(etiquetaResultado);

        // Define el tamaño de la ventana
        setSize(1080, 720);

        // Cierra la aplicación al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);

        // Hace visible la ventana
        setVisible(true);
    }

    /**
     * Clase interna que representa la acción de cada operación.
     */
    private class Operacion implements ActionListener {
        // Tipo de operación: "+", "-", "*", "/", "^"
        private String operador;

        /**
         * Constructor que recibe el tipo de operación.
         *
         * @param operador Operación a ejecutar.
         */
        public Operacion(String operador) {
            this.operador = operador;
        }

        /**
         * Ejecuta la operación cuando se hace clic en un botón.
         *
         * @param e Evento del botón presionado.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Convierte los textos ingresados a números
                double num1 = Double.parseDouble(campoNumero1.getText());
                double num2 = Double.parseDouble(campoNumero2.getText());
                double resultado = 0.0;

                // Ejecuta la operación según el operador
                switch (operador) {
                    case "+":
                        resultado = num1 + num2;
                        break;
                    case "-":
                        resultado = num1 - num2;
                        break;
                    case "*":
                        resultado = num1 * num2;
                        break;
                    case "/":
                        // Valida que el divisor no sea cero
                        if (num2 == 0) {
                            throw new ArithmeticException("División por cero");
                        }
                        resultado = num1 / num2;
                        break;
                    case "^":
                        resultado = Math.pow(num1, num2);
                        break;
                }

                // Muestra el resultado en la etiqueta
                etiquetaResultado.setText("Resultado: " + resultado);
            } catch (NumberFormatException ex) {
                // Muestra mensaje si los campos no contienen números válidos
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor, ingrese números válidos.",
                        "Error de entrada",
                        JOptionPane.ERROR_MESSAGE
                );
            } catch (ArithmeticException ex) {
                // Muestra mensaje si hay una división por cero
                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        "Error matemático",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    /**
     * Método principal. Inicia la aplicación.
     *
     * @param args Argumentos de línea de comandos (no usados).
     */
    public static void main(String[] args) {
        new Calculadora();
    }
}