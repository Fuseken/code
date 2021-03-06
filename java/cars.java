import java.util.*;

/**
 * component
 */
interface CarParts {
    public double getWeight();
}

public class Assembly implemenets Part {

    /**
     * all components
     */
    private ArrayList<CarParts> carComponents = new ArrayList<CarParts>();

    /**
     * getWeight for whole car
     */
    public double getWeight() {
        double totalWeight = 0;
        for( CarParts part : carComponents ) {
            totalWeight += part.getWeight();
        }
        return totalWeight;
    }

}

public class Part implements CarParts {

    /**
     * component: weight
     */
    private double weight;

    /**
     * weight of this part
     */
    public double getWeight() {
        return weight;
    }
}

public class Program {
    public static void main(String[] args) {
        Part chassis = new CarParts();
        Part engine  = new CarParts();
        Part body    = new CarParts();
        Assembly porsche = new Assembly();
        porsche.add(chassis);
        porsche.add(engine);
        porsche.add(body);

        double porscheWeight = porsche.getWeight;
        System.out.println("porsche weights " + porscheWeight);
    }
}
