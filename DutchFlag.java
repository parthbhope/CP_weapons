package templates;
import java.util.*;
public class DutchFlag {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i=0,j=0,k=n-1,temp;
		int arr[] = new int[n];
		for( i =0;i<n;i++)
			arr[i] = sc.nextInt();
		sc.close();
		for(i=0;i<n;i++)
		{
			if(arr[i]==0)
			{
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				j++;
			}
			else if(arr[i] == 2)
			{
				temp = arr[k];
				arr[k] = arr[i];
				arr[i]= temp;
				i--;
				k--;
			}
		}
		
	}

}
