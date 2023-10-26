/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerdesignpattern;

/**
 *
 * @author fa20-bse-040
 */
public class ObserverDesignPAttern {
   public static void main(String[] args) {
      Subject subject = new Subject();

     HexaObserver hexaObserver = new HexaObserver(subject);
    OctalObserver octalObserver = new OctalObserver(subject);
    BinaryObserver binaryObserver = new BinaryObserver(subject);
    //By default all observer are notified and updated but when we implement detach method on;ly active observers are updated and notifed
         subject.detach(hexaObserver);
       System.out.println("Now hexa observer Detached, only the OctalObserver and BinaryObserver will receive updates\n");
      System.out.println("First state change: 15");	
      subject.setState(15);
      System.out.println("Second state change: 10");	
      subject.setState(10);
   }
}
