package ly.fullstack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	/*
	 * public static void main(String[] args) { System.out.println("Hello World!");
	 * System.out.println("\n**************************************\n");
	 * System.out.println("\tWelcome to TheDesk \n");
	 * System.out.println("**************************************"); //
	 * optionsSelection(); }
	 */

	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println("\n**************************************\n");
		System.out.println("\tWelcome to TheDesk \n");
		System.out.println("**************************************"); //
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		ArrayList<Integer> expenses = new ArrayList<Integer>();

		
		  expenses.add(1000); 
		  expenses.add(2300); 
		  expenses.add(45000);
		  expenses.add(32000);
		  expenses.add(110);
		  arrlist.addAll(expenses);
		  
		optionsSelection(expenses);

	}

	private static void optionsSelection(ArrayList<Integer> expenses) {
		String[] arr = { "1. I wish to review my expenditure", "2. I wish to add my expenditure",
				"3. I wish to delete my expenditure", "4. I wish to sort the expenditures",
				"5. I wish to search for a particular expenditure", "6. Close the application" };
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		int slen = arr1.length;
		for (int i = 0; i < slen; i++) {
			System.out.println(arr[i]);
			// display the all the Strings mentioned in the String array
		}
		System.out.println("\nEnter your choice:\t");
		Scanner sc = new Scanner(System.in);
		int  options =  sc.nextInt();
		for (int j = 1; j <= slen; j++) {
			if (options == j) {
				switch (options) {
				case 1:
					System.out.println("Your saved expenses are listed below: \n");
					System.out.println(expenses + "\n");
					optionsSelection(expenses);
					break;
				case 2:
					System.out.println("Enter the value to add your Expense: \n");
					expenses.add(sc.nextInt());
					System.out.println("Your value is updated\n");
					System.out.println(expenses + "\n");
					optionsSelection(expenses);
					break;
				case 3:
					System.out.println(
							"You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
					deleteExpenses(expenses, sc.nextInt());
					//expenses.addAll(arrlist);
					System.out.println(expenses + "\n");
					optionsSelection(expenses);
					break;
				case 4:
					System.out.println();
					sortExpenses(expenses);
					System.out.println(expenses + "\n");
					optionsSelection(expenses);
					break;
				case 5:
					System.out.println("Enter the value you nedd Serching in your Expense: \n");
					int y = sc.nextInt();
					int x = searchExpenses(expenses, y);
					if (x == 0) {
						System.out.println("The value Not exist in your Expense:"+y+" \n");
					}else {
						System.out.println("The value was found in your Expense:"+ x +" \n");
					}
					System.out.println(expenses + "\n");
					optionsSelection(expenses);
					break;
				case 6:
					closeApp();
					break;
				default:
					System.out.println("You have made an invalid choice!");
					break;
				}
			}
		}
	}

	private static void closeApp() {
		System.out.println("Closing your application... \nThank you!");
	}

	private static Integer searchExpenses(ArrayList<Integer> arrayList, Integer value) {
		int result = 0;
		Iterator serIter = arrayList.iterator();
		while (serIter.hasNext()) {
			int x = (Integer) serIter.next();
			if (x == value)
				result = x;
		}
		return result;

	}

	private static ArrayList<Integer> sortExpenses(ArrayList<Integer> arrayList) {
		Collections.sort(arrayList);
		return arrayList;
	}


	private static ArrayList<Integer> deleteExpenses(ArrayList<Integer> arrayList, Integer removeValue) {
		Iterator serIter = arrayList.iterator();
		while (serIter.hasNext()) {
			int x = (Integer) serIter.next();
			if (x == removeValue) {
				serIter.remove();
			}
		}
		return arrayList;
	}


}
