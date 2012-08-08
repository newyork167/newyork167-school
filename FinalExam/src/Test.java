
public class Test {

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		int[] array = {1,2,3,4,5};
//		searchNumericArray(5, array);
//		searchNumericArray(6, array);
//	}
//	
//	 public static int searchNumericArray(int searchFor, int[] array){
//			try{
//				for(int i=0;i<array.length;i++){
//					if(array[i] == searchFor){
//						return i;
//					}
//				}
//					throw new Exception("Element not found");
//			}
//			catch(Exception e){
//				System.out.println(e.getMessage());
//			}
//			return -1;
//	 }
	 public static void main(String[] args)

     {

                 int num = 0;

                 ShowMe(num);

     }



     public static void ShowMe(int arg)

     {

                 System.out.println(arg);

                 if (arg < 10)

                             ShowMe(arg + 1);

     }

}
