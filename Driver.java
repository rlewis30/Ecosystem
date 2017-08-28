import java.util.*;

public class Driver
{
    public static void main(String[]args)
    {   
        boolean full=false;
        
        Animal[] river=createRiver();
        System.out.println(river.length);
        displayRiver(river);
        System.out.println();
        
        /*
        This is the main loop that causes the activity to happen in the ecosystem
        */
        for(int i=0;i<11;i++)
        {
            for(int j=0;j<river.length;j++)
            {
                if(river[j]!=null) //finds the animals in the open water
                {
                    if(river[j].move()==1) //checks to see if the animal moves to the left
                    {
                        if(j!=0)
                        {
                            String interaction=river[j].interaction(river[j], river[j-1]);
                            switch(interaction)
                            {
                                case "die":
                                    river[j]=null;
                                    //System.out.println("The fish died!");
                                    break;
                                case "eat":
                                    river[j-1]=null;
                                    //System.out.println("The Bear ate the fish!");
                                    break;
                                default:
                                    if(Animal.checkAnimal(river[j])=="Bear")
                                    {
                                        river[j]=null;
                                        river[j-1]=new Bear();
                                        //System.out.println("The Bear moves left!");
                                    }
                                    else
                                    {
                                        river[j]=null;
                                        river[j-1]=new Fish();
                                        //System.out.println("The Fish moves left!");
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
                            switch(interaction)
                            {
                                case "die":
                                    river[j]=null;
                                    //System.out.println("The fish died!");
                                    break;
                                case "eat":
                                    river[j+1]=null;
                                    //System.out.println("The Bear ate the fish!");
                                    break;
                                default:
                                    if(Animal.checkAnimal(river[j])=="Bear")
                                    {
                                        river[j]=null;
                                        river[j+1]=new Bear();
                                        //System.out.println("The Bear moves left!");
                                    }
                                    else
                                    {
                                        river[j]=null;
                                        river[j+1]=new Fish();
                                        //System.out.println("The Fish moves left!");
                                    }
                                    break;
                            }
                        }
                    }
                    
                     else//checks to see if the animal moves to the right
                    {
                        //System.out.println(Animal.checkAnimal(river[j])+" stays where it is at");
                    }
                }
            }
            
            displayRiver(river);
            System.out.println();
        }
    }
    
    /*
    *This method creates the river and places the Bears and the Fishes
    */
    public static Animal[] createRiver()
    {
//      Random riverSize = new Random();
//      Animal[] river=new Animal[riverSize.nextInt((50-4)+4)+4];
        Animal[] river=new Animal[50];
        
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
    
    
    /*
    *This method takes in an array and displays the river and the animals in the river
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