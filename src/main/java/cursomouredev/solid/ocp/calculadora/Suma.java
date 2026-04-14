package cursomouredev.solid.ocp.calculadora;

public class Suma {
    public int sumar(int... números) {
        int suma = 0;
        for (int num : números) {
            suma += num;
        }
        return suma;
    }

    public double sumar(double... números) {
        double suma = 0.0;
        for (double num : números) {
            suma += num;
        }
        return suma;
    }

    public double sumarPromediar(double... números) {
        double promedio = 0.0;
        for (double num : números) {
            promedio += num;
        }
        return promedio / números.length;
    }

    public double sumarInversos(double... números) {
        double sumaInversa = 0.0;
        for (double num: números) {
            sumaInversa += (1/num);
        }
        return sumaInversa;
    }
}
