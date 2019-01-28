package EightPuzzle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import EightPuzzle.Puzzle;

class Node implements Comparable<Node>{
	Puzzle puzzle;
	int pathcost = 0;
	int depth;
	public Node(Puzzle p) {
		this.puzzle = p;
	}
	public int getDepth() { return depth; }
	public int getPathcost() {return pathcost;}
	@Override
	public int compareTo(Node o) {
		return this.pathcost - o.pathcost;
	}
}

public class Solver {
	
	//Breadth-First Search
	public static void BFS(Puzzle p) {
		Queue<Node> que = new LinkedList<>();
		HashMap<String, Integer> seen = new HashMap<>();
		int depth = 0;
		boolean goal = p.isGoal();
		Node n = new Node(p);
		que.add(n);
		seen.put(n.puzzle.getPkey(), 1);
		n.puzzle.show();
		while(goal == false) {
			Node last = que.remove();
			if(goal == false) {
				//checking left move first
				Puzzle l = new Puzzle();
				l.copy(n.puzzle);
				l.moveL();
				l.show();
				
				//if found goal, will stop the while loop
				goal = l.isGoal(); 
				
				
				//check if this board state has been in the queue before then add node
				if(seen.get(l.getPkey()) == null) {
					Node left = new Node(l);
					left.pathcost = n.pathcost + l.cost();
					que.add(left);
					seen.put(l.getPkey(), 1);
				}
				
			}
			
			if(goal == false) {
				//checking up move first
				Puzzle u = new Puzzle();
				u.copy(n.puzzle);
				u.moveU();
				u.show();
				
				//if found goal, will stop the while loop
				goal = u.isGoal(); 
				
				
				//check if this board state has been in the queue before then add node
				if(seen.get(u.getPkey())  == null) {
					Node up = new Node(u);
					up.pathcost = n.pathcost + u.cost();
					que.add(up);
					seen.put(u.getPkey(), 1);
				}
			}
			if(goal == false) {
				//checking down move first
				Puzzle d = new Puzzle();
				d.copy(n.puzzle);
				d.moveD();
				d.show();
				
				//if found goal, will stop the while loop
				goal = d.isGoal(); 
				
				
				//check if this board state has been in the queue before then add node
				if(seen.get(d.getPkey())  == null) {
					Node down = new Node(d);
					down.pathcost = n.pathcost + d.cost();
					que.add(down);
					seen.put(d.getPkey(), 1);
				}
			}
			
			if(goal == false) {
				//checking up move first
				Puzzle r = new Puzzle();
				r.copy(n.puzzle);
				r.moveR();
				r.show();
				
				//if found goal, will stop the while loop
				goal = r.isGoal(); 
				
				
				//check if this board state has been in the queue before then add node
				if(seen.get(r.getPkey())  == null) {
					Node right = new Node(r);
					right.pathcost = n.pathcost + r.cost();
					que.add(right);
					seen.put(r.getPkey(), 1);
				}
			}
			n = que.peek();
			System.out.println("Tried : " + seen.size());
			System.out.println("Cost : " + last.pathcost);
		}
		
		
	}
	
	//Depth-First Search
	public static void DFS(Puzzle p) {
		Stack<Node> stack = new Stack<>();
		HashMap<String, Integer> seen = new HashMap<>();
		int depth = 0;
		boolean goal = p.isGoal();
		Node n = new Node(p);
		stack.push(n);
		seen.put(n.puzzle.getPkey(), 1);
		n.puzzle.show();
		while(goal == false) {
			stack.pop();
			if(goal == false) {
				Puzzle r = new Puzzle();
				r.copy(n.puzzle);
				r.moveR();
				r.show();
				
				goal = r.isGoal(); 
				
				if(seen.get(r.getPkey())  == null) {
					Node right = new Node(r);
					right.pathcost = n.pathcost + r.cost();
					stack.push(right);
					seen.put(r.getPkey(), 1);
				}
			}
			if(goal == false) {
				Puzzle d = new Puzzle();
				d.copy(n.puzzle);
				d.moveD();
				d.show();
				
				goal = d.isGoal(); 
				
				if(seen.get(d.getPkey())  == null) {
					Node down = new Node(d);
					down.pathcost = n.pathcost + d.cost();
					stack.push(down);
					seen.put(d.getPkey(), 1);
				}
			}			
			if(goal == false) {
				Puzzle u = new Puzzle();
				u.copy(n.puzzle);
				u.moveU();
				u.show();
				
				goal = u.isGoal(); 
				
				if(seen.get(u.getPkey())  == null) {
					Node up = new Node(u);
					up.pathcost = n.pathcost + u.cost();
					stack.push(up);
					seen.put(u.getPkey(), 1);
				}
				
			}
			
			if(goal == false) {
				Puzzle l = new Puzzle();
				l.copy(n.puzzle);
				l.moveL();
				l.show();
				
				goal = l.isGoal(); 
				
				if(seen.get(l.getPkey()) == null) {
					Node left = new Node(l);
					left.pathcost = n.pathcost + l.cost();
					stack.push(left);
					seen.put(l.getPkey(), 1);
				}
			}

			
			n = stack.peek();
			System.out.println("Tried : " + seen.size());
		}
		
	}
	
