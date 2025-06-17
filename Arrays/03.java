class Public{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=1; i<n; i++){
			arr[i]=sc.nextInt();
			if(arr[i]>0){
				if(arr[i]%2==0)
					System.out.println("even");
				else System.out.println("odd");
			}	
			else if(arr[i]==0) System.out.pritnln("zero");
			else System.out.println("negative");
		}
		if(arr[0]==arr[n-1]) System.out.println("equal");
		else if(arr[0]>arr[n-1]) System.out.println("greater");
		else System.out.println("lesser");
		sc.close();
	}	
}