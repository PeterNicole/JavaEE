/**
 * 
 */
package sample;

/**
 * @author Nicole
 *
 */
public class Hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello Eclipse.");
		if(args.length > 0) {
			System.out.println("First command-line argument " + args[0]);
		}
		else {
			System.err.println("No command-line arguments found.");
		}

	}

}
