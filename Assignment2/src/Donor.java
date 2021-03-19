/**
 * APT: PrefixCode
 */
//package bonus;

import java.util.*;

/**
 * @author MarcusDeans
 *
 */
public class Donor implements Comparable<Donor>{
    String myFirstName;  // Donor’s first name
    String myLastName;	// Donor’s last name
    int myIDNumber;	// Donor’s id number
    double myAmount;	// total amount Donor has given to all companies
    HashMap<String, ArrayList<Double> > myDonations;// map of company ids to list of all donations given to that company

    Donor(String first, String last, int id) {	// Constructor
        // code not shown
        myFirstName=first;
        myLastName=last;
        myIDNumber=id;
    }

    public String getName() {	// returns Donor’s name
        return myFirstName + " " + myLastName;
    }

    public int getID() {	// returns Donor’s ID
        return myIDNumber;
    }

    public double getAmount() {	// returns total amount Donor has given
        return myAmount;
    }

    public void addDonation(String compName, double amount) {	// add a donation, the donor is giving company compName a donation of amount
        // code not shown
        myAmount+=amount;
        ArrayList<Double> temp=new ArrayList<Double>();
        temp.add(amount);
        if(myDonations.get(compName)==null) {
            myDonations.put(compName, temp);
        }
        else {
            temp.addAll(myDonations.get(compName));
            myDonations.replace(compName, temp);
        }
    }

    public int numberOfDonations(String compName) {	// returns the total number of donations Donor has given to company compName
        return myDonations.get(compName).size();
    }

    public double getAmountCharity(String compName) {	// return the total amount a Donor has given to the company named compName
        // code not shown
        double sum = 0;
        for (Double e : myDonations.get(compName)) sum += e;
        return new Double(sum);
    }

	/*
	 *
		print out the Donors name on one line, and then for each charity the donor
		has given to, print on one line the charity id, a comma, the total number of
		donations followed by the words " donations totaling ", and the total amount
		given to that charity.
		Then print a line that says Total: and the total amount
	 *
	 */

    public void printDonorAmounts() {

        // Getting an iterator
        Iterator donationIterator = myDonations.entrySet().iterator();

        // Iterate through the hashmap
        System.out.println(myFirstName+" "+myLastName);

        Double total= new Double(0.0);

        while (donationIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)donationIterator.next();
            Double amount = ((Double)mapElement.getValue());
            System.out.println(mapElement.getKey() + ", "+ myDonations.get(mapElement.getKey()).size() + " donations totaling" + amount);
            total+=amount;
        }
        System.out.println("Total: "+total);
    }


    @Override
    public boolean equals(Object o) {
        Donor other = (Donor) o;
        // rest of code not shown

        if (other.getID()==this.myIDNumber) {
            return true;
        }
        else return false;
    }


    @Override
    public int hashCode() {
        return (int)  (myIDNumber);
    }


    @Override
    public int compareTo(Donor o) {
        if (myIDNumber < o.myIDNumber ) return -1;
        if (myIDNumber > o.myIDNumber )  return 1;
        return 0;
    }
}
