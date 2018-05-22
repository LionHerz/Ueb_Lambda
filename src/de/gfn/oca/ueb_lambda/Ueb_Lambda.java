package de.gfn.oca.ueb_lambda;

import java.util.*;
import java.util.function.Predicate;

/**
 *
 * @author gfn
 */
public class Ueb_Lambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>(); // List of animals
        
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));
        
        //print(animals, new CheckIfHopper());
        print(animals, a -> a.canHop());
        print(animals, a -> ! a.canSwim());
        print(animals, a -> a.canSwim());
    }
    
    // private static void print(List<Animal> animals, CheckTrait checker) {
    private static void print(List<Animal> animals, Predicate<Animal> checker) {
        for(Animal animal : animals) {
            if (checker.test(animal)) // hier wird der lambda code angestoßen
                System.out.print(animal.getSpecies() + " ");
        }
        System.out.println();
                
    }
}

class Animal {
    private String speciesCV;
    private boolean canHopCV;
    private boolean canSwimCV;
    
    public Animal(String speciesName,boolean hopper, boolean swimmer) {
        speciesCV = speciesName;
        canHopCV = hopper;
        canSwimCV = swimmer;
    }
    
    public boolean canHop() {
        return canHopCV;
    }
    
    public boolean canSwim() {
        return canSwimCV;
    }

    public String getSpecies() {
        return speciesCV;
    }
    
}
