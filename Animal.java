import java.util.*;
/**
 * This is an abstract class is extended by the Bear and Fish classes
 * @author Ryan Lewis
 */
public abstract class Animal 
{    
    /**
    * This method generates and returns a random number that corresponds to the direction that the animal moves
    * @return a random integer between 1-3
    */    
    public int move()
    {
        Random ran = new Random();
        int direction=ran.nextInt((3-1)+1)+1;
        //System.out.println(direction);
        return direction;
    }
    
    /**
     * This method determines the type of the animal as well as the interaction that happens among the animals
     * @param animal1
     * @param animal2
     * @return a string that represents the action the animal takes
     */
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
        else if(animalType1==1&&animalType2==1||animalType1==2&&animalType2==2)
        {
            action="duplicate";
        }
        else if((animalType1==1&&animalType2==3)||(animalType1==3&&animalType2==1)||(animalType1==2&&animalType2==3)||(animalType1==3&&animalType2==2)) 
        {
            action="moves";
        }
        return action;
    }
    
    /**
     * This method determines what kind of animal the array element is
     * @param animal
     * @return String that is the type of animal
     */
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
    
    /**
     * This method returns an index for a random null element in an array which is to be the index where a new animal is 
     * created.
     * @param a
     * @return an integer that is a random index that contains a null value
     */
    public static int duplicate(Animal[]a)
    {
        int index=0;
        Random rand = new Random();
        
        ArrayList<Integer> nullIndex=new ArrayList<>();
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==null)
            {
                nullIndex.add(i);
            }
        }
        
//        System.out.println("The indexes for the nulls are: ");
        for(int i=0;i<nullIndex.size();i++)
        {
            //System.out.println(nullIndex.get(i));
        }
        if(nullIndex.isEmpty()==false)
        {
            index=nullIndex.get(rand.nextInt(nullIndex.size()));
//          System.out.println("The index is: "+index);
        }
        return index;
    }
   
   /**
    * This method returns a boolean in order to see if there are any null places in the array
    * @param b
    * @return a boolean which is true if there are nulls in the array or false if there are none
    */
   public static boolean checkNull(Animal[] b)
   {
       boolean isNull=false;
       for(int i=0;i<b.length;i++)
       {
           if(b[i]==null)
           {
               isNull=true;
           }
       }
       return isNull;
   }
}
