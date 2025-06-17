class Public{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr1=new int[n/2 + 1];
		int[] arr2=new int[n/2 + 1];
		int k=0, j=0;
		for(int i=1; i<n; i++){
			if(i%2==0) arr1[k++]=i;
			else arr2[j++]=i;
		}
		for(int i=0; i<n/2 +1; i++){
			System.out.print(arr1[i]+" ");	
		}
	        for(int i=0; i<n/2 + 1; i++){
			System.out.print(arr2[i]+" ");	
		}
		sc.close();
	}	
}