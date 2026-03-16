package Vector_Operations_Program;

public class Vector {

    public final double[] comp;

    public Vector(double[] newV) throws VectorException {
        if (newV == null || newV.length == 0) {
            throw new VectorException("Vector cannot be empty");
        }
        if (newV.length != 2 && newV.length != 3) {
            throw new VectorException("Only 2D and 3D vectors allowed");
        }
        this.comp = newV.clone();
    }

    private void checkLen(Vector other) throws VectorException {
        if (this.comp.length != other.comp.length) {
            throw new VectorException("Vectors must be of the same dimension (" 
                + this.comp.length + " != " + other.comp.length + ")");
        }
    }

    public Vector add(Vector other) throws VectorException {
        checkLen(other);
        double[] res = new double[comp.length];
        for (int i = 0; i < comp.length; i++) {
            res[i] = this.comp[i] + other.comp[i];
        }
        return new Vector(res);
    }

    public Vector subtract(Vector other) throws VectorException {
        checkLen(other);
        double[] res = new double[comp.length];
        for (int i = 0; i < comp.length; i++) {
            res[i] = this.comp[i] - other.comp[i];
        }
        return new Vector(res);
    }

    public double dotProd(Vector other) throws VectorException {
        checkLen(other);
        double res = 0;
        for (int i = 0; i < this.comp.length; i++) {
            res += this.comp[i] * other.comp[i];
        }
        return res;
    }

    public Vector crossProd(Vector other) throws VectorException {
        if (this.comp.length != 3 || other.comp.length != 3) {
            throw new VectorException("Cross product is only defined for 3D vectors.");
        }
        double[] res = new double[3];
        res[0] = this.comp[1] * other.comp[2] - this.comp[2] * other.comp[1];
        res[1] = this.comp[2] * other.comp[0] - this.comp[0] * other.comp[2];
        res[2] = this.comp[0] * other.comp[1] - this.comp[1] * other.comp[0];
        return new Vector(res);
    }

    public double getMagnitude() {
        double sum = 0;
        for (double val : comp) sum += val * val;
        return Math.sqrt(sum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < comp.length; i++) {
            sb.append(String.format("%.2f", comp[i]));
            if (i < comp.length - 1) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
}