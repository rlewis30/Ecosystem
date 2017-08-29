import java.util.*;
/**
 * This is class contains the main method for the program
 * @author Ryan Lewis
 */
public class Driver
{
    /**
     * This is the main method that runs the program
     * @param args 
     */
    public static void main(String[]args)
    {   
        boolean full=false; //This variable holds the flag which determines whether or not to end the loop that starts moves that causes activity
        boolean nullCount=false;
        int count=0;
        int index; 
        
        Animal[] river=createRiver(); //This creates an Animal array that contains the river and the place animals
        displayRiver(river); //This displays the river prior to the loop starting
        System.out.println();
        
        /*
        This is the main loop that causes the activity to happen in the ecosystem
        */
        while(full==false)
        {
            nullCount=false;
            for(int j=0;j<river.length;j++) //This loop goes through all the objects in the river array to start their actions
            {   if(river[j]==null)
                {
                }
                else//finds the animals in the open water
                {
                    if(river[j].move()==1) //checks to see if the animal moves to the left
                    {
                        if(j!=0) //This makes sure the object in the array is not null
                        {
                            String interaction=river[j].interaction(river[j], river[j-1]); //This gets the interaction for that animal
                            switch(interaction) //This launches the code that has that animal do that action
                            {
                                case "die": 
                                    river[j]=null;
                                    System.out.println("The fish died!");
                                    break;
                                case "eat":
                                    river[j-1]=null;
                                    System.out.println("The Bear ate the fish!");
                                    break;
                                case "duplicate":
                                    if(Animal.checkAnimal(river[j])=="Bear")
                                    {
                                        index=Animal.duplicate(river);
                                        river[index]=new Bear();
                                        System.out.println("Bear was born!");
                                    }
                                    else
                                    {
                                        index=Animal.duplicate(river);
                                        river[index]=new Fish();
                                        System.out.println("Fish was born!");
                                    }
                                    break;
                                default:
                                    if(Animal.checkAnimal(river[j])=="Bear")
                                    {
                                        river[j]=null;
                                        river[j-1]=new Bear();
                                        System.out.println("The Bear moves left!");
                                    }
                                    else
                                    {
                                        river[j]=null;
                                        river[j-1]=new Fish();
                                        System.out.println("The Fish moves left!");
                                    }
                                    break;
                            }
                        }
                    }
                    
                    else if(river[j].move()==2) //checks to see if the animal moves to the right
                    {
                        if(j!=river.length-1)
                        {
                            String interaction=river[j].interaction(river[j], river[j+1]);
                            switch(interaction) //This launches the code that has that animal do that action
                            {
                                case "die":
                                    river[j]=null;
                                    System.out.println("The fish died!");
                                    break;
                                case "eat":
                                    river[j+1]=null;
                                    System.out.println("The Bear ate the fish!");
                                    break;
                                case "duplicate":
                                    if(Animal.checkAnimal(river[j])=="Bear")
                                    {
                                        index=Animal.duplicate(river);
                                        river[index]=new Bear();
                                    }
                                    else
                                    {
                                        index=Animal.duplicate(river);
                                        river[index]=new Fish();
                                        break;
                                    }
                                default:
                                    if(Animal.checkAnimal(river[j])=="Bear")
                                    {
                                        river[j]=null;
                                        river[j+1]=new Bear();
                                        System.out.println("The Bear moves left!");
                                    }
                                    else
                                    {
                                        river[j]=null;
                                        river[j+1]=new Fish();
                                        System.out.println("The Fish moves left!");
                                    }
                                    break;
                            }
                        }
                    }
                    
                    else//checks to see if the animal moves to the right
                    {
                        System.out.println(Animal.checkAnimal(river[j])+" stays where it is at");
                    }
                }
            }
            
            displayRiver(river); //This displays the river after every loop
            System.out.println();
            if(Animal.checkNull(river)==false) //This determines whether to set the flag which determines if the river is full
            {
                full=true;
            }
        }
    }
    
    /**
     * This method creates the array which represents the river, places the animals in the river, and ranomizes that array
     * @return an array that represnts the river and the animals in the river
     */
    public static Animal[] createRiver()
    {
//      Random riverSize = new Random();
//      Animal[] river=new Animal[riverSize.nextInt((50-4)+4)+4];
        Animal[] river=new Animal[20];
        
        int size=river.length/2;
        for(int i=0;i<size;i++)
        {
            if((i+1)%2==0)
            {
                river[i]=new Fish();
            }
            else
            {
                river[i]=new Bear();
            }
        }
        
        ArrayList<Animal> riverList = new ArrayList<>(Arrays.asList(river));
        Collections.shuffle(riverList);
        Animal shuffledRiver[]=riverList.toArray(new Animal[riverList.size()]);
        return shuffledRiver;
    }
    
    
    /**
     * This method displays the river graphically
     * @param river 
     */
    public static void displayRiver(Animal[]river)
    {
        for(int i=0;i<river.length;i++)
        {
            if(river[i] instanceof Bear)
            {
                System.out.print("Bear|");
            }
            else if (river[i] instanceof Fish)
            {
                System.out.print("Fish|");
            }
            else
            {
                System.out.print("Empty Water|");
            }
        }
    }
}