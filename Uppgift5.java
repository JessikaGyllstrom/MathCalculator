import java.util.Scanner;

public class Uppgift5 
{
   /**
    * Programmet beräknar area och volym samt presenterar bråktal
    * 
    * 1. Läser in radie och height
    * 2. Avbryter när användaren skriver "q"
    * 2. Skriver ut radie och height
    * 3. Beräknar basytansarea, mantelytansarea & volym
    * 4. Skriv ut resultat 
    * 5. Läser in nominator och denominator
    * 6. Avbryter när användaren skriver "q"
    * 7. Skriver ut nominator och denominator
    * 8. Skriver ut bråktalet
    * 
    *
    * @author Jessika Gyllström, jesgyl-0
    */
   private static Scanner userInput = new Scanner(System.in);
   
   public static void main(String[] args) 
   { 
      //skapar variabler 
      int radius = 0;
      int height = 0;
      int inputNumber1 = 0;
      int inputNumber2 = 0;  
      double area = 0;           
      double volume = 0;
      double mantelArea = 0;
      int division;
      double c = 0;    
      int answer = 0;
      int run = 0;   
      int[] vektor = new int[3];
      
         
      System.out.printf("--------------------------------------------%n"
      + "# Test av area och volymmetoderna%n"
      + "--------------------------------------------%n"
      + "> ");
     
     //loop som skickar vidare värde för radie och höjd
     //avslutas om användaren matar in q 
     do
     {   
         radius = input();
         if(radius == -1)
         {
            break;
         }
         height = input();  
         if(height == -1)
         {
            break;
         }    
         
      
      area = area(radius);     
      c = pythagoras(radius, height);
      mantelArea = area(radius, c);   
      volume = volume(radius, height);
         
      System.out.printf("Basytans area:  %.2f %n", area);
      System.out.printf("Mantelytans area:  %.2f %n", mantelArea);   
      System.out.printf("Volume:  %.2f %n", volume);
      } while(true);
        
      
      System.out.printf("--------------------------------------------%n"
      + "# Test av bråktalsmetoderna"
      + "--------------------------------------------%n"
      + "> ");
      

      //loop som skickar vidare värde för radie och höjd
      //avslutas om användaren matar in q 
      do
      {   
         inputNumber1 = input();
         if(inputNumber1 == -1)
         {
            break;
         }
         inputNumber2 = input();  
         if(inputNumber2 == -1)
         {
            break;
         }          
     
      vektor = fraction(inputNumber1, inputNumber2);
      if(inputNumber2==0)
      {
         System.out.println("Error");
      }
      else
      {
      printFraction(vektor);
      }
     } while(true);    
    }          
      /**
       * medoden räknar ut arean
       * @param radius
       * @return decimaltal
       */  
      public static double area(int radius)
      {

        double baseArea = Math.PI * (radius * radius);
        return baseArea;
      }
      /**
       * metoden räknar ut mantelytans arean
       * @param radius, height
       * @return decimaltal
       */  
      public static double area(int radius, double height)
      {                
        final double PI = 3.14;
        double m = PI * radius * height ;
        return m;
      }
      /**
       * metoden räknar ut hypotenusan 
       * @param radius, height
       * @return decimaltal
       */  
      public static double pythagoras(int sideA, int sideB)
      {
        double c = Math.sqrt((sideA * sideA) + (sideB * sideB)); 
        return c;
      }
      /**
       * metoden räknar ut volym 
       * @param radius, height
       * @return decimaltal
       */ 
      public static double volume(int radius, int height)
      {
        final double PI = 3.14;
        double v = PI * radius * radius * height / 3;
        return v;
      }
      /**
       * metoden tar in täljare och nämnare och omvandlar till heltal och bråkdel
       * nominator = täljare, denominator = nämnare
       * @param nominator, denominator
       * @return array
       */ 
      public static int[] fraction(int nominator, int denominator)
      {   
         //om nämnaren är 0
         if(denominator == 0)
         {
            return null;
            
         }
         //om täljaren är 0
         else if(nominator == 0)
         {
            int[] v = {0, 0, 0};
            return v;
         } 
         else 
         {    
         //räknar ut kvoten och sparar i integer
         int integer = nominator / denominator;
         //räknar ut resttalet och sparar i denom
         int denom = nominator % denominator;
         int[] v = {integer, denom, denominator}; 

         return v;    
         }
      }
      /**
       *metoden förkortar bråktal genom att hitta största gemensamma delaren
       * @param a, b
       * @return array
       */ 
       public static int gcd(int a, int b)
       {
         int c = 0;
        
         if(a<b)
         {
           b = a;
         }
         while(b!=0)
         {
            c = a % b;
            a = b;
            b = c;
         }
          return a;      
        }
    
       /**
        * metoden tar emot array och skriver ut den som heltal, täljare, nämnare
        * @param array
        * 
        */ 
       
       public static void printFraction(int[] parts)
       {   
          //om alla element i array är 0
          if(parts[0]==0 && parts[1]==0 && parts[2]==0)
          {
             System.out.print("0");
          }
          //om andra siffran är lika med 0
          else if(parts[1]==0)
          {
             System.out.print(parts[0]);
          }
          else if(parts[0]==0)
          {
             System.out.print(parts[1]);
             System.out.print("/");
             System.out.print(parts[2]);
          }
          else if(parts[0]!=0)
          {
             System.out.print(parts[0] + " ");        
             System.out.print(parts[1]);
             System.out.print("/");
             System.out.print(parts[2]);
          }
          else
          {
             System.out.print("Error");

          }
          System.out.println();
       
       }
       
       /**
        * metod som läser in användarens inmatning och returnerar ett heltal eller "-1" om användaren skriver q
        * @return heltal -1
        * 
        */ 
       public static int input()
       {  
          int input = 0;
          int number;
          
          while(true)
          {
           if(userInput.hasNextInt())
           {     
             number = userInput.nextInt();
             input = Math.abs(number);
             break;
           
           } 
           else if(userInput.next().equalsIgnoreCase("q")) 
           {
              input = -1;
              break;           
           }  
           else 
           {
              System.out.println("Ange heltal");
           }
                   
         } 
                    
         return input;
        }
}

      
       

       

        
   
    
      
      
  