	//Uniform-Cost Search (by modified version cost)
	public static void UCS(Puzzle p) {
		PriorityQueue<Node> list = new PriorityQueue<>();
		HashMap<String, Integer> seen = new HashMap<>();
		boolean goal = p.isGoal();
		Node n = new Node(p);
		list.add(n);
		seen.put(n.puzzle.getPkey(), 1);
		n.puzzle.show();
		while(goal == false) {
			list.poll();
			if(goal == false) {
				//checking left move first
				Puzzle l = new Puzzle();
				l.copy(n.puzzle);
				l.moveL();
				l.show();
				l.cost();
				//if found goal, will stop the while loop
				goal = l.isGoal(); 
				
				if(seen.get(l.getPkey()) == null) {
					Node left = new Node(l);
					left.pathcost = n.pathcost + l.cost();
					list.add(left);
					seen.put(l.getPkey(), 1);
				}
			}
			if(goal == false) {
				//checking left move first
				Puzzle u = new Puzzle();
				u.copy(n.puzzle);
				u.moveU();
				u.show();
				u.cost();
				//if found goal, will stop the while loop
				goal = u.isGoal(); 
				if(seen.get(u.getPkey())  == null) {
					Node up = new Node(u);
					up.pathcost = n.pathcost + u.cost();
					list.add(up);
					seen.put(u.getPkey(), 1);
				}
					
			}
			if(goal == false) {
				//checking left move first
				Puzzle d = new Puzzle();
				d.copy(n.puzzle);
				d.moveD();
				d.show();
				d.cost();
				//if found goal, will stop the while loop
				goal = d.isGoal(); 
				if(seen.get(d.getPkey())  == null) {
					Node down = new Node(d);
					down.pathcost = n.pathcost + d.cost();
					list.add(down);
					seen.put(d.getPkey(), 1);
				}
			}
			if(goal == false) {
				//checking left move first
				Puzzle r = new Puzzle();
				r.copy(n.puzzle);
				r.moveR();
				r.show();
				r.cost();
				//if found goal, will stop the while loop
				goal = r.isGoal(); 
				
				if(seen.get(r.getPkey())  == null) {
					Node right = new Node(r);
					right.pathcost = n.pathcost + r.cost();
					list.add(right);
					seen.put(r.getPkey(), 1);
				}
			}

			n = list.peek();
			System.out.println("Tried : " + seen.size());
			System.out.println("Cost : " + list.peek().pathcost);
		}
		
	}
	
