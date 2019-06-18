package Lab1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOTestOut {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter length: ");
	    int l = Integer.parseInt(in.readLine());
		System.out.println("Enter width: ");
		int w = Integer.parseInt(in.readLine());
		Rectangle r = new Rectangle(l,w);
		r.area();
		
		
	}

}
