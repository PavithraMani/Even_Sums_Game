import java.util.*;

public class EvenSumsGame {

	int ele=0;

	static List<Integer> lis = new ArrayList<Integer>();
	static List<Integer> list1 = new ArrayList<Integer>();

	public static void main(String[] args) {
		int[] A = new int[]{4,5,3,7,2};
		int[] result = new int[3];
		List<Integer> l1=new ArrayList<Integer>();

		for(int ii=0;ii<A.length;ii++)
			lis.add(A[ii]);
		System.out.println("Initial list : "+lis);
		List<Integer> l=game(lis,A);
		System.out.println("Final list : "+l);

		while(l.size()!=1){
			Integer[] array = l.toArray (new Integer [l.size()]);
			for (int i=0;i<array.length;i++)
				result[i] = array[i].intValue();

			l1=game(l,result);
			System.out.println("Final list : "+l1);

		}
		System.out.println("");
		System.out.println("**************");
		if(l1.get(0)%2==0)
			System.out.println("Player 1 LOSES");
		else
			System.out.println("Player 1 WINS");
		System.out.println("**************");

	}

	public static List<Integer> game(List<Integer> list, int[] A){

		for(int j=0;j<A.length;j++){
			if(A[j]%2==0)
				list1.add(A[j]);
			else{
				int sum=A[j]+A[j+1];
				if (sum%2==0)
					list1.add(sum);
			}
		}
		Collections.sort(list1);
		System.out.println("Summed list 1 : "+list1);

		for(int i=0;i<list.size();i++){
			if(A[i]%2==0){
				int index=Collections.binarySearch(list1, A[i]);
				if(index>=0){
					if (A[i]==Collections.max(list1)){
						list.remove(list.indexOf(A[i]));
						list1.remove(list1.indexOf(A[i]));
					}
				}
			}
			else if((A[i]+A[i+1])%2==0){
				int index=Collections.binarySearch(list1, A[i]+A[i+1]);
				if(index>=0){
					if ((A[i]+A[i+1])==Collections.max(list1)){
						list.remove(list.indexOf(A[i]));
						list.remove(list.indexOf(A[i+1]));
						list1.remove(list1.indexOf(A[i]+A[i+1]));
					}
				}
			}
		}
		list1.clear();
		return list;

	}
}