	//Best-First Search (numbers of incorrect)
	public static void BTFS(Puzzle p) {
		HashMap<String, Integer> seen = new HashMap<>();
		ArrayList<Node> list = new ArrayList<Node>();
		Stack<Node> stack = new Stack<Node>();
		boolean goal = p.isGoal();
		Node n = new Node(p);
		stack.push(n);
		seen.put(n.puzzle.getPkey(), 1);
		n.puzzle.show();
		/*basically the same as other ones in creating nodes
		 * but since we are putting in best first, instead of pushing in to a stack right away
		 * checking no duplicates first, then add to an ArrayList<Node>
		 * Then sort the ArrayList by least amount of incorrects, 
		 * then push on to the stack.
		 */
		
		while(goal == false) {
			stack.pop();
			if(goal == false) {
				Puzzle r = new Puzzle();
				r.copy(n.puzzle);
				r.moveR();
				r.show();
				
				goal = r.isGoal(); 
				//check dup, then adds to the list, but not the stack
				if(seen.get(r.getPkey())  == null) {
					Node right = new Node(r);
					right.pathcost = n.pathcost + r.cost();
					list.add(right);
					seen.put(r.getPkey(), 1);
				}
			}
			if(goal == false) {
				Puzzle d = new Puzzle();
				d.copy(n.puzzle);
				d.moveD();
				d.show();
				
				goal = d.isGoal(); 
				
				if(seen.get(d.getPkey())  == null) {
					Node down = new Node(d);
					down.pathcost = n.pathcost + d.cost();
					list.add(down);
					seen.put(d.getPkey(), 1);
				}
			}			
			if(goal == false) {
				Puzzle u = new Puzzle();
				u.copy(n.puzzle);
				u.moveU();
				u.show();
				
				goal = u.isGoal(); 
				
				if(seen.get(u.getPkey())  == null) {
					Node up = new Node(u);
					up.pathcost = n.pathcost + u.cost();
					list.add(up);
					seen.put(u.getPkey(), 1);
				}
				
			}
			
			if(goal == false) {
				Puzzle l = new Puzzle();
				l.copy(n.puzzle);
				l.moveL();
				l.show();
				
				goal = l.isGoal(); 
				
				if(seen.get(l.getPkey()) == null) {
					Node left = new Node(l);
					left.pathcost = n.pathcost + l.cost();
					list.add(left);
					seen.put(l.getPkey(), 1);
				}
			}
			
			//using insertion sorting the ArrayList, since no more than 4 items will ever be there, very fast.
			int len = list.size();
			for(int i = 1; i < len; i++) {
				Node temp = list.get(i);
				int inco = list.get(i).puzzle.incorrect();
				int j = i - 1;
				while(j >= 0 && list.get(j).puzzle.incorrect() > inco) {
					
					list.set(j+1, list.get(j));
					j = j - 1; 
				}
				list.set(j+1,temp);
			}
			//now pushing the nodes on to the stack most incorrect goes first (close to bottom)
			for(int i = list.size()-1; i >= 0; i--) {
				Node temp = list.get(i);
				stack.push(temp);
			}
			//clear the list
			list.clear();
			//set node reference to the top of the stack, pops is back on top when loop begins.
			n = stack.peek();
			System.out.println("Tried : " + seen.size());
		}
		
	}
	
