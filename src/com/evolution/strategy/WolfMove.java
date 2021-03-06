
package com.evolution.strategy;

import com.evolution.model.Animal;
import com.evolution.model.Model;
import com.evolution.model.Sheep;
import com.evolution.model.Square;
import java.util.ArrayList;

/**
 * Class WolfMove / Pattern Strategy
 * @author Anthony
 */
public class WolfMove implements BehaviorMove{

    Model m;

    /**
     * Constructor of the WolfMove Behavior
     * @param mParam Model
     */
    public WolfMove(Model mParam) {
        m = mParam;
    }

    /**
     * Method move
     * @param animal Animal
     */
    @Override
    public void move(Animal animal) {
        ArrayList<Square> list1 = new ArrayList<>();
        ArrayList<Square> list2 = new ArrayList<>();
        ArrayList<Square> list3 = new ArrayList<>();

        int x = animal.getPosX();
        int y = animal.getPosY();

        int finalx;
        int finaly;

        boolean flag = false;
    

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                list1.add(new Square(i, j));
            }
        }

        // SUPRIMER LES CAS IMPOSSIBLES
        for (int z = 0; z < 9; z++) {
            if (!(list1.get(z).getX() < 0 || list1.get(z).getX() >= m.getSizeX())) {
                if (!(list1.get(z).getY() < 0 || list1.get(z).getY() >= m.getSizeY())) {
                    list2.add(list1.get(z));

                }
            }
        }
        // On note les cases, si il y a un mouton on sélectionne cette case, sinon on va dans les cases où il n'y a pas d'animaux
        //Verif des animaux et selection du mouton
        for (int i = 0; i < list2.size(); i++) {
            if (m.world[list2.get(i).getX()][list2.get(i).getY()].getNumberOfAnimals()==1) {

                for (int j = 0; j < m.getListAnimals().size(); j++) {
                    if (m.getAnimal(j).getPosX() == list2.get(i).getX() && m.getAnimal(j).getPosY() == list2.get(i).getY()) {
                        if (m.getAnimal(j) instanceof Sheep) {
                            //System.out.println("ATTENTION LOUP SUR MOUTON !! -----------------------------------------------");
                            finalx = m.getAnimal(j).getPosX();
                            finaly = m.getAnimal(j).getPosY();
                          
                            m.world[x][y].setNumberOfAnimals(m.world[x][y].getNumberOfAnimals()-1);
                            
                            animal.setPosX(finalx);
                            animal.setPosY(finaly);
                            m.world[finalx][finaly].setNumberOfAnimals(m.world[finalx][finaly].getNumberOfAnimals()+1);
                            System.out.println("Loup va en :"+finalx+" "+finaly);
                            flag = true;
                            break;
                        }
                    }
                }
            }
            else{
                list3.add(list2.get(i)); // Si il n'y a pas d'animal on ajoute à L3
            }

            if (flag == true) {
                // Si on a déjà déplacé sur le mouton alors on termine la fonction
                break;
            }
        }
        
        //L3 correspond au cases sans loups. Et sans mouton sinon la fonction
        // serait terminée
        if (flag == false) {
           if (!list3.isEmpty()) {
            int rand = Model.randInt(0, list3.size() - 1);

            m.world[x][y].setNumberOfAnimals(m.world[x][y].getNumberOfAnimals() -1);
            
            animal.setPosX(list3.get(rand).getX());
            animal.setPosY(list3.get(rand).getY());
            m.world[animal.getPosX()][animal.getPosY()].setNumberOfAnimals(m.world[animal.getPosX()][animal.getPosY()].getNumberOfAnimals()+1);
            
            System.out.println("Loup va en :"+animal.getPosX()+" "+animal.getPosY());

        } else {
            System.out.println("Loup va en :"+animal.getPosX()+" "+animal.getPosY());
        }
        }

    }

}
