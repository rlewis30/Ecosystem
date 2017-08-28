import java.util.*;

/*
This is an abstract class is extended by the Bear and Fish classes
*/
public abstract class Animal 
{
/*
This method generates and returns a random number that corresponds to the direction that the animal moves    
*/    
    public int move()
    {
        Random ran = new Random();
        int direction=ran.nextInt((3-1)+1)+1;
        //System.out.println(direction);
        return direction;
    }
    
    public String interaction(Animal animal1, Animal animal2)
    {
        String action="";
        int animalType1;
        int animalType2;
        
        if(animal1 instanceof Bear)
        {
            animalType1=1;
        }
        else if(animal1 instanceof Fish)
        {
            animalType1=2;
        }
        
        else
        {
            animalType1=3;
        }
        
        if(animal2 instanceof Bear)
        {
            animalType2=1;
        }
        else if(animal2 instanceof Fish)
        {
            animalType2=2;
        }
        
        else
        {
            animalType2=3;
        }
        
        if(animalType1==2&&animalType2==1)
        {
            action="die";
        }
        else if(animalType1==1&&animalType2==2)
        {
            action="eat";
        }
        else if((animalType1==1&&animalType2==3)||(animalType1==3&&animalType2==1)||(animalType1==2&&animalType2==3)||(animalType1==3&&animalType2==2)) 
        {
            action="moves";
        }
        return action;
    }
    
    public static String checkAnimal(Animal animal)
    {
        String animalKind="";
        if(animal instanceof Bear)
        {
            animalKind="Bear";
        }
        else if(animal instanceof Fish)
        {
            animalKind="Fish";
        }
        else
        {
            animalKind="Water";
        }
        
        return animalKind;
    }
}
