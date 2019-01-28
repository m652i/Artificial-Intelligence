package EightPuzzle;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Puzzle {
	int [] list = {1,2,3,4,5,6,7,8,0};
	int spaceIndex = 99;
	int cost = 0;
	//prints puzzle for easy check in case needed
	public void show(){
		locateSpace();
		for(int i = 0; i < 9; i++) {
			if(i%3==2) System.out.println(list[i]);
			else System.out.print(list[i]);
		}
		System.out.println("----");
	}
	//insert puzzle if needed (has validity check, no exception, just prints and won't execute if invalid entry)
	public void insert(int[] arr) { 
		int[]checker = {0,1,2,3,4,5,6,7,8};
		if(Arrays.equals(IntStream.of(arr).sorted().toArray(), checker)) this.list = arr;
		else System.out.println("===== Invalid Entry, Please Try Again =====");
	}
	//returns the current Puzzle as an String(for map key search)
	public String getPkey() {
		return  Arrays.toString(this.list);
	}
	//returns the current Puzzle
	public int[] getPuzzle() {
		return list;
	}
	//copies from another Puzzle class object
	public void copy(Puzzle a) {
		for(int i = 0; i < 9; i++) {
			this.list[i] = a.getPuzzle()[i];
		}
	}
	//find location of space (which is 0) function called at main
	public void locateSpace() {
		int j = 0;
		for(int i : list) {
			if(i != 0) j++;
			else break;
		}
		this.spaceIndex = j;
	}
	//Move Right (space moves left)
	public char moveR() {
		locateSpace();
		if(spaceIndex % 3 != 0){ 
			this.cost = this.list[spaceIndex - 1]; //modified version cost 
			this.list[spaceIndex] = this.list[spaceIndex - 1];
			this.list[spaceIndex - 1] = 0;
			this.spaceIndex = spaceIndex - 1;
			System.out.println("Move right" + cost);
			return 'R';
		} else System.out.println("No move");return 'N';
	}
	//Move left (space moves right)
	public char moveL() {
		locateSpace(); 
		if(spaceIndex % 3 != 2){ 
			this.cost = this.list[spaceIndex + 1]; //modified version cost 
			this.list[spaceIndex] = this.list[spaceIndex + 1];
			this.list[spaceIndex + 1] = 0;
			this.spaceIndex = spaceIndex + 1;
			System.out.println("Move left" + cost);
			return 'L';
		} else System.out.println("No move");return 'N';
	}
	//Move down (space moves up)
	public char moveU() {
		locateSpace();
		if(spaceIndex < 6){ 
			this.cost = this.list[spaceIndex + 3]; //modified version cost 
			this.list[spaceIndex] = this.list[spaceIndex + 3];
			this.list[spaceIndex + 3] = 0;
			this.spaceIndex = spaceIndex + 3;
			System.out.println("Move up" + cost);
			return 'U';
		} else System.out.println("No move");return 'N';
	}
	//Move up (space moves down)
	public char moveD() {
		locateSpace();
		if(spaceIndex > 2){ 
			this.cost = this.list[spaceIndex - 3]; //modified version cost 
			this.list[spaceIndex] = this.list[spaceIndex - 3];
			this.list[spaceIndex - 3] = 0;
			this.spaceIndex = spaceIndex - 3;
			System.out.println("Move down" + cost);
			return 'D';
		} else System.out.println("No move");return 'N';
	}
	//check equal (since we don't want to put in repeated)
	public boolean isEqual(Puzzle a) {
		if(Arrays.equals(list, a.getPuzzle()) == true)return true;
		else return false;
	}
	//if not equal, check how many are different, using Goal checker (can be adjusted)
	public int incorrect() {
		int counter = 0;
		int [] checker = {1,2,3,8,0,4,7,6,5};
		for(int i = 0; i < 9; i++) {
			if(checker[i]!=this.list[i]) counter++;
		}
		//System.out.println("Incorrect : " + counter);
		return counter;
	}
	//check Manhattan distance (Very specifically for this goal only!!! for speed I believe making a easy distance call map would be the fastest?)
	public int manhat() {
		int a0 [] = {0,1,2,3,4,3,2,1,2};
		int a1 [] = {1,0,1,2,3,2,3,2,1};
		int a2 [] = {2,1,0,1,2,3,4,3,2};
		int a3 [] = {1,2,3,2,3,2,1,0,1};
		int a4 [] = {2,1,2,1,2,1,2,1,0};
		int a5 [] = {3,2,1,0,1,2,3,2,1};
		int a6 [] = {2,3,4,3,2,1,0,1,2};
		int a7 [] = {3,2,3,2,1,0,1,2,1};
		int a8 [] = {4,3,2,1,0,1,2,3,2};
		int [] [] all = {a0,a1,a2,a3,a4,a5,a6,a7,a8};
		int manhat = 0;
		for(int i = 0; i < 9; i++) {
			int a = list[i]-1;
			if(a < 0) a = 8;
			manhat += all[i][a];
			//System.out.println("called array : a"+i + " position : " + a +" manhat : " +manhat);
		}
		System.out.println(manhat);
		return manhat;
	}
	//check if goal state (goal is 123/804/765)
	public boolean isGoal() {
		int [] checker = {1,2,3,8,0,4,7,6,5};
		System.out.println(Arrays.equals(this.list, checker));
		return Arrays.equals(this.list, checker);
	}
	//randomize
	public void random() {
		random(this.list);
	}
	private void random(int [] a) {
		Random rnd = ThreadLocalRandom.current();
		for(int i = 0; i <= 8 ; i++) {
			int index = rnd.nextInt(i + 1);
			int temp = a[index];
			a[index] = a[i];
			a[i] = temp;
		}
	}
	//return cost of the modified version
	public int cost() {
		return cost;
	}
	//return total cost

}
