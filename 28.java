import java.util.Random;
// КЛАСС НЕЙРОНА 
public class Neuron {
    private double[] weights; // веса связей с предыдущими нейронами
    private double bias; // смещение нейрона
    private double output; // выходное значение нейрона

    // конструктор класса, принимающий количество входов нейрона
    public Neuron(int numInputs) {
        Random random = new Random();
        weights = new double[numInputs];
        for (int i = 0; i < numInputs; i++) {
            weights[i] = random.nextDouble() * 2 - 1; // случайные значения весов
        }
        bias = random.nextDouble() * 2 - 1; // случайное значение смещения
    }

    // функция прямого распространения нейрона
    public double feedForward(double[] inputs) {
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        sum += bias;
        output = sigmoid(sum); // применяем функцию активации
        return output;
    }

    // функция активации - сигмоида
    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }
}



//СОЗДАНИЕ НЕЙРОНКИ
public class NeuralNetwork {
    private Neuron[] neurons; // массив нейронов

    // конструктор класса, принимающий количество входов нейронов
    public NeuralNetwork(int numInputs) {
        neurons = new Neuron[2];
        neurons[0] = new Neuron(numInputs);
        neurons[1] = new Neuron(numInputs);
    }

    // функция прямого распространения нейронной сети
    public double feedForward(double[] inputs) {
        double[] outputs = new double[2];
        outputs[0] = neurons[0].feedForward(inputs);
        outputs[1] = neurons[1].feedForward(inputs);
        return sigmoid(outputs[0] + outputs[1]); // применяем функцию активации
    }

    // функция активации - сигмоида
    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }
}


//ИСПОЛЬЗОВАТЬ ЧЕРЕЗ MAIN
public static void main(String[] args) {
    NeuralNetwork network = new NeuralNetwork(2);
    double[] inputs = {0.5, 0.8};
    double output = network.feedForward(inputs);
    System.out.println("Output: " + output);
}