	//A*1 (cost and numbers of incorrect)
	public static void Astar1(Puzzle p) {
		//creating a priority queue that selects by Astar score (in this case pathcost + incorrect)
		PriorityQueue<Node> list = new PriorityQueue<>(new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				int astar = o1.pathcost + o1.puzzle.incorrect();
				int bstar = o2.pathcost + o2.puzzle.incorrect();
				return astar - bstar;
			}
			
		});
		HashMap<String, Integer> seen = new HashMap<>();
		boolean goal = p.isGoal();
		Node n = new Node(p);
		list.add(n);
		seen.put(n.puzzle.getPkey(), 1);
		n.puzzle.show();
		while(goal == false) {
			list.poll();
			if(goal == false) {
				//checking left move first
				Puzzle l = new Puzzle();
				l.copy(n.puzzle);
				l.moveL();
				l.show();
				l.cost();
				//if found goal, will stop the while loop
				goal = l.isGoal(); 
				
				if(seen.get(l.getPkey()) == null) {
					Node left = new Node(l);
					left.pathcost = n.pathcost + l.cost();
					list.add(left);
					seen.put(l.getPkey(), 1);
				}
			}
			if(goal == false) {
				//checking left move first
				Puzzle u = new Puzzle();
				u.copy(n.puzzle);
				u.moveU();
				u.show();
				u.cost();
				//if found goal, will stop the while loop
				goal = u.isGoal(); 
				if(seen.get(u.getPkey())  == null) {
					Node up = new Node(u);
					up.pathcost = n.pathcost + u.cost();
					list.add(up);
					seen.put(u.getPkey(), 1);
				}
					
			}
			if(goal == false) {
				//checking left move first
				Puzzle d = new Puzzle();
				d.copy(n.puzzle);
				d.moveD();
				d.show();
				d.cost();
				//if found goal, will stop the while loop
				goal = d.isGoal(); 
				if(seen.get(d.getPkey())  == null) {
					Node down = new Node(d);
					down.pathcost = n.pathcost + d.cost();
					list.add(down);
					seen.put(d.getPkey(), 1);
				}
			}
			if(goal == false) {
				//checking left move first
				Puzzle r = new Puzzle();
				r.copy(n.puzzle);
				r.moveR();
				r.show();
				r.cost();
				//if found goal, will stop the while loop
				goal = r.isGoal(); 
				
				if(seen.get(r.getPkey())  == null) {
					Node right = new Node(r);
					right.pathcost = n.pathcost + r.cost();
					list.add(right);
					seen.put(r.getPkey(), 1);
				}
			}

			n = list.peek();
			System.out.println("Tried : " + seen.size());
			System.out.println("Cost : " + list.peek().pathcost);
		}
		
	}
	
	//A*2 (cost and Manhattan distance)
	public static void Astar2(Puzzle p) {
		//creating a priority queue that selects by Astar score (in this case pathcost + manhattan)
		PriorityQueue<Node> list = new PriorityQueue<>(new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				int astar = o1.pathcost + o1.puzzle.manhat();
				int bstar = o2.pathcost + o2.puzzle.manhat();
				return astar - bstar;
			}
			
		});
		HashMap<String, Integer> seen = new HashMap<>();
		boolean goal = p.isGoal();
		Node n = new Node(p);
		list.add(n);
		seen.put(n.puzzle.getPkey(), 1);
		n.puzzle.show();
		while(goal == false) {
			list.poll();
			if(goal == false) {
				//checking left move first
				Puzzle l = new Puzzle();
				l.copy(n.puzzle);
				l.moveL();
				l.show();
				l.cost();
				//if found goal, will stop the while loop
				goal = l.isGoal(); 
				
				if(seen.get(l.getPkey()) == null) {
					Node left = new Node(l);
					left.pathcost = n.pathcost + l.cost();
					list.add(left);
					seen.put(l.getPkey(), 1);
				}
			}
			if(goal == false) {
				//checking left move first
				Puzzle u = new Puzzle();
				u.copy(n.puzzle);
				u.moveU();
				u.show();
				u.cost();
				//if found goal, will stop the while loop
				goal = u.isGoal(); 
				if(seen.get(u.getPkey())  == null) {
					Node up = new Node(u);
					up.pathcost = n.pathcost + u.cost();
					list.add(up);
					seen.put(u.getPkey(), 1);
				}
					
			}
			if(goal == false) {
				//checking left move first
				Puzzle d = new Puzzle();
				d.copy(n.puzzle);
				d.moveD();
				d.show();
				d.cost();
				//if found goal, will stop the while loop
				goal = d.isGoal(); 
				if(seen.get(d.getPkey())  == null) {
					Node down = new Node(d);
					down.pathcost = n.pathcost + d.cost();
					list.add(down);
					seen.put(d.getPkey(), 1);
				}
			}
			if(goal == false) {
				//checking left move first
				Puzzle r = new Puzzle();
				r.copy(n.puzzle);
				r.moveR();
				r.show();
				r.cost();
				//if found goal, will stop the while loop
				goal = r.isGoal(); 
				
				if(seen.get(r.getPkey())  == null) {
					Node right = new Node(r);
					right.pathcost = n.pathcost + r.cost();
					list.add(right);
					seen.put(r.getPkey(), 1);
				}
			}

			n = list.peek();
			System.out.println("Tried : " + seen.size());
			System.out.println("Cost : " + list.peek().pathcost);
		}
		
	}
	
	//A*3 (better Astar for the modified puzzle)
	public static void Astar3(Puzzle p) {

		
	}
	
	public static void main(String[] args) {
		Puzzle seasy = new Puzzle();
		Puzzle easy = new Puzzle();
		Puzzle med = new Puzzle();
		Puzzle hard = new Puzzle();
		int [] se = {1,2,3,8,4,5,7,0,6};
		int [] e = {1,3,4,8,6,2,7,0,5};
		int [] m = {2,8,1,0,4,3,7,6,5};
		int [] h = {5,6,7,4,0,8,3,2,1};
		seasy.insert(se);
		easy.insert(e);
		med.insert(m);
		hard.insert(h);
		//BFS(seasy); 
		//BFS(easy);			//Done
		//BFS(med);			//Done
		BFS(hard);			//Done
		//DFS(seasy);
		//DFS(easy);			//Done 90000
		//DFS(med);			//Done around 100000
		//DFS(hard);			//Done actually the least 42554
		//UCS(seasy);
		//UCS(easy);			//Done 30
		//UCS(med);			//Done 200
		//UCS(hard);			//Done 180000
		//BTFS(seasy);
		//BTFS(easy);		//Done 19
		//BTFS(med);			//Done 24000
		//BTFS(hard);		//Done 23500
		//Astar1(seasy);
		//Astar1(easy);		//Done 19 cost 13
		//Astar1(med);		//Done 114 cost 25
		//Astar1(hard);		//Done 175319 cost 114 (modified version for lower cost decreases the speed to find goal)
		//Astar2(seasy);
		//Astar2(easy);		//Done 17 cost 17
		//Astar2(med);		//Done 76 cost 31
		//Astar2(hard);		//Done  cost 108
	}
}
