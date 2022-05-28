package pl.edu.pwr.mine;

public class Main {

    public static void main(String[] args) {
        Simulation simulation = new Simulation(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        simulation.run();
    }
}
